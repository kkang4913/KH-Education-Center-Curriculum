package exam09;

public class Rectangle {
	private double width;
	private double lenth;
	private double area;
	private double round;

	public Rectangle() {
	}

	public Rectangle(double width, double lenth) {
		this.width = width;
		this.lenth = lenth;
		_area();
		_round();
	}

	public void setWidth(double width) {
		this.width = width;
		_area();
		_round();
	}

	public void setLenth(double lenth) {
		this.lenth = lenth;
		_area();
		_round();
	}

	public double getWidth() {
		return width;
	}

	public double getLenth() {
		return lenth;
	}

	public double getArea() {
		return area;
	}

	public double getRound() {
		return round;
	}

	public void _area() {
		area = width * lenth;
	}

	public void _round() {
		round = (width + lenth) * 2;
	}
}
