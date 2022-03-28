package exam02;

public class Teacher extends Person { //선생님 ==사람 개념적으로 같다(공통된 상위개념)
	private int classLevel; //담당 학년
	private	int classRoom;  //담당 반
	private	String subject; //담당 과목
	
	public Teacher(String name) {
		super(name);
		//super.setName(name);
	}
	
	public int getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(int classLevel) {
		this.classLevel = classLevel;
	}
	public int getCalssRoom() {
		return classRoom;
	}
	public void setCalssRoom(int calssRoom) {
		this.classRoom = calssRoom;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String getGender() {
		return super.getGender() + "선생님";
	}

	@Override
	public String toString() {
		return super.toString() + "" + "Teacher [classLevel=" + classLevel + ", classRoom=" + classRoom + ", subject=" + subject + "]";
	}



	
}
