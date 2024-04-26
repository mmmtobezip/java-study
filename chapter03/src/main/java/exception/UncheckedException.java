package exception;

public class UncheckedException {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		
		for(int i = 0; i <= a.length; i++) {
			System.out.println(a[i]); // ArrayIndexOutOfBoundsException -> UncheckedException
			//위 코드처럼 간단한 구현의 경우, for문을 돌때마다 try-catch를 쓸 수 없음
			//uncheckedexception는 에러(logical error)이기 때문에 매 케이스마다 try-catch로 받으면 가독성 저하(=에러성 예외)
			//<-> checkedexception은 코드 구현 시, 필수적으로 처리되야 할 예외들에 쓰임
		}

	}

}
