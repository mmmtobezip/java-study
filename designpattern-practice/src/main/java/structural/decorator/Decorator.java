package structural.decorator;

//FilterInputStream/FilterOutputStream과 같은 기능을 하는 (보조스트림, Decotrator)
//즉, FilterInputstream은 추상이기에 read를 구현할 수 x
//주스트림일수도 보조스트림일수도?
public abstract class Decorator extends Component {

	//abstract이기에 여기서 operation()을 구현할 수 없음. 단지 추상
//	@Override
//	public String operation() {
//		
//		return null;
//	}
	//Component를 구현하기 위해선 보조스트림인 Decotrator는 그 앞에 있는 주스트림을 불러야한다. 
	protected Component component; //ConcretComponent도 가능 
	
	public Decorator(Component component) {  //주스트림을 생성자에 넣어야한다. 그래야 구현 가능
		this.component = component;
	}
	
	//데코레이터에선 많은 기능을 만들어도 됨. 순서없이 끼워쓰는 용도로 사용되기에
}
