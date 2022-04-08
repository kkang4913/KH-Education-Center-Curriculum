package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import exception.GradeException;
import model.vo.Acount;
import model.vo.Student;
import model.vo.Teacher;

public class LoginMenuManager {
	private TeacherDatabaseManager tDB = new TeacherDatabaseManager();
	private DatabaseManager dDB= new DatabaseManager();
	private Scanner sc = new Scanner(System.in);

	public void main() {
		StringBuilder sb = new StringBuilder();
		// String 빌더를 통해 새로운 객체가 아닌 문자열 바로 추가
		sb.append("=====성적 관리 프로그램 실행=====\n");
		sb.append("1. 교사용 로그인\n");
		sb.append("2. 학생용 로그인\n");
		sb.append("3. 패스워드 초기화\n");
		sb.append("9. 프로그램 종료\n");
		sb.append(">>>>>");
		
		
		// 반복문 안의 조건식 확인 true 수행된다.
		while (true) {
			// 위의 String sb 를 출력 
			System.out.println(sb.toString());
			/*
			 * int menuNum = sc.nextInt();
			 * switch(menuNum)
			 */
			
			String menuNum = sc.nextLine();
			switch (menuNum.charAt(0)) {
			case '1':
				System.out.println("====교사용 성적 관리 프로그램 실행 ====");
				try {
					teacherLoginMenu();
				} catch (GradeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case '2':
				System.out.println("====학생용 성적 관리 프로그램 실행 ====");
				studentLoginMenu();
				break;
			case '3':
				resetPasswordMenu();
				break;
			case '9':
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("해당하지 않는 번호 입니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	private void resetPasswordMenu() {
		System.out.print("1. 교사용\n");
		System.out.print("2. 학생용\n");
		System.out.print(">>> ");
		
		String type = sc.nextLine();
		
		switch(type.charAt(0)) {
			case '1':
				teacherResetPassword(); break;
			case '2':
				studentResetPassword(); break;
		}
	}
	
	
	private void teacherResetPassword() {
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		boolean existed = tDB.isExisted(name);
		if (existed) {
			Teacher teacher = tDB.getTeacher(name);
			String newPass =teacher.resetPassword();
			System.out.println(newPass + "로 초기화 하였습니다.");
		}else {
			System.out.println("해당하는 계정이 존재하지 않습니다.");
		}
	}
	
	private void studentResetPassword() {
		
		System.out.print("이름 : ");
		String name = sc.nextLine();

		boolean existed = dDB.isExisted(name);
		if (existed) {
			Student student = dDB.getStudent(name);
			String newPass =student.resetPassword();
			System.out.println(newPass + "로 초기화 하였습니다.");
		}else {
			System.out.println("해당하는 계정이 존재하지 않습니다.");
		}
	}


	private void teacherLoginMenu() throws GradeException {
		System.out.print("이름 : ");
		String username = sc.nextLine();

		for (int i = 0; i < 3; i++) {
			System.out.print("패스워드 : ");
			String password = sc.nextLine();
			
			
			if (!(password.length() >=4 && password.length() <=12)) {
				throw new GradeException("4 ~ 12자의 범위를 벗어났습니다.");
			}
			
			Teacher loginAcount = tDB.login(username, password);

			if (loginAcount != null) {
				if (loginAcount.getLoginDate() != null) {
					System.out.println("최근 접속 시간 : "	+((Teacher)loginAcount).getLoginDateFomat()); 
				}else {
					System.out.println("첫 로그인을 환영합니다.");
				}
				
				((Teacher)loginAcount).setLoginDate(new Date());

				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
				System.out.println("현재 접속 시간 : " + sFormat.format(new Date()));
				
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

			Student loginAcount = dDB.login(username, password);

			if (loginAcount != null) {
				MenuManager m = new MenuManager(loginAcount);
				m.main();
				break;
			} else {
				System.out.println("로그인 실패, 이름과 패스워를 확인해주세요.");
			}
		}	}

}
