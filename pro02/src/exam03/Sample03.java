package exam03;

import java.util.Scanner;

public class Sample03 {
public static void main(String[] args) {
	/*
	 *  사용자가 입력한 한 줄 데이터를 처리하기 위한 sc.nextLine()
	 *  
	 *  sc.next() : 이 메서드는 공백이 있는 문자열에 대해 입력의 구분자로 공백을 취급을 하여 일부의 문자열만 반영
	 */
	
	Scanner scr = new Scanner(System.in);
	System.out.print("한 줄의 문자열 입력 : ");
	String sInput = scr.nextLine();
	System.out.print("또 다른 한줄의 문자열 입력 : ");
	String sInput2 =scr.next();
	
	System.out.println("사용자 입력 값 : " + sInput);
	System.out.printf("사용자 입력 값 : %s\n", sInput);
	System.out.println("==============================");
	
	System.out.println("사용자 입력 값 : " + sInput2);
	System.out.printf("사용자 입력 값 : %s\n", sInput2);
    

}
}
