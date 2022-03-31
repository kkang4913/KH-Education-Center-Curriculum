package exam09;

public abstract class Customer {
	private String name;
	private int age;
	private char gender;
	private double priceTotal;
	
	public Customer(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public double getPriceTotal() {
		return this.priceTotal;
	}
	
	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}
	//구매
	public abstract void buy(String productName, double price);
	
	//환불 : 리턴타입, 매개변수 타입을 미리 생각해둬야한다.
	public abstract boolean refund(String productName);
	
	//장바구니 : 리턴타입, 매개변수 타입을 미리 생각해둬야한다.
	public abstract boolean basket(String productName, int count);
	
	//배송조회
	public abstract String searchDelivery(String orderCode);
	
	//포인트적립
	public abstract int addpoint(int price);
	
	//추천상품
	public abstract String[] suggestionProduct();
	
}
