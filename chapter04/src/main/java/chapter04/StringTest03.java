package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		String s1 = "Hello " + "World" + " java" + 17;
		System.out.println(s1);
		
		//스트링은 불변객체인데, 왜 "+" 연산이 되는지?
		//String s1 = "Hello " + "World" + " java" + 17 -> 
		//String s1 = new StringBuffer("Hello").append(" World").append(" java").append(17).toString();

	}

}
