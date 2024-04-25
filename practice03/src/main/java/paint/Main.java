package paint;

// 도형 그리기 프로그램 본체 
public class Main {

	public static void main(String[] args) {
		Point point = new Point(10, 20);
//		point.setX(10);
//		point.setY(20);
		drawPoint(point);
//		point.disapper();
		point.show(false); //true면 찍고, false면 지우는 파라미터에 따라 다양한 기능 제공 : 다형성
		
		ColorPoint point2 = new ColorPoint(100, 200, "red");
		drawColorPoint(point2); //부모의 기능을 부르므로 자식의 "red"는 나오지 않음 -> 해결을 위해 오버라이딩
	}
	
	private static void drawPoint(Point point) {
		point.show();
	}
	
	private static void drawColorPoint(ColorPoint point) {
		point.show();
	}
}
