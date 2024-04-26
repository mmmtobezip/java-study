package chapter04;

public class StringTest02 {

	public static void main(String[] args) {
		//immutability(불변성) 
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		
		s2 = s1.toUpperCase(); //s2는 새로운 객체로 만등어짐 
		String s4 = s2.concat("??"); //임시적으로 이름이 없는 객체 생성됨  
		String s5 = "!".concat(s2).concat("@");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		System.out.println(equalsHello("hello"));
		//System.out.println(equalsHello(null));
		
	}
	
	
	private static boolean equalsHello(String s) {
		return s.equals("hello"); //null이 들어오면 에러발생함
		//return "hello".equals(s); //비교하고 싶은 스트링이 리터럴이면 비교할 스트링을 앞에, 변수를 뒤에 -> 왜냐면 equals()가 호출된 후 "hello" 객체 사라질 것 
	}

}
