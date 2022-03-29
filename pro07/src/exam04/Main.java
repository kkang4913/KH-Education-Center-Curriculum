package exam04;

public class Main {
public static void main(String[] args) {
	
	PrimiumCustomer p1 = new PrimiumCustomer("홍길동", 30, 'M');
	NormalCustomer n1 = new NormalCustomer("고길동", 40, 'M');
		
	p1.buy("루이비통", 3500000);
	p1.buy("루이비통", 3500000);
	p1.buy("루이비통", 3500000);
	p1.buy("루이비통", 3500000);
	n1.buy("루이비통", 3500000);
}
}
