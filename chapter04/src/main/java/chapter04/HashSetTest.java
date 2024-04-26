package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	
	public static void main(String[] args) {
		Set<Rect> set = new HashSet<Rect>(); //Generic, 객체 종류가 다양한데 
		
		Rect r1 = new Rect(10, 20);
		Rect r2 = new Rect(10, 20);
		Rect r3 = new Rect(4, 50);
		
		set.add(r1);
		set.add(r2);
		set.add(r3); 
		
		//저장하는 컬렉션(컨테이너, 리스트, 배열 등) 
		for(Rect r : set) { //set은 순서보장x <-> list는 순서보장
 			System.out.println(r);
		}
		
	}

}
