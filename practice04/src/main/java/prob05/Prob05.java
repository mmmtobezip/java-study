package prob05;

//수정 금지 
public class Prob05 {

	public static void main(String[] args) {
		Base base = new MyBase();
		//Mybase에서 base를 상속받아 -> mybase구현 후 실행결과 출력하면됨.

		base.service("낮");
		base.service("밤");
		base.service("오후"); 
	}
}
