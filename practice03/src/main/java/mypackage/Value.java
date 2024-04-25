package mypackage;

public class Value {
	public int value; //정보은닉은 위배되지만, call by reference 예제
	
	//value값을 갖는 생성자 Value
	public Value(int value) {//파라미터 변수 
		//인스턴스 변수 
		//value = value; 파라미터 변수 - 인스턴스 변수끼리 runtime 때 충돌 발생함. 동일하기에
		this.value = value; //this를 이용해서 위에 발생하는 문제 해결 -> 왼쪽은 인스턴스 변수, 오른쪽은 메서드 호출될 때 넘어오는 변수를 의미
		
		                    
		
	}
}
