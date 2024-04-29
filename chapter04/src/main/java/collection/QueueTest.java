package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>(); //Queue는 구현체x, LinkedList가 Queue인터페이스 구현
												 //큐로 레퍼런싱하면 큐로, 링크드리스트로하면 리스트로
		
		queue.offer("둘리"); 
		queue.offer("마이콜");
		queue.offer("또치");
		
		while(!queue.isEmpty()) {
			String s = queue.poll();
			System.out.println(s);
		}
		
		//비어있는 경우 null 리턴 
		System.out.println(queue.poll()); //exception안터지고, null 출력(큐가 비었다는건 그렇게 ciritical한 부분이 아니라는)

		queue.offer("둘리"); 
		queue.offer("마이콜");
		queue.offer("또치");
		System.out.println(queue.poll());
		System.out.println(queue.peek()); //제일 앞에있는 것 
		System.out.println(queue.poll());
		
	}

}
