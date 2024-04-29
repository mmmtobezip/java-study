package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		// 1. Locale
		Locale aLocale = Locale.getDefault(Locale.Category.FORMAT); //ca 캘린더 타입에 따라 
		//System.out.println(aLocale); //ko_KR 출력
		
		//2. TimeZone : defaultTimeZone(aLocale);
		TimeZone tz = TimeZone.getDefault();
		//System.out.println(aLocale + ":" + tz);
		
		System.out.println(cal);
	}
}
