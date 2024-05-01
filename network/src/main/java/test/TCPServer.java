package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			//1. Create ServerSocket
			serverSocket = new ServerSocket(); 
			
			//2. Binding - Socket에 InetSocketAddress[InetAddress(IpAddress + Port = 객체]를 바인딩 
			//serverSocket.bind(new InetSocketAddress("127.0.0.1", 5000), 10); //"127.0.0.1"와 같이 특정 호스트 IP 대역을 바인딩 하는걸 지양
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10); //"": ip, 5000: port, 10: 대기 백로그 queue size
			
			//3. Accept
			Socket socket = serverSocket.accept(); //blocking
			System.out.println("[연결!!]"); //해당 출력문은 서버-클라이언트 연결된 후 출력되지 않음. -> serverSocket은 blocking 상태로 돌아가 소켓은 닫힌다.
			
		
		} catch (IOException e) {
			System.out.println("[Server] error: " + e);
		} finally {
			try {
				//Close ServerSocket
				if(serverSocket != null && !serverSocket.isClosed()) { //socket닫고, 스트림도 닫으면 2개를 닫는거라 에러가난다. 따라서 serverSocket의 닫힘 유무로 and연산 해주기
					serverSocket.close(); //소켓은 안에 스트림이 존재 -> 스트림을 close()하면 socket도 close(). 실제 데이터를 주고받는건 socket stream이다. 따라서 두개 모두 close되는 조건을 야기할 수 있음
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}

}
