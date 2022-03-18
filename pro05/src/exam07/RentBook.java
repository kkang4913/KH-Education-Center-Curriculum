package exam07;

public class RentBook {

	public String bName;
	public String bNo;
	public String bRentDate;
	public int 	  bRentDays;
	public String bRetrunDate;
	public String bWriter;
	public String bRentName;
	public int bOverDays;
	public String bRentPlace;

	public RentBook() {
		this.bRentDays = 7;
	}
	public RentBook(String bName, String bNo) {
		this();
		this.bName = bName;
		this.bNo = bNo;
	}
	public RentBook(String bName, String bNo, String bRentDate) {
		this(bName, bNo);
		this.bRentDate = bRentDate;
	}	
	public RentBook(String bName, String bNo, String bRentDate, int bRentDays) {
		this(bName, bNo,bRentDate);
		this.bRentDays = bRentDays;
	}	
}