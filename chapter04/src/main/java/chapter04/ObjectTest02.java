package chapter04;

//동일성 동질성 비교 
public class ObjectTest02 {
	/*
	 * x=10, y=20의 값을 가진 p1의 레퍼런스 값이 1000이라고 가정,
	 * x=10, y=20의 값을 가진 p2의 레퍼런스 값이 2000이라고 가정,
	 * x=10, y=20의 값을 가진 p3의 레퍼런스 값이 2000이라고 가정,
	 */

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p2; 
		
		// == : 두 객체의 동일성 -> 동일한 객체를 레퍼런스하고 있다. 
		System.out.println(p1 == p2); //false : 두 객체는 다른 객체다
		System.out.println(p2 == p3); //true : 두 객체는 같은 객체다(레퍼런스값 같다)

		
		//equals : 두 객체의 동질성(내용 비교)
		//         부모 클래스 Object의 기본 구현은 동일성(==) 비교와 같다. -> 같게 만들고 싶으면 equals()를 @override 해줘야함
		// hashcode와 함께 @Override 해줘야 하는데, 그 이유는 
		System.out.println(p1.equals(p2)); //false : x=10, y=20이라는 내용이 같은데도 false가 나오는 이유는, 현재 Object 클래스의 equals()를 사용중
		/*
		 *     public boolean equals(Object obj) {
        			return (this == obj);
    		   }
    		   this = p1, object = p2 두개의 동일성 비교를 하는중 -> false나오는 이유 
		 */
		System.out.println(p2.equals(p3));	//true : 동일한 객체를 가르키고 있다 
	}

}
