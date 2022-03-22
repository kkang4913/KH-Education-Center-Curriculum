package exam10.medel.vo;

public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private int age;
	private char gender;
	private String Phone;
	private String email;
	
	//자동 생성되기에 만들지 않아도 괜찮다.
	//기본생성자는 매개개변수가 있는 생성자가 없으면 자동 생성
	//public Member() {}
	
	public void changeName(String name) {
		memberName = name;
	}
	public void printName() {
		System.out.println(memberName);
	}
	
}
