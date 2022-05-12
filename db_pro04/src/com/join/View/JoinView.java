package com.join.View;

import java.util.Scanner;

import com.join.controller.JoinController;
import com.join.dao.JoinDAO;
import com.join.menu.JoinMenu;
import com.join.vo.JoinVo;

/*
 *  CLI 화면에 회원가입, 탈퇴, 정보수정 등과 같은 메뉴 및 정보를
 *  보여주고 사용자가 데이터를 입력할 수 있는 화면을 제공하는 객체
 */
public class JoinView {
	
	private Scanner sc = new Scanner(System.in);
	private JoinController jc = new JoinController();
	private JoinMenu menu = new JoinMenu();
	
	public void show() {
		
		// 회원 가입 및 로그인 요청에 맞추어 적절한 메서드를 호출
		while (true) {
			System.out.println(menu.getMenu());
			System.out.println("메뉴 번호를 입력해주세요. ex) 1, 2, 3");
			System.out.print("입력 > > > > > > ");
			String input = sc.nextLine();
			switch (input) {
			case "1":
				this.joinMenu();
				break;
			case "2":
				this.loginMenu();
				break;
			case "3":
				System.out.println("회원 가입 프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("잘못된 메뉴 번호입니다. 다시 확인해 주세요.");
				break;
			}
		}
	}
	public void joinMenu() {
		// 회원 가입을 처리하기 위한 메서드
		JoinVo data = new JoinVo();
	
		System.out.print("아이디 입력: ");
		data.setUserid(sc.nextLine());
		
		System.out.print("패스워드 입력: ");
		data.setUserpw(sc.nextLine());
		
		System.out.print("이름 입력: ");
		data.setUsername(sc.nextLine());
		
		System.out.print("성별 입력(남/여): ");
		data.setGender(sc.nextLine());
		
		System.out.print("나이 입력: ");
		data.setAge(sc.nextLine());
		
		boolean result =jc.join(data);
		
		
		if (result) {
			System.out.println("회원 가입이 완료되었습니다.");
		}else {
			System.out.println("회원 가입에 실패하였습니다.(아이디 중복)");
		}
		
	}
	
	public void loginMenu() {
		// 로그인을 처리하기 위한 메서드
		String userid, userpw;
		
		System.out.print("아이디 : ");
		userid = sc.nextLine();
		
		System.out.print("패스워드 : ");
		userpw = sc.nextLine();

		JoinVo account = jc.login(userid, userpw);
		
		if (account != null) {
			System.out.println(account.getUserid() + "님이 로그인 하였습니다.");
			this.afterLoginMenu(account);
		}else {
			System.out.println("잘못된 아이디 또는 패스워드 입니다.");
		}
	}
	public void afterLoginMenu(JoinVo account) {
		while (true) {
			System.out.print(menu.getAfterLogin(account.getUserid()));
			System.out.print(">>>");
			String input = sc.nextLine();
			
			switch (input) {
			case "1":			
				System.out.println("아무것도 입력을 하지 않으면 이전 값을 유지 합니다.");
				System.out.print("변경 할 패스워드 : ");
				input = sc.nextLine();
				input = input.isEmpty() ? account.getUserpw() : input;
				account.setUserpw(input);
				
				System.out.print("변경 할 이름 : ");
				input = sc.nextLine();
				input = input.isEmpty() ? account.getUsername() : input;
				account.setUsername(input);
				
				System.out.print("변경 할 성별(남/여) : ");
				input = sc.nextLine();
				input = input.isEmpty() ? Character.toString(account.getGender()) : input;
				account.setGender(input);
				
				System.out.print("변경 할 나이 : ");
				input = sc.nextLine();
				input = input.isEmpty() ? Integer.toString(account.getAge()) : input;
				account.setAge(input);
				
				if(jc.update(account)) {
					System.out.println("정보 수정이 완료되었습니다.");
				}else {
					System.out.println("정보 수정에 실패하였습니다.");
				}
				break;
			case "2":	
				System.out.print("패스워드 : ");
				input = sc.nextLine();
				
				if (jc.remove(account, input)) {
					System.out.println("회원 탈퇴가 완료되었습니다.");
					return;
				}else {
					System.out.println("회원 탈퇴가 이루어지지 않았습니다.패스워드를 확인해주세요.");
				}
				break;
			case "3":
				System.out.println(account.getUserid() + "님이  로그아웃하였습니다.");
				account =null; //로그아웃처리
				return;
			default:
				System.out.println("잘못된 메뉴 번호입니다. 다시 확인해 주세요.");
				break;
			}
		}
	}
	
}
