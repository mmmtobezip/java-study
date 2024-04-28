package prob3;

public abstract class Bird {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void fly();
	public abstract void sing(); //오버라이드, toString()도 
	
    @Override
    public String toString() {
        return "새의 이름은 " + name + " 입니다.";
    }
}