package exam01;

import java.util.Scanner;

public class Sample06 {
public static void main(String[] args) {
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
	

		Scanner scr = new Scanner(System.in);
		String ampm = "오전"; // 초기값을 설정하면 if문에서 "오전"조건식을 만들필요가 없다.

		System.out.print("시간 입력 : ");
		int h = scr.nextInt();

		System.out.print(" 분 입력 : ");
		int m = scr.nextInt();

//		if (h >= 12 && h <= 23) {
//			ampm = "오후";
//			//h = h !=12 ? h -12 : 12;  //삼항연산자
//			if (h != 12) {
//				h -= 12;
//			}
//		}else if (h == 0 ) {
//			h += 12;
		
		switch (h / 12) {
		case 0:
			if (h == 0) {
				h = 12;
			}
			break;
		case 1:
			ampm = "오후";
			if (h != 12) {
				h -= 12;
			}
			break;
		default:
			break;
		}
		System.out.printf("변환된 시간 : %s %d시 %d분", ampm, h, m);
	}
}
