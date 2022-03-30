package exam07;
//차장
public class DeputyGeneralManager extends DepartmentManager  {
	
	private boolean headManager; //본부장직 수행 여부를 구분(8)
	
	public boolean isHeadManager() {
		return headManager;
	}

	public void setHeadManager(boolean headManager) {
		this.headManager = headManager;
	}

	//(4)
	public DeputyGeneralManager(String name, int age) {
		super(name, age);
		setSalary(5500);
	}

	@Override
	public void bonus(int month) {
		switch (month) {
		case 4: case 8: case 12:
			super.bonus(month);
			break;
		}
	}
	@Override
	public void jobPay() {
		if(isHeadManager()) {
		double bonusPay =getSalary() * 0.2 /12;
		System.out.printf("본부장직 수행 보너스 %,d 원을 추가 지급하였습니다.\n",(int)(bonusPay* 10000));
		}
	}
}
