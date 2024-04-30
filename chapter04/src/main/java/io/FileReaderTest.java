package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader in = null;
		InputStream is = null;
		try {
			in = new FileReader("test.txt"); //주스트림 
			is = new FileInputStream("test.txt"); //파일은 동시에 읽을 수 있음
			
			int data = -1; //char단위로 읽어도 되지만, -1 체크하기 번거로워서 int씀 
			int count = 0;
			while((data = in.read()) != -1) { //int 4byte 중 3byte씩 글자 읽음
				System.out.print((char)data); //문자로 출력하고 싶을 경우 char()붙이면 됨.
				count++;
			}
			
			System.out.println(""); //개행
			System.out.println("count:" + count); //7번
			System.out.println("================");
			
			data = -1;
			int InputStreamCount = 0; //InputStream counting을 위한 count 리셋
			while((data = is.read()) != -1) {
				System.out.print((char)data);
				InputStreamCount++;
			}
			
			System.out.println(""); //개행
			System.out.println("count:" + InputStreamCount); //21번
		} catch (FileNotFoundException e) {
			System.out.println("file not found:" + e);
		} catch (IOException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(in != null) {
					in.close();
				}
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
