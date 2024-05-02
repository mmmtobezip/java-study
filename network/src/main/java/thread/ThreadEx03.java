package thread;

public class ThreadEx03 {

	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new AlphabetThread();
		Thread thread3 = new Thread(new UpperCaseAlphabetRunnable()); //생성자로 runnable을 구현하는 객체를 넣어주고, 스레드를 생성하게
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
