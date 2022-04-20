package exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

class Person implements Comparable<Person> {

	private String name;
	private int age;

	public Person(String name, int age) {
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
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		if (this.getName().compareTo(o.getName()) > 0) {
			return 1;
		} else if (this.getName().compareTo(o.getName()) < 0) {
			return -1;
		} else {
			if (this.getAge() > o.getAge()) {
				return 1;
			} else if (this.getAge() < o.getAge()) {
				return -1;
			}
		}
		return 0;
	}

}

public class Sample01 {
	public static void main(String[] args) {
		/*
		 * List 컬렉션 - ArrayList
		 */
		
		//List<Integer> aList = new ArrayList<Integer>();
		//List<Integer> aList new Vector<Integer>(); 동기화 기능 : Thread Safe  : 동시에 다른 스레드가 공유를 하지 못하게 해주는 기능
		List<Integer> aList = new LinkedList<Integer>(); //객체 삽입와 삽입이 빈번하게 일어나는 상황에서 성능이 좋음

		aList.add(100);
		System.out.println(aList);
		aList.add(200);
		System.out.println(aList);
		aList.add(300);
		System.out.println(aList);

		aList.add(2, 400);
		System.out.println(aList);

		List<Integer> bList = new ArrayList<Integer>();
		bList.add(500);
		bList.add(600);
		bList.add(700);

		aList.addAll(bList);
		System.out.println(aList);

		Integer result1 = aList.set(2, 350);
		System.out.println(result1 + " | " + aList);

		result1 = aList.set(3, 450);
		System.out.println(result1 + " | " + aList);

		boolean result2 = aList.contains(Integer.valueOf(300));
		System.out.println(result2);

		int result3 = aList.indexOf(Integer.valueOf(300));
		System.out.println(result3);

		result2 = bList.isEmpty();
		System.out.println(result2);

		bList.clear();
		result2 = bList.isEmpty();
		System.out.println(result2);

		result3 = aList.size();
		System.out.println(result3);

		System.out.println(aList);
		result1 = aList.remove(0);
		System.out.println(result1 + " " + aList);

		aList.remove(Integer.valueOf(600));
		System.out.println(aList);

		for (int i = 0; i < aList.size(); i++) {
			System.out.println(aList.get(i));
		}

		// 반복자 : 길이를 몰라도 while문을 활용해서 반복하는 기능을 구현할 수 있다.
		System.out.println("<<<<<< Iterator 사용>>>>>>");
		Iterator<Integer> iter = aList.iterator();
		while (iter.hasNext()) {
			Integer i1 = iter.next();
			System.out.println(i1);
		}
		// iterator 메서드가 보이면 활용할 수 있는 기능 : for each문
		// 더 이상 저장되어 있는 요소가 없을 때 까지 반복
		System.out.println("<<<<<< for each 문 >>>>>>");
		for (Integer i2 : aList) {
			System.out.println(i2);
		}
		// 역순으로 배치/ 정렬x
		Collections.reverse(aList);
		System.out.println(aList);

		// List 계열 정렬해주는 기능 (오름차순)
		Collections.sort(aList);
		System.out.println(aList);

		// 내림차순은 sort 후 reverse 를 한다.
		Collections.sort(aList);
		Collections.reverse(aList);
		System.out.println(aList);

		aList.add(3, 150);
		aList.add(1, 250);
		aList.add(4, 550);

		System.out.println(aList);

		// 내림차순 정렬
		Collections.sort(aList, new Comparator<Integer>() {
			// 정렬을 하기위해 기준을 만들어 주는 과정
			@Override
			public int compare(Integer x, Integer y) {
				if (x > y) {
					return -1; // 리턴값 1 오름차순
				} else if (x < y) {
					return 1; // 리턴값 -1 오름차순
				} else {
					return 0;
				}
			}

		});
		System.out.println(aList);

		List<Person> pList = new ArrayList<Person>();

		pList.add(new Person("홍길동", 23));
		pList.add(new Person("김철수", 23));
		pList.add(new Person("김철수", 21));
		pList.add(new Person("김철수", 25));

		System.out.println(pList);
		
		Collections.sort(pList);
		System.out.println(pList);

		Collections.sort(pList, new Comparator<Person>() {

			@Override
			public int compare(Person x, Person y) {
				if (x.getName().compareTo(y.getName()) > 0) {
					return 1;
				} else if (x.getName().compareTo(y.getName()) < 0) {
					return -1;
				} else {
					if (x.getAge() > y.getAge()) {
						return 1;
					} else if (x.getAge() < y.getAge()) {
						return -1;
					}
				}
				return 0;
			}
		});
		System.out.println(pList);
	}
}
