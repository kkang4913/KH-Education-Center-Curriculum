package exam01;

import java.util.Scanner;

public class Sample05 {
public static void main(String[] args) {
	/*
	 * Switch문
	 * 		-if문은 주로 값의 범위에 따라 특정 코드를 실행하도록 하기 위한 용도로 사용하지만
	 * 		 Switch문은 주로 식에 대한 특정 결과값 나오는 경우 해당 코드를 실행하기 위한 용도로 사용한다.
	 * 		-주로 메뉴 번호를 선택하고 선택된 특정 메뉴에 대한 코드를 실행 시킬 때 사용
	 * 		 (환율 계산 프로그램에도 적용하기 쉬운 조건문이다. sample03)
	 * 		-switch 는 if 문과 다르게 조건이 만족한다고 해서 조건에 해당하는 코드만 수행하고 종료되지 않는다.
	 * 		 조건이 만족한 case 부터 순차적으로 모든 case의 코드를 실행한다.
	 * 		 이러한 특징 때문에 특정 case의 코드만 실행하고 종료되기 원하는 경우 break 문을 사용하여 종료시켜야한다.
	 */

	/*
	 * switch 사용 형식 
	 * switch (식) { 
	 * 		case 식에 대한 결과값1:
	 * 			결과값1에 해당하는 경우 실행할 코드
	 * 		case 식에 대한 결과값2:
	 * 			결과값2에 해당하는 경우 실행할 코드
	 * 
	 * 		default: 
	 *			위에 나열한 case에 해당하지 않는 값이 계산된 경우 실행할 코드
	 *			if문의 else 처럼 옵션이다. 
	 */
		//switch문 예제
		Scanner sc = new Scanner(System.in);
		System.out.println("다음에 나열된 메뉴중 하나의 번호를 선택하시오.");
		System.out.print("1. 조회\n2. 추가\n3. 수정\n4. 삭제\n9. 종료\n : ");
		int menu =sc.nextInt();
		
		switch (menu) {		//사용자가 입력한 메뉴 값에 따라 아래의 조건에 맞는 코드 실행
		case 1:
			System.out.println("조회 메뉴를 선택했습니다.");
			break;
		case 2:
			System.out.println("추가 메뉴를 선택했습니다.");
			break;
		case 3:
			System.out.println("수정 메뉴를 선택했습니다.");
			break;
		case 4:
			System.out.println("삭제 메뉴를 선택했습니다.");
			break;
		case 9:	
			System.out.println("프로그램을 종료합니다.");
			break;  //마지막 case에서는 꼭 break 구문이 필요없다.
		default:
			System.out.println("메뉴 번호를 잘못 입력하였습니다.");
		}
	//강사님이 내주신 실습문제
	/*	24시 표기를 12표기 출력으로 변환 하는 프로그램
	 *	23시 30분은 -> 오후 11시 30분 
	 * 	00시 15분은 -> 오전 12시 15분
	 * 	12시 20분은 -> 오후 12시 20분
	 * 	11시 59분은 -> 오전 11시 59분
	 * 	
	 * 	시간 입력 : 23
	 * 	분 입력 : 30
	 * 
	 * 	변환된 시간 : 오후 11시 30분
	 */
	String apm = "오전";

	Scanner scr = new Scanner(System.in);
	System.out.println("===시간 변환 프로그램===");

	System.out.print("시간 입력 : ");
	int timeh = scr.nextInt();

	System.out.print(" 분 입력 : ");
	int timem = scr.nextInt();

	if (timeh >= 12 && timeh <=23) {
		apm = "오후";
		timeh = timeh !=12 ? timeh - 12 : 12; 
	}else if (timeh == 0) {
		timeh += 12;
	}
	System.out.printf("변환된 시간 : %s %d시 %d분",apm,timeh,timem);
}
}
