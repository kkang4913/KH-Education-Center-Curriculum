package exam01;

import java.util.Iterator;

public class Sample02 {
public static void main(String[] args) {
	/*
	 * 배열의 크기가 10인 배열을 선언하고 10 ~ 1까지의 값으로 초기화 한다.
	 */
	//초기화
	int[] arr1 = new int[10];
	int num = 10;
	for (int i = 0; i < 10; i++) {
		arr1[i] = num--;
	}
	// 결과 확인용 출력
	for (int i = 0; i < 10; i++) {
		System.out.print(arr1[i] + "\t");
	}
	System.out.println("\n");

	/*
	 * 배열의 크기가 10인 배열을 선언하고 2 부터 시작하여 짝수값에 해당하는 값으로 초기화
	 */
	//초기황
	int[] arr2 = new int[10];
	num = 2;
	for (int i = 0; i < 10; i++) {
		arr2[i] = num;
		num += 2;
	}
	for (int i = 0; i < 10; i++) {
		System.out.print(arr2[i] + "\t");
	}
	System.out.println("\n");

	/*
	 * 배열의 크기가 5 인 실수 배열을 선언하고 1 부터 0.5 씩 증가된 값으로 초기화 한다.
	 */
	//초기화
	double[] arr3 = new double[5];
	double num2 = 1.0;

	for (int i = 0; i < 5; i++) {
		arr3[i] = num2;
		num2 += 0.5;
	}
	// 결과 출력
	for (int i = 0; i < 5; i++) {
		System.out.print(arr3[i] + "\t");
	}
	System.out.println("\n");

	/*
	 * 배열의 크기가 5인 문자 배열을 선언하고 'A' ~ 'E' 까지의 문자값으로 초기화 한다.
	 */
	//초기화
	char[] arr4 = new char[5];
	char num3 = 'A';
	for (int i = 0; i < 5; i++) {
		arr4[i] = num3++;
	}

	// 결과 출력
	for (int i = 0; i < 5; i++) {
		System.out.print(arr4[i] + "\t");
	}
	System.out.println("\n");
}
}
