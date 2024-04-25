package paint;

//실습 2 - 도형그리기 프로그램 
public class Point {
	private int x;
	private int y;

//	public Point() { //ColorPoint의 오류를 해결하기 위한 기본 생성자 -> 자식에서 super(x, y)로 해결 가능
//		
//	}
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
	
	//메서드 오버로딩
	public void show(boolean visible) {
		if(visible) {
//			System.out.println("점(" + x + ", " + y + ")을 그렸습니다.");	
			show();
		} else {
//			System.out.println("점(" + x + ", " + y + ")을 지웠습니다.");
			disappear();
		}
		
	}
	
	//동일한 기능하는 메서드 분리
	public void show() {
		System.out.println("점(" + x + ", " + y + ")을 그렸습니다.");
	}
	
	public void disappear() {
		System.out.println("점(" + x + ", " + y + ")을 지웠습니다.");
	}
	

}
