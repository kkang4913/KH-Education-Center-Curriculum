package exam02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
	
	private String name;
	private int age;
	
	public Person (String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Sample04 [name=" + name + ", age=" + age + "]";
	}
	
	
	// 이름만 중복되는 경우 
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name);
	}
	
	
	// 소스 -> hascode 실행
	// 중복된 값을 찾고 존재하면 하나만 저장
//	@Override
//	public int hashCode() {
//		return Objects.hash(age, name);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		return age == other.age && Objects.equals(name, other.name);
//	}
	
	
	
	
}

public class Sample04{
	public static void main(String[] args) {
		Set<Person> pSet = new HashSet<Person>();
		//객체는 달라도 값이나 속성이 일부 또는 어느정도 같은 경우 중복으로 만들고 싶은 상황
		pSet.add(new Person("홍길동", 25));
		pSet.add(new Person("김철수", 23));
		pSet.add(new Person("김철수", 21));
		pSet.add(new Person("박주왕", 26));
		
		System.out.println(pSet);
	}
}