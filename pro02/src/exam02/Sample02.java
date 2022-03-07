package exam02;

public class Sample02 {
	public static void main(String[] args) {
		// printf 활용 표형식으로 출력(정렬)
		// 가급적 영문자로만 작성하세요. 한글로 작성하면 원하는 방식으로 출력이 되질 않는다.
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8s|\n", "name", "age");
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "Hong", 34);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "Kim", 28);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "Park", 19);
		System.out.print("+--------+--------+\n");

		System.out.println(); // 위의 출력과 구분하기 위한 개행

		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8s|\n", "name", "age");
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8.2f|\n", "Hong", 34.0);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8.2f|\n", "Kim", 28.0);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8.2f|\n", "Park", 19.0);
		System.out.print("+--------+--------+\n");

		System.out.println(); // 위의 출력과 구분하기 위한 개행
		
		System.out.print("+--------+--------+\n");		//터미널(콘솔)
		System.out.printf("|%8s|%8s|\n", "이름", "나이");			//영문자 1자 -> 1칸
		System.out.print("+--------+--------+\n");		//한글 1자 -> 2칸 
		System.out.printf("|%8s|%8d|\n", "홍길동", 34);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "김스티븐", 28);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "박마리아나", 19);
		System.out.print("+--------+--------+\n");
	}
}
