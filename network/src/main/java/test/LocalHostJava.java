package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

//내 PC의 ip를 알기 위한 테스트 클래스 
public class LocalHostJava {
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost(); //4byte
			
			String hostName = inetAddress.getHostName(); //컴퓨터 이름은 PC마다 부여됨. 서버 이름은 대체적으로 green, yellow, white등과 같음. 
			String hostIpAddress = inetAddress.getHostAddress(); //local host, 내 네트워크 프로그램이 돌고 있는 로컬의 주인, 반대쪽(클라이언트)는 remote host가 됨.
			
			System.out.println(hostName);
			System.out.println(hostIpAddress);
			
			byte[] ipAddress =inetAddress.getAddress(); //4byte - original
			for(byte IpAddress : ipAddress) { //1byte씩 출력
				//System.out.print((int)IpAddress); //192 = -64, 168 = -88로 나오는데 2의 보수때문 
				System.out.println(IpAddress & 0x000000ff);
			}
			
		} catch (UnknownHostException e) { //getLocalHost() exception
			e.printStackTrace();
		}
	}

}
