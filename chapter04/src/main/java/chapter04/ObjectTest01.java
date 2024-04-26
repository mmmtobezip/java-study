package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();
		
		Class klass = point.getClass(); //reflection 객체 정보
		System.out.println(klass); 
		
		System.out.println(point.hashCode()); //address 기반의 해싱값(address x, reference x), 16진수
		
		System.out.println(point.toString()); //getClass() + "@" + hashCode() 호출 / 오버라이드(toString()만 가져옴) / 10진수
		System.out.println(point); //객체가 들어오면 객체의 toString()을 println()이 호출함
		

	}

}
