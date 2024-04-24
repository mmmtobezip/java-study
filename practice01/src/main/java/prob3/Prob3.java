package prob3;

import java.util.Scanner;

public class Prob3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("숫자를 입력하세요: ");
    int num = sc.nextInt();

    if (num < 0) {
      System.out.println("음수는 입력할 수 없습니다");
    } else {
      int sum = calculateSum(num);
      System.out.println("결과값: " + sum);
    }
    sc.close();
  }

  public static int calculateSum(int num) {
    int sum = 0;
    if(num % 2 == 1) {
      for (int i = 1; i <= num; i += 2) {
        sum += i;
      }
    } else {
      for (int i = 2; i <= num; i += 2) {
        sum += i;
      }
    }
    return sum;
  }
}