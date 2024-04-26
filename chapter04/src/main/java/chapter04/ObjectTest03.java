package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		/*
		 * s1, s2은 현재 "hello" 객체를 가르키고 있음
		 */
		System.out.println(s1 == s2); // false (동의성)
		System.out.println(s1.equals(s2)); // true (동질성)
		System.out.println(s1.hashCode() + " : " + s2.hashCode()); //내용 기반 해시값(오버라이드) -> 해시코드 같은 이유 
		System.out.println(System.identityHashCode(s1) + " : " + System.identityHashCode(s2)); //s1의 주소기반 해시값(Systme에서 util메서드로 제공)
		
		System.out.println("===========================");
		
		String s3 = "hello";
		String s4 = "hello";
		
		//new String()으로 안만들어도 리터럴로 쓰면 new String("hello")로 컴파일러 변경해주는데, 결과가 다른 이유  
		System.out.println(s3 == s4); // true
		System.out.println(s3.equals(s4)); // true
		System.out.println(s3.hashCode() + " : " + s4.hashCode()); 
		System.out.println(System.identityHashCode(s3) + " : " + System.identityHashCode(s4)); 
		/*
		 * String객체를 만들 때 리터럴을 사용해야함.(new String() x)
		 * JVM에는 상수풀
		 */

	}

}
