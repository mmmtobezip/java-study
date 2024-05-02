package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			//1. socket 생성
			socket = new Socket();
			
			//2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT)); //파라미터로 줘도 되고, 상수로 만들어서 넣어도 됨.
			
			//3. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//4. 쓰기 
			String data = "Hello World";
			os.write(data.getBytes("UTF-8"));
			
			//5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if(readByteCount == -1) { //로직상 서버가 먼저 끊진 못함. -> 정상적인 종료 시 아래 에러
				System.out.println("[Client] closed by Server");
				return; //종료시킴
			}
			
			//38라인으로 온건 데이터를 잘 읽은 것 -> 인코딩 해준 후 화면에 뿌리기 
			data = new String(buffer, 0, readByteCount, "UTF-8"); //Line40 -> 보조스트림인 InputStreamReader에게 맡기면 된다. (경계가 없는걸 "\n개행"을 붙여 보낸다.) 읽을 땐 개행 제외 bufferedReader로 읽기 
			System.out.println("[Client] received:" + data);
		} catch (SocketException e) {
			System.out.println("[Client] suddenly closed by Server");
		}  catch (IOException e) {
			System.out.println("[Client] error:" + e);
		} finally {
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
//서버 -> 클라이언트 연결 -> 클라리언트 write -> 서버 return -> 