package exam02;

import java.util.Random;
import java.util.RandomAccess;
import java.util.Scanner;

public class Sample16 {
public static void main(String[] args) {
	/*0 ~ 2정수
	 * 0 -> 가위
	 * 1 -> 바위
	 * 2 -> 보
	 */
	
	/*
	 * 사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요.
	 * 컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고,
	 * 사용자에게는 직접 가위바위보를 받으세요.
	 * 
	 * 사용자가 "exit"를 입력하기 전까지 가위바위보를 계속 진행하고 "exit"가 들어가면 반복을 멈추고
	 * 몇 번의 승부에서 몇 번 이기고 몇 번 비기고 몇번 졌는지 출력하세요.
	 */
	String name = "";
	String game = "";
	String comgame = "";
	String result = "";
	String ston = "바위";
	int j = 0;
	int s = 0;
	int m = 0;
	int p = 0;
	int rd = 0;
	int rd2 = 0;
	Random random = new Random();

	Scanner sc = new Scanner(System.in); // 사용자 이름 입력
	System.out.print("사용자 이름 입력 : ");
	name = sc.nextLine();

	while (true) {
		rd = random.nextInt(3);
		System.out.print("가위 바위 보 : ");
		game = sc.nextLine();
		switch (rd) {
		case 0:
			comgame = "가위";
			break;
		case 1:
			comgame = "바위";
			break;
		case 2:
			comgame = "보";
			break;
		}
		if (game.equals("exit")) {
			result = "가위 바위 보 게임을 종료합니다.\n";
			System.out.println(result + "" + j + "전" + s + "승" + m + "무" + p + "패");
			break;
		}if (game.length() > 3) {
			System.out.println("잘못 입력하셨습니다.");
			continue;
		}
		if (game.equals(comgame)) {
			result = "비겼습니다.";
			m++;
		} else if (rd == 0) {
			if (game.length() == 2) {
				result = "이겼습니다..";
				s++;
			} else {
				result = "졌습니다.";
				p++;
			}
		} else if (rd == 1) {
			if (game.length() == 2) {
				result = "졌습니다.";
				p++;
			} else {
				result = "이겼습니다..";
				s++;
			}
		} else if (rd == 2) {
			if (game.equals(ston)) {
				result = "졌습니다.";
				p++;
			} else {
				result = "이겼습니다..";
				s++;
			}
		}
		System.out.println(name + " : " + game);
		System.out.println("컴퓨터 : " + comgame);
		System.out.println(result);
		result = "";
		j++;
	}
}
}