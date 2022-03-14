package exam01;

import java.util.Iterator;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 배열(Array)
		 * 		동일한 자료형의 데이터를 하나의 묶음으로 만들어 관리하기 위한 것
		 * 		
		 * 		기존 변수 공간에는 하나의 값만을 저장할 수 있었던 것에서 배열을 사용하면
		 * 		하나 이상의 값을 저장할 수 있게된다.
		 * 
		 * 		배열로 저장된 값은 인덱스(Index) 번호가 부여되어 개별 값에 접근을 할 수 있다.		
		 * 		인덱스(Index) 번호는 0번 부터 시작하는 번호로 생성된다.
		 *
		 *배열 선언 방법
		 *		자료형[] 배열명;
		 *		자료형 배열명[];
		 *		
		 *배열에 저장할 값의 갯수(배열크기)를 정하는 방법
		 *		배열명 = new 자료형[배열크기]
		 *
		 *배열에 초기값 설정		
		 *		배열명[위치값] = 초기값;
		 *
		 *배열 선언 후 즉시 크기 설정 및 초기값 저장
		 *		자료형[] 배열명 = new 자료형[] {초기값1, 초기값2, 초기값3, ....}
		 */
	
		int[] arr1;
		arr1 =new int[3];
		arr1[0] = 1; arr1[1] =2; arr1[2] =3;
		
		System.out.println(arr1[0] + "," + arr1[1] + "," + arr1[2]);
		
		//반복문 사용 초기화
		for (int i = 0; i < 3; i++) {
			arr1[i] = i + 1;
		System.out.println(arr1[i]);
		}
		
		int[] arr2 = new int[]{3,4,5};
		
		System.out.println(arr2[1]+ ","+ arr2[0] + ","+ arr2[2]);
		
		for (int i = 0; i < 3; i++) {
			System.out.print(arr2[i] + "\t");
		}
		System.out.println("\n");
		
//		System.out.println(arr1);	//이런 식으로 출력하면 안된다.
//		System.out.println(arr2);	//배열 객체가 출력된다.
		
		
		
		
	}

}
