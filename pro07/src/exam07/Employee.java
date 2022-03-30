package exam07;
//회사 직원
public class Employee {
	//공통적인 기본 기능(속성) : 직원(1)
	private String name; //이름
	private int age;	 //나이	
	private char gender; //성별
	private int salary;	 //연봉
	
	//생성자(매개변수 생성자) -> 기본생성자가 생성 안됨(3)
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//모든 직원들의 급여
	public void payMonth() {
		double pay = (double)getSalary() /12;
		System.out.printf("월급 : %,d 원 지급 하였습니다.\n",(int)(pay* 10000));
	}
	
	
	//getter & setter (2)
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
}
