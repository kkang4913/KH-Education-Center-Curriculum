package exam03.pack2;

import exam03.pack1.AccessParent;
			//자식 				//부모          //상속개념
public class AccessChild extends AccessParent {
	
	public void method() {
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
	}
}
