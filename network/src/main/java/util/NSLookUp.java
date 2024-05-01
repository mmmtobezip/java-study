package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookUp {
	public static void main(String[] args) {
		try {
			InetAddress[] inetAddress = InetAddress.getAllByName("www.naver.com"); //("부여받은 이름"), 네이버는 예시, 이름으로 여러 ip 호출 가능
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
