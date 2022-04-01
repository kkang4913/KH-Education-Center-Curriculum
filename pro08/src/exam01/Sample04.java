package exam01;

import java.util.StringTokenizer;

public class Sample04 {
public static void main(String[] args) {
	/*
	 *  StringTokenizer (분리가 된 문자열들을 Token이라 지칭)
	 * 		- String 클래스에서 제공하는 split() 메서드와 유사한 기능을 제공하는 클래스
	 */
	String phone = "010-4913-2169";
	StringTokenizer token = new StringTokenizer(phone,"-");
	
	System.out.println("토큰 수 : " + token.countTokens());
	
	while (token.hasMoreTokens()) {
		System.out.println(token.nextToken());
	}
	
	
	
}
}
