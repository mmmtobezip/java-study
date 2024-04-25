package mypackage;

public class Goods2 {
	public String name; //모든 접근 가능한 변수(제한x)
	protected int price; //같은 패키지 + 자식 클래스 접근 가능한 변수 
	int countStock; //같은 패키지(default)에서만 접근 가능한 변수  -> 잘안씀 
	private int countSold; //클래스 내부에서만 접근 가능한 변수
	
	public void privateTest() {
		countSold = 50;
	}

}
