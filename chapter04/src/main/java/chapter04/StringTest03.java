package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		String s1 = "Hello " + "World" + " java" + 17;
		
		//스트링은 불변객체인데, 왜 "+" 연산이 되는지?
		//String s1 = "Hello " + "World" + " java" + 17 
		//String s1 = new StringBuffer("Hello").append(" World").append(" java").append(17).toString();
		//String s1 = new StringBuilder("Hello").append(" World").append(" java").append(17).toString();
		
		//1000000번 new 생성 -> unlock -> 굉장히 느려짐 
		String s2 = "";
		for(int i = 0; i< 1000000; i++) {
			//1. s2 += "h";
			//2. s2 = new StringBuffer(s2).append("h").toString();
		}
		
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i< 1000000; i++) {
			sb.append("h"); //3. append()안에 메서드 실행 -> new() x 
		}
		String s3 = sb.toString();
		
		String s4 = "aBcABCabcAbc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc", 7));
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3, 5));
		
		String s5 = "        ab    cd   ";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6); //문자열 합치기 
		System.out.println(s7);
		
		System.out.println("----" + s5.trim() + "----"); //
		System.out.println("----" + s5.replaceAll(" ", "") + "----"); //공백 제거 
		
		String[] tokens = s6.split(","); //문자열 분리 -> 배열로 들어옴
		for(String s : tokens) {
			System.out.println(s);
		}
		
		String[] tokens2 = s6.split(" ");
		for(String s : tokens2) {
			System.out.println(s); //비어있는 배열도, null도 아님. 원본 배열을 리턴해줌(짤라낼 조건이 없으면)
		}
	}
}
