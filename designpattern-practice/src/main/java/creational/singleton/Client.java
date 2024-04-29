package creational.singleton;

public class Client {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance(); //객체 생성 or 기존에 존재하는 객체 전달 
		Singleton s2 = Singleton.getInstance(); //동일성
		System.out.println(s1 == s2); // true
	}

}
