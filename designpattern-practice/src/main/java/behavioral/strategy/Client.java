package behavioral.strategy;

public class Client {

  public static void main(String[] args) {
    CalculateContext cc = new CalculateContext();
    cc.execute(new CalculateStrategy() { // 대상 전략 = interface 주입
      @Override
      public int calculate(int val1, int val2) {
        return val1 + val2;
      }
    });

    cc.execute((val1, val2) -> { // 함
      return 0;
    });



    cc.execute((val1, val2) -> val1 - val2); // 함수
    cc.execute((val1, val2) -> val1 * val2);
    cc.execute((val1, val2) -> val1 / val2);
  }

}
