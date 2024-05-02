package thread;

public class ThreadEx01 {
	public static void main(String[] args) {
		//개별 스레드로 돌리기
//		for(int i = 0; i < 10; i++) {
//			System.out.print(i);
//		}
		
		new DigitThread().start();
		

	}
}
