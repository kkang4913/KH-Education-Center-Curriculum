package exam03;

import java.util.Objects;

public class Grade extends Score  {
	//점수와 등급 정보를 가지는 객체
	private char level;
	
	public Grade() {}
	
	public Grade(double point) {
		this.setPoint(point);
	}
	
	//점수를 설정할 때 0 ~ 100 사이의 점수만 설정할 수 있도록 만들어라.
	@Override
	public void setPoint(double point) {
		char[] rank =new char[] {'F','F','F','F','E','E','D','C','B','A'};
		if (point >=0 && point <=100) {
			super.setPoint(point);
		}
		this.level = rank[(int)(getPoint() /10)];
	}

	public char getLevel() {
		return level;
	}

	public void setLevel(char level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return super.toString() + "" + "Grade [level=" + level + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(level);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Grade other = (Grade) obj;
		System.out.println(level + "|" + other.level);
		return level == other.level;
	}
	
	
	
	
	
}
