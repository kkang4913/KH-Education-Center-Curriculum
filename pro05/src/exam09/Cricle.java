package exam09;

import java.awt.geom.Area;
import java.util.Scanner;

public class Cricle {
	private static final double PI = 3.14;
	private double radius;
	private double area;
	private double round;
	
	public static double getPi() {
		return PI;
	}

	public Cricle() {}
	
	public Cricle(double raius) {
	setRadius(raius);
	}
	public void setRadius(double radius) {
		this.radius = radius;
		_area(); _round();
	}
	public double getRadius() {
		return radius;
	}
	public double getDiamiter() {
		return radius *2;
	}
	
	public double getArea() {
		return area;
	}
	public double getRound() {
		return round;
	}
	
	private void _area() {
		area =PI * radius *radius;
	}
	
	private void _round() {
		round = 2 * PI *radius;
	}

	
}
