package kom.conn.view;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import kom.conn.VO.clothsVO;
import kom.conn.controller.clothsController;
import kom.conn.dao.clothsDAO;
import kom.conn.menu.clothsMenu;

public class clothsView {
	private clothsDAO dao = new clothsDAO();
	private clothsVO vo = new clothsVO();
	private clothsController cc = new clothsController();
	
	private clothsMenu menu = new clothsMenu();
	private Scanner sc = new Scanner(System.in);
	
	

	public void show() throws Exception {
		while (true) {
			System.out.println(menu.login());
			System.out.println("메뉴 번호를 입력해주세요. ex) 1, 2, 3, 4, 5 ....");
			System.out.print("입력 > > > > > > ");
			String input = sc.nextLine();
			
			switch (input) {
			case "1":
				this.joinlogin();
				break;
			case "2":
				this.loginMenu();
				break;
			case "3":
				String id,pw;
				
				System.out.println("아이디(이름) : ");
				id = sc.nextLine();
				System.out.println("패스워드 : ");
				pw = sc.nextLine();
				
				clothsVO data = dao.get(id);
				
				if (cc.remove(data, id, pw)) {
					System.out.println(id + "관리자 계정 삭제를 성공하였습니다.");
				}else {
					System.out.println("관리자 계정 삭제가 이뤄지지 않았습니다. ");
				}
				break;
			case "4":
				System.exit(0);
				break;
			default:
				System.out.println("잘못된 메뉴 번호입니다. 다시 확인해 주세요.");
				break;
			}
		}
}
	private void joinlogin() {
		//회원가입 처리
		clothsVO data = new clothsVO();
		
		System.out.println("관리자 ID는 이름으로 입력하세요.");
		System.out.println("--------------------------------");
		
		System.out.print("아이디(이름) 입력 : ");
		data.setAdminid(sc.nextLine());
	
		System.out.print("패스워드 입력 : ");
		data.setPassword(sc.nextLine());
		
		boolean result = cc.join(data);
		
		if (result) {
			System.out.println("관리자 등록이 완료되었습니다.");
		}else {
			System.out.println("관리자 등록에 실패하였습니다.(아이디가 존재합니다)");
		}
		
	}
	
	public void loginMenu() throws Exception {
		String adminid, pw;
		
		System.out.print("아이디(이름) : ");
		adminid = sc.nextLine();
		
		System.out.print("패스워드 : ");
		pw = sc.nextLine();
		
		clothsVO account = cc.login(adminid,pw);
		
		if (account != null) {
			System.out.println(account.getAdminid() + "님이 로그인 하였습니다.");
			this.afterLoginMenu(account);
			return;
		}else {
			System.out.println("잘못된 아이디 또는 패스워드 입니다.");
		}
	}
	
	public void afterLoginMenu(clothsVO account) throws Exception {
		String input;
		while (true) {
			System.out.println(menu.loginMenu());
			System.out.print("> > > > > ");
			input = sc.nextLine();
			switch (input) {
			case "1":
				System.out.println(menu.programMenu());
				System.out.print("입력 >>>>> ");
				input = sc.nextLine();
				switch (input) {
				case "1":
					account = new clothsVO();
					
					System.out.print("브랜드 코드 입력 : ");
					account.setBrandCode(sc.nextLine());
					
					System.out.print("  제품 코드 입력 : ");
					account.setProductCode(sc.nextLine());
					
					System.out.print("     제품명 입력 : ");
					account.setProductName(sc.nextLine());
					
					System.out.print("  제품 가격 입력 : ");
					account.setPrice(sc.nextInt());
					
					System.out.print("  제품 수량 입력 : ");
					account.setCounts(sc.nextInt());

					System.out.print("        DEL(Y/N) : ");
					account.setDelYn(sc.next().charAt(0));
					
					
					boolean result = dao.add(account);
					
					if (result) {
						System.out.println("제품 등록이 완료되었습니다.");
						sc.nextLine();
					}else {
						System.out.println("제품 등록에 문제가 발생하였습니다. 다시 확인해주세요");
					}
					break;
				case "2":
					System.out.println("값을 입력하지 않으면 이전 값을 유지합니다.");
					System.out.print("브랜드코드를 입력하세요 : ");
					input = sc.nextLine();
					input = input.isEmpty() ? account.getBrandCode() : input;
					account.setBrandCode(input);
					
					System.out.print("변경 할 제품 코드 : ");
					input = sc.nextLine();
					input = input.isEmpty() ? account.getProductCode() : input;
					account.setProductCode(input);
					
					System.out.print("변경 할 제품명 : ");
					input = sc.nextLine();
					input = input.isEmpty() ? account.getProductName() : input;
					account.setProductName(input);
					
					System.out.print("변경 할 제품 가격 : ");
					input = sc.nextLine();
					input = input.isEmpty() ? Integer.toString(account.getPrice()) : input;
					account.setPrice(input);

					System.out.print("변경 할 제품 수량 : ");
					input = sc.nextLine();
					input = input.isEmpty() ? Integer.toString(account.getCounts()) : input;
					account.setCounts(input);
					
					System.out.print("거래처 삭제 (Y/N) : ");
					input = sc.nextLine();
					input = input.isEmpty() ? Character.toString(account.getDelYn()) : input;
					account.setDelYn(input.charAt(0));
					
					result = cc.update(account);
					
					if (result) {
						System.out.println("등록된 제품의 정보 수정이 완료되었습니다.");
					}else {
						System.out.println("등록된 제품의 정보를 찾을 수 없습니다.");
					}
					break;
				case "3":
					System.out.print("Product Code 를 입력하세요 : ");
					String pCode = sc.nextLine();
					account = dao.pget(pCode);
					if(account != null) {
					if (cc.remove(account, pCode)) {
						System.out.println("코드와 일치하는 제품을 삭제하였습니다.");
					}else {
						System.out.println("코드가 일치하지 않습니다. 다시 확인해 주세요.");
					}
					break;
					}
				case "4":
					System.out.print("조회할 브랜드 코드를 입력해주세요 : ");
					input = sc.nextLine();
					account = dao.gett(input);
					
					System.out.println();
					System.out.print(account.getBrandCode() + "\t");
					System.out.print(account.getProductCode() + "\t");
					System.out.print(account.getProductName()+ "\t");
					System.out.print(account.getPrice()+ "\t");
					System.out.print(account.getCounts()+ "\t");
					
					//출력날짜를 변경
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

					java.util.Date createDate = new java.util.Date(account.getRegistDt().getTime());
					String sDate = dateFormat.format(createDate);
					
					System.out.println(sDate +  "\t");
					break;
				case "5":
					System.out.println("이전 화면으로 이동합니다.");
					break;
				case "6":
					System.out.println("프로그램을 종료합니다");
					System.exit(0);
				default:
					break;
				}
				break;
			case "2":
				this.brandMenu();
				
				break;
			case "3":
				return;
			default:
				break;
			}
			
		}
	}
	

	public void brandMenu() throws Exception  {
		System.out.println(menu.BrandMenu());
		
		System.out.println("메뉴 번호를 입력해주세요. ex) 1, 2, 3, 4....");
		System.out.print("입력 >>>>>>");
		String input = sc.nextLine();
		
		switch (input) {
		case "1":
			System.out.println("거래처 등록");
			break;
		case "2":
			System.out.println("거래처 수정");
			break;
		case "3":
			System.out.println("거래처 삭제");
			break;
		case "4":
			System.out.print("       이전 메뉴로 이동합니다   \n");

			System.out.print("    <    이전 메뉴로 이동중    >    \r");
			Thread.sleep(1000);
			System.out.print("   <<    이전 메뉴로 이동중    >>   \r");
			Thread.sleep(1000);
			System.out.print("  <<<    이전 메뉴로 이동중    >>>  \r");
			Thread.sleep(1000);
			System.out.print(" <<<<    이전 메뉴로 이동중    >>>> \r");
			Thread.sleep(1000);
			System.out.print("<<<<<    이전 메뉴로 이동중    >>>>>\r");
			return;
		case "5":
			System.out.println("프로그램 종료");
			System.exit(0);
			break;
		default:
			System.out.println("잘못된 메뉴 번호입니다. 다시 확인해 주세요.");
			break;
		}
	}
	
}