package exam07;

public class Sample02 {
public static void main(String[] args) {
	Construtor c1 = new Construtor(10);
	System.out.println(c1.num1);
	
	Construtor c2 = new Construtor();
	System.out.println(c2.num1 );
	
	Construtor c3 = new Construtor(100);
	Construtor c4 = new Construtor(100, 50);
	Construtor c5 = new Construtor(100, 50, 30);
	Construtor c6 = new Construtor(100, 50, 30, 20);
}
}