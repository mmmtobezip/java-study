package practice03;

import mypackage.Goods2;

//practice03에 DiscountGoods2 클래스를 만들되, mypackage에 있는 Goods2클래스를 상속
public class DiscountGoods2 extends Goods2 {
	private float discountRate = 0.5f;
	
	public float getDiscountPrice() {
		//부모(Goods2)에 protected로 명시한 price는 자식에서 접근 가능(다른 패키지라도) 
		return discountRate * price;
	}

}
