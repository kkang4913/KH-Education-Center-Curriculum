package exam09;

import exam05.Circle;

public class Sample01 {
public static void main(String[] args) {
	/*
	Circle 클래스 Rectangle 클래스 Triangle 클래스
	
	1.위의 만들어진 클래스를 이용하여 각 도형의 넓이를 구하기 위한 메서드를 
	만들어본다 (메서드명은 area)
	2.위의 만들어진 클래스를 이용하여 각 도형의 둘레를 구하기 위한 메서드를
	만들어 본다. 메서드명 round
	트라이앵글은 정삼각형으로 취급 둘레를 구한다.
	*/
	Cricle c1 = new Cricle(3);
	
	
	System.out.println("원의 넓이" + c1.getArea());
	System.out.println("원의 둘레" + c1.getRound());
	System.out.println("반지름" + c1.getRadius());
	System.out.println("지름" + c1.getDiamiter());
	c1.setRadius(5);
	
	System.out.println("원의 넓이" + c1.getArea());
	System.out.println("원의 둘레" + c1.getRound());
	System.out.println("반지름" + c1.getRadius());
	System.out.println("반지름" + c1.getDiamiter());
	
	
	System.out.println("PI : " + c1.getPi());
}
}
