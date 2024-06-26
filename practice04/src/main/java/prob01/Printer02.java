package prob01;

public class Printer02 {
//	public void println(int value) {
//		System.out.println(value);
//	}
//	
//	public void println(boolean value) {
//		System.out.println(value);
//	}
//	
//	public void println(double value) {
//		System.out.println(value);
//	}
//	
//	public void println(String value) {
//		System.out.println(value);
//	}
	
	//1. <T> : 제너릭으로 쓸 파라미터(not return type) 정의 
	//public <T> void println() {
	//}
	
	//2. T로 파라미터 받는 메서드 - 한개만 받는
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	//3. T로 리턴 받는 메서드 
	//public <T> T println(T t) {
	//	System.out.println(t);
	//	return t;
	//}
	
	public int sum(Integer... nums) { //배열로 반환
		int s = 0;
		for(Integer n : nums) {
			s += n;
		}
		
		return s;
	}
	
	// 제네릭 가변(여러개 받는) - 오버로딩
	public <T> void println(T... ts) {
		for(T t : ts) {
		System.out.println(t);
		}
	}
}
