package exam02;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Sample14 {

	public static void main(String[] args) {
		/*
		 * 12자 시리얼 넘버를 생성하시오. (시리얼 넘버는 'A' ~ 'Z' 사이의 문자로만 이루어져 있는 것)
		 * 사용자 입력을 통해 생성할 시리얼 넘버의 수량을 파악하고 해당 수만큼 출력한다.
		 * 그리고 시리얼 번호의 출력 형식은 다음과 같다.
		 * "UTM-HFS-ZBG-BGK"
		 */
		Random random = new Random();

		char start = 'A';
		char end = 'Z';
		String serial = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("시리얼 넘버의 수량 : ");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			for (int j = 0; j < 12; j++) {
				char ch = (char) (random.nextInt(end - start + 1) + start);
				serial += ch;
				if (j % 3 == 2 && j != 11) {
					serial += '-';
				}
			}
			System.out.println(serial);
			serial = "";
		}
	}
}
