package exam04;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		/*
		 * Grade 에는 과목에 대한 성적 정보가 있는 객체
		 * 
		 * GradeList 에는 Grade 를 배열로 관리하는 객체 -과목에 대한 성적 관리를 위해 Grade 객체를 추가/ 수정/ 삭제/ 조회
		 * 기능을 만든다. -가능하면 가장 높은 점수를 가지는 과목으로 정렬 할 수 있는 기능을 만든다.
		 */

		GradeList datas = new GradeList();
		datas.add(new Grade("영어", 67.8));
		datas.add(new Grade("국어", 37.8));
		datas.add(new Grade("수학", 90.8));
		datas.add(new Grade("과학", 39.8));
		datas.add(new Grade("사회", 70.8));

		System.out.println(Arrays.toString(datas.getUnder()));
		System.out.println(Arrays.toString(datas.getUnder(90)));
		System.out.println(datas.getTop());
		System.out.println(datas.getBottom());
		System.out.println(Arrays.toString(datas.getTop(2)));
		System.out.println(Arrays.toString(datas.getBottom(3)));

		datas.sort(true);

		for (int i = 0; i < datas.length(); i++) {
			System.out.print(datas.getName(i));
			System.out.println(datas.getScore(i));
		}

	}
}
