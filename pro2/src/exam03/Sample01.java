package exam03;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 변수(Variable) : 값을 저장하기 위한 공간, 변수 공간을 만들 때 공간에 대한 이름을 지칭하여 사용(변수명) ﻿ 공간에 저장되는
		 * 값은 언제든지 바뀔 수 있다.
		 * - 사람 입장에서는 값은 정수, 실수, 문자열 등의 값을 지칭
		 * - 기계 입장에서는 값는 10010101010101 (2진수 값 -bit 값) 이다
		 * - 저장된 값은 필요하면 언제든 "재사용" 할 수 있다.
		 * - 값이 긴 경우 짧은 변수명으로 사용할 수 있다.
		 * - 값이 변경될 ㅕㅇ우 변수에 저장될 값만 변경하면 되기 때문에 "유지보수"에 용이하다.
		 * 
		 * 주의사항
		 * 변수는 메모리(RAM)에 값을 저장하기 때문에 프로그램에 동작하는 동안에만 사용되며, 프로그램이 종료되면
		 * 변수에 저장된 값은 사라진다.
		 * ﻿
		 */
		
		/*
		 * 변수 선언 형식
		 * 		자료형 변수명:
		 * 
		 * 변수 선언 후 즉시 값을 저장하는 형식
		 * 		자료형 변수명 = 값
		 * 
		 * 변수 선언 후 나중에 값을 저장하는 형식
		 * 		자료형 변수명;
		 * 		변수명 = 값;
		 */
		
		int num;
		
		int num2 = 1;
		
		int num3;
		num3 =2;
		
		int num4 = num3 +num2;
		System.out.println(num4);
		
		/*
		 * 자료형 : 변수 공간에 저장할 값의 종류(Type)를 지정하기 위해 사용
		 * boolean - 논리형
		 * char -문자형
		 * String -문자열
		 * byte - 숫자
		 * short -숫자
		 * int -숫자
		 * long -숫자
		 * float - 실수
		 * double -실수
		 * 
		 */
		
		boolean b1 =true;
		boolean b2 =false;
		
		char ch = 'A';
		String str = "A";
		
		byte b3 =1;
		short s2 =2;
		int i1 =3;
		long l1 = 4;
		
		float f1 = 5.0f;
		double d1 =6.0;
	
	}

}
