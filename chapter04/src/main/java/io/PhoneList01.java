package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class PhoneList01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			File file = new File("./phone.txt"); //File은 IO클래스가 아님. File객체를 FileInputStream에 넣어도됨.
			if(!file.exists()) {
				System.out.println("file not found");
				return;
			}
			
			System.out.println("=== 파일정보 ===");
			System.out.println(file.getAbsolutePath()); //파일의 절대 위치
			System.out.println(file.length() + "Bytes"); //byte단위로 나오는 파일의 길이
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
			
			
			System.out.println("=== 전화번호 ===");
			
			//1. 기반스트림
			FileInputStream fis = new FileInputStream(file); // new FileInputStream("./phone.txt")
			
			//2. 보조스트림1(byte|byte|byte => char로 변환)
			InputStreamReader isr = new InputStreamReader(fis, "utf-8"); //(주스트림, 인코딩 유형)
			
			//3. 보조스트림2(char|char|char|\n -> "charcharchar")
			br = new BufferedReader(isr);
			
			//4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t "); //String들을 tab+space로 나눌 예정
				
				int index = 0;
				while(st.hasMoreElements()) { //토큰이 더 남았는지 
					String token = st.nextToken();
					
					//데이터 형식대로 뽑기 위함
					if(index == 0) { //이름 
						System.out.print(token + ":");
					} else if(index == 1) { //전화번호1
						System.out.print(token + "-");
					} else if(index == 2) { //전화번호2
						System.out.print(token + "-");
					} else { //전화번호3
						System.out.print(token + "\n");
					}
					index++;
				}
			}
		} catch(UnsupportedEncodingException e) {
			System.out.println("error:" + e);
			
		} catch(IOException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
