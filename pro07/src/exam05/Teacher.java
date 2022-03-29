package exam05;

public class Teacher extends Person {

	private int classLevel;
	private int classLRoom;
	private String subject;
	
	
	public Teacher(String name,int age) {
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


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
