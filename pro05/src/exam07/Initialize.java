package exam07;

public class Initialize {
	
	/*JVM 기본값 (클래스 변수
	public int n1;
	public String s1;
	public boolean b1;
	public double d1;
	*/
	// 명시적 초기화
	public int n1 = 10;;
	public static int n2 =20;
	
	public String s1 = "빈값";
	public static String s2 = "정적";
	
	public boolean b1 = true;
	public double d1 = 1.0;
	
	{	//인스턴스 변수 초기화 블록 초기값
		n1 =20;
		s1 = s1 + "입니다";
		b1 = !b1;
		d1 +=9;
		s2 = s2+"~~~";
	}

	static {
		n2 = 30;
		s2 = s2+"!!!";
	}



}
