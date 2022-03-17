package exam04;

public class Sample01 {

	public static void main(String[] args) {
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		StaticTest st3 = new StaticTest();
		
		StaticTest.share =20;
		//System.out.println(st1.share + "|" + st2.share + "|" + st3.share);
		System.out.println(StaticTest.share + "|" + StaticTest.share + "|" + StaticTest.share);
		
		StaticTest.share =30;
		//System.out.println(st1.share + "|" + st2.share + "|" + st3.share);
		System.out.println(StaticTest.share + "|" + StaticTest.share + "|" + StaticTest.share);
		
		StaticTest.share =40;
		//System.out.println(st1.share + "|" + st2.share + "|" + st3.share);
		System.out.println(StaticTest.share + "|" + StaticTest.share + "|" + StaticTest.share);
	
	
		FinalTest ft1 = new  FinalTest();
		
		//ft1.CONSTANT = 20;
		System.out.println(ft1.CONSTANT);
	
		FinalStaticTest fst1 = new FinalStaticTest();
		FinalStaticTest fst2 = new FinalStaticTest();
		
		System.out.println(fst1.SHARE_CONSTENT + "|" + fst2.SHARE_CONSTENT + "|" + FinalStaticTest.SHARE_CONSTENT);
		//fst1.SHARE_CONSTENT =20;
		
	
	}

}
