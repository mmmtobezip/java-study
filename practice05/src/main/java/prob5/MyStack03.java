package prob5;

//generic 사용
public class MyStack03<T> { //제네릭 파라미터<T, E, K, V, S, U>사용 
		private int top;
		private T[] buffer; //String -> Object 변경

		public MyStack03(int capacity) {
			top = -1;
			buffer = (T[])new Object[capacity]; //실행 타입엔 new T[capacity] 쓸 수 x -> 타입이 무엇인지 결정하지 못하기에 -> Object로 만들고 캐스팅하는 기법 사용 -> warning은 miss casting error
		}
		
		//2. 방법은 타입 정보를 알기위해 클래스 객체를 넣어줘야함(getClass() 객체) -> 권장x 
		//public MyStack03(Class<?> klass, int capacity) {
		//  top = -1;
	    //  buffer = (T[])Array.newInstance(klass, capacity); 
		//}

		public void push(T s) { 
			if (top == buffer.length - 1) {
				resize();
			}

			buffer[++top] = s;		
		}

		public T pop() throws MyStackException {
			if (isEmpty()) {
				throw new MyStackException("stack is empty");
			}

			T result = buffer[top];
			buffer[top--] = null;

			return result;
		}

		public boolean isEmpty() {
			return top == -1;
		}

		private void resize() {
			T[] temp = (T[])new Object[buffer.length * 2];
			for (int i = 0; i <= top; i++) {
				temp[i] = buffer[i];
			}

			buffer = temp;
		}
	}