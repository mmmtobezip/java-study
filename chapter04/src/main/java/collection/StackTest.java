package collection;

import java.util.Stack;

//Vector의 자식, 배열구현, push&pop에 sync 설정된
public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		
		while(!s.isEmpty()) { //s.isEmpty() == false -> !s.isEmpty() 
			String str = s.pop();
			System.out.println(str);	
		}
		//스택 비었는데 꺼낼경우 경우 예외 - EmptyStackException 발생
		//s.pop();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		
	}

}
