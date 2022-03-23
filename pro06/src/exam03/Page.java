package exam03;

public class Page {
	private int pNum;			//페이지 번호
	private String[] bName;
	private int[] pMaxNum;
	
	public Page(String[] bName) {
	this.bName =bName;
	}
	
	public int[] getpMaxNum() {
		return pMaxNum;
	}

	public void setpMaxNum(int[] pMaxNum) {
		this.pMaxNum = pMaxNum;
	}

	public Page(String[] bName, int pNum) {
		this.bName = bName;
		this.pNum = pNum;
	}

	public String[] getbName() {
		return bName;
	}

	public void setbName(String[] bName) {
		this.bName = bName;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public void _nextPage(int pNum) {
		this.pNum = pNum;
		pNum += pNum;
		System.out.println(pNum);
		
	}
	public void _backPage(int pNum) {
		this.pNum = pNum;
	}
	
	
}
