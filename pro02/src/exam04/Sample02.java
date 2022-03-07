package exam04;

import java.util.Scanner;

public class Sample02 {
	// 이항 연산자 : 피 연산자가 2개 있는 연산
	// 1+1, 2+2, 1*3, 4/1 등등 
	public static void main(String[] args) {
		//산술 연산자 +, -, *, /, %(나머지, 짝수 홀수 구분 활용)
		Scanner scr = new  Scanner(System.in);
		
		int num1, num2;
		System.out.print("num1 의 값을 입력 하세요 : ");
		num1 = scr.nextInt();
		System.out.print("num2 의 값을 입력 하세요 : ");
		num2 =scr.nextInt();
		//초기화 한 부분을 스캐너 사용해서 사용자 입력 받는 것으로 입력
			
		System.out.printf("%d + %d = %d\n", num1, num2, num1+num2);
		System.out.printf("%d - %d = %d\n", num1, num2, num1-num2);
		System.out.printf("%d * %d = %d\n", num1, num2, num1*num2);
		System.out.printf("%d / %d = %.2f\n", num1, num2, (double)num1/num2);
		System.out.printf("%d %% %d = %d\n", num1, num2, num1%num2); 
		//prinf사용시 % 중복이 있어 이스케이프 문자를 사용 -> %% 두번 사용하면 됨
		
		//비교 연산자
		// ==(같다), !=(다르다), <(왼쪽이 작다), >(왼쪽이 크다), 
		//<=(왼쪽이 작거나 같다), >=(왼쪽이 크거나 같다)
		num2= 10;
		System.out.printf("%d == %d -> %b\n", num1, num2, num1 == num2);
		System.out.printf("%d != %d -> %b\n", num1, num2, num1 != num2);
		System.out.printf("%d > %d -> %b\n", num1, num2, num1 > num2);
		System.out.printf("%d < %d -> %b\n", num1, num2, num1 < num2);
		System.out.printf("%d >= %d -> %b\n", num1, num2, num1>=num2);
		System.out.printf("%d <= %d -> %b\n", num1, num2, num1 <= num2);
		
	}
}
