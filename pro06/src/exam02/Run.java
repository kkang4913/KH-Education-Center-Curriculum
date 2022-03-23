package exam02;

import java.util.Arrays;

public class Run {
	public static void main(String[] args) {
		ReportGrade r = new ReportGrade("홍길동");
		String[] subjects = new String[] { "국어", "영어", "수학", "과학" };

		double[] grades = new double[] { 76.8, 84.2, 93.3, 87.8 };

		r.setSubjects(subjects);
		r.setGrade(grades);

		r.setGrade("영어", 90);
		
		String[] s = r.getSubjects();
		double[] d = r.getGrade();
		
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i] + " : " + d[i]);
		}

		r.add("사회", 92.4);
		
		System.out.println(r.getGrade("국어"));
		System.out.println(r.getGrade("수학"));
		System.out.println(r.getGrade("영어"));
		System.out.println(r.getGrade("과학"));
		System.out.println(r.getGrade("사회"));
		
		System.out.println(Arrays.toString(r.getSubjects()));
		r.remove(2);
		System.out.println(Arrays.toString(r.getSubjects()));
		r.remove("과학");
		System.out.println(Arrays.toString(r.getSubjects()));
	}
}
