package chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 1. 클라이언트로부터 연결 요청 대기
 * 2. 클라이언트와 연결 후, 이루어지는 통신은 모두 ChatServerThread 역할
 * 
 */
public class ChatServer {
	public static final int PORT = 3000;
	public static final String IP = "127.0.0.1";
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//1. Create ServerSocket
			serverSocket = new ServerSocket();
			
			//2. Binding 
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결 기다림" + hostAddress + ":" + PORT);
			
			
			//3. 요청 대기 - 많은 클라이언트의 요청을 받기 위해 while문에서 소켓 생성
			while(true) {
				Socket socket = serverSocket.accept(); //blocking
				new ChatServerThread(socket).start();
				// List<Writer> listWriters = new ArrayList<Writer>();
				//socket뿐만 아니라 데이터를 담는 리스트 타입의 listWriters도 함께 스레드 생성자에 삽입
				//ChatServer가 service thread(요청 처리 스레드)를 하나 생성해줌
				//ChatServerThread = EchoRequestHandler 비슷한 역할 
				
			}
			
		} catch(IOException e) {
			log("error: " + e);
			} finally {
				try {
					//Close ServerSocket
					if(serverSocket != null && !serverSocket.isClosed()) { 
						serverSocket.close(); 
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	public static void log(String message) {
		System.out.println("[Chat Server]: " + message);
	}

}
