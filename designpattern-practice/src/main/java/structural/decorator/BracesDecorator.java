package structural.decorator;

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
