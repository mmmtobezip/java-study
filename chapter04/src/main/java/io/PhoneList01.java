package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class PhoneList01 {
	public static void main(String[] args) {
		try {
			File file = new File("./phone.txt"); //File은 IO클래스가 아님. File객체를 FileInputStream에 넣어도됨.
			if(!file.exists()) {
				System.out.println("file not found");
				return;
			}
			
			System.out.println("=== 파일정보 ===");
			System.out.println(file.getAbsolutePath()); //파일의 절대 위치
			System.out.println(file.length() + "Bytes"); //byte단위로 나오는 파일의 길이
			//System.out.println(file.lastModified()); //ms - long타입 
			
			//Date d = new Date(file.lastModified()); //Calendar도 가능
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
			
			
			System.out.println("=== 전화번호 ===");
			
			//1. 기반스트림
			FileInputStream fis = new FileInputStream(file); // new FileInputStream("./phone.txt")
			
			//2. 보조스트림(byte|byte|byte => char로 변환)
			InputStreamReader isr = new InputStreamReader(fis, "utf-8"); //(주스트림, 인코딩 유형)
			fis.read(); //IOException 처리 필요
			 
		} catch(UnsupportedEncodingException e) {
			System.out.println("error:" + e);
			
		} catch (FileNotFoundException e) {
			//catch안에선 log -> 사과 -> 자원해제(close)
			//FileNotFoundException은 메모리를 많이 차지함. -> 로직을 추가하지 않기		
		} catch (IOException e) { //FileNotFoundException은 IOException의 자식, 먼저 IOException으로 예외를 발생시켜도 됨. 
								  //그렇기 때문에 IOException을 먼저 처리하면, FileNotFoundException을 적을 필요x (하위 예외로 들어갈 일이x)
			
		}
	}
}
