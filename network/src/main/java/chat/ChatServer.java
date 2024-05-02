package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 * 1. 클라이언트로부터 연결 요청 대기
 * 2. 클라이언트와 연결 후, 이루어지는 통신은 모두 ChatServerThread 역할
 * 
 */
public class ChatServer {
	public static final int PORT = 8000;
	public static final String SERVER_IP = "192.168.0.102";
	//public static final String SERVER_IP = "0.0.0.0";
	
	public static void main(String[] args) {
		List<Writer> listWriters = new ArrayList<Writer>(); //chatserver 스레
		ServerSocket serverSocket = null; 
		
		try {
			//1. Create ServerSocket
			serverSocket = new ServerSocket();
			//serverSocket.setReuseAddress(true);
			
			//2. Binding 
//			String hostAddress = InetAddress.getLocalHost().getHostAddress();
//			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			
			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT), 10); 
			log("connected by client[" + SERVER_IP + ":" + PORT + "]");
			
			
			//3. 연결 시도(대기) - 많은 클라이언트의 요청을 받기 위해 while문에서 소켓 생성
			while(true) {
				Socket socket = serverSocket.accept(); //blocking
				new ChatServerThread(socket, listWriters).start();
//				Thread thread = new ChatServerThread(socket, listWriters);
//				thread.start();
				
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
