package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		
		System.out.println("상품 이름, 가격, 수량을 입력하세요.(예시: 콜라 1000 10)");

		// 상품 입력
		for(int i = 0; i < COUNT_GOODS; i++) {
			String name = scanner.next();
			int price = scanner.nextInt();
			int count = scanner.nextInt();
			goods[i] = new Goods(name, price, count);
		}

		// 상품 출력
		for(Goods g : goods) {
			System.out.println(g.getName() + 
							   "(가격:" + g.getPrice() + "원)이 " + g.getCount() + "개 입고 되었습니다.");
		}
		
		// 자원정리
		scanner.close();
	}
}
