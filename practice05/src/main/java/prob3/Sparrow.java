package prob3;

public class Sparrow extends Bird{	
	@Override
	public void fly() {
		System.out.println("참새(" + getName() + ")가 날아 다닙니다.");
	}
	
	@Override
	public void sing() {
		System.out.println("참새(" + getName() + ")가 소리내어 웁니다.");
	}
    @Override //Override의 Override 애노테이션을 쓰는게 맞나..
    public String toString() {
        return "참새의 이름은 " + getName() + " 입니다.";
    }
}
