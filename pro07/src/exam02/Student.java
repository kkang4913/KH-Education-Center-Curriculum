package exam02;

public class Student extends Person { //학생 == 사람 개념적으로 같다(공통된 상위개념)
	private int classLevel; //학년
	private int classRoom;	//반
	
	public Student(String name) {
	super(name);
	}
	
	public int getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(int classLevel) {
		this.classLevel = classLevel;
	}
	public int getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	@Override
	public String getGender() {
		return super.getGender() + "학생";
	}
	@Override
	public String toString() {
		return super.toString() + "" + "Student [classLevel=" + classLevel + ", classRoom=" + classRoom + "]";
	}
	



	
	
	
	
}
