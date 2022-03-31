package exam11;
	

public class Main {
public static void main(String[] args) {
	BasicCalculator c1 = new Calculator();
	System.out.println(c1.add(10, 20));
	System.out.println(c1.sub(10, 20));
	System.out.println(c1.mul(10, 20));
	System.out.println(c1.div(10, 20));
	
	Calculator c2 = new EngineerCalc();
	System.out.println(c2.add(10, 20));
	System.out.println(c2.sub(10, 20));
	System.out.println(c2.mul(10, 20));
	System.out.println(c2.div(10, 20));
	
	EngineerCalc eng = (EngineerCalc)c2;
	System.out.println(eng.mod(10, 20));
	System.out.println(eng.sqrd(10, 20));
	System.out.println(eng.abs(10));
	
	Calculator c3 = new ProgrammerCalc();
	System.out.println(c3.add(10, 20));
	System.out.println(c3.sub(10, 20));
	System.out.println(c3.mul(10, 20));
	System.out.println(c3.div(10, 20));
	
	ProgrammerCalc pro =(ProgrammerCalc)c3;
	System.out.println(pro.binary(4));
	System.out.println(pro.octal(4));
	System.out.println(pro.hexa(4));
}
}
