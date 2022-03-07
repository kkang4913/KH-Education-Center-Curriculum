package exam03;

import java.util.Scanner;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 받기 위한 Scanner 클래스
		 * 		-콘솔(터미널) 환경에서 사용자 입력을 받기 위해 사용
		 * 		-기본 기능이 아니기 떄문에 import 구문 필요
		 */
		// Scanner 객체 생성 : new 연산자를 통해 새로운 객체를 생성하겠다.
		Scanner scr = new  Scanner(System.in);
		
		// 사용자 입력을 받고 재사용을 위해 변수에 저장 // 사용자가 인식하기 편하게 출력 구문을 먼저 입력하자.
		System.out.print("사용자 이름을 입력 하세요 : ");
		String str = scr.next();
		
		//사용자 입력 값을 출력
		System.out.println("사용자 입력 값 : " + str);
		System.out.printf("사용자 입력 값 : %s\n", str);
		
	}

}
