package exam05;

import java.util.Random;

public class Sample01 {
public static void main(String[] args) {
	
	Circle circle1 = new Circle();
	Circle circle2 = new Circle();

	circle1.radius = 1.5;
	circle2.radius = 3.5;

	circle1.diamiter = circle1.radius *2;
	circle2.diamiter = circle2.radius *2;
	
	circle1.area = (circle1.radius * circle1.radius) * Circle.PI;
	circle2.area = (circle2.radius * circle2.radius) * Circle.PI;

	System.out.println(circle1.area);
	System.out.println(circle2.area);
	
	Rectangle rectangle1 = new Rectangle();
	Rectangle rectangle2 = new Rectangle();
	
	rectangle1.width = circle1.diamiter;
	rectangle2.width = circle2.diamiter;
	System.out.println(rectangle1.width + "|" + rectangle2.width);
	
	Random rand = new Random();
	
	rectangle1.height = rand.nextInt(7) + 3;
	rectangle2.height = rand.nextInt(7) + 3;
	System.out.println(rectangle1.height + "|" + rectangle2.height);
	
	rectangle1.area = rectangle1.width * rectangle1.height;
	rectangle2.area = rectangle2.width * rectangle2.height;
	System.out.println(rectangle1.area + "|" + rectangle2.area);
}
		
	
	
	
}
