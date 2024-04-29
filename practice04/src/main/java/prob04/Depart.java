package prob04;

public class Depart extends Employee{
	private String department;
	
	public Depart(String name, int salary, String department) {
		super(name, salary); //super()로 부모의 생성자/메서드 호출 
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public void getInformation() {
        System.out.printf("이름: " + getName() + "  연봉: " + getSalary() + "  부서: " + department); 
    }
}
