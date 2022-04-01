package exam01;

import java.util.Arrays;
import java.util.Scanner;

public class Sample02 {
	Scanner sc = new Scanner(System.in);
	public void ex01() {
		/*
		 * 사용자 입력으로 정수값을 입력 받을 때 한번의 입력으로 1개 이상의 정수값을
		 * 받을 수 있도록 한다.(nextLine())메서드 사용)
		 * 
		 * 예)
		 *   정수값 입력 : 10 20 30 40 50
		 *   
		 *   다음의 값을 입력하셨습니다.
		 *   10,20,30,40,50
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 입력 : ");
		String str = sc.nextLine();
		String sArr[];
		sArr = str.split(" ");
		System.out.println("다음의 값을 입력하였습니다.");
		System.out.println(String.join(", ", sArr));
	}
	
	public void ex02() {

	/*
	 * 사용자 입력으로 전화번호를 입력 받을 때 xxx-xxxx-xxxx 형식으로 입력하지 않은 경우
	 * 다시 입력하도록 한다.
	 */
		Scanner sc = new Scanner(System.in);
	boolean b =true;
	while (b) {
		System.out.print("전화번호 입력(하이픈 사용: xxx-xxxx-xxxx) : ");
		String pNum1 = sc.nextLine();
	if (pNum1.length() == 13) {
		String s = pNum1.substring(0, 3) + "-" + pNum1.substring(4, 8)  + "-" + pNum1.substring(9, 13);
		System.out.println(s);
		b = false;
		break;
	}else{
		System.out.println("잘못된 형식으로 입력하셨습니다.다시 입력해주세요.");
		continue;
    }
	}
	
	System.out.println("======================================================");
	}
	public void ex03() {
		/*
		 * 사용자 입력으로 전화번호를 입력 받고 출력할 때 전화번호 마지막 4자리 숫자는
		 * 다음의 문자로 마스킹 처리하여 출력되도록 한다.(마스킹문자 -> *)
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("전화번호 입력 : ");
		String pNum2 =sc.nextLine();
		String[] sArr = pNum2.split("-");
		sArr[2] = "****";
		String m = pNum2.join("-", sArr);
		System.out.println(m);
	}
	public void ex04() {
		/*
		 * 사용자 입력으로 이메일 주소 형식을 입력 받을 때 xxxxx@gmail.com 또는 xxxxx@naver.com,
		 * xxxxx@nate.com 의 주소 형식만 받을 수 있도록 한다.
		 */
		System.out.print("이메일 주소 입력 : ");
		String email;
		email = sc.nextLine();
		if (email.contains("@gamil.com") || email.contains("@naver.com") || email.contains("@nate.com") ) {
			System.out.println(email);
		}else {
			System.out.println("잘못된 이메일 형식입니다.");
		}
	}
	
	public void ex05() {
		while (true) {
			System.out.print("전화번호 입력 : ");
			String input =sc.nextLine();
			String[] sArr = input.split("-");
			
			if (sArr.length !=3) {
				continue;
			}
			if (sArr[0].length() == 3 &&sArr[1].length() == 4 && sArr[2].length() == 4 ) {
				continue;
			}
			System.out.println("전화번호 입력을 확인하였습니다.");
			break;
		}
	}
	public void ex06() {
		/*
		 * 사용자 입력으로 전화번호를 입력 받고 출력할 때 전화번호 마지막 4자리 숫자는
		 * 다음의 문자로 마스킹 처리하여 출력되도록 한다.(마스킹문자 -> *)
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("전화번호 입력 : ");
		String pNum2 =sc.nextLine();
		String m = pNum2.replace(pNum2.subSequence(pNum2.length() -4,pNum2.length() ), "****");
		System.out.println(m);
	}
	public void ex07() {
		/*
		 * 사용자 입력으로 이메일 주소 형식을 입력 받을 때 xxxxx@gmail.com 또는 xxxxx@naver.com,
		 * xxxxx@nate.com 의 주소 형식만 받을 수 있도록 한다.
		 */
		String[] emailDomain = new String[] {"gamil.com","naver.com","nate.com"};
		
		while(true) {
		System.out.print("이메일 주소 입력 : ");
		String email;
		email = sc.nextLine();
	
		String[] sArr = email.split("@");
		
		if (sArr.length != 2) {
			System.out.println("이메일 주소 형식이 아닙니다. 다시 입력하세요.");
			continue;
		}
		
		boolean valiad = false;
		for (int i = 0; i < emailDomain.length; i++) {
			if (sArr[1].equals(emailDomain)) {
				valiad = true;
			}
		}
		
		if (!valiad) {
			System.out.println("이메일 주소 형식이 아닙니다. 다시 입력하세요.");
		continue;
		}
		System.out.println("이메일 주소를 확인하였습니다.");
		}
	}
public static void main(String[] args) {
	
	Sample02 s2 = new Sample02();
	//s2.ex01();
	//s2.ex02();
	//s2.ex03();
	//s2.ex04();
	//s2.ex05();
	//s2.ex06();
	//s2.ex07();
	
	
	
	
	
	
	
	
}
}
