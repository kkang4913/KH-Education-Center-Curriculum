package exam02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Sample02 {
	public static void main(String[] args) {
		/*
		 *  로또 번호 생성
		 * 		 - 1 ~ 45 까지의 랜덤 번호를 생성하여 리스트에 담는다.
		 * 		 - 중복된 값 없이 리스트에 담도록 한다.
		 * 		 - 총 6개의 정수값을 리스트에 저장한다.
		 * 		 - 마지막에 출력 할 때는 오름차순으로 정렬하여 출력되도록 한다.
		 */
		
		Random rand = new Random();
		Set<Integer> aSet = new HashSet<Integer>();
	
		for (int i = 0; i < 6;) {
			int r =rand.nextInt(45) + 1;
			if (aSet.add(Integer.valueOf(r))) {
				i++;
			}
		}
		System.out.println(aSet);
		
		List<Integer> aList = new ArrayList<Integer>(aSet);
		Collections.sort(aList);
		
		System.out.println(aList);

		
		
		
}
}