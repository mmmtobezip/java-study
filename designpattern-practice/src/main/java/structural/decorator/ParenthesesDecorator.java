package structural.decorator;

public class ParenthesesDecorator extends Decorator {

	public ParenthesesDecorator(Component component) { //앞에것의 String을 받을 수 있게
		super(component);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String operation() {
		//앞에게 데코레이터라면 처리된게 오고, 주스트림이 오면 string이 온다?
		String text = component.operation();
		return "(" + text + ")";
	}

}
