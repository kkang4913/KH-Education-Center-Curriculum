package model.vo;

public class Student extends Acount  {
	private Grade[] grades;
	
	
	public Student(String name) {
		setName(name);
		setPassword("1111");
	}
	
	public Student(String name, String passWord) {
		setName(name);
		setPassword("1111");
	}


	public Grade[] getGrades() {
		return grades;
	}
	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}

	
}
