package exam07;

import java.util.Random;

public class Main {
public static void main(String[] args) {
	Random rand = new Random();
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
	
	//직책 업무별 보너스급여 확인 
	((DepartmentManager)e3).setTeamManager(true);
	((DeputyGeneralManager)e4).setHeadManager(true);
	((Director)e5).setHeadManager(true);

	//모든 직원에 대한 반복(배열)
	for(int m = 1; m <= 30; m++) {
		int month = m % 12 ==0 ? 12 : m % 12;
		System.out.printf("%d 월 급여 지급 내역\n",month);
		System.out.println("------------------------------------");

		for (int i = 0; i < empArr.length; i++) {
			System.out.println("[" + empArr[i].getName() + "]");
			empArr[i].payMonth();
			empArr[i].bonus(month);
			System.out.println("------------------------------------");
		}
		
		if((rand.nextInt(9) + 1) % 4 == 0) {
			int idx = rand.nextInt(4) + 1;
			System.out.println(empArr[idx].getName() + "님이 법카 쏜다 ~");
			((AssistantManager)empArr[idx]).corpCard(100000);
		
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