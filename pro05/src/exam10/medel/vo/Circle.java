package exam10.medel.vo;

public class Circle {
	private final double PI = 3.14;
	private int radius =1;
	
	public Circle() {}
	
	public void incrementRadius() {
		//반지름의 크기 1증가시키는 메서드
		radius++;
	}
	public void getAreaOfCricle() {
		//원의 넓이
		double area = radius *radius *PI;
		System.out.println(area);
	}
	public void getSizeOfCricle() {
		//원의 둘레
		double size = (radius*2) *PI;
	System.out.println(size);
	}
	
	
	
}
