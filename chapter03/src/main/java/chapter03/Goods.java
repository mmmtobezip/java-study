package chapter03;

public class Goods {
	public static int countOfGoods = 0;
	
	//필드 변수 - 소문자 시작 
	private String name;
	private int price; 
	private int countStock; //재고 개수
	private int countSold; //판매 개수 
	
	//3. countOfGoods가 없는 기본 생성자
	//기본 생성자 생성 - 아래 Goods 클래스와 오버로딩(다양한 방식, 파라미터만 다른 생성자)
	//초기화를 안해서 countOfGoods가 늘지 않음. -> 중복되는 코드들이 많아짐.
	public Goods() {
		this("", 0, 0, 0); //오버로딩을 통해 발생하는 countofGoods 중복 방지 코드
	} 
	
	//2. 필요한 값으로 만든 생성자
	public Goods(String name, int price, int countStock, int countSold) {
		//클래스 이름 생략 가능
		countOfGoods++;
		
		//인스턴스 변수 초기화
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
	}

	//1. 기본 생성자
//	public Goods() {
//////내부에선 클래스 이름 생략 가능 
//////Goods.countOfGoods++; 이태릭체 = 클래스 변수 
////countOfGoods++;
//} 

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) {
			price = 0;
		}
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	public void showInfo() {
		System.out.println("상품이름 : " + name + 
							", 상품가격 : " + price + 
							", 판매개수 : " + countSold + 
							", 재고개수 :" + countStock);
	}
	
	//할인 메서드
	public int calcDiscountPrice(float percentage) {
		int result = price - (int)(price * percentage); //int*float = float(큰쪽)로 출력되는데, result를 int타입으로 선언했으니 소수점들이 떨어져나갈 수 있다는 에러 문구가 나옴
		return result;
		
	}
	
	


}
