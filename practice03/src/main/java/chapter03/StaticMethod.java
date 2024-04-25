package chapter03;

public class StaticMethod {
	int n; //인스턴스 변수
	static int m; //메서드가 되는 static 변수
	
	void f1() {
		n = 10; //인스턴스 접근 가능 
	}
	
	void f2() {
		StaticMethod.m = 10;
		
		//같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능 / 물론 외부에선 접근 불가
		m = 20;
	}
	
	void f3() {
		f2();
	}
	
	void f4() {
		StaticMethod.s1(); //객체 없이 부를 수 있음 
		
		//같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능 
		s1();
	}
	
	static void s1() {
		//Error : static method에서는 instance 변수 접근 불가
		//n = 10; // 객체 존재 여부 등 모르기에
	}
	
	static void s2() {
		//Error : static method에서는 instance 메서드 접근 불가
		//f1();
	}
	
	static void s3() {
		StaticMethod.m = 10;
		
		//같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능 / 물론 외부에선 접근 불가
		m = 10;
	}
	
	static void s4() {
		StaticMethod.s1();
		
		//같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능 
		s1();
	}
	
	//static -> static 끼리만 접근 가능 - 메소드 #finish 
}
