package prob2;

public class Prob2 {
	public static void main(String[] args) {
		int n = 10;

	    for(int i = 1; i<=n; i++) {
	      for(int j = i; j<=i+n-1; j++) {
	        System.out.print(j+ " ");
	      }
	      System.out.println();
	    }
	}
}
