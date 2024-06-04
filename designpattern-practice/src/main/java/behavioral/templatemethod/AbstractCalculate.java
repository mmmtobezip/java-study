package behavioral.templatemethod;

import java.util.Scanner;

@SuppressWarnings("resource")
// Calculator의 템플릿 패턴 적용 버전
public abstract class AbstractCalculate {
  public void templateMethod() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("(val1, val2) > ");
    int val1 = scanner.nextInt();
    int val2 = scanner.nextInt();

    int result = calculate(val1, val2);

    System.out.println(result);

  }

  public abstract int calculate(int val1, int val2);
  // hook()으로 남겨두기, 구현은 상속받은 자식들이 처리

}
