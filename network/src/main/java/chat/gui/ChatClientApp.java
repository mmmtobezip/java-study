package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {
	public static void main(String[] args) {
		Socket socket = null;
		String name = null;
		Scanner scanner = null; 

		try {
			scanner = new Scanner(System.in);
			
			while(true) {
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();
				
				if (name != null && !name.isEmpty()) { 
					break;
				}
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
			
			//2. Create socket
			socket = new Socket();
			//3. Connection
			socket.connect(new InetSocketAddress(ChatServer.SERVER_IP, ChatServer.PORT));
			//4. Read/Write
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			pw.println("join:" + name);
			
			String data = br.readLine();
			if(("join:ok").equals(data)) {
				//Create Thread
				new ChatWindow(name, socket, br, pw).show(); 
			}
		} catch (SocketException e) {
			log("SocketException: " + e);
		} catch (IOException e) {
			log("Error: " + e);
		} finally {
			scanner.close();
		}
	}
	
	private static void log(String message) {
		System.out.println("[ChatClientApp]: " + message);
	}
}
