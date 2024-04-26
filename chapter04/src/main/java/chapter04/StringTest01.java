package chapter04;

public class StringTest01 {
	public static void main(String[] args) {
		// c:\temp
		System.out.println("c:\\temp"); //\t : tap으로 인식 -> \\ or / 사용해줘야 경로 출력 가능
		
		// "Hello"
		System.out.println("\"Hello\""); // \: escape에 사용
		
		// 제어문자 \(역슬래시 사용)
		// \t : tab
		// \n : newline(개행문자)
		// \r : carriage return 
		// \b : beep
		
		System.out.print("hello\tworld\n");
		System.out.println("hello\tworld");
		
		//
		char c = '\'';
		System.out.println(c);
	}
}
