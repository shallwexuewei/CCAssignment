package ch10.cbc.xuewei.ece.cmu;

public class Solution11 {
	public static void peaksAndValleys(int[] array) {
		int len = array.length;
		for (int i = 1; i < len; i += 2) {
			// find the index of the entry with largest value in the 3 adjacent
			// values.
			int currentIndex = i - 1;
			int minIndex = currentIndex;
			int minValue = array[currentIndex];
			currentIndex++; // i
			if (array[currentIndex] < minValue) {
				minValue = array[currentIndex];
				minIndex = currentIndex;
			}
			currentIndex++; // i+1
			if (currentIndex < len && array[currentIndex] < minValue) {
				minValue = array[currentIndex];
				minIndex = currentIndex;
			}

			// swap the value in ith position and in the maxinum value's index
			if (i != minIndex) {
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums  = {5, 3, 1, 2, 3};
		System.out.println("before:");
		for(int i:nums){
			System.out.print(i);
			System.out.print(' ');
		}
		System.out.println();
		Solution11.peaksAndValleys(nums);
		System.out.println("after:");
		for(int i:nums){
			System.out.print(i);
			System.out.print(' ');
		}
		System.out.println();
	}

}
