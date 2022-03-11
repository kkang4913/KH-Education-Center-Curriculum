package exam02;

import java.util.Scanner;

public class Sample09 {

	public static void main(String[] args) {
		
		/*
		 * 문자열에서 문자만 추출하는 방법
		 * 		문자열 변수명.charAt(위치값)
		 */
		
		String s = "Hello java Programming";
		char c = s.charAt(0);
		
		System.out.println(s.charAt(0));
		System.out.println(s.charAt(1));
		System.out.println(s.charAt(2));
		System.out.println(s.charAt(3));
		System.out.println(s.charAt(4));

		/*
		 * 문자열의 길이를 알아내는 방법(문자열의 길이는 문자열의 문자 수를 의미, 공백 포함)
		 * 문장열 변수명.length();
		 */
		s = "Hello java Programming";
		int len = s.length();
		System.out.println("문자열의 문자수 : " + len);
		
		/*
		 *문자열과 문자열 비교하는 방법
		 *	문자열 변수명.eqials(문자열) 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		String str1 ="문자열";
		
//		if (str1.equals(str)) {
//			System.out.println("같습니다");
//		}else {
//			System.out.println("달라요");
//		}
		
		if (str1==str) {
			System.out.println("==로 비교한 문자열 값입니다.");
		}else {
			System.out.println("문자열 값이 다릅니다.");  //문자열이 지니고 있는 특징 중 하나 // 꼭 equals 적용
		}
		
	}

}
