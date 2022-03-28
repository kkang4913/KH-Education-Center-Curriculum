package exam05;

public class Student {
	/*
	 * 학생 정보를 관리하기 위한 클래스
	 * 		-이름, 나이, 학년, 반 정보를 관리하는 클래스
	 */
	private String stuName;
	private int stuAge;
	private int stuLevel;
	private int stuRoom;
	
	private Student(String name, int age) {
	this.stuName =name;
	this.stuAge =age;
	}
	
	public Student(String name, int age, int stuLevel, int stuRoom) {
		this(name, age);
		this.stuLevel = stuLevel;
		this.stuRoom = stuRoom;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public int getStuLevel() {
		return stuLevel;
	}

	public void setStuLevel(int stuLevel) {
		this.stuLevel = stuLevel;
	}

	public int getStuRoom() {
		return stuRoom;
	}

	public void setStuRoom(int stuRoom) {
		this.stuRoom = stuRoom;
	}



}
