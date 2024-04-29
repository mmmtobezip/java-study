package prob5;

public class MainApp03 {
	public static void main(String[] args) {
		try {
			MyStack03<String> stack = new MyStack03<>(3); 
			stack.push("Hello"); 
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			//stack.push(1); //컴파일 단계에서 error발생 - MainApp02와 다른점 : 제너릭은 런타임 때 <T>를 사용하는 코드를 넣으면 안됨. -> 컴파일 단계에서 타입 캐스팅 방지 가능하기에 Object 사용보다 권장
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = (String)stack.pop(); 
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack03<>(3);
			stack.push("Hello");

			System.out.println(stack.pop()); 
			System.out.println(stack.pop()); 
			
		} catch ( MyStackException ex) {
			System.out.println( ex );
		}

	}

}