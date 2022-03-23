package exam03;

public class Run {
public static void main(String[] args) {
	Page page = new Page(args);
	String[] bName = new String[] {"1번책","2번책","3번책","4번책"};
	int[] pMaxNum = new int[]{5,7,9,10};
	
	page.setbName(bName);
	page.setpMaxNum(pMaxNum);
	
	String[] s = page.getbName();
	int[] ii = page.getpMaxNum();
	
	for (int i = 0; i < s.length; i++) {
		System.out.print(s[i] + "의 한도:" +ii[i]+ "\t");
	}
	System.out.println("");
	System.out.println("=============================================================");
	
	page._nextPage(80);
}
}
