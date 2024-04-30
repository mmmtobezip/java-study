package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PhoneList02 {
	public static void main(String[] args) {
		Scanner sc = null; 
		
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
			sc = new Scanner(file);
			
			while(sc.hasNextLine()) {
				String name = sc.next(); //next() : tab+space : 개행
				String phone = sc.next(); 
				String phone2 = sc.next();
				String phone3 = sc.next();
				
				System.out.println(name + ":" + phone + "-" + phone2 + "-" + phone3);
			}
		} catch(FileNotFoundException e) {
			System.out.println("error:" + e);
		} finally {
			if(sc != null) { //scanner는 null일 가능성이 없긴함
				sc.close();
			}
		}
	}
}