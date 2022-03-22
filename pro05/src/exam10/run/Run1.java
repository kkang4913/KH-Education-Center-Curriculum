package exam10.run;

import exam10.medel.vo.Member;

public class Run1 {

	public static void main(String[] args) {
		Member m = new Member();
		m.changeName("홍길동");
		
		m.printName();
	}
}
