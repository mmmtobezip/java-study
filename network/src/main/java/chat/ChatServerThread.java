package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/*
 * 1. 통신을 위한 스트림을 얻어 오기 위해 Socket 객체 저장
 * 2. 클라이언트와 채팅 데이터 통신하는 역할
 * 	2-1. 연결된 클라이언트의 닉네임 저장하는 역할 
 */
public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private List<Writer> listWriters;
	
	private BufferedReader br;
	private PrintWriter pw;
                 
	public ChatServerThread(Socket socket, List<Writer> listWriters) { 
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		try {
			//1. Remote Host Information
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort(); 
			
			ChatServer.log("Connected by Client[" + remoteHostAddress + ":" + remotePort + "]");
			
			//2. Get IO Stream 
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			//3. 요청 처리
			while(true) {
				String request = br.readLine();
				
				if(request == null) {
					doQuit(pw);
					ChatServer.log("Closed by Client");
					break;
				}
				
				ChatServer.log("[ChatServerThread recevied=> " + request + "]");
				
				//4. 프로토콜 구현
				String[] tokens = request.split(":");
				if(("join").equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if(("message").equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if(("quit").equals(tokens[0])) {
					doQuit(pw);
					break;
				} else {
					ChatServer.log("Error: 알 수 없는 요청(" + tokens[0] + ")");
				}
			}
		} catch(SocketException e) {
			ChatServer.log("Socket Exception: " + e);
		} catch(IOException e) {
			ChatServer.log("Error: " + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}	
		
	}
	
	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;
		String message = nickName + "님이 참여하였습니다.";
		System.out.println(message);

		broadCastMsg(message);
		
		//writer pool에 저장 
		addWriter(writer);
		
		//ack
		pw.println("join:ok"); 
	}
	
	private void addWriter(Writer writer) {
		synchronized(listWriters) { //synchronized()는 여러 스레드가 하나의 공유 객체에 접근할 때 동기화 보장 
			listWriters.add(writer);
		}
	}
	
	private void broadCastMsg(String message) {
		synchronized(listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(message);
			}
		}
	}
	
	private void doMessage(String message) {
		//protocol: "message:하이^^;\n"
		broadCastMsg(nickname + ":" + message);	
	} 
	
	private void doQuit(Writer writer) {
		//protocol: "quit"
		removeWriter(writer);
		
		if(nickname != null) {
			String message = nickname + "님이 퇴장 하였습니다.";
			broadCastMsg(message);	
		}
	}
	
	private void removeWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.remove(writer);
		}
	}
}

	