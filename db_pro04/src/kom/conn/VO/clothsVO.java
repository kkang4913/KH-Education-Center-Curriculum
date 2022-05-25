package kom.conn.VO;

import java.sql.Date;

public class clothsVO {
	//관리자ID_Password 테이블
	private String adminid;
	private String password;
	
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//tb_테이블
	private String brandCode;
	private String productCode;
	private String productName;
	private int price;
	private int counts;
	private Date registDt;
	private char delYn;
	
	//tb_브랜드
	private String brandName;
	private String address;
	private String tel;
	
	
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
		
	}
	public void setPrice(String price) {
		this.price = Integer.parseInt(price);
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public void setCounts(String counts) {
		this.counts = Integer.parseInt(counts);
	}
	public Date getRegistDt() {
		return registDt;
	}
	public void setRegistDt(Date registDt) {
		this.registDt = registDt;
	}
	public char getDelYn() {
		return delYn;
	}
	public void setDelYn(char delYn) {
		this.delYn = delYn;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
