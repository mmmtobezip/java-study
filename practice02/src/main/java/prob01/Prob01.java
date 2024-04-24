package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );
	
		System.out.print("금액: ");
		int input = scanner.nextInt();
		
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		String[] result = {"50000원", "10000원", "5000원", "1000원", "500원", "100원", "50원", "10원", "5원", "1원"};
		
		for(int i = 0; i < MONEYS.length; i++) {
			int cnt = input / MONEYS[i];
			
			if(cnt > 0) {
				System.out.println(result[i] + ": " + cnt + "개");
				input %= MONEYS[i];
			}
		}
		scanner.close();
 	}
}