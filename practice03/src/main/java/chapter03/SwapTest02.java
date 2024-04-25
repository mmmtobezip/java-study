package chapter03;

public class SwapTest02 {

	//GoodsApp을 객체로 만들지 않았음. 
	public static void main(String[] args) {
		int i = 10;
		int j = 20;
		System.out.println(i + ", " + j);
		
		/*swap */
		swap(i, j);
		
		System.out.println(i + ", " + j);
	}
	
	//static method는 인스턴스 메서드를 호출할 수 없음. 
	//4단계로 나눴을 때, 객체가 만들어져야 호출이 가능한데, static method안에서는 인스턴스 메서드 호출할 수 없음.
	//-> 시점이 다르기에 main호출시점에 안만들어졌을수도, static method가 안만들어져 있을수도
	//static method안에서는 static method 호출 가능, static은 동일한 method area에 있기 때문
	private static void swap(int m, int n) {
		
	}

}
