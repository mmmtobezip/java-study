package chapter03;

import mypackage.Value;

public class SwapTest3 {

	//GoodsApp을 객체로 만들지 않았음. 
	public static void main(String[] args) {
		Value i = new Value(10);
		Value j = new Value(20);
		System.out.println(i.value + ", " + j.value);
		
		/*swap */
		swap(i, j);
		
		System.out.println(i.value + ", " + j.value);
	}

	private static void swap(Value m, Value n) { //레퍼런스를 넘기는, 변경하고 싶은 객체를 넘김, 함수안에서는 객체 값 조작 가능
		int tmp = m.value;
		m.value = n.value;
		n.value = tmp;
	}

}
