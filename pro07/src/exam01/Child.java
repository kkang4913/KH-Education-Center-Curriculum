package exam01;

public class Child extends Parent {
	
	public Child(int number) {
		super(number);	//부모생성자 명시
	}
	
	
	@Override
	public int getNumber() {
		System.out.println("자식의 getNumber 메서드 시작");
		int num = super.getNumber();
		System.out.println("자식의 getNumber 메서드 끝");
		return num + 10;
	}
}
