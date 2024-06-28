//package prob6;
//
//import java.util.ArrayList;
//import java.util.List;
//
////tectangle, recttriangle 만들기 
////shape 추상에는 getArea, getPermter잇음
////그걸 tectangle, recttriangle클래스에서 shape 상속 구현 -> w / h
////shape은 w, h 가질 수 있음. 
////list 2개인데, 하나는 rectangle, 하나는 rectrriangle 
////Resizable 인터페이스 구현 
////rectangle이 resizable구현되고 있는거 잘못됨(-> x)
////
//public class ShapeTest {
//
//	public static void main(String[] args) {
//		List<Shape> list = new ArrayList<Shape>();
//		
//		list.add( new Rectangle(5, 6) );
//		list.add( new RectTriangle( 6, 2) );
//		
//		for( Shape shape : list ) {
//			System.out.println( "area:" + shape.getArea() );
//			System.out.println( "perimeter:" + shape.getPerimeter() );
////			
//			if( shape instanceof Resizable ) {
//				Resizable resizable = (Resizable) shape;
//				resizable.resize( 0.5 );
//				System.out.println( "new area:" + shape.getArea() );
//				System.out.println( "new perimeter:" + shape.getPerimeter() );
//			}
//		}
//	}
//}