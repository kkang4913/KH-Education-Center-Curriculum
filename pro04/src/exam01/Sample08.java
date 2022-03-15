package exam01;

import java.util.Scanner;

public class Sample08 {
public static void main(String[] args) {
	/*
	 * 사용자가 입력한 영문자열에서 입력된 문자의 수를 구하는 코드를 작성
	 * 		1. 영문자를 제외한 다른 문자는 무시한다.
	 * 		2. 영문자의 대/소문자를 구분하지 않고 문자 수를 구한다.
	 * 
	 * 예제
	 * 		영문자 입력 : hello java programming
	 * 
	 * 		입력한 영문자 분포
	 * 		a(3), e(1), g(2), h(1), i(1)
	 * 		j(1), l(2), m(2), n(1), o(2)
	 * 		p(1), r(2), v(1)
	 * 
	 */
	Scanner sc = new Scanner(System.in);

	System.out.print("영문자 입력 : ");
	String result = sc.nextLine();
	
	// 크기만큼 배열이 정해져 있다 알파벳 26자
	//0 :a 1:b 2:c......25:z
	int[] arr = new int[26]; 

	for (int i = 0; i < result.length(); i++) {
		char c = result.charAt(i);
		if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) { // 대문자 소문자 구분하지 않게
			arr[c % 32 - 1]++; // 사용자 입력 값에 대소문자 a를 넣으면 배열의 위치가 나오고 +=1 카운팅된다.
		}
		if ((c >= 'A' && c <= 'Z')) {
			arr[c = 'A'] +=1;
		}else if ((c >= 'a' && c <= 'z')) {
			arr[c - 'a'] +=1;
		}
		switch(c) { //26개의 case를 만들어야한다.
		case 'A': case'a':
			arr[0] +=1; break;
		case 'B': case'b':
			arr[1] +=1; break;
		case 'C': case'c':
			arr[2] +=1; break;
		case 'D': case'd':
			arr[3] +=1; break;
		}
	}
	for (int i = 0; i < arr.length; i++) {
		if (arr[i] > 0) {
			//소문자 125 아스키코드
			System.out.printf("%c(%d), ", (char) (i + 97), arr[i]); 
		}
	}
}
}
