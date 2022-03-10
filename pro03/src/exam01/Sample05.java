package exam01;

import java.util.Scanner;

public class Sample05 {
public static void main(String[] args) {
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
	String result = null;

	Scanner scr = new Scanner(System.in);
	System.out.println("===시간 변환 프로그램===");
	System.out.print("시간 입력 : ");
	int time = scr.nextInt();
	System.out.print(" 분 입력 : ");
	int time2 = scr.nextInt();

	if (time == 23 && time2 == 30) {
		time = 11;
		result = "변환된 시간 : 오후 %d시 %d분\n";
	} else {
		if (time == 00 && time2 == 15) {
			time = 12;
			result = "변환된 시간 : 오전 %d시 %d분\n";
		} else {
			if (time == 12 && time2 == 20) {
				time = 00;
				result = "변환된 시간 : 오후 %d시 %d분\n";
			} else {
				if (time == 11 && time2 == 59) {
					time = 11;
					result = "변환된 시간 : 오전 23%d시 %d분\n";
				}
			}
		}
	}
	System.out.printf(result, time, time2);
}
}
