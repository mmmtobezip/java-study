package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 6000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			//1. Create ServerSocket
			serverSocket = new ServerSocket(); 
			
			//2. Binding - Socket에 InetSocketAddress[InetAddress(IpAddress + Port = 객체]를 바인딩 
			serverSocket.bind(new InetSocketAddress("127.0.0.1", PORT), 10); 
			
			//3. Accept
			Socket socket = serverSocket.accept(); //blocking
			System.out.println("[연결!!]"); 
			
		
			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress(); 
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress(); 
				int remotePort = inetRemoteSocketAddress.getPort(); 
				log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
			
				//4. IO Stream 받아오기 
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); //PrintWriter는 안에 BufferedReader가 내장됨 / 앞에 있는 보조스트림(OutputStreamWriter)를 넣어줌
				//내가 보낸 스트링을 getByte()해줄 수 있음 encoding 유형 알려줘야함
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8")); //데이터 읽기 
				//close()해주면 stream이 모두 닫히므로 close()는 안해줘?
				
				
				while(true) {
					String data = br.readLine(); //blocking (키보드, 파일에서 읽는건지 모름) -> 개행을 빼고 읽은 데이터가 data에 담김
					
					if(data == null) { 
						log("closed by client");
						break;
					}
					
					//데이터 받고 서버에게 보내는 로그
					log("recevied:" + data);
					
					// 데이터 쓰기 
					pw.println(data);
				}
			} catch(SocketException e) { 
				log("suddenly closed by client");
			} catch(IOException e) {
				log("error:" + e);
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
			log("error: " + e);
			} finally {
				try {
					//Close ServerSocket
					if(serverSocket != null && !serverSocket.isClosed()) { 
						serverSocket.close(); 
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	private static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}
	}

