package prob06;

public abstract class Arith {
	//얘는 부모에서 구체적인 기능 없이 껍데기 메서드만을 제시하고 
	//하위에서 그 기능이 다르므로 prob06문제는 abstract으로 구현하는게 맞음.
	private int a;
	private int b;
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public abstract int calculate();

}
