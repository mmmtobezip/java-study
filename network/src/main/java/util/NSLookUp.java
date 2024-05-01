package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookUp {
	public static void main(String[] args) {
		BufferedReader bf = null;
		
		while(true) {
			System.out.print(">");
			try {
				bf = new BufferedReader(new InputStreamReader(System.in));
				String input = bf.readLine();
				if(input.equals("exit")) {
					System.out.println("프로그램 종료");
					break;
				}
				
				InetAddress[] inetAddress = InetAddress.getAllByName(input); //("부여받은 이름"), 네이버는 예시, 이름으로 여러 ip 호출 가능
				
		        for (InetAddress address : inetAddress) {
		        	System.out.println(input + " : " + address.getHostAddress());
		        }
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


