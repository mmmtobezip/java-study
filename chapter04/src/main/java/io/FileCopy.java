package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		//추상클래스(좌) 변수명 
		InputStream is = null;
		OutputStream os = null;
		try {
			//파일 읽기 
			is = new FileInputStream("mini.jpg");
			//파일 출력(byte단위로 읽음) 
			os = new FileOutputStream("min.copy.jpg");
			
			int data = -1; //byte로 읽을 수도 있음. 
			while((data = is.read()) != -1) { //파일 끝에 도달하면 -1 return해줌(do-while, while문 모두 사용 가능)
				os.write(data);	
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found: " + e);
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if(is != null) {
					is.close(); //null point exception 발생 가능 
				}
				if(os != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
}
