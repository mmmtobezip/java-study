package chapter04;

public class WrapperClassTest01 {
	public static void main(String[] args) {
		//직접 생성하면 heap영역에 객체가 존재하게 된다. 
		//리터럴(literal)을 사용하면 JVM안의 Constant Pool에서 관리하게 된다. 
		//원래 객체 생성 방법 하지만, deprecated
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		//Auto Boxing(객체 생성 권장 방법)
		Integer j1 = 10;
		Integer j2 = 20;
		
		System.out.println(j1 != j2);
		System.out.println(j1.equals(j2)); //객체이기에 equals() 호출 가능 
		
		//Auto Unboxing(기본값)
		int m = j1 + 10;
		//int m = j1.intValue() + 10; 객체이기에 메서드로 부를 수도 있으나 기본 타입 호출 권장 
	}
}
