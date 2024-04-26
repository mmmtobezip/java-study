package exception;

@SuppressWarnings("serial")
public class MyException extends Exception {
	/**
	 * 객체를 파일에 저장하는데 복원 시 사용되는 고유한 번호
	 * private static final long serialVersionUID = 1L;
	 */
	public MyException(String message) { //커스텀 메시지 
		super(message);
	}
	
	public MyException() {
		super("MyException Thrown"); //기본 메시지
	}

}
