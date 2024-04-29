package prob5;

public class MainApp02 {
	public static void main(String[] args) {
		try {
			MyStack02 stack = new MyStack02(3); //String[] buffer = new String[3];  
			stack.push("Hello"); //값 넣기 
			stack.push("World");
			stack.push("!!!");
			//stack.push("java");
			//stack.push(1); //에러 발생 ->int를 넣으면 pop()에서 String()타입으로 꺼내기에 타입캐스팅 오류 발생, 들어갈 땐 upcasting이기에 암시적으로 들어갔지만, 꺼낼 때(pop()) 오류남 -> Object를 리턴하니 컴파일 단계에선 다운캐스팅으로 인식하고 넘어가지만, 런타임때 ClassCastException발생
			//Object객체를 쓰면 컴파일에는 안나오지만 런타임때 에러를 발견함 -> 컴파일 때 문제를 발견해 해결하는 Generic클래스 사용 권장
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = (String)stack.pop(); 
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack02(3);
			stack.push("Hello");

			System.out.println(stack.pop()); 
			System.out.println(stack.pop()); //비어 있는 상태에서 pop() 재호출 -> exception 발생 -> null return이 아니라 mystackexception 발생
			
		} catch ( MyStackException ex) {
			System.out.println( ex );
		}

	}

}