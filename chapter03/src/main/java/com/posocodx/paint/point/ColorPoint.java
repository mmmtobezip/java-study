package com.posocodx.paint.point;

public class ColorPoint extends Point {
	//다른 패키지내 Point를 상속하면, 에러가 나는걸 볼 수 있음
	//컴파일 하는 시점에서 기본 생성자가 없고, 기본 생성자를 넣어줬는데
	//자동으로 기본생성자에 super()가 들어갈테지만, 현재 Point에는 기본 생성자가 없음.
	/*
	 * 부모의 기본 생성자 super()가 존재해야 하는데, Point에는 존재하지 않음
	 * 생성자 오버로딩하면서 x, y값을 받는 것만 존재 -> 에러나는 이유 
	 * 
	 */
	
	// 1. 문제 - 부모 클래스의 기본 생성자 부재
//	public ColorPoint() {
//		//생성자를 만들어도
//		super() //super()이 자동으로 들어가고 Point클래스(부모)를 보면 기본 생성자가 없으므로 에러 발생
//	}
	// 2. 해결 - 부모 클래스의 기본생성자 만들어주기 
	// 3. 자식에서 생성자 만들고, 부모에서 호출하는 x, y를 불러오기
	
	private String color;
	public ColorPoint(int x, int y, String color) {
//		this.x = x; step 1
//		this.y = y; 
//		setX(x); step 2
//		setY(y);
		/*
		 * 1. 생성자 생성
		 * -> 만들어지는 객체 모양은 아래와 같다(new())
		 * 2. Point에는 x, y 존재
		 * 3. ColorPoint에는 color 존재 
		 * 4. 현재 this로 x, y 접근 불가  -> 접근지시자가 private로 되어있으므로
		 * 5. 해결방법은 Point의 x, y필드를 protected로 바꿔주면 됨.
		 * 6. 하지만 부모를 고칠 수 없는 경우가 존재함.
		 * 7. 예를들어 라이브러리 클래스를 부모로 했다면, jar로 묶여있으므로 부모를 고칠 수 없음
		 * 8. 따라서 setter로 값을 받으면됨. 
		 */
		super(x, y); //step 3 -> 그럼 Point에 생성한 기본 생성자를 만들필요x 
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
//	@Override
//	public void show() { //Point override method -> 컴파일 하는 과정에서 오버라이드 메서드인지 체크하기 위해 @(Annotation)사용
//		//super.show(); //부모의 기능을 그대로 사용하되, 부분 재구현도 가능/아니면 아예 새로운 show() 구현도 가능
//		System.out.println("점(x=" + getX() + ", y=" + getY() + 
//							", color=" + color + ")을 그렸습니다.");
//		
//	}

}
