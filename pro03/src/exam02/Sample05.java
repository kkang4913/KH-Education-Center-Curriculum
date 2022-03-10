package exam02;

import java.util.Iterator;
import java.util.Scanner;

public class Sample05 {
public static void main(String[] args) {
	/*
	 * 메뉴가 주어지고 주어진 메뉴 번호의 범위를 벗어난 경우에만
	 * 3번의 반복 입력 기회를 주어 올바르게 입력하도록 유도한다.
	 * 
	 * 올바른 번호를 입력 했으면 더이상의 반복은 없이 반복문이 종료될수 있도록 만든다
	 * 번호를 잘못 입력했을 때에는 "잘못된 메뉴 번호입니다" 메시지를 출력해주세요.
	 */

	Scanner sc = new Scanner(System.in);
	int menu; // 가급적 선언을 반복문 밖에서 하자. 반복문 안에서만 쓰이기 때문에 변수를 밖에서도 사용하기 위해
	boolean exited =false;
	
	for (int i = 0; i < 3; i++) {
		System.out.println("다음에 나열된 메뉴중 하나의 번호를 선택하시오 : ");
		System.out.print("1. 조회\n2. 추가\n3. 수정\n4. 삭제\n9. 종료\n : ");
		menu = sc.nextInt();

//		if (menu >= 1 && menu <= 4 && menu == 9) {
//			break;
//		}

		switch (menu) { // 사용자가 입력한 메뉴 값에 따라 아래의 조건에 맞는 코드 실행
		case 1:
			System.out.println("조회 메뉴를 선택했습니다.");
			exited =true;
			break;
		case 2:
			System.out.println("추가 메뉴를 선택했습니다.");
			exited =true;
			break;
		case 3:
			System.out.println("수정 메뉴를 선택했습니다.");
			exited =true;
			break;
		case 4:
			System.out.println("삭제 메뉴를 선택했습니다.");
			exited =true;
			break;
		case 9:
			System.out.println("프로그램을 종료합니다.");
			exited =true;
			break; // 마지막 case에서는 꼭 break 구문이 필요없다.
		default:
			System.out.println("잘못된 메뉴 번호 입니다.");
		}
		if (exited) {
			break;
		}
	}
}
}
