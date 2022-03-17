package exam03;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Sample01 {
	public static void main(String[] args) {

		Random rd = new Random();

		int[] arr1 = new int[10];
		int[] arr2 = new int[10];

		int num1 = 0;

		for (int i = 0; i < arr1.length; i++) {
			int num = rd.nextInt(99 - 9) + 10;
			arr1[i] = num;

			num = rd.nextInt(99 - 9) + 10;
			arr2[i] = num;

		}
		System.out.println("=====1.출력 결과=====");
		System.out.println("arr1 : " + Arrays.toString(arr1));
		System.out.println("arr2 : " + Arrays.toString(arr2));

		//
		int[] arr3 = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr3[i] = arr1[i] + arr2[i];
		}
		System.out.println("=====2.출력 결과=====");
		System.out.println("arr3 : " + Arrays.toString(arr3));

//		//
//		int[] arr4 = new int[30];
//		int[] arr5 = new int[30];
//
//		int idx1 = 0, idx2 = 0;
//
//		for (int i = 0; i < arr1.length; i++) {
//			if (arr1[i] % 2 == 0) {
//				arr4[idx1] = arr1[i];
//				idx1++;
//			} else {
//				arr5[idx2] = arr1[i];
//				idx2++;
//			}
//		}
//
//		for (int i = 0; i < arr2.length; i++) {
//			if (arr2[i] % 2 == 0) {
//				arr4[idx1] = arr2[i];
//				idx1++;
//			} else {
//				arr5[idx2] = arr2[i];
//				idx2++;
//			}
//		}
//		for (int i = 0; i < arr3.length; i++) {
//			if (arr3[i] % 2 == 0) {
//				arr4[idx1] = arr3[i];
//				idx1++;
//			} else {
//				arr5[idx2] = arr3[i];
//				idx2++;
//			}
//		}
//
//		arr4 = Arrays.copyOf(arr4, idx1);
//		arr4 = Arrays.copyOf(arr5, idx2);

		// 두번째 방법
		/*
		 * int[] arr4; int[] arr5;
		 * 
		 * int cnt1 = 0, cnt2 = 0;
		 * 
		 * for (int i = 0; i < arr1.length; i++) { if (arr1[i] % 2 == 0) { cnt1++; }
		 * else { cnt2++; } if (arr2[i] % 2 == 0) { cnt1++; } else { cnt2++; } if
		 * (arr3[i] % 2 == 0) { cnt1++; } else { cnt2++; } }
		 * 
		 * arr4 = new int[cnt1]; arr5 = new int[cnt2]; int idx1 = 0, idx2 = 0;
		 * 
		 * for (int i = 0; i < arr1.length; i++) { if (arr1[i] % 2 == 0) { arr4[idx1] =
		 * arr1[i]; idx1++; } else { arr5[idx2] = arr1[i]; idx2++; } if (arr2[i] % 2 ==
		 * 0) { arr4[idx1] = arr2[i]; idx1++; } else { arr5[idx2] = arr2[i]; idx2++; }
		 * if (arr3[i] % 2 == 0) { arr4[idx1] = arr3[i]; idx1++; } else { arr5[idx2] =
		 * arr3[i]; idx2++; } }
		 */

		// 세번째 방법 -동적배열

		int[] arr4 = new int[0];
		int[] arr5 = new int[0];

		for (int i = 0; i < arr1.length; i++) {
			int[] temp;

			if (arr1[i] % 2 == 0) {
				temp = new int[arr4.length + 1];
				System.arraycopy(arr4, 0, temp, 0, arr4.length);
				arr4 = temp;

				arr4[arr4.length - 1] = arr1[i];
			} else {
				temp = new int[arr5.length + 1];
				System.arraycopy(arr5, 0, temp, 0, arr5.length);
				arr5 = temp;

				arr5[arr5.length - 1] = arr1[i];
			}

			if (arr2[i] % 2 == 0) {
				temp = new int[arr4.length + 1];
				System.arraycopy(arr4, 0, temp, 0, arr4.length);
				arr4 = temp;

				arr4[arr4.length - 1] = arr2[i];
			} else {
				temp = new int[arr5.length + 1];
				System.arraycopy(arr5, 0, temp, 0, arr5.length);
				arr5 = temp;

				arr5[arr5.length - 1] = arr2[i];
			}

			if (arr3[i] % 2 == 0) {
				temp = new int[arr4.length + 1];
				System.arraycopy(arr4, 0, temp, 0, arr4.length);
				arr4 = temp;

				arr4[arr4.length - 1] = arr3[i];
			} else {
				temp = new int[arr5.length + 1];
				System.arraycopy(arr5, 0, temp, 0, arr5.length);
				arr5 = temp;

				arr5[arr5.length - 1] = arr3[i];
			}
		}
		System.out.println("=====3.출력 결과=====");
		System.out.println("arr4 : " + Arrays.toString(arr4));
		System.out.println("arr5 : " + Arrays.toString(arr5));

		// 4. 문제

		int[] arr6 = new int[0];
		int[] arr7 = new int[1];

		for (int i = 0; i < arr4.length - 1; i++) {
			if (arr4[i] != -1) {
				for (int j = i + 1; j < arr4.length; j++) {
					if (arr4[i] == arr4[j]) {
						arr4[j] = -1;
					}
				}
			}
		}
		for (int i = 0; i < arr4.length; i++) {
			if (arr4[i] != -1) {
				int[] temp = new int[arr6.length + 1];
				System.arraycopy(arr6, 0, temp, 0, arr6.length);
				arr6 = temp;

				arr6[arr6.length - 1] = arr4[i];
			}
		}

		arr7[0] = arr5[0];
		for (int i = 1; i + 1 < arr5.length; i++) {
			boolean dup = false;
			for (int j = 0; j < arr7.length; j++) {
				if (arr7[j] == arr5[i]) {
					dup = true;
					break;
				}
			}
			if (!dup) {
				arr7 = Arrays.copyOf(arr7, arr7.length + 1);
				arr7[arr7.length - 1] = arr5[i];
			}
		}
		System.out.println("=====4.출력 결과=====");
		System.out.println("arr6 : " + Arrays.toString(arr6));
		System.out.println("arr5 : " + Arrays.toString(arr7));

		// 5. 문제
		/*
		for (int i = 0; i < arr6.length; i++) {
			for (int j = i + 1; j < arr6.length - 1; j++) {
				if (arr6[i] > arr6[j]) {
					int tmp = arr6[i];
					arr6[i] = arr6[j];
					arr6[j] = tmp;
				}
			}
		}
		for (int i = 0; i < arr7.length; i++) {
			for (int j = i + 1; j < arr7.length - 1; j++) {
				if (arr7[i] > arr7[j]) {
					int tmp = arr7[i];
					arr7[i] = arr7[j];
					arr7[j] = tmp;
		 */

		int[] arr8 = arr6.clone();
		int[] arr9 = arr7.clone();
		
		for (int i = 0; i < arr8.length - 1; i++) {
			for (int j = i+1; j < arr8.length; j++) {
				if (arr8[i] > arr8[j]) {
					int temp = arr8[j];
					arr8[j] = arr8[i];
					arr8[i] =temp;
				}
			}
		}
		for (int i = 0; i < arr9.length - 1; i++) {
			for (int j = i+1; j < arr9.length; j++) {
				if (arr9[i] > arr9[j]) {
					int temp = arr9[j];
					arr9[j] = arr9[i];
					arr9[i] =temp;
				}
			}
		}
		System.out.println("=====5.출력 결과=====");
		System.out.println(Arrays.toString(arr8));
		System.out.println(Arrays.toString(arr9));

		//6.문제
		
		int Length = arr8.length + arr9.length;
		
		int[] arr10 = new int[Length];
		
		System.arraycopy(arr8, 0, arr10, 0, arr8.length);
		System.arraycopy(arr9, 0, arr10, arr8.length, arr9.length);
		
		System.out.println("=====6.출력 결과=====");
		System.out.println(Arrays.toString(arr10));
	}
}