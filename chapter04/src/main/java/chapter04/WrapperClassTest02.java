package chapter04;

public class WrapperClassTest02 {
	public static void main(String[] args) {
		String s = "123456";
		//String to Int
		int i = Integer.parseInt(s); //클래스 메서드 parseInt()
		//cf1. 반대로
		String s1 = String.valueOf(i);
		//cf2. 반대로 
		String s2 = "" + i; //StringBuffer가 append()
		System.out.println(s+ ":" + s1 + ":" + s2);
		
		int a = Character.getNumericValue('A'); //16진수 
		System.out.println(a);
		
		//cf. 아스키 코드값
		char c = 'A';
		System.out.println(c); //A
		System.out.println((int) c); //65
		
		//2진수 
		String s4 = Integer.toBinaryString(-15); //양수와 음수가 메모리에 어떻게 올라가는가, 2의 보수 학습
		System.out.println(s4);
		
		//16진수
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
		
	}
}
