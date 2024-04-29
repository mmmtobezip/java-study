package collection;

import java.util.Enumeration;
import java.util.Vector;


//가급적 사용자제(옛날 List클래스 버전?)
public class VectorTest01 {
	public static void main(String[] args) {
		Vector<String>  v = new Vector<>(); //예전의 Vector 사용(not List)
		
		v.addElement("둘리");
		v.addElement("마이콜"); //v.add()는 List인터페이스에 있음. Vector는 addElement() 
		v.addElement("또치");
		
		//순회 1
		for(int i = 0; i < v.size(); i++) {
			String s = v.elementAt(i); //<-> v.get(i) : List
			System.out.println(s);
		}
		
		//삭제 
		v.removeElementAt(2);
		
		
		//순회 2 - 지양 
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s); //또치 제외 출력
		}
	}

}
