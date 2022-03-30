package exam07;
//과장
public class DepartmentManager extends AssistantManager {
	
	private boolean teamManager; //팀장직 수행 여부를 구분(8)
	
	
	//(4)
	public DepartmentManager(String name, int age) {
		super(name, age);
		setSalary(4000);
	}
	@Override
	public void payMonth() {
		super.payMonth();
		if(teamManager) {
		double bonusPay =getSalary() * 0.1 /12;
		System.out.printf("팀장직 수행 보너스 %,d 원을 추가 지급하였습니다.\n",(int)(bonusPay* 10000));
		}
	}
	
	@Override
	public void bonus(int month) {
		switch (month) {
		case 4: case 8: case 12:
			super.bonus(month);
			break;

		}
	}
	
	public boolean isTeamManager() {
		return teamManager;
	}
	public void setTeamManager(boolean teamManager) {
		this.teamManager = teamManager;
	}
	
	
}
