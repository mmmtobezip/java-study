package prob01;

//오버로딩없이 generic()으로 출력 -> 객체지향적으로 보면 오버로딩을 택하는게 좋음 
public class PrinterTest02 {

	public static void main(String[] args) {
		Printer02 printer = new Printer02();
		//print.<Integer>println(10); 이렇게 타입을 넣어줘야 하지만, 10이 integer타입인걸 알고 있으므로 생략도 가능(파라미터 타입으로 컴파일러가 추론을 함)
		printer.println( 10 );
		printer.println( true );
		printer.println( 5.7 );
		printer.println( "홍길동" );
	}
}