package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	public static final int PORT = 6000; 
	public static final int BUFFER_SIZE = 1024;
	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			//1. 소켓 생성 
			socket = new DatagramSocket(PORT);
			
			//UDPServer의 역할은 패킷을 만들어서 클라이언트로부터 받은 패킷이 제대로 들어왔는지 체크 필요 
			while(true) {
				//2. 데이터 수신 : 패킷을 만들고 파라미터로 수신 체크
				DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(rcvPacket); //데이터 도착 시, rcvPacket에 데이터가 쌓이고 blocking됨. 
				
				byte[] rcvData = rcvPacket.getData(); 
				
				//3. byte -> text로 변환을 위한 encdoing
				int offset = rcvPacket.getLength();
				String message = new String(rcvData, 0, offset, "UTF-8"); //0~offset길이 만큼 encoding 
				
				System.out.println("[UDP Echo Server] received: " + message);
				
				//4. 데이터 송신 rcvPacket을 주소만 변경한채로 사용해도 괜찮겠지만, sendPacket은 주소를 지정해줘야함. 
				//message에서 getByte()로 utf-8로 인코딩 과정 필요
				byte[] sendData = message.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, rcvPacket.getAddress(), rcvPacket.getPort()); // (내용, 내용의 길이, 보낼사람의 주소, 받는사람의 주소)
				
				socket.send(sendPacket);
			}
				
		} catch (SocketException e) {
			System.out.println("[UDP Echo Server] error: " + e);
		} catch (IOException e) {
			System.out.println("[UDP Echo Server] error: " + e);
		} finally {
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}

}
