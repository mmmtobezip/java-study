package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			//기반 스트림
			FileReader fr = new FileReader("./src/main/java/io/BufferedReaderTest.java"); // . : chapter04
			
			//보조 스트림 
			br =new BufferedReader(fr);
			
			String line = null; //byte단위는 -1이 파일의 끝임을 나타내지만, string(=char) 단위 객체는 파일의 끝이 null일 때 판단가능  
			
			//buffered는 읽을 때 readLine();
			while((line = br.readLine()) != null) {
				System.out.println(line); //개행
			} 
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found:" + e);
		} catch (IOException e) {
			System.out.println("error:" + e);
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
