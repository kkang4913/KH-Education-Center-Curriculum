package exam03;

import java.util.Scanner;

public class Sample02 {
	public static void main(String[] args) {
		/*
		 * 사용자 입력을 받기 위한 Scanner 클래스
		 * 		-기본적으로 모든 사용자가 입력 데이터는 문자열이다.
		 *			(nextInt(), nextdouble(), next())	 
		 */
		//Scaaner 객체 생성 -> new 연산자 사용
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		//int uInput = sc.next(); -> String 값만을 받음 -> nextInt로 변환하여 사용
		int uInput = sc.nextInt();		//실제로는 문자열이지만 입력받은 문자열을 정수로 변환 시켜준다.
		System.out.println("입력한 숫자의 값은 : "  + uInput);
		System.out.printf("입력한 숫자의 값은 : %d\n", uInput);
		
		System.out.println("========================");
		
		System.out.print("실수를 입력하세요 : ");
		double dInput = sc.nextDouble();
		System.out.println("입력한 숫자의 값은 : "  + dInput);
		System.out.printf("입력한 숫자의 값은 : %.2f\n", dInput);
}
}
