package behavioral.iterator;

public class Client {

	public static void main(String[] args) {
		//이미지 왼쪽 만들기
		Aggregate<String> fruits = new AggregateImpl<>(new String[] {"Peach", "Mango", "Apple"}); //Aggregate interface 구현체 
		//Aggregate1 -> Iterator1을 구현해야함. 
		Iterator<String> it = fruits.createIterator();
		
		//for-each 못씀 
		while(it.hasNext()) {
			String fruit = it.next();
			System.out.println(fruit);
		}
	}

}
