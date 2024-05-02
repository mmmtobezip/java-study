package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerThread {
	public static final int PORT = 6000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(); 
			serverSocket.bind(new InetSocketAddress("127.0.0.1", PORT), 10); 
			log("starts...[port: " + PORT + "]");
			
			while(true) {
				Socket socket = serverSocket.accept();  //blocking
				new EchoRequestHandler(socket).start();  //EchoRequestHandler는 소켓을 받고 해당 소켓을 사용해 스레드 사용?
			}
		} catch(IOException e) {
			log("error: " + e);
			} finally {
				try {
					if(serverSocket != null && !serverSocket.isClosed()) { 
						serverSocket.close(); 
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	public static void log(String message) { //private -> public(EchoRequest에서 쓰기 위함)
		System.out.println("[EchoServer] " + message);
	}
}

