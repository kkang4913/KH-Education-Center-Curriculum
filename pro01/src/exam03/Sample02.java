package exam03;

public class Sample02 {
public static void main(String[] args) {
	//지역변수는 반드시 초기화가 필요
	int x;					//공간만 만들어주고 값이 없는데 
	x=1;
	System.out.println(x);
	
	/*상수 : 한 번 초기화를 한 후에는 값을 수정할 수 없다.
	 *변수 선언 방식과 유사마려, 변수 선언 할 때 쓰이는 자료형 앞에 final 예약어를 사용
	 *
	 * 
	 */
	final int i;
	i = 2;
//	i = 3; // 값을 수정 할 수 없기 때문에 오류가 발생한다.
	System.out.println(i);
	String str = "기차";
	System.out.println(str);
	String str1 = new String("기차" + "칙칙폭폭");
	System.out.println(str1);
	String str2 = "기차" +(123 + 45) + "출발";
	System.out.println(str2);
	String str3 = 123+45 + "기차" + "칙칙폭폭";
	System.out.println(str3);
}
}
