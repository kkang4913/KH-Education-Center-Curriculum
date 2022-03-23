package exam02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ReportGrade {
	private String name;
	private String[] subjects;
	private	double[] grade;
	
	
	public ReportGrade(String name) {
		this.name = name;
	}
	
	public ReportGrade(String name, String[] subjects) {
		this.name = name;
		this.subjects = subjects;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getSubjects() {
		return subjects;
	}
	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	public double[] getGrade() {
		return grade;
	}
	
	public double getGrade(String subject) {
		int idx = this._findIdex(subject);
		return this.grade[idx];
	}
	public void add(String subject, double grade) {
		int len = this.subjects.length;
		this.subjects =Arrays.copyOf(this.subjects, this.subjects.length +1);
		this.grade =Arrays.copyOf(this.grade, this.grade.length +1);
	
		this.subjects[len] =subject; 
		this.grade[len] =grade; 
	}
	
	public void remove(String subject) { //과목명으로 제거, 배열에 없는 과목명의 경우 "해당 과목 존재x
		int index = this._findIdex(subject);
		if (index == -1) {
			System.out.println("해당 과목이 존재하지 않습니다.");
		}
		this.remove(index);
	}
	public void remove(int index) {	//인덱스로 제거 "인덱스의 범위를 벗어났습니다.
		if (index >=this.subjects.length && index <0 ) {
			System.out.println("인덱스의 범위를 벗어났습니다.");
			return;
		}
		String[] temp1 = new String[subjects.length -1];
		double[] temp2 = new double[grade.length -1];
		int idx = 0;
		for (int i = 0; i < this.subjects.length; i++) {
			if (i != index) {
				temp1[idx] = this.subjects[i];
				temp2[idx] = this.grade[i];
				idx++;
			}
		}
		this.subjects  =temp1;
		this.grade  =temp2;
	}
	
	public void setGrade(double[] grade) {
		this.grade = grade;
	}
	
	public void setGrade(String subjects, double grade) {
		int idx = this._findIdex(subjects);
		this.grade[idx] =grade;
	}
	
	private int _findIdex(String subject) {
		int idx =-1;
		for (int i = 0; i < this.subjects.length; i++) {
			String s = this.subjects[i];
			if (subject.equals(s)) {
				idx = i;
				break;
			}
		}
		return idx;
}
}

