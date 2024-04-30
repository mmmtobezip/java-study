package structural.decorator;

public class Client {

	public static void main(String[] args) {
		//주스트림만 사용
		//하지만, Decorator같이 보조스트림만으론 사용 불가
		System.out.println(new ConcretComponent("Hello World").operation());
		
		//보조스트림 -> 보조스트림 -> 주스트림
		//보조스트림 -> 주스트림
		System.out.println(new BracesDecorator(new ConcretComponent("Hello World")).operation());
		System.out.println(new ParenthesesDecorator(new BracesDecorator(new ConcretComponent("Hello World"))).operation());
		
		System.out.println(new ParenthesesDecorator(new ConcretComponent("Hello World")).operation());
		System.out.println(new BracesDecorator(new ParenthesesDecorator(new ConcretComponent("Hello World"))).operation());
	}
}
