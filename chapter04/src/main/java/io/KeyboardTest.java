package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class KeyboardTest {

	public static void main(String[] args) {
		BufferedReader br = null; //enter칠 때 string 받아올 수 있게
		try {
			//1. 기반 스트림(표준입력 stdin, System.in(클래스 변수)) -> JVM 로딩되며 OS로부터 받은 0(키보드) | 1(콘솔) 자동으로 띄워지는
			//2. 보조 스트림(byte|byte|byte| => char)
			InputStreamReader isr = new InputStreamReader(System.in, "utf-8");
			
			//3. 보조 스트림2(char1|char2|char3|\n => "char1char2char3"
			br = new BufferedReader(isr);
			
			//4. 처리
			String line = null;
			while((line = br.readLine()) != null) { //키보드 파일의 끝이란 없음.
				if(line.equals("quit")) { //무한루프 방지
					break;
				}
				System.out.println(line); 
			}
		} catch(IOException e) {
			System.out.println("error: " + e);
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
