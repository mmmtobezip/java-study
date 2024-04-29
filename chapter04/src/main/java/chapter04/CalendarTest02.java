package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest02 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); 
		
		printDate(cal);
		
		//크리스마스 날짜 찾기
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 11); //12월(Month - 1), 가져올 땐 +1 
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		//n일 되는 날짜 찾기
		cal.set(2000, 06, 12); //한번에 값 넣기도 가능
		cal.add(Calendar.DATE, 10000); 
		printDate(cal);
	}
	
	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"}; //수정 금지, final 상수 (대문자 생성, 소문자 변수와 비교하기 위해)
		
		int year = cal.get(Calendar.YEAR); 		 //Calendar는 밀레니엄세대 이후에 나온거라 +1900 안해도됨
		int month = cal.get(Calendar.MONTH); 	 //0 ~ 11, +1 
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); //1(일요일) ~ 7(토요일) 
		int hours = cal.get(Calendar.HOUR);
		int minutes = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		
		System.out.println(year + "년 " + 
						  (month + 1) + "월 " + 
						  date + "일 " +
						  DAYS[day-1] + "요일 " +
						  hours + "시 " + minutes + "분 " + seconds + "초");
	}
}