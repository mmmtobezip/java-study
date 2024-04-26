package chapter04;

import java.util.Objects;

//기본적으로 Object를 상속받게함.(=부모) 
public class Point {
	private int x;
	private int y;
	
	//기본 생성자
	public Point() {
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() { //객체를 String으로 바꿀 때 자기 값을 사용 -> 클래스 이름만 나오는 역할 -> 객체 안의 값을 디버깅할 때 자주씀 
		return "Point [x=" + x + ", y=" + y + "]";
	}
	/*
	 * hashcode는 주소를 해싱한거, 이걸 오버라이드함. 
	 * equals와 함께 오버라이드 하게 되는데 이유는 뭘까 
	 * 
	 * 객체의 equals란? !=equals()
	 * = 같다
	 * 1. 동일성 2. 동질성
	 * -2개의 객체(P1==P2 객체의 레퍼런스가 1000번째이면, ==연산자로 레퍼런스하는 값이 같은지, 같은 객체(e.g. 기본타입, String)인지 비교한다 : 동일성 
	 * -2개의 객체(설상 P1!=P2 두 객체의 속 내용이 같은 데이터인지 비교할 때(e.g. 자료구조) -> set에 넣으면 안됨. : 동질성 
	 * -동일하면 동질하다. 하지만 자료구조는 내용을 따짐. -> ==연산자를 사용할 수 없음. -> equals() 사용
	 * 
	 */
	
	//동질성은 hashcode로 선검사 -> 같으면 내용 비교 -> equals()와 hashCode() 같이 쓰는 이유
	@Override
	public int hashCode() {
		return Objects.hash(x, y); //내용 기반 hashing
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}


}
