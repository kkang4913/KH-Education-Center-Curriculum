package exam08;
  //추상 클래스 키워드
public abstract class Shape  {
	
	private double width;
	private double height;
	
	// 넓이를 구하기 위한 메서드 : 선언 만 한 추상메서드
	public abstract double getArea();
	// 둘레 구하기 위한 메서드  : 선언 만 한 추상메서드
	public abstract double getRound();
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	
	
}
