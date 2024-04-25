package paint;

// 도형 그리기 프로그램 본체 
public class Main {

	public static void main(String[] args) {
		Point point = new Point(10, 20);
		//drawPoint(point);
		//point.show(false); //true면 찍고, false면 지우는 파라미터에 따라 다양한 기능 제공 : 다형성
		draw(point);
		ColorPoint point2 = new ColorPoint(100, 200, "red");
		//drawPoint(point2);  //오버라이딩 : 확장성 -> 캐스팅 발생
		/*
		 * downcasting, upcasting
		 * 
		 * ColorPoint cp = new ColorPoint();
		 * Point p = cp; 업 캐스팅(자식이 밑, 부모가 위) -> 따로 명시안해도 가능한(암시적)
		 */
		//point2.show(true); //boolean을 override안해도 color가 나옴 -> Point의 show()에 visible
		draw(point2);
		//drawTriangle(new Triangle());
		//drawRectangle(new Rectangle());
		draw(new Triangle());
		draw(new Rectangle());
		draw(new Circle());
		
		draw(new GraphicText("Hello World"));
		
		//instanceof 연산자
		Circle c= new Circle();
		System.out.println(c instanceof Circle); //true
		System.out.println(c instanceof Shape); //true
		System.out.println(c instanceof Object); //true
		
		/*
		 * 아래 라인은 오류 : 연산자 우측항이 클래스인 경우,
		 * 				  레퍼런스 하고있는 class 타입의 hierachy 상의 하위 상위만
		 * 				  instanceof 연산자 사용 가능   
		 */
		//System.out.println(c instanceof Point);
		
		/*
		 * 참고로 인터페이스의 경우 상속 관계가 아니므로 기능의 구현 여부를 묻는 클래스이기에 hierachy 관계x
		   -> instanceof 사용 불가 
		 * 
		 */
		Object o = new Circle(); //레퍼런스하고 있는 타입의 상/하위만 
		System.out.println(o instanceof String);  //false
		
		
		/*
		 * 연산자 우측항이 인터페이스인 경우,
		 * Hierachy 상관없이 instanceof 연산자를 사용할 수 있다. 
		 */
		System.out.println(c instanceof Drawable);
		System.out.println(c instanceof Runnable);
		
		
		
		
	}
	
	private static void drawPoint(Point point) {
		point.show();
	}
	
	private static void drawShape(Shape shape) {
		shape.draw();
	}
	
	private static void draw(Drawable drawable) {
		drawable.draw();
	}
	
//	private static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	private static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
//	}
}
