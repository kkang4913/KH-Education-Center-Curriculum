package exam02;

import java.util.Scanner;

public class Sample11 {
public static void main(String[] args) {
	/*
	 * 2. 사용자가 입력한 영단어에서 'a'; 'e', 'i', 'o', 'u' 문자의
	 * 	  수를 구해 출력한다.
	 * "java programming" -> 5개
	 */

	Scanner sc = new Scanner(System.in);
	System.out.print("문자열 입력 : ");
	String str = sc.nextLine();
	int cnt = 0;
	for (int i = 0; i < str.length(); i++) {
		switch (str.charAt(i)) {
		case 'a': case 'e': case 'i': case 'o': case 'u':
			cnt++;
		}
		//if (str.charAt(i) == 'a') {
		//	cnt++;
		//} else if (str.charAt(i) == 'e') {
		//	cnt++;
		//} else if (str.charAt(i) == 'i') {
		//	cnt++;
		//} else if (str.charAt(i) == 'o') {
		//	cnt++;
		//} else if (str.charAt(i) == 'u') {
		//	cnt++;
		//}
	}
	System.out.printf("'a'; 'e', 'i', 'o', 'u' 문자가 총 %d 개 있습니다", cnt);
}
}
