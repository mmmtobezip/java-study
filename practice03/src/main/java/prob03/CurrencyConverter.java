package prob03;

public class CurrencyConverter {
	private static double rate;
	
	public static void setRate(double r) {
		rate = r;
	}
	
	public static double toDollar(double krw) {
		return krw / rate;
	}
	
	public static double toKRW(double dollar) {
		return dollar * rate;
	}

}
