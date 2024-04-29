package creational.singleton;

public class Singleton {
	private static Singleton instance = null; 
	
	
	// private 생성자 -> new() 외부에서 접근 불가(내부는 가능)
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		
		return instance; 
	}

}
