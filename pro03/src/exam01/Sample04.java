package exam01;

import java.util.Scanner;

public class Sample04 {
public static void main(String[] args) {
	/*
	 * Scanner 를 사용하여 사용자 입력을 받고 다음의 결과가 나오도록 하시오.
	 *		1.사용자 입력을 통해 국어, 영어, 수학 점수를 입력 받는다. (정수데이터)
	 * 		2.입력받은 정수 데이터의 값에 대해 총점과 평균을 구한다.
	 * 		3.쳥균 점수가 60점 이상인 경우에만 다음의 메시지를 출력한다.
	 * 			축하합니다. 합격입니다.
	 * 				총점 : 213점
	 * 				국어 : 75점
	 * 				영어 : 70점
	 * 				수학 : 68점
	 * 				평균 : 71.0점
	 * 		4.평균 점수가 60점 미만인 경우네는 다음의 메시지를 출력한다.
	 * 			평균 점수가 미달하였습니다.
	 * 		5.국어, 영어, 수학 과목중 40점 미만의 과목이 있는 경우 다음의 메시지를 출력한다.
	 * 			과락된 과목이 있어 불합격 되었습니다.
	 * 
	 */
	
	int kor, mat, eng, sum;
	double avg;
	Scanner scr = new  Scanner(System.in);
	System.out.print("국어 점수를 입력하세요 : ");
	kor = scr.nextInt();
	System.out.print("영어 점수를 입력하세요 : ");
	mat = scr.nextInt();
	System.out.print("수학 점수를 입력하세요 : ");
	eng = scr.nextInt();
	
	sum = (kor + mat +eng);		//총점
	avg = (kor + mat +eng) /3; 	//평균
	
	if(kor <40 || eng <40 || mat < 40) {
		System.out.println("과락된 과목이 있어 불합격 되었습니다.");
	}else {
		if (avg >=60) {
//			System.out.println("축하 합니다. 합격입니다.");
//			System.out.printf("총점 : %d\n", sum );
//			System.out.printf("국어 : %d\n", kor );
//			System.out.printf("영어 : %d\n", eng );
//			System.out.printf("수학 : %d\n", mat );
//			System.out.printf("평균 : %.1f\n", avg );
			
			System.out.println("축하 합니다. 합격입니다.");
			System.out.println("총점 : " + sum + "점" );
			System.out.println("국어 : " + kor + "점" );
			System.out.println("영어 : " + mat + "점" );
			System.out.println("수학 : " + eng + "점" );
			System.out.println("평균 : " + avg + "점" );
		}else if(avg <60) {
			System.out.println("평균 점수가 미달하였습니다.");
	}
		
	}
}

}

