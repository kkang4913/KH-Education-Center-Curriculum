package exam01;

import java.util.Iterator;
import java.util.Random;

public class Sample09 {
	public static void main(String[] args) {
		/*
		 * 배열의 크기가 5 인 정수 배열을 생성하고 해당 배열에
		 * 정수 값을 임의로 생성하여 초기화 하는 작업을 수행하도록
		 * 단, 배열에 초기화된 값은 중복되어서는 안된다.
		 */
	Random rd = new Random();
	int[] arry = new int[5];
	boolean flag =false;
	
	for (int i = 0; i < arry.length; ) {
	flag = false;
	int	num = rd.nextInt(19) + 1;
	for (int j = 0; j < i; j++ ) {
		if (arry[j] == num) {
			flag = true;	//중복이 되어 있다면 멈추고
			break;
		}
	}		
	if(!flag) {		//중복이 되지 않았다면 num 값을 추가
		arry[i] =num;
		System.out.printf("arry[%d] ==> %d\n",i, arry[i]);
		i++;
	}
	// 출력 값이 0이 나오는 경우 인덱스값을 증가시켜주는 for의 i++을 다른 곳으로
	}
	}
}