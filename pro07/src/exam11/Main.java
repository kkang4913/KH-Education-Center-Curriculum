package exam11;
	

public class Main {
public static void main(String[] args) {
	BasicCalculator c1 = new Calculator();
	System.out.println(c1.add(10, 20));
	System.out.println(c1.sub(10, 20));
	System.out.println(c1.mul(10, 20));
	System.out.println(c1.div(10, 20));
	
	BasicCalculator c2 = new EngineerCalc();
	System.out.println(c2.add(10, 20));
	System.out.println(c2.sub(10, 20));
	System.out.println(c2.mul(10, 20));
	System.out.println(c2.div(10, 20));
	
	EngineerCalc eng = (EngineerCalc)c2;
	System.out.println(eng.mod(10, 20));
	System.out.println(eng.sqrd(10, 20));
	System.out.println(eng.abs(10));
	
	
}
}
