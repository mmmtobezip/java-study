package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Scanner sc = null;
		DatagramSocket socket = null;
	
		try {
			//1. scanner 생성 
			sc = new Scanner(System.in);
			//2. socket 생성
			socket = new DatagramSocket();
			
			while(true) {
				System.out.print(">>");
				String message = sc.nextLine();
				
				if(("quit").equals(message)) {
					break;
				}
				
				//3. 데이터 보내기
				//보낼 데이터를 byte[]로 뽑고 - IOException 처리 필요(read/write할 때)
				byte[] sendData = message.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,new InetSocketAddress(SERVER_IP, UDPEchoServer.PORT)); 
				socket.send(sendPacket);
				
				//4. 데이터 받기
				DatagramPacket rcvPacket = new DatagramPacket(new byte[UDPEchoServer.BUFFER_SIZE], UDPEchoServer.BUFFER_SIZE); //통신할 땐 서버의 버퍼 사이즈와 동일해야함. 
				socket.receive(rcvPacket);
				
				byte[] rcvData = rcvPacket.getData();
				int offset = rcvPacket.getLength();
				message = new String(rcvData, 0, offset, "UTF-8");
				System.out.println("<" + message);
			}
		} catch (SocketException e) {
			System.out.println("[UDP Echo Client] error: " + e);
		} catch (IOException e) {
			System.out.println("[UDP Echo Client] error: " + e);
		} finally {
			if(sc != null) {
				sc.close();
			}
			if(socket != null & !socket.isClosed()) {
				socket.close();
			}
		}

	}

}
