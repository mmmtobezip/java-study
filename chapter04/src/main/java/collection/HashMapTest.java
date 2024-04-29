package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>(); //Map<String, int> map = new HashMap<>(); 불가 
		
		map.put("one", 1); //auto boxing -> 자바 Collection은 전부 객체로 다룸(기본타입x) 
		map.put("two", 2);
		map.put("three", 3);
		
		//가져올 땐 key값 사용 
		int i = map.get("one"); //auto unboxing
		int j = map.get(new String("one")); 
		System.out.println(i + ":" + j);
		
		map.put("three", 3333);
		System.out.println(map.get("three"));
		
		//순회 1 - key set으로 호출
		Set<String> s = map.keySet();
		for(String key : s) {
			System.out.println(map.get(key));
		}
	}

}
