package prob04;

public class StringUtil {
	public static String concatenate(String[] str) {
		StringBuilder sb = new StringBuilder(); //sb 추가 학습 
		
		for(int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}
		
		return sb.toString();
	}
}
