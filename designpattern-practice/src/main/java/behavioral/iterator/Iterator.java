package behavioral.iterator;

//* Iterator가 순회해야 할 데이터 타입들(element) 존재할 것.
public interface Iterator<E> {
	E next();
	boolean hasNext(); 

}
