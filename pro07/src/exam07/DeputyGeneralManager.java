package exam07;
//차장
public class DeputyGeneralManager extends Employee {
	
	private boolean teamManager; //팀장직 수행 여부를 구분(8)
	private boolean headManager; //본부장직 수행 여부를 구분(8)
	
	//(4)
	public DeputyGeneralManager(String name, int age) {
		super(name, age);
		setSalary(5500);
	}

}
