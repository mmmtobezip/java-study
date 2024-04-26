package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		try {
			new MyClass().danger();
		} catch (IOException e) {
			e.printStackTrace(); //예외가 발생한 stack 상태를 보여줌(어떤 메서드안에서 예외가 발생했는지)
		} catch (MyException e) {
			System.out.println("error:" + e);
		}
		

	}

}
