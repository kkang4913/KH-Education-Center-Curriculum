package exam07;


public class Main {
public static void main(String[] args) {
	//다형성 적용 (5)
	//상위 클래스    =   하위 클래스
	Employee e1 = new Staff("김사원", 28); 
	Employee e2 = new AssistantManager("박대리", 33); 
	Employee e3 = new DepartmentManager("이과장", 38); 
	Employee e4 = new DeputyGeneralManager("차차장", 48); 
	Employee e5 = new Director("곽부장", 50); 
	
	//크기에 맞는 배열을 생성 / 각 인덱스에 할당(7)
	Employee[] empArr = new Employee[5];
	empArr[0] = e1; empArr[1] = e2; empArr[2] = e3; empArr[3] = e4; empArr[4] = e5;
	
	//보너스급여 확인 
	((DepartmentManager)e3).setTeamManager(true);
	
	((DeputyGeneralManager)e4).setHeadManager(true);

	((Director)e5).setTeamManager(true);
	((Director)e5).setHeadManager(true);

	
	for (int i = 0; i < empArr.length; i++) {
		System.out.println(empArr[i].getName() + "의 연봉은 " + empArr[i].getSalary() + "만원");
		empArr[i].payMonth();
		empArr[i].bonus();
		
		if (empArr[i] instanceof AssistantManager) {
			((AssistantManager)empArr[i]).corpCard(5000000);
		}else if (empArr[i] instanceof DepartmentManager) {
			((DepartmentManager)empArr[i]).corpCard(5000000);
		}else if (empArr[i] instanceof DeputyGeneralManager) {
			((DeputyGeneralManager)empArr[i]).corpCard(5000000);
		}else if (empArr[i] instanceof Director) {
			((Director)empArr[i]).corpCard(5000000);
		}
		
		System.out.println("=======================================");
	}
	
//	System.out.println(e1.getName() + "의 연봉은 " + e1.getSalary() + "만원");
//	System.out.println(e2.getName() + "의 연봉은 " + e1.getSalary() + "만원");
//	System.out.println(e3.getName() + "의 연봉은 " + e3.getSalary() + "만원");
//	System.out.println(e4.getName() + "의 연봉은 " + e4.getSalary() + "만원");
//	System.out.println(e5.getName() + "의 연봉은 " + e5.getSalary() + "만원");
}
}