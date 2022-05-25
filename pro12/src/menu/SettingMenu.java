package menu;

import java.util.Scanner;

import db.PenaltyDatabase;
import game.GuessNum;

public class SettingMenu {

	Scanner sc = new Scanner(System.in);
	PenaltyDatabase pDB = new PenaltyDatabase();

	public void show() {
		System.out.println("===================4444");
		
		String menu = "";

		menu += "<<< Penalty Setting >>>\n";
		menu += "┌─────────────────────┐\n";
		menu += "│ 1. Penalty Add      │\n";
		menu += "│ 2. Penalty Modify   │\n";
		menu += "│ 3. Penalty Remove   │\n";
		menu += "│ 4. Back             │\n";
		menu += "└─────────────────────┘\n";
		menu += " : ";

		while (true) {
			System.out.println(menu);
			String input = sc.nextLine();

			switch (input.charAt(0)) {
			case '1':
				addMenu();
				break;
			case '2':
				modifyMenu();
				break;
			case '3':
				removeMenu();
				break;
			case '4':
				return;
			}

		}

	}

	// 추가
	private void addMenu() {
		String menu = "";
		menu += "추가할 벌칙을 입력하세요. 입력을 중단하려면 exit 를 입력하세요";
		menu += ": ";

		while (true) {
			System.out.println(penaltyListUp());
			System.out.print(menu);
			String input = sc.nextLine();

			if (input.equals("exit")) {
				System.out.println("추가 작업을 중단합니다.");
				break;
			}

			pDB.add(input);
			System.out.println("입력한 벌칙을 추가하였습니다.");

		}
	}

	// 수정
	private void modifyMenu() {
		String menu ="";

		menu += "수정할 벌칙을 다음 항목에 맞추어 입력하세요. 입력을 중단하려면 exit 를 입력하세요\n";
		menu += "수정할 벌칙의 번호 : ";
		
		while (true) {
			System.out.println(penaltyListUp());
			System.out.print(menu);
			String input = sc.nextLine();
			
			if (input.equals("exit")) {
				System.out.println("추가 작업을 중단합니다.");
				break;
			}
			int number = Integer.parseInt(input);
			
			System.out.print("벌칙 입력 : ");
			input = sc.nextLine();
			
			pDB.modify(number, input);
			System.out.println("벌칙을 수정하였습니다.");
			
			
		}
		
	}

	// 삭제
	private void removeMenu() {
		String menu ="";
		menu += "삭제할 벌칙을 번호를 입력하세요. 입력을 중단하려면 exit 를 입력하세요\n";
		menu += "삭제할 벌칙의 번호 : ";
		
		while (true) {
			System.out.println(penaltyListUp());
			System.out.print(menu);
			String input = sc.nextLine();
			
			if (input.equals("exit")) {
				System.out.println("추가 작업을 중단합니다.");
				break;
			}
			int number = Integer.parseInt(input);
			
			pDB.remove(number);
			System.out.println("벌칙을 삭제하였습니다.");
			
			
		}
		
	}

	// 파일을 읽고 목록화 하는 작업 기능을 가진 메소드
	private String penaltyListUp() {
		//불러온 데이터를 읽고
		String data = pDB.load();
		
		// 스플릿으로 분리 하여 배열에 저장
		String[] listUp =data.split("\n");
		
		//반복문 활용 / 넘버링 작업을 위한 절차
		String res = "";
		for (int i = 0; i < listUp.length; i++) {
			res += String.format("%d. %s\n", i+1, listUp[i]);
		}
	return res;
	}

}
