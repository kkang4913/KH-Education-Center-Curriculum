package exam03;

import java.io.Serializable;
						//객체 보조 스트림 기능을 사용하기 위해서 필수 인터페이스 
public class ObjSample implements Serializable {
	private int num;
	private double point;
	private boolean yn;
	private String s;
	
	public ObjSample(int n, double d, boolean b, String s) {
		num =n;
		point =d;
		yn =b;
		this.s=s;
	}

	@Override
	public String toString() {
		return "ObjSample [num=" + num + ", point=" + point + ", yn=" + yn + ", s=" + s + "]";
	}
	
}
