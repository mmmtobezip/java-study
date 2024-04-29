package behavioral.iterator;

//데이터를 가지고 있는 인터페이스
public interface Aggregate<E> {
	Iterator<E> createIterator(); 
}
