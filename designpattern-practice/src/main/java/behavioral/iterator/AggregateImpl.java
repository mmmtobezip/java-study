package behavioral.iterator;

public class AggregateImpl<E> implements Aggregate<E>{
	private E[] datas = null; 
	
	public AggregateImpl(E[] datas) {
		this.datas = datas;
	}
	
	@Override
	public Iterator<E> createIterator() {
		return new IteratorImpl();
	}
	
	private class IteratorImpl implements Iterator<E> {
		int index = 0;
		
		@Override
		public E next() {
			return datas[index++];
			//return index < datas.length ? datas[index++] : null;
		}
		
		@Override
		public boolean hasNext() {
			return index < datas.length;
		}
		
	}
	//iterator는 한 번만 돌고 끝나지, 재사용x 
}
