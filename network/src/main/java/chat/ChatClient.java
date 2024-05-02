package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 6000;

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			//1. socket 생성
			socket = new Socket();
			
			//2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT)); //파라미터로 줘도 되고, 상수로 만들어서 넣어도 됨.
			
		} catch (IOException e) {
			System.out.println("[Client] Socket Exception : " + e);
		}
	}

}
