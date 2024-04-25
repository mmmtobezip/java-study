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

	}
	
	private static void drawPoint(Point point) {
		point.show();
	}

}
