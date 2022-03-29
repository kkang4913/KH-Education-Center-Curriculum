package exam05;

public class Student extends Person {
	
	private int classLevel;
	private int classLRoom;
	
	public Student(String name,int age) {
		super(name,age);
	}

	public int getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(int classLevel) {
		this.classLevel = classLevel;
	}

	public int getClassLRoom() {
		return classLRoom;
	}

	public void setClassLRoom(int classLRoom) {
		this.classLRoom = classLRoom;
	}
	

}
