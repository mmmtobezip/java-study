package collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest02 {
	public static void main(String[] args) {
		List<String> list = new Vector<>();  //Vector 사용2
		
		//list인터페이스에 있는 함수 사용 
		list.add("둘리");
		list.add("마이콜");
		list.add("또치");
		
		//순회 1
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i); 
			System.out.println(s);
		}
		
		//삭제 
		list.remove(2);
		
		//순회 2 - iterator 사용
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		//순회 3 - iterable 사용 시 for-each 사용 가능
		for(String s : list) {
			//iterator없이 순회 가능
			System.out.println(s);
		}
	}
}
