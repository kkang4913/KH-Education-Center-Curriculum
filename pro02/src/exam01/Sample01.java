package exam01;

public class Sample01 {

	public static void main(String[] args) {
//		int i1 = 500;
//		byte b1;
//
//		// int(4byte) b1(1byte) 큰 범위에서 작은 범위로 할당 시 강제 형변환이 필요하다.
//		b1 = (byte) i1; // 강제 형변환(casthing)
//
//		System.out.println(i1);
//		System.out.println(b1);
//
//		byte b2 = 100;
//		int i2;
//
//		i2 = b2;
//
//		System.out.println(i2);
//		System.out.println(b2);
//		// 자동 형변환 : 큰범위에서 작은 범위로 할당
//
//		double d1 = 10.4;
//		int i3 = 5;
//		int i4;
//		// i4 = i3 + d1; : 형변환을 해줄수 없다 오류 발생
//		i4 = (int) (i3 + d1);
//		// 자동 형변환 (i3 -> d1으로 자동 형변환 double>int , 강제 형변환이 동시에 이뤄짐
//		System.out.println(i4);
		
		double d2 =10.6;
		double d3 =10.7;
		int i5, i6;
		
		i5 = (int)(d2+d3); 
		i6 = (int)d2 + (int)d3;
		System.out.println(i5);
		System.out.println(i6);
		// 데이터 손실 주의 사항 / 실수값 처리시 문제가 많이 발생
	}

}
