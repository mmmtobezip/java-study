package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {
	public static void main(String[] args) {
		int[] a = {10, 20, 30, 40};
		
		double[] d = ArrayUtil.intToDobule(a); //intToDouble() = util -> 이를 통해 객체 생성
		System.out.println(Arrays.toString(d));
	}

}
