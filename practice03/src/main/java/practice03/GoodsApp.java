package practice03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods camera = new Goods("nikon", 40000, 10, 20); 
//		camera.setName("nikon");
//		camera.setPrice(400000);
//		camera.setCountSold(10);
//		camera.setCountStock(20);
		
		camera.showInfo();
		
		//정보은닉
		camera.setPrice(-4000000);
		
		// static 변수(클래스 변수)
		Goods goods2 = new Goods(); //기본 생성자 사용 - 객체 생성
		Goods goods3 = new Goods();
		System.out.println(Goods.countOfGoods); //countOfGoods를 생성한 내부클래스가 아닌 경우엔, 클래스 이름 생략 불가능
		
		camera.setPrice(4000000);
		System.out.println(camera.calcDiscountPrice(0.5f));
	}

}
