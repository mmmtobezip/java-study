package prob5;

public class MainApp {

	public static void main(String[] args) {
		try {
			MyStack stack = new MyStack(3); //String[] buffer = new String[3];  
			stack.push("Hello"); //값 넣기 
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = stack.pop(); 
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack(3);
			stack.push("Hello");

			System.out.println(stack.pop()); 
			System.out.println(stack.pop()); //비어 있는 상태에서 pop() 재호출 -> exception 발생 -> null return이 아니라 mystackexception 발생
			
		} catch ( MyStackException ex) {
			System.out.println( ex );
		}

	}

}