package creational.factorymethod;

import java.util.Map;
import java.util.Scanner;

public class WiseClient {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("화면선택(2d, 3d): ");
    String dimension = scanner.nextLine();

    System.out.print("도형번호: ");
    int shapeNo = scanner.nextInt();

    // 추상클래스
    Screen screen = "3d".equals(dimension) ? new Screen3D() : new Screen2D();
    screen.display(shapeNo); // operation
  }

  // Screen3D - 추상클래스 Screen을 구현하는 구현 클래스
  private static class Screen3D extends Screen {
    // 초기화 e.g. int[] is = new int[] {10, 20, 30};
    // map 초기화 방법
    private Map<Integer, Drawable> mapShape = Map.of(
        // key, value
        1, new Sphere(), 2, new Cube());

    // factory method
    @Override
    public Drawable getShape(int shapeNo) { // 객체 생성을 팩터리 메서드에 대한 호출로 대체 ?
      return mapShape.get(shapeNo);
    }
  }


  private static class Sphere implements Drawable {
    @Override
    public void draw() {
      System.out.println("구를 그렸습니다."); // Screen에 있던 구를 그리는 객체 역할 분리
    }
  }

  private static class Cube implements Drawable {
    @Override
    public void draw() {
      System.out.println("사각기둥을 그렸습니다.");
    }
  }

  // Screen2D
  private static class Screen2D extends Screen {
    private Map<Integer, Drawable> mapShape = Map.of(1, new Triangle(), 2, new Rectangle());

    @Override
    public Drawable getShape(int shapeNo) {
      return mapShape.get(shapeNo);
    }
  }

  private static class Triangle implements Drawable {
    @Override
    public void draw() {
      System.out.println("삼각형을 그렸습니다.");
    }
  }

  private static class Rectangle implements Drawable {
    @Override
    public void draw() {
      System.out.println("사각형을 그렸습니다.");
    }
  }
}
