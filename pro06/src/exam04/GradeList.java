package exam04;

import java.util.Arrays;

public class GradeList {
	private Grade[] gList;

	// 추가
	public void add(Grade grade) {
		this.gList = Arrays.copyOf(this.gList, length() + 1);
		this.gList[length() - 1] = grade;
	}

	public void add(String name) {
		Grade g = new Grade(name);
		this.add(g);
	}

	public void add(String name, double score) {
		Grade g = new Grade(name, score);
		this.add(g);
	}

	// 수정 :
	// 수정할 과목을 찾아서 과목명을 수정 -> 변경전 과목명, 변경후 과목명
	// 수정할 과목을 찾아 점수를 수정 -> 찾을 과목 , 수정할 점수
	// 수정할 과목을 찾아 과목, 점수를 수정 -> 변경전 과목명, 변경후 과목명 , 수정할 점수
	// 수정할 데이터의 인덱스를 지정해서 1)과목명 2)점수 3)과목 점수 수정
	public void upDate(String src, String dest) {
		int idx = this.findIndex(src);
		if (idx >= 0) {
			this.gList[idx].setName(dest);
		}
	}
	public void upDate(String src,double score) {
		int idx = this.findIndex(src);
		if (idx >= 0) {
		this.gList[idx].setScore(score);
		}
	}
	public void upDate(String src,String dest, double score) {
		int idx = this.findIndex(src);
		if (idx >= 0) {
		this.gList[idx].setName(dest);
		this.gList[idx].setScore(score);
		}
	}
	public void upDate(String src, Grade dest) {
		int idx = this.findIndex(src);
		if (idx >= 0) {
		this.gList[idx] = dest; 
		}
	}
	
	public void upDate(int index, String name) {
		if (_validIndex(index)) {
			this.gList[index].setName(name);
		}
	}
	public void upDate(int index, double score) {
		if (_validIndex(index)) {
		this.gList[index].setScore(score);
		}
	}
	public void upDate(int index, String name, double socre) {
		if (_validIndex(index)) {
		this.gList[index].setName(name);
		this.gList[index].setScore(socre);
		}
	}
	public void upDate(int index, Grade grade) {
		if (_validIndex(index)) {
		this.gList[index] = grade;
		}
	}
	// 삭제

	// 조회
	
	
	
	
	
	
	
	//공통 기능의 메서드 : 공통된 과목명을 찾는 
	public int findIndex(String name) {
		for (int i = 0; i < length(); i++) {
			Grade data = this.gList[i];
			if (data.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	public int length() {
		return this.gList.length;
	}
	
	
	//유효한 범위의 인덱스 인지 확인하는 메서드
	private boolean _validIndex(int index) {
		return (index >=0 && index < this.gList.length);
	}
	
	
	
}
