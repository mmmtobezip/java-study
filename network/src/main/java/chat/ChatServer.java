package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 * 1. 클라이언트로부터 연결 요청 대기
 * 2. 클라이언트와 연결 후, 이루어지는 통신은 모두 ChatServerThread 역할
 */
public class ChatServer {
	public static final int PORT = 8000;
	public static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		List<Writer> listWriters = new ArrayList<Writer>(); 
		ServerSocket serverSocket = null; 
		
		try {
			//1. Create serverSocket 
			serverSocket = new ServerSocket();
			//2. Binding 
			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT), 10); 
			log("Connected by Client[" + SERVER_IP + ":" + PORT + "]");
			
			//3. Connection 
			while(true) {
				Socket socket = serverSocket.accept(); 
				new ChatServerThread(socket, listWriters).start();
			}
		} catch(IOException e) {
			log("Error: " + e);
			} finally {
				try {
					//Closed serverSocket 
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
