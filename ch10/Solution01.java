package ch10.cbc.xuewei.ece.cmu;

public class Solution01 {
	/*
	 * sort and merge array1 and array2, and array1 has enough space to hold the
	 * new array len1: the length of array1 len2: the length of array2
	 */
	public static void sortedMerge(int[] array1, int[] array2, int len1,
			int len2) {
		if (len1 == 0) {
			if (len2 != 0) {
				for (int i = 0; i < len2; i++) {
					array1[i] = array2[i];
				}
			}
			return;
		}
		if (len2 == 0) {
			return;
		}

		int i1 = len1 - 1;
		int i2 = len2 - 1;
		while (array1[i1] == -1) {
			i1--;
		}

		int last = array1.length - 1;
		while (i1 > -1 && i2 > -1) {
			if (array1[i1] > array2[i2]) {
				array1[last] = array1[i1];
				i1--;
			} else {
				array1[last] = array2[i2];
				i2--;
			}
			last--;
		}
		while (i2 > -1) {
			array1[last] = array2[i2];
			last--;
			i2--;
		}
	}

	public static void printArray(int[] array, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(array[i]);
			System.out.print(' ');
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] array1 = new int[] { -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] array2 = new int[] { 3, 4, 5, 6, 7, 8, 9, 10 };
		Solution01.sortedMerge(array1, array2, 0, 8);
		Solution01.printArray(array1, array1.length);
		System.out.println("-----------------------------------");

		array1 = new int[] { 1, 2, 11, 12 };
		array2 = new int[] {};
		Solution01.sortedMerge(array1, array2, 4, 0);
		Solution01.printArray(array1, array1.length);
		System.out.println("-----------------------------------");

		array1 = new int[] { 1, 2, 11, 12, -1, -1, -1, -1, -1, -1, -1, -1 };
		array2 = new int[] { 3, 4, 5, 6, 7, 8, 9, 10 };
		Solution01.sortedMerge(array1, array2, 4, 8);
		Solution01.printArray(array1, array1.length);
		System.out.println("-----------------------------------");

		array1 = new int[] { 1, 4, 7, 8, 9, 15, -1, -1, -1, -1, -1, -1 };
		array2 = new int[] { 2, 3, 5, 11, 12, 16 };
		Solution01.sortedMerge(array1, array2, 6, 6);
		Solution01.printArray(array1, array1.length);
	}
}
