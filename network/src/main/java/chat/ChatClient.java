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
	private static final String SERVER_IP = "192.168.0.102";

	public static void main(String[] args) {
		Socket socket = null;
		Scanner sc = null;
		
		try {
			//1. 키보드 연결 
			 sc = new Scanner(System.in);
			
			//2. socket 생성
			socket = new Socket();
			
			//3. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT)); //파라미터로 줘도 되고, 상수로 만들어서 넣어도 됨.
			log("Server connect completed");
			
			//4. reader/writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			//5. join 프로토콜 처리 
			System.out.print("닉네임>>");
			String input = sc.nextLine();
			pw.println("join:" + input); //	접속한 유저 이름 출력	
			
			String nickName = br.readLine();
			if(nickName.equals("join:ok")) {
				System.out.println("입장하였습니다. 즐거운 채팅 되세요.");
			}
			
			//6. ChatClientReceiveThread 시작 
			new ChatClientThread(socket).start();
			
			//7. 키보드 입력
			while(true) {
				//System.out.print(">>");
				String data = sc.nextLine();
				
				if(data.equals("quit")) {
					//8. quit 프로토콜 처리 
					pw.println("quit");
					break;
				} else if(data.equals("message")) {
					//9. message 프로토콜 처리 
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
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String message) {
		System.out.println("[Chat Client]: " + message);
	}
}
