package structural.decorator;

//FileInputStream/FileOutputStream과 같음
public class ConcretComponent extends Component {

	private String text; 
	
	//생성자 
	public ConcretComponent(String text) {
		this.text = text;
	}
	
	//abstract의 구체적인 구현
	@Override
	public String operation() {
		return text; //데이터를 String으로 바꿔 return 해주는 기능
	}
}
