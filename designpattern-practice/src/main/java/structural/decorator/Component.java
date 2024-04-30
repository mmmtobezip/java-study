package structural.decorator;

//상위 추상스트림 = 주스트림 
//InputStream/OutputStream과 같음
public abstract class Component {
	//정의되지 않은 operation() 존재
	//리턴이 String 타입
	public abstract String operation();
}
