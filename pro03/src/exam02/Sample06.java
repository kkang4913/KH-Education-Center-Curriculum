package exam02;

import java.util.Iterator;
import java.util.Scanner;

public class Sample06 {
	public static void main(String[] args) {
		/*
		 * 사용자가 입력한 정수값 까지 반복 출력하는 코드를 작성한다. (1 ~ 사용자 입력 값까지 출력)
		 */
		int i;
		int data;
		Scanner sc = new Scanner(System.in);
		System.out.print("사용자 입력 값 : ");
		data = sc.nextInt();
		for (i = 0; i <= data; i++) {
			System.out.print(i + 1);
		}
		System.out.println("");
		/*
		 * 사용자가 입력한 정수값 부터 ~ 1 까지 반복 출력하는 코드를 작성한다.
		 */
		System.out.print("정수값 입력 : ");
		data = sc.nextInt();
		for (int j = data; j >= 1; j--) {
			System.out.print(j);
		}
		System.out.println("");
		/*
		 * 위 문제에서 반복 출력할 때 한 줄에 7개의 정수 값이 출력되도록 코드를 작성.
		 */
		System.out.print("정수값 입력 : ");
		data = sc.nextInt();
		for (int k = 0; k < data; k++) {
			System.out.print(k + 1 + " ");
			if (i % 7 == 0) {
				System.out.println();
			}
		}
	}
}
