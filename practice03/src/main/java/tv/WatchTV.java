package tv;

//TV클래스 테스트하는 클래스
//WatchTV는 건들지 말고, 
public class WatchTV {
	public static void main( String[] args ) {
		TV tv = new TV( 7, 20, false); //1. 생성자 만들어야함 - 채널, 볼륨, 전원 초기화

		tv.status();

		tv.power( true ); //전원

		tv.volume( 120 ); //숫자를 찍는 것도 

		tv.status();

		tv.volume( false ); //boolean을 찍는 것도 있음. 숫자로 채널을 올리고 내릴 수도 있지만, 버튼으로도 가능
							//두개를 오버로딩해야함. 1칸씩 올리고 내리는거 = 채널도 동일하게 구현
							
		tv.status();

		tv.channel( 0 ); //채널 = 볼륨의 경우 max=255이므로, 255를 초과하면 1로, 1에서 내려가면 255로 -> 라운딩 처리?

		tv.status();

		tv.channel( true );

		tv.channel( true );

		tv.channel( true );

		tv.status();

		tv.power( false );

		tv.status();

		}
}
