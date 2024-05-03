package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
	private Socket socket;

	public ChatClientThread(Socket socket) { 
		this.socket = socket;
	}
	
	//키보드에 들어오는 출력만
	@Override
	public void run() {
	     /* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			while(true) {
				String message = br.readLine();
				if(message == null) {
					break;
				}
				System.out.println(message);
			}
		} catch(SocketException e) { 
			ChatClient.log("Socket Exception :" + e);
		} catch(IOException e) {
			ChatClient.log("Error:" + e);
		}finally {
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
