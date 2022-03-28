package exam02;

public class Main {
public static void main(String[] args) {
	
	Student s = new Student("홍길동");
	s.setName("홍길동");
	s.setAge(50);
	s.setGender('M');
	s.setClassLevel(1);
	s.setClassRoom(2);
	System.out.println(s.getName());
	
	Teacher t = new Teacher("이순신");
	t.setName("이순신");
	t.setAge(20);
	t.setGender('M');
	t.setClassLevel(3);
	t.setCalssRoom(3);
	t.setSubject("수학");
	System.out.println(t.getName());

	// 학생,선생님 클래스에서 getGender()라고 할 때 학생은 남학생,여학생으로 반환되도록 하고
	// 선생님은 남선생님, 여선생님 으로 반환되도록 하기 위해 코드를 수정하시오.
	System.out.println(s.getGender());
	System.out.println(t.getGender());
	
	System.out.println(s);
	System.out.println(t);
	
	Student s1 = new Student("홍길동");
	s1.setName("홍길동");
	s1.setAge(50);
	s1.setGender('M');
	s1.setClassLevel(1);
	s1.setClassRoom(2);
	System.out.println(s.getName());
	
	System.out.println(s.equals(s1));
	
}
}
