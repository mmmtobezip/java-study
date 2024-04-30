package structural.decorator;

//보조스트림의 역할에 따라 분명한 이름
//BufferedInputStream, BufferedOutputStream 등 
//실제 기능을 가지고 있는 
public class BracesDecorator extends Decorator {

	public BracesDecorator(Component component) { //
		super(component);
		
	}

	@Override
	public String operation() {
		String text = component.operation(); //like read()
		return "{" +  text + "}"; //기존 기능에 "{}"를 추가한다.
	}

}
