package exam05;

import java.util.Arrays;

public class Main {
public static void main(String[] args) {
	
	StudentList sList = new StudentList("홍길동", 16, 1, 2);
	sList.add("대장금", 16, 1, 1);
	sList.add("이순신", 17, 2, 2);
	sList.add("헐크", 16, 3, 3);
	sList.add("아이언맨", 16, 4, 4);
	sList.add("토르", 16, 5, 5);

	System.out.println(sList.length());
	sList.remove("토르");
	System.out.println(sList.length());
	System.out.println(sList.findIndex("헐크"));
	System.out.println(sList.findIndex("토르"));
	
	System.out.println(sList.length());
	System.out.println(Arrays.toString(sList.getNames(1)));
	
	sList.remove(2);
	System.out.println(sList.length());
	System.out.println(Arrays.toString(sList.getNames(1, 2)));
}
}