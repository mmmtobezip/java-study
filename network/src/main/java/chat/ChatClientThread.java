package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

//scanner로 체크하는 클라 메인 스레드
//닉네임 입력 
//서버와 연결 후 join -> 성공 시 -> bufferedreader를 스레드 안에서 스레드에게 던져줘서 read?
//포멧 출력?
//스캐너로 입력하면 

//콘솔에 서버로부터 받은 데이터 출력하기
//multi - thread 
public class ChatClientThread extends Thread {
	
	private Socket socket;
	private BufferedReader br;
	
	public ChatClientThread(Socket socket) { //생성자 지정 
		this.socket = socket;
	}
	
	//키보드에 들어오는 출력만
	@Override
	public void run() {
	     /* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */	
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			while(true) {
				String message = br.readLine();
				if(message == null) {
					break;
				}
				ChatClient.log(message);
			}
		} catch(SocketException e) { 
			ChatClient.log("Socket Exception :" + e);
		} catch(IOException e) {
			ChatClient.log("error:" + e);
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
