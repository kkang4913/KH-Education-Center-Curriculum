package exam02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class Sample01 {
public static void main(String[] args) {
	/*
	 * Set 컬렉션
	 */
	
	//순서에 관련 없이 제멋대로 저장 된다.
	Set<Integer> aSet = new HashSet<Integer>();
	aSet.add(100); aSet.add(200); aSet.add(300);
	aSet.add(400); aSet.add(500); aSet.add(600);
	
	System.out.println(aSet);

	//set : 중복을 허용하지 않기 때문에 출력된 값에 변화가 없다.
	aSet.add(100); aSet.add(200); aSet.add(300);
	System.out.println(aSet);
	
	boolean res1;
	//중복된 값이 있어 false
	res1 =aSet.add(100);
	System.out.println(res1 + " " + aSet);
	
	//중복된 값이 없고 추가 됬으므로 true
	res1 =aSet.add(700);
	System.out.println(res1 + " " + aSet);

	Set<Integer> bSet = new HashSet<Integer>();
	bSet.add(700); bSet.add(800); bSet.add(900);
	
	res1 = aSet.addAll(bSet);
	System.out.println(res1 + " " + aSet);
	
	res1 = aSet.addAll(bSet);
	System.out.println(res1 + " " + aSet);
	
	res1 = aSet.contains(Integer.valueOf(100));
	System.out.println(res1);
	
	res1 = aSet.contains(Integer.valueOf(150));
	System.out.println(res1);
	
	//bset에 데이터가 있는지 없는지 확인
	res1= bSet.isEmpty();
	System.out.println(res1);
	
	bSet.clear(); //bset을 비워라
	res1= bSet.isEmpty(); //데이터 유무 확인
	System.out.println(res1);
	
	//데이터 값을 지우는 기능
	aSet.remove(Integer.valueOf(100));
	System.out.println(aSet);
	//존재하지 않는 값을 지우면 실행을 되지만 변화가 없다/ 대신 boolean 형식으로 반환하여 확인 가능
	res1 =aSet.remove(Integer.valueOf(150));
	System.out.println(res1 + " " +aSet);
	
	Iterator<Integer> iter =  aSet.iterator();
	while (iter.hasNext()) {
		Integer i = iter.next();
		System.out.print(i + "\t");
	}
	System.out.println();
	
	for (Integer i : aSet) {
			System.out.print(i + "\t");
			
	}
	System.out.println();
	
	// Set을 List로 변경 가능
	List<Integer> aList = new ArrayList<Integer>(aSet);
	Collections.sort(aList);
	System.out.println(aList);
	aList.add(400);
	System.out.println(aList);
	
	//List를 Set으로 변경
	aSet = new HashSet<Integer>(aList);
	System.out.println(aSet);
	
	
	
	
	
}
}
