package exam02;

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
	}

}
