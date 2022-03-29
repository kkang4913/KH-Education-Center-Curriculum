package exam04;

public class PrimiumCustomer extends Customer {
	private double discount;
	private double priceTotal;
	
	public PrimiumCustomer(String name, int age, char gender) {
		super(name,age,gender);
	}
	
	
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}
	@Override
	public void buy(String productName, double price) {
		price = _calcDiscount(price);
		priceTotal += price; //누적
		System.out.printf("%s 님이 %s 을(를)할인율 %.2f 적용하여  %,.0f 원에 구입하였습니다, 누적금액은 %,.0f원 입니다.\n",
				getName(),productName,this.discount,price,priceTotal);
		
	}
	
	private double _calcDiscount(double price) {
		if (this.priceTotal >= 10000000) {
			this.discount = 0.1;
		}else if (this.priceTotal >= 5000000) {
			this.discount = 0.05;
		}else if (this.priceTotal >= 3000000) {
			this.discount = 0.02;
		}
		price = price * (1-discount);
		return price;
	}
	
}
