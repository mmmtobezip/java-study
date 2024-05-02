package thread;

public class ThreadEx02 {

	public static void main(String[] args) {
		//start()전에는 단지 객체만 생성한 것 
		Thread thread1 = new DigitThread();
		Thread thread2 = new AlphabetThread();
		
		thread1.start();
		thread2.start();
	}
}
