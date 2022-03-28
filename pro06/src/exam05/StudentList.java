package exam05;

import java.util.Arrays;
import java.util.Iterator;

import exam04.Grade;

public class StudentList {
	/*
	 * Student 클래스 배열 형식으로 관리할 수 있게 만드는 클래스 
	 * - 이 클래스로 다음의 기능을 제공하도록 한다 
	 * - 학생 정보를 추가 할 수 있는 기능 
	 * (반드시 이름, 나이, 학년, 반 정보가 저장되도록 한다 )
	 * 
	 * - 학생 정보를 수정 할 수 있는 기능 (학생 이름으로 학년, 반 정보를 수정할 수 있게 한다 )
	 * 
	 * - 학생 정보를 삭제 할 수 있는 기능 
	 * (학생 이름 뿐만아니라 학년, 반 정보로도 삭제할 수 있게 한다 ) 
	 * (예로 3학년에 해당하는 학생
	 * 정보를 모두 삭제할 수 있게 하는 기능)
	 *
	 * - 학생 이름으로 학년,반 정보를 제공하는 기능 
	 * - 학년 정보로 모든 학생의 이름을 제공하는 기능 - 학년, 반 정보로 모든 학생의 이름을
	 * 제공하는 기능
	 */

	private Student[] sArr;

	public StudentList(String name, int age, int stuLevel, int stuRoom) {
		sArr = new Student[1];
		sArr[0] = new Student(name, age, stuLevel, stuRoom);
	}

	public void add(String name, int age, int stuLevel, int stuRoom) {
		sArr = Arrays.copyOf(sArr, sArr.length + 1);
		sArr[sArr.length - 1] = new Student(name, age, stuLevel, stuRoom);
	}

	public void add(Student student) {
		sArr = Arrays.copyOf(sArr, sArr.length + 1);
		sArr[sArr.length - 1] = student;
	}
	// 학생 정보 수정

	public void upDate(String findName, int stuLevel, int stuRoom) {
		int idx = this._findIndex(findName);
		if (idx == 1) {
			return;
		}
		sArr[idx].setStuLevel(stuLevel);
		sArr[idx].setStuRoom(stuRoom);
	}

	// 삭제 하는 로직
	public void remove(String findName) {
		int idx = this._findIndex(findName);
		Student[] temp = new Student[sArr.length - 1];
		System.arraycopy(sArr, 0, temp, 0, idx);
		System.arraycopy(sArr, idx + 1, temp, idx, sArr.length - (idx + 1));
		sArr = temp;
	}

	public void remove(int stuLevel) {
		while (_findIndex(stuLevel) != -1) {
			int idx = _findIndex(stuLevel);
			this._remove(idx);
		}
	}

	private void _remove(int index) {
		Student[] temp = new Student[sArr.length - 1];
		System.arraycopy(sArr, 0, temp, 0, index);
		System.arraycopy(sArr, index + 1, temp, index, sArr.length - (index + 1));
		sArr = temp;
	}

	public int[] getstuLevelRoom(String name) {
		int idx = _findIndex(name);
		return new int[] { sArr[idx].getStuLevel(), sArr[idx].getStuRoom() };
	}

	public String[] getNames(int stuLevel) {
		String[] result = null;
		for (int i = 0; i < sArr.length; i++) {
			if (stuLevel == sArr[i].getStuLevel()) {
				if (result == null) {
					result = new String[0];
				}
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = sArr[i].getStuName();
			}
		}
		return result;
	}

	public String[] getNames(int stuLevel, int stuRoom) {
		String[] result = null;
		for (int i = 0; i < sArr.length; i++) {
			if (stuLevel == sArr[i].getStuLevel() && stuRoom == sArr[i].getStuRoom()) {
				if (result == null) {
					result = new String[0];
				}
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = sArr[i].getStuName();
			}
		}
		return result;
	}

	public int length() {
		return sArr.length;
	}

	// 해당 인데스 찾는 기능 메서드
	public int findIndex(String name) {
		return this._findIndex(name);
	}

	private int _findIndex(String name) {
		for (int i = 0; i < sArr.length; i++) {
			if (name.equals(sArr[i].getStuName())) {
				return i;
			}
		}
		return -1;
	}

	private int _findIndex(int stuLevel) {
		for (int i = 0; i < sArr.length; i++) {
			if (stuLevel == sArr[i].getStuLevel()) {
				return i;
			}
		}
		return -1;
	}
}
