package exam02;

import java.util.Iterator;
import java.util.Random;

public class Sample02 {
public static void main(String[] args) {
	/*
	 * 1 ~ 16 까지의 정수를 4x4 배열에 순차적으로 저장하고 표 형식으로 출력하시오.
	 */
	int[][] arr = new int[4][4];
	
	int num = 1;
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[i].length; j++) {
			arr[i][j] = num++;
		}
	}
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[i].length; j++) {
			System.out.print(arr[i][j] + "\t");
		}
		System.out.println("\n");
	}
	
	System.out.println("==========================================");
	/*
	 * 1 ~49 사이의 임의의 정수를 5x6 배열에 순차적으로 저장하고 표 형식으로 출력하시오
	 */
	Random rd = new Random();
	
	int[][] arr1 = new int[5][6];
	
	
	for (int i = 0; i < arr1.length; i++) {
		for (int j = 0; j < arr1[i].length; j++) {
		int num1 = rd.nextInt(49) + 1 ;
		arr1[i][j] = num1;
		}
	}
	for (int i = 0; i < arr1.length; i++) {
		for (int j = 0; j < arr1[i].length; j++) {
		int num1 = rd.nextInt(49) + 1 ;
		System.out.print(arr1[i][j] + "\t");
		}
		System.out.println("\n");
	}
	System.out.println("==========================================");
	/*
	 * 1 ~49 사이의 임의의 정수를 5xn 배열에 순차적으로 저장하고 표 형식으로 출력하시오
	 * (n의 경우 3 ~ 6 사이의 임의의 크기로 만들어 저장되도록 한다.)
	 */
	int[][] arr3 = new int[5][];

	for (int i = 0; i < arr3.length; i++) {
		int size = rd.nextInt(4) + 3;
		arr3[i] = new int[size];

		for (int j = 0; j < arr3[i].length; j++) {
			num = rd.nextInt(49) + 1;
			arr3[i][j] = num;
		}
	}
	for (int i = 0; i < arr3.length; i++) {
		for (int j = 0; j < arr3[i].length; j++) {
			System.out.print(arr3[i][j] + "\t");
		}
		System.out.println("\n");
	}
System.out.println("\n");
}

}
