package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {
	public static void main(String[] args) {
		Socket socket = null;
		Scanner sc = null;
		
		try {
			//1. 키보드 연결 
			sc = new Scanner(System.in);
			
			//2. socket 생성
			socket = new Socket();
			
			//3. 서버 연결
			socket.connect(new InetSocketAddress(ChatServer.SERVER_IP, ChatServer.PORT));
			
			//4. reader/writer
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			//5. join 프로토콜 
			System.out.print("닉네임>>");
			String input = sc.nextLine();
			pw.println("join:" + input);
			
			String response = br.readLine();
			if(response.startsWith("join:ok")) {
				System.out.println(input + "님이 입장하였습니다. 즐거운 채팅 되세요.");
			}
			
			//6. Create ChatClientReceiveThread
			new ChatClientThread(socket).start();
			
			//7. 키보드 입력
			while(true) {
				String data = sc.nextLine();
				
				if(("quit").equals(data)) {
					//8. quit 프로토콜
					pw.println("quit");
					break;
				} else {
					pw.println("message:" + data);
				}
			}	
		} catch (SocketException e) {
			log("SocketException: " + e);
		} catch (IOException e) {
			log("Error:" + e);
		} finally { //자원정리 
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
				if(sc != null) {
					sc.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String message) {
		System.out.println("[Chat Client]: " + message);
	}
}
