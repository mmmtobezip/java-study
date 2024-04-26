package prob04;

//오버라이드 문제
public class Prob04 {

	public static void main(String[] args) {
		Employee pt = new Depart( "홍길동", 3000, "개발부" );
		/*
		 * 현재 Employee는 name과 salary만 받고 있음. 
		 * depart 오버라이드해서 주소까지 나오게?
		 */
		pt.getInformation();
	}
}