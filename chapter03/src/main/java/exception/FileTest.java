package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//checked exception 예외(강제 체크)
public class FileTest {
	
	public static void main(String[] args)  {
		FileInputStream fis = null; //파일 읽는 클래스
		
		/*
		 * Unhandled exception type FileNotFoundException : 생성자가 자동으로 던지는 예외 -> 처리가 필요하다고 알려줌(checked exception)
		 * 위 같은 에러를 던지는 예외들이 io, jdbc 등 주로 통신하는 클래스들에서 발생
		 */
		
		//public static void main(String[] args) throws FileNotFoundException {}  1. 다시 자바 밖으로 던져서 예외 처리하는 방법
		// 2. try-catch 예외 처리 
		try {
			fis = new FileInputStream("checkedExceptionTest.txt");	
			int data = fis.read();
			System.out.println((char)data); //byte코드
		} catch (FileNotFoundException e) { //filenotfound excpetion
			System.out.println("error: " + e);
		} catch (IOException e) { //filenotfound excpetion
			System.out.println("error: " + e);
		} finally { //자원 종료도 필요 
			try {
				if(fis != null) { //nullpoint exception 
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
