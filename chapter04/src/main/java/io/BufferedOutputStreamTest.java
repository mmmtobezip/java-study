package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream  bos = null;
		
		try {
			//주스트림 = 기반스트림 
			//클래스 이름 사용(OutputStream도 가능, 하지만 확실하게 구분짓기 위해 이름으로 사용)
			FileOutputStream fos = new FileOutputStream("hello.txt");
			
			//보조스트림 
			bos = new BufferedOutputStream(fos); //like decorator pattern
																	  //System.out.println(new BracesDecorator(new ConcretComponent()) 과 같음
			
			//
			//char -> int 아스키코드
			//for(int i = 97; i <= 122; i++) {}
			for(int i = 'a'; i <= 'z'; i++) {
				bos.write(i);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found:" + e);
		} catch (IOException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				//자기가 사용하는 보조스트림만 닫으면 됨 -> chain이 걸려서 전부 close됨
				if(bos != null) { 
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
