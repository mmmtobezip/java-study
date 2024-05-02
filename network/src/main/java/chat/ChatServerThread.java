package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/*
 * 1. 통신을 위한 스트림을 얻어 오기 위해 Socket 객체 저장
 * 2. 클라이언트와 채팅 데이터 통신하는 역할
 * 	2-1. 연결된 클라이언트의 닉네임 저장하는 역할 
 */
public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	BufferedReader br = null;
	PrintWriter pw = null;

	public ChatServerThread(Socket socket) { //소켓 생성자 
		this.socket = socket;
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
					ChatServer.log("closed by client");
					break; 
				}
				ChatServer.log("[ChatServerThread recevied: " + request);
				
				//4. 프로토콜 구현
				//조건에 따라 scanner로 받아서 
				//처음 유저가 입장하면 "join: " + scanner
				//유저가 입력한게 "quit: " + scanner이면 종료
				//else "message: " + scanner면, 파싱해서 데이터를 그대로 보여주기
				
			}
		} catch(SocketException e) {
			ChatServer.log("Socket Exception: " + e);
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
}

	