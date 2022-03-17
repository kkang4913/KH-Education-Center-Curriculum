package exam01;

import java.util.Arrays;
import java.util.Scanner;

public class Sample11 {
public static void main(String[] args) {
	/*
	 *	사용자 입력을 받아서 다음의 기능을 수행하는 코드를 작성
	 *		1. 사용자 입력을 사용 할 횟수를 먼저 입력 받는다.
	 *		2. 배열에 저장된 모든 정수의 합과 평균을 구하여 출력 
	 *		3. -1 입력이 들어오면 더 이상 사용자 입력을 받지 않는 것으로 한다.
	 * 예제
	 *		1 번째 정수값 입력 : 7	
	 *		2 번째 정수값 입력 : 12	
	 *		3 번째 정수값 입력 : 24
	 *		4 번째 정구값 입력 : -1
	 *		
	 *총 합 : 43
	 *		평 균 : 14.3	
	 */	
	Scanner sc = new Scanner(System.in);
	int sum = 0;
	double avg = 0;

	int[] arr1 = new int[0];

	int i = 0;
	for (;;) {
		System.out.printf("%d 번째 정수값 입력 : ", i + 1);

		// 사용자가 입력한 값이 정수냐
		int num1;
		String other = "";
		if (sc.hasNextInt()) { 	//정수 입력
			num1 = sc.nextInt(); sc.nextLine(); //버퍼 클리어,플러쉬 nextLine();
		} else {								//남아 있는 개행이 날라가게 된다.
			other = sc.nextLine();
			if (other.equals("exit")) {
				break;
			} else {
				System.out.println("정수 값 또는 exit를 입력하세요.");
				continue; // 반복의 처음 위치로 돌아가게
			}
		}

		int[] temp1 = Arrays.copyOf(arr1, arr1.length + 1);
		arr1 = temp1;

		arr1[i] = num1;
		sum += arr1[i];
		i++;
	}
	avg = (double) sum / arr1.length;
	System.out.printf("총 합 : %d\n", sum);
	System.out.printf("평 균 : %.1f\n", avg);
}
}
