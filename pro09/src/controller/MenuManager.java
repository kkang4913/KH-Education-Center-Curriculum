package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import model.vo.Acount;
import model.vo.Grade;
import model.vo.Student;
import model.vo.Teacher;

public class MenuManager {
	DatabaseManager dm = new DatabaseManager();
	TeacherDatabaseManager tm = new TeacherDatabaseManager();
	Scanner sc = new Scanner(System.in);
	private Acount loginAcount;
	
	public MenuManager(Acount loginAcount) {
		this.loginAcount = loginAcount;
	}
	
	public void main() {
		if (loginAcount instanceof Teacher) {
			teacherMenuList();
		}else {
			studentMenuList();
		}
	}
	/*사용자 입력을 받아서 위의 메뉴에 해당하는 번호를 입력하면 다음의 메서드를 동작
	 * 	- 성적 조회 : searchMenu();
	 *  - 학생 정보 추가 : studentAddMenu();
	 *  - 성적 정보 수정 : subjectModifyMenu();
	 *  - 학생 정보 삭제 : studentDeleteMenu();
	 *  - 프로그램 종료 : system.exit(0); <----이코드 그대로 사용하면 프로그램 종료
	 */
	

	public void teacherMenuList() {
		// TODO Auto-generated method stub
		
		StringBuilder sb =new StringBuilder();
		sb.append("1. 성적 조회\n");
		sb.append("2. 학생 정보 추가\n");
		sb.append("3. 성적 정보 수정\n");
		sb.append("4. 학생 정보 삭제\n");
		sb.append("9. 로그아웃\n");
		sb.append(">>>");
		
		
		boolean logout =false;
		while (true) {
			System.out.print(sb.toString());
			int menuNumber = Integer.parseInt(sc.nextLine());
			
			switch (menuNumber) {
			case 1:
				searchMenu(); break;
			case 2:
				StudentAddMenu(); break;
			case 3:
				subjectModifyMenu(); break;
			case 4:
				studentDeleteMenu(); break;
			case 9:
				System.out.println("로그아웃되었습니다. ");
				logout = true;
				
			}
			if (logout) {
				break;
			}
		}
	}
	
	public void studentMenuList() {
		// TODO Auto-generated method stub
		StringBuilder sb =new StringBuilder();
		sb.append("1. 성적 조회\n");
		sb.append("9. 로그아웃\n");
		sb.append(">>>");
		boolean logout =false;
		while (true) {
			System.out.print(sb.toString());
			int menuNumber = Integer.parseInt(sc.nextLine());
			
			switch (menuNumber) {
			case 1:
					printGrades(
							((Student)loginAcount).getName(),
							((Student)loginAcount).getGrades()
							);
					break;
			case 9:
				System.out.println("로그아웃되었습니다. ");
				logout = true;

			}
			if (logout) {
				break;
			}
		}
	}
public void printGrades(String name, Grade[] grades) {
	StringBuilder sb =new StringBuilder();
	sb.append("이름 : " + name + "\n");
	sb.append("-----------------------\n");
	for (int i = 0; i < grades.length; i++) {
		sb.append(grades[i].getName() + "\t");
	}
	sb.append("\n");
	double avg = 0;
	for (int i = 0; i < grades.length; i++) {
		sb.append(grades[i].getScoer() + "점\t");
		avg += grades[i].getScoer();
	}
	avg /= grades.length;
	sb.append("\n");
	for (int i = 0; i < grades.length; i++) {
		sb.append(grades[i].getLevel() + "등급\t");
	}
	sb.append("\n");
	sb.append("-------------------------\n");
	sb.append("평균 : " + avg + "\n");
	sb.append("-------------------------\n");

	System.out.println(sb.toString());
}


	
	
	
	public void searchMenu() {
		/*
		 * DatabaseManager 클래스의 search 메서드를 사용하여 성적 정보가 출력될 수 있게 한다.
		 * 
		 * --------------------
		 * 이름: 홍길동
		 * --------------------
		 * 국어   영어   수학   과학
		 * xx점  xx점   xx점  xx점
		 * x등급  x등급  x등급  x등급
		 * -------------------
		 * 평균 : xx.xx 점
		 */
		while(true) {
		System.out.print("이름 입력 : ");
		String name =sc.nextLine();
		Grade[] grades =dm.search(name);
		if(grades ==null) {
			System.out.println("입력한 학생의 정보를 찾을 수 없습니다.다시 입력해주세요.");
		}
		}
	}
		
	public void StudentAddMenu() {
		while(true) {
		System.out.print("추가할 학생의 이름 : ");
		String addName = sc.nextLine();
		boolean result = dm.add(addName);
	if (result == true) {
		System.out.println("추가 작업이 완료되었습니다.");
		break;
	}else {
		System.out.println("중복된 이름이 존재합니다.");
	}
		}
	}
	
	
	public void subjectModifyMenu(){
		while(true) {
			String name;
			Grade[] grades = new Grade[0];
			while(true) {
				System.out.print("학생 이름 : ");
				name = sc.nextLine();
				grades = dm.search(name);
				if(grades == null) {
					System.out.println("해당 학생 정보가 존재하지 않습니다. 다시 입력하세요.");
				} else {
					StringBuilder sb = new StringBuilder();
					sb.append("--------------------\n");
					for(int i = 0; i < grades.length; i++) {
						sb.append(grades[i].getName() + "\t");
					}
					sb.append("\n--------------------\n");
					
					System.out.println(sb.toString());
					break;
				}
			}
			
			System.out.print("점수 : ");
			String[] inputArr = sc.nextLine().split(" ");
			int[] scoreArr = new int[grades.length];
			
			for(int i = 0; i < grades.length; i++) {
				scoreArr[i] = Integer.parseInt(inputArr[i]);
				Student result = dm.modify(name, grades[i].getName(), scoreArr[i]);
				if(result != null) {
					System.out.printf("%s 과목의 점수를 수정 하였습니다.\n", grades[i].getName());
				} else {
					System.out.println("수정 작업에 문제가 발생하였습니다.");
				}
			}
			break;
		}
	}
	
	public void studentDeleteMenu(){
		while(true) {
		System.out.print("삭제할 학생의 이름 : ");
		String addName = sc.nextLine();
		boolean result = dm.remove(addName);
	if (result == true) {
		System.out.println("추가 작업이 완료되었습니다.");
		break;
	}else {
		System.out.println("삭제할 학생 정보가 존재하지 않습니다.");
	}
		}

	}
		
	
	
	
	
	}
