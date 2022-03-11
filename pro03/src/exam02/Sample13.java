package exam02;

import java.util.Iterator;
import java.util.Random;

public class Sample13 {
	public static void main(String[] args) {

		/*
		 * 임의의 값을 생성하기 위해 사용하는 모듈 import java.util.Random
		 */
		Random random = new Random();
		int num = random.nextInt(10);
		System.out.println(num);

		for (int i = 0; i <= 10; i++) { // 0 ~ 10 미만
			int num2 = random.nextInt(10); // 0 ~ 9 사이의 난수값 생성
			System.out.print(num2);
		}
		// 1~ 9 사이의 난수값 생성
		for (int j = 0; j < 10; j++) {
			int num2 = random.nextInt(9) + 1;
			System.out.println(num2);

		}
		// 'A' ~ 'Z' 사이의 임의의 문자 생성
		char c = (char) (random.nextInt(26) + 'A');
		System.out.println(c);

		char start = 'A';
		char end = 'Z';

		for (int i = 0; i < 10; i++) {
			char ch = (char) (random.nextInt(end - start + 1) + start);
			System.out.println((char) ch);
		}
		// 12자 시리얼 넘버를 생성하시오. (시리얼 넘버는 'A' ~ 'Z' 사이의 문자로만 이루어져 있는 것
		char start1 = 'A';
		char end1 = 'Z';
		String serial = "";
		for (int i = 0; i < 12; i++) {
			char ch = (char) (random.nextInt(end1 - start1 + 1) + start1);
			serial += ch;
		}
		System.out.print(serial);

	}
}
