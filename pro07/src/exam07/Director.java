package exam07;
//부장
public class Director extends Employee {
	
	private boolean teamManager; //팀장직 수행 여부를 구분(8)
	private boolean headManager; //본부장직 수행 여부를 구분(8)

	//(4)
	public Director(String name, int age) {
		super(name, age);
		setSalary(8000);
	}

}
