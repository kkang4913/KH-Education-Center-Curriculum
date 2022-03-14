package exam02;

import java.util.Random;
import java.util.Scanner;

public class Sample15 {
	public static void main(String[] args) {
		/*
		 * 1부터 100 사이의 정수 중 임의의 난수가 정해지고 사
		 * 
		 * 
		 */
		int num;
		int num2 = 0;
		int ex;
		Random random = new Random();
		ex = (random.nextInt(99) + 1);
		System.out.println(ex);

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("1 ~ 100 사이의 임의의 난수를 맞춰보세요 : ");
			num = sc.nextInt();
			num2++;
			if (num == 0 || num > 100) {
				System.out.println("1 ~ 100 사이의 숫자를 입력해주세요.");
			} else if (num < ex) {
				System.out.println("down!");
			} else if (num > ex) {
				System.out.println("up!!");
			}
			if (num == ex) {
				System.out.println("정답입니다" + "\n" + num2 + "회만에 맞추셨습니다.");
				break;
			}
		}
	}
}