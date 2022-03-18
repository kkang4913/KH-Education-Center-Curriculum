package exam08;

public class Sample01 {
public static void main(String[] args) {
	
	MethodSample methodSample = new MethodSample();
	methodSample.method01();
	methodSample.method2();

	System.out.println(methodSample.num1);//인스턴스
	
	System.out.println(MethodSample.num2);//클래스(static)
	
	MethodSample.method2(); //static(정적/클래스)메서드 사용시
	
	int var1 = methodSample.method03();
	int[] var2 = methodSample.method04();
	String var3 =methodSample.method05();
	
	int[] var4 =new int[] {1,2,3};
	System.out.println(var4);
	int[] var5 = methodSample.method06(var4.clone());
	System.out.println(var4[0]);
	System.out.println(var5);
	
	methodSample.method07(1,2,7,8);
}
}
