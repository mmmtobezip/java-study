package thread;

public class UpperCaseAlphabet { //스레드 아님
	
	public void print() {
		for(char c = 'A'; c <= 'J'; c++) {
			System.out.println(c); 
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
