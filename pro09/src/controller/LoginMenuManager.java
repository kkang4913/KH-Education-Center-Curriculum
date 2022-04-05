package controller;

import java.util.Scanner;

import model.vo.Acount;
import model.vo.Student;
import model.vo.Teacher;

public class LoginMenuManager {
	private TeacherDatabaseManager tDB = new TeacherDatabaseManager();
	private DatabaseManager dDB= new DatabaseManager();
	private Scanner sc = new Scanner(System.in);

	public void main() {
		StringBuilder sb = new StringBuilder();

		sb.append("=====성적 관리 프로그램 실행=====\n");
		sb.append("1. 교사용 로그인\n");
		sb.append("2. 학생용 로그인\n");
		sb.append("9. 프로그램 종료\n");
		sb.append(">>>>>");

		while (true) {
			System.out.println(sb.toString());
			int menuNum = Integer.parseInt(sc.nextLine());
			switch (menuNum) {
			case 1:
				System.out.println("====교사용 성적 관리 프로그램 실행 ====");
				teacherLoginMenu();
				break;
			case 2:
				System.out.println("====학생용 성적 관리 프로그램 실행 ====");
				studentLoginMenu();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("해당하지 않는 번호 입니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	private void teacherLoginMenu() {
		System.out.print("이름 : ");
		String username = sc.nextLine();

		for (int i = 0; i < 3; i++) {
			System.out.print("패스워드 : ");
			String password = sc.nextLine();

			Acount loginAcount = tDB.login(username, password);

			if (loginAcount != null) {
				MenuManager m = new MenuManager(loginAcount);
				m.main();
				break;
			} else {
				System.out.println("로그인 실패, 이름과 패스워를 확인해주세요.");
			}
		}
	}
	private void studentLoginMenu() {
		System.out.print("이름 : ");
		String username = sc.nextLine();

		for (int i = 0; i < 3; i++) {
			System.out.print("패스워드 : ");
			String password = sc.nextLine();

			Acount loginAcount = dDB.login(username, password);

			if (loginAcount != null) {
				MenuManager m = new MenuManager(loginAcount);
				m.main();
				break;
			} else {
				System.out.println("로그인 실패, 이름과 패스워를 확인해주세요.");
			}
		}	}

}
