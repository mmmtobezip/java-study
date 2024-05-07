package behavioral.observer;

import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    Subject<Integer> intsubject = new Subject<>();// int지만, object 객체가 들어갈 수도 있음

    // observer 등록 - 인터페이스로 구현(Anonymous)
    intsubject.registerObserver(new Observer<Integer>() {
      @Override
      public void update(Integer val) {
        System.out.println("Observer01: " + val);
      }
    });

    // 람다식
    intsubject.registerObserver((Integer val) -> {
      System.out.println("Observer02: " + val);
    });

    /*
     * 파라미터 한 개인 경우 줄이기 가능 intsubject.registerObserver(val -> { System.out.println("Observer01: " +
     * val); });
     */
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.print(">> ");
      int val = sc.nextInt();
      intsubject.changeSubject(val);
    }

  }

}
