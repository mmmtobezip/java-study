package chapter03;

public class Student extends Person {
	public Student() {
		//부모의 기본 생성자를 컴파일러가 자동으로 넣어줌. 
		//자식 생성자에서 부모생성자를 명시적으로 호출하지 않으면 
		//자동으로 부모의 기본 생성자를 호출하게 된다. = super()
		//super(); 부모를 호출하는 메서드 -> 상속은 자동으로 super가 동작됨.
		//super()는 명시를 할 때 sysout보다 먼저 불리는 단계임 - 가장 먼저 호출
		//->sysout뒤에 super()넣으면 에러 나는 이유
		System.out.println("Student() called");
	}
	
}
