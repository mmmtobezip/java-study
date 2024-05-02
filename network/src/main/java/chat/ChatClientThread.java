package chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

//scanner로 체크하는 클라 메인 스레드
//닉네임 입력 
//서버와 연결 후 join -> 성공 시 -> bufferedreader를 스레드 안에서 스레드에게 던져줘서 read?
//포멧 출력?
//스캐너로 입력하면 
public class ChatClientThread extends Thread {

	
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

	@Override
	public void run() {
		super.run();
	}

}
