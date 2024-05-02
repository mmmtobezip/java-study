package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
	private List<PrintWriter> listWriters;
	
	BufferedReader br = null;
	PrintWriter pw = null;

	public ChatServerThread(Socket socket, List<PrintWriter> listWriters) { //소켓 생성자 
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		try {
			//1. Remote Host Info
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort(); 
			ChatServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
			
			//2. Get IO Stream 
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			//3. 요청 처리
			while(true) {
				String request = br.readLine();
				
				if(request == null) {
					//doQuit(pw); //로그 찍은 다음에 클라이언트가 "quit" 보내지 않고 소켓을 닫은 경우에 대한 에러 처리가 필요한가?
					ChatServer.log("closed by client");
					doQuit(pw);
					break; 
				}
				ChatServer.log("[ChatServerThread recevied: " + request);
				
				//4. 프로토콜 구현
				//조건에 따라 scanner로 받아서 
				//처음 유저가 입장하면 "join: " + scanner
				//유저가 입력한게 "quit: " + scanner이면 종료
				//else "message: " + scanner면, 파싱해서 데이터를 그대로 보여주기
				String[] tokens = request.split(":");
//				if(tokens[0].equals("join")) {
//					doJoin(tokens[1], pw);
//				} else if(tokens[0].equals("message")) {
//					doMessage(tokens[1]);
//				} else if(tokens[0].equals("quit")) {
//					doQuit(pw);
//					break;
//				} else {
//					ChatServer.log("Error: 알 수 없는 요청(" + tokens[0] + ")");
//				}
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
					break;
				} else {
					ChatServer.log("Error: 알 수 없는 요청(" + tokens[0] + ")");
				}
			}
		} catch(SocketException e) {
			ChatServer.log("Socket Exception: " + e); //퇴장처리(?)
		} catch(IOException e) {
			ChatServer.log("error: " + e);
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
	
	private void doJoin(String nickName, PrintWriter printWriter) {
		this.nickname = nickName;
		String message = nickName + "님이 참여하였습니다.";
		//A유저가 채팅방 입장 시, 다른 유저들에게 000님이 참여하였습니다. 라는 메시지를 보내는게 브로드캐스팅 
		broadCastMsg(message);
		
		//writer pool에 저장 
		addWriter(printWriter);
		
		//ack를 보내 유저들의 채팅방 참여가 성공적이라는 것을 클라이언트에게 알려주는 용도 
		//ack
		printWriter.println("join:ok");
//		printWriter.flush();
	}
	
	private void addWriter(PrintWriter printWriter) {
		 //list타입의 writer pool에 파라미터로 받은 PrintWriter추가 
		synchronized(listWriters) { //synchronized()는 여러 스레드가 하나의 공유 객체에 접근할 때 동기화 보장 
			listWriters.add(printWriter);
		}
	}
	
	private void broadCastMsg(String message) {
		synchronized(listWriters) {
			for(PrintWriter writer : listWriters) {
				writer.println(message);
				writer.flush();
			}
		}
	}
	
	private void doMessage(String message) {
		//프로토콜: "message:하이^^;\n"
		broadCastMsg(nickname + ":" + message);	
	} 
	
	private void doQuit(PrintWriter printWriter) {
		//프로토콜: "quit"
		//000님이 퇴장 하였습니다. 라는 메시지가 브로드캐스팅 되어야 한다
		//현재 스레드의 printWriter를 writer pool에서 제고한 후, 브로드캐스팅 하면됨 
		removeWriter(printWriter);
		
		if(nickname != null) {
			String message = nickname + "님이 퇴장 하였습니다.";
			broadCastMsg(message);	
		}
	}
	
	private void removeWriter(PrintWriter printWriter) {
		//list타입의 writer pool에 파라미터로 받은 PrintWriter 삭제
		synchronized(listWriters) {
			listWriters.remove(printWriter);
		}
	}
}

	