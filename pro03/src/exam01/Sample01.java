package exam01;

import java.util.Scanner;

public class Sample01 {

	public static void main(String[] args) {
		/* (제어문) : 조건문 , 반복문 , 분기문 
		 *   조건문
		 * 	  - 프로그램의 코드의 실행을 제어하기 위한 제어문 중 하나이다.
		 * 	  - 조건에 따라 코드를 실행하거나 실행하지 않게 제어를 한다.	
		 * 	  - (true: 실행 / false: 실행하지 않고 다음 코드로 진행하여 실행)
		 *	  - 조건문에 종류 : if문 , switch문 
		 */
		/*
		 * if문
		 * 		if(조건식){
		 * 			조건식의 결과가 참일 때 실행하는 코드를 입력하세요.
		 * }
		 */
		int num1 = 9 ;
		if (num1 > 10) {
			System.out.println("num1 에 할당된 값은 10 보다 큽니다.");
		}else {
			System.out.println("num1 에 할당된 값은 10보다 작습니다.");
		}
	/*
	 * if... eles
	 * 		if(조건식{
	 * 		조건식의 결과가 참일 때 실행하는 코드를 입력하세요.
	 * }else{
	 * 		조건식의 결과ㅏ 거짓일 때 실핼하는 코드를 입력하세요.
	 * }
	 */
		int num2 =5;
		
		if (num2 % 2 == 0) {
			System.out.println("num2의 값은짝수입니다.");
		}else {
			System.out.println("num2의 값은 홀수입니다.");
			
		}
		/*
		 * if ...else if ...else
		 * 		if(조건식1){
		 * 		조건식의 결과가 참일 때 실행하는 코드를 입력하세요.
		 * 		}else if(조건식2){
		 *      조건식1의 결과가 거짓이고 대신 조건식2의 결과가 참일 경우 실행
		 *      else if(조건식3){
		 *      조건식2의 결과가 거짓이고 대신 조건식3의 결과가 참일 경우 실행  
		 * 		}else{ 위의 두가지 조건 모두 충족하지 않을시)
		 * 		모든 조건식의 결과가 거짓일 경우 코드를 실행.
		 *	} 
		 */
		int num3 = 78;

		if (num3 <= 39) {
			System.out.println("과락입니다");
		} else if (num3 <= 59) {
			System.out.println("E등급 입니다.");
		} else if (num3 <= 69) {
			System.out.println("D등급 입니다.");
		} else if (num3 <= 79) {
			System.out.println("C등급 입니다.");
		} else if (num3 <= 89) {
			System.out.println("B등급 입니다.");
		} else {
			System.out.println("A등급입니다.");
		}
		/*
		 * 중첩 if문
		 * 		-문장 안에 또 다른 문장이 중첩되어 작성되는 형태
		 * 		-중첩은 원하는 만큼 반복하여 중첩시킬 수 있다.
		 * 	
		 * 	if(조건식){
		 * 		if(조건식2){
		 * 		...
		 * 		}else{
		 * 		if(조건식3){
		 * 		...
		 * 			}
		 * 		}
		 * }
		 */
		num3 = 48;

		if (num3 <= 39) {
			System.out.println("과락입니다");
		} else if (num3 <= 59) {
			System.out.println("E등급 입니다.");
		} else if (num3 <= 69) {
			System.out.println("D등급 입니다.");
		} else if (num3 <= 79) {
			System.out.println("C등급 입니다.");
		} else if (num3 <= 89) {
			System.out.println("B등급 입니다.");
		} else {
			if (num3 ==100) {
				System.out.println("만점입니다.");
			}else {
				System.out.println("A등급입니다.");
			}
		}
}
}
