package exam05;

public class Main {
public static void main(String[] args) {
	/*
	 * 다형성
	 * 		- 객체지향 프로그램의 3대 특징 중 한가지(그 밖의 특징 캡슐화,상속)
	 * 		- 하나의 객체가 여러 형태를 가질 수 있다는 의미
	 * 		- 하나의 객체(부모)를 사용해서 여러 형태의 객체(자식)를 다룰 수 있는 기능 제공
	 */
	
	/*
	 * 업 캐스팅  
	 * 		- 상위 객체(부모)로 변환 하는 것
	 * 		- 자식 클래스가 부모 클래스로 변환
	 * 		- 부모 타입의 참조변수에 자식 타입의 참조변수를 저장할 수 있다.
	 * 		- 자동으로 변환이 이루어지기 때문에 별도의 캐스팅 연산자를 사용할 필요가 없다.
	 */
	Person s1 = new Student("홍길동",30);		//하위객체 -> 상위객체
	Person t1 = new Teacher("고길동", 20);	//업 캐스팅
	
	System.out.println(s1.getName()	+ " | " + s1.getAge());
	System.out.println(t1.getName()	+ " | " + t1.getAge());
	
	Person[] p1 = new Person[3];
	p1[0] = new Teacher("헐크",20);
	p1[1] = new Student("토르",30);
	p1[2] = new Student("로키",40);

	for (int i = 0; i < p1.length; i++) {
		System.out.println(p1[i].getName()	+ " | " + p1[i].getAge());
	}
	
	/*
	 * 다운 캐스팅
	 * 		- 하위 객체로 변환 하는 것
	 * 		- 부모 클래스로 업 캐스팅한 객체를 다시 자식 타입으로 변환하는 것
	 * 		- 부모 타입의 참조변수에 저장된 자식 타입의 참조값을 다시 원래의 자식 타입으로 변환
	 * 		- 캐스팅 연산자를 사용하여 변환을 시켜야 한다.
	 */ 
	Person s2 = new Student("홍길동",30);
	Student s3 = (Student)s2;
	s3.setClassLevel(1);
	s3.setClassLRoom(2);
	
	Person t2 = new Teacher("홍길동",30);
	Teacher t3 = (Teacher)t2; 
	t3.setClassLevel(1);
	t3.setClassLRoom(2);
	t3.setSubject("국어");
	
	Person[] p2 = new Person[2];
	p2[0] = s3; p2[1] = t3;
	
	for (int i = 0; i < p2.length; i++) {
		if (p2[i] instanceof Student ) {
			Student s = (Student)p2[i];
			System.out.println(s.getClassLevel() + "학년" + s.getClassLRoom() + "반 학생");
		}else {
			Teacher t = (Teacher)p2[i];
			System.out.println(t.getClassLevel() + "학년" + t.getClassLRoom() + "반 " + t.getSubject() + " 담당 선생님");
		}
	}
	
}
}
