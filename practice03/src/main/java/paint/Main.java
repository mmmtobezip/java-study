package paint;

// 도형 그리기 프로그램 본체 
public class Main {

	public static void main(String[] args) {
		Point point = new Point(10, 20);
//		point.setX(10);
//		point.setY(20);
		drawPoint(point);

	}
	
	private static void drawPoint(Point point) {
		point.show();
	}

}
