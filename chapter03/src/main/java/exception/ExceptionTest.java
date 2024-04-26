package exception;

//예외 처리 try-catch
public class ExceptionTest {
	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a; //0
		
		//1. 예외 발생 ArithmeticException 
		//int result = (1+2+3) / b; 
		
		System.out.println("Some Code1...");
		
		try {
			System.out.println("Some Code2...");
			System.out.println("Some Code3...");
			
			int result = (1+2+3) / b; 
			
			System.out.println("Some Code4..."); //try 예외 발생 시 출력x 
			System.out.println("Some Code5...");
			
		} catch(ArithmeticException ex) { 
			/* ArithmeticException 예외 처리 */
			
			//1. 로깅(파일로 남겨두기) 
			System.out.println("error: " + ex);
			//2. 정상 종료 
			//System.exit(0); 
			return;
		} finally {
			System.out.println("자원 정리: e.g. close file, socket, db connection"); //파일을 열었거나, 
		}
		
		System.out.println("Some Code6...");
		System.out.println("Some Code7...");
		
	}

}
