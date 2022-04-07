package model.vo;

import java.util.Random;

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

	public String resetPassword() {
		Random rand = new Random();
		String prefix = "STD_";
		String newPass = "";
		
		for (int i = 0; i < 6; i++) {
			newPass += (char)(rand.nextInt(26) + 65);
		}
		setPassword(prefix + newPass);
		return prefix + newPass;
	}
	
}
