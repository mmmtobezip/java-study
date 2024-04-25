package chapter03;

import mypackage.Goods2;

public class Goods2App {

	public static void main(String[] args) {
		Goods2 goods = new Goods2();
		
		//public은 접근 제한 없음
		goods.name = "camera";
		
		//protected는 같은 패키지내 접근 가능
		//protected에서 더 중요한 건 자식에서 접근이 가능하다
		//goods.price = 40000;

		//default는 같은 패키지내 접근 가능
		//Goods2가 practice03 패키지내 없으면 에러
		//goods.countStock = 10;
		
		//private는 내부에서만 접근 가능
		//Goods2에서 만든 countSold는 Goods2에서만 사용 가능
		//goods.countSold = 20;
	}

}
