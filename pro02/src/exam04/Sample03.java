package exam04;

import java.util.Scanner;

public class Sample03 {
	public static void main(String[] args) {
		/*
		 * 복합 대입 연산
		 * 		대입(할당) 연산자와 산술연산이 결합되어 사용되는 연산자
		 * 		산술연산 수행 -> 대입 연산이 수행하는 형태로 실행.
		 */
			int num1 =1;
			
			num1 += 1;    // num1 = num1 + 1; 
			// ++num1 : 1씩 증가만 가능 하기에 상황애 맞게 사용하면 된다
			System.out.println(num1);
			num1 += 2;    // num1 = num1 + 2;
			System.out.println(num1);
			num1 -= 3;    // num1 = num1 - 1;
			System.out.println(num1);
			num1 *= 4;	  // num1 = num1 * 1;	
			System.out.println(num1);
			num1 /= 2;    // num1 = num1 * 1;
			System.out.println(num1);
			num1 %= 2;    // num1 = num1 % 1;
			System.out.println(num1);
			// 주의사항 : = 항상 뒤로
			
			/*
			 * 	삼항 연산자 :  조건식 ? 식1 : 식2
			 * 	조건식 : true false 가 나올 수 있는 식을 작성 해야 한다.
			 * 	식1 : 조건식의 결과가 참일 때 수행할 식을 작성 한다.
			 * 	식2 : 조건식의 결과가 거짓 일 때 수행할 식을 작성한다.
			 */
			int num2 = 10;
			int num3 = 20;
			int num4 = 20;
			System.out.println(num2 > num3 ? true : (num3 == num4) ? "그냥 해본겨" : "나도 몰라 이젠");
			
			int age =19;
			String result = age >=20 ? "성인입니다" : "미성년자 입니다";
			System.out.println("당신은 " + result);
		
			Scanner scr = new  Scanner(System.in);
			System.out.print("당신의 나이를 입력 하세요 : ");
			int age2;
			age2 = scr.nextInt();
			String result2 = (age2<age) ? "미성년자 입니다" : "성인입니다";
			System.out.println(age2<age ? "미성년자 입니다" : "성인입니다");
			System.out.printf("당신은 %s\n", result2 );
			
			int num5 =15;
			
			result = num5 %2 ==0 ? "짝수" :"홀수";
			System.out.printf("%d는 %s 입니다\n", num5, result);
			
	}
}
