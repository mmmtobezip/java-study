package prob04;

//오버라이드 문제 - e.g. point의 colorpoint 색깔 나오는 것 처럼 -> 부서까지 나오게 
public class Prob04 {

	public static void main(String[] args) {
		Employee pt = new Depart( "홍길동", 3000, "개발부" );
		pt.getInformation();
	}
}