package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>(); //Set: 중복허용x

		String s1 = "둘리"; // String s1 = new String("둘리");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("도우너");
		s.add(s1); //하나는 constant pool에 있는, 하나는 heap에 있는 둘리가 들어감. -> 내용이기에 size()에 안들어감
				   //객체의 동일서 안따지고, 자료(=data)는 동질성으로 체크함.
		
		System.out.println(s.size());
		System.out.println(s.contains(s1)); //System.out.println(s.contains("둘리"));
		
		//순회 1
		for(String str : s) {
			System.out.println(str);	
		}	
	}

}
