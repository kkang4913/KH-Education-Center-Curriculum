package exam02;

import java.util.Iterator;

public class Sample02 {
	public static void main(String[] args) {
		// 1 ~ 99 까지 반복문을 사용하여 반복 출력 출력하시오. ( 단 초기값 설정은 i = 1로 한다.)

		// 1 ~ 99 까지 반복문을 사용하여 반복 출력 출력하시오. ( 단 초기값 설정은 i = 0로 한다.)

		// 1 ~ 99 까지 반복문을 사용하여 반복 출력 출력하시오. ( 단 짝수에 해당하는 값만 출력 하시오.)

		for (int i = 1; i < 100; i++) {
			System.out.println(i + "번째 반복 출력합니다.");
		}
		System.out.println("=====================");
		for (int i = 0; i < 99;) {
			i++;
			System.out.println(i + "번째 반복 출력합니다.");
		}
		System.out.println("======================");
		for (int i = 2; i < 100; i+=2) {
				System.out.println(i + "번째 반복 출력합니다.");
			}
		}
	}