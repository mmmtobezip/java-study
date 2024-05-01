package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

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
			
			
			//서버 소켓 try문 위에까지 
			try {
				//클라이언트쪽 ip+port가 들어있는 inetRemoteSocketAddress
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress(); //다운캐스팅 
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress(); //getAddress() -> InetAddress객체가 나오고 -> getHostAddress()는 Client의 Socket 객체 ip주소
				int remotePort = inetRemoteSocketAddress.getPort(); //서버와 accept() 후 만들어진 새로운 Client의 Socket 객체의 포트번호 
				System.out.println("[Server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");
			
				//4. IO Stream 받아오기 
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				
				while(true) {
					//5. 데이터 읽기 - 소켓통신은 byte단위로 읽어들임
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // 읽는 순간 blocking되기에 무한루프도 ok
					
					if(readByteCount == -1) { 
						//클라이언트가 정상적으로 종료, 명시적으로 소켓이 close() 호출한 것 
						System.out.println("[Server] closed by client");
						break;
					}
					//if문을 안탔으니 close()는 호출이 안된거고, 읽은 데이터를 화면에 뿌려야함.
					String data = new String(buffer, 0, readByteCount, "UTF-8"); //encoding, 256을 다 하는게 아니라 limit(readByteCount)을 정해줌
					System.out.println("[Server] received:" + data);
					
					//6. 데이터 쓰기 - outputstream 활용
					os.write(data.getBytes("UTF-8")); //string객체에서 byte를 꺼내오는 방법 getBytes()
				}
				
			} catch(SocketException e) { //통신중에 발생한 에러 
				System.out.println("[Server] suddenly closed by client");
			} catch(IOException e) {
				System.out.println("[Server] error:" + e);
			}finally {
				try {
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}	 
			
		} catch(IOException e) {
			System.out.println("[Server] error: " + e);
			} finally {
				try {
					//Close ServerSocket
					if(serverSocket != null && !serverSocket.isClosed()) { //socket닫고, 스트림도 닫으면 2개를 닫는거라 에러가난다. 따라서 serverSocket의 닫힘 유무로 and연산 해주기
						serverSocket.close(); //소켓은 안에 스트림이 존재 -> 스트림을 close()하면 socket도 close(). 실제 데이터를 주고받는건 socket stream이다. 따라서 두개 모두 close되는 조건을 야기할 수 있음
					}
				} catch (IOException e) { //ServerSocket에 대한 예외 처리
					e.printStackTrace();
				}
			}
		}
	}


