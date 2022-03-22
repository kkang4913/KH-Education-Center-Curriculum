package exam10.medel.vo;

public class Product {
	private String pName = "키보드";
	private	int price = 250000;
	private	String brand = "X오X드";
	
	//기본생성자
	//매개변수가 있는 기본 생성자가 존재하지 않아 자동생성 
	//작성 필요가 없다.
	public Product() {}

	public void imformation() {
		System.out.println(pName);
		System.out.println(price);
		System.out.println(brand);
	}
}