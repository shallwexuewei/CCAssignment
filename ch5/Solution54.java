package ch5.cbc.xuewei.ece.cmu;

public class Solution54 {
	
	public static int[] nextNumber(int positiveInteger) {
		int[] result = new int[2];
		boolean isTail0 = false; // true if the tail bit of the number is 0
		if((positiveInteger & 1) == 0) {
			isTail0 = true;
		}

		int i = positiveInteger;
		int count0 = 0; // the number of tailing 0s
		int count1 = 0; // the number of 1s after rightmost non-trailing zero

		// count the number of tailing 0s
		while (((i & 1) == 0) && (i != 0)) {
			count0++;
			i >>>= 1;
		}

		// count the number of 1s after rightmost non-trailing zero
		while ((i & 1) == 1) {
			count1++;
			i >>>= 1;
		}

		int countTailing1s0s = count0 + count1;
		if (countTailing1s0s == 32 || countTailing1s0s == 0) {
			// in this case there is no bigger number, because all 1s are in the
			// right side of 0s
			result[0] = -1;
		} else {
			// the index of rightmost non-trailing zero
			int indexSpecial0 = count0 + count1;
			// used to flip the rightmost non-traling zero
			int mask = 1 << indexSpecial0;
			i = positiveInteger;
			// flip the rightmost non-traling zero
			i |= mask;
			// clear all bits after the position of the original rightmost
			// non-traling zero
			i &= ~(mask - 1);
			// flip (count1-1) zeros at the tail.
			i |= (1 << (count1 - 1)) - 1; 
			result[0] = i;
		}

		// to calculate the next smallest number
		// from now on,
		// count1 is the number of tailing 1s
		// while count0 is the number of 0s after rightmost non-trailing 1
		if (isTail0) {
			count1 = 0;
			if(count0 == 0) {
				// in this case there is no smaller number, because the number is 0
				result[1] = -1;
				return result;
			}
		} else {
			i = positiveInteger >>> count1;
			if( i == 0) {
				// in this case there is no smaller number, because all 0s are in
				// the right side of 1s
				result[1] = -1;
				return result;
			}
			count0 = 0;
			// count the number of 1s after rightmost non-trailing zero
			while (((i & 1) == 0) && (i != 0)) {
				count0++;
				i >>>= 1;
			}
		}

		// the index of rightmost non-trailing 1
		int indexSpecial1 = count0 + count1;
		i = positiveInteger;
		// clears all bits after rightmost non-trailing 1
		i &= ((~0) << (indexSpecial1 + 1));
		// make a mask with (count1+1) 1s at the tail
		int mask = (1 << (count1 + 1)) - 1;
		i |= mask << (count0 - 1);
		result[1] = i;

		return result;
	}
	
	public static void printResult(int[] result) {
		String[] strs = new String[2];
		if(result[0] == -1) {
			strs[0] = "Error: no larger number!";
		} else {
			strs[0] = Integer.toBinaryString(result[0]);
		}
		if(result[1] == -1) {
			strs[1] = "Error: no smaller number!";
		} else {
			strs[1] = Integer.toBinaryString(result[1]);
		}
		System.out.println("next smallest number: \t" + strs[0]);
		System.out.println("next largest number: \t" + strs[1]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String binaryString = "1110110101110";
		int num = Integer.parseInt(binaryString, 2);
		int[] result = Solution54.nextNumber(num);
		System.out.println("binary number: \t\t" + Integer.toBinaryString(num));
		printResult(result);
		System.out.println("---------------------------------------------------------");
		
		num = 1 << 31;
		result = Solution54.nextNumber(num);
		System.out.println("binary number: \t\t" + Integer.toBinaryString(num));
		printResult(result);
		System.out.println("---------------------------------------------------------");
		
		binaryString = "0000111111111";
		num = Integer.parseInt(binaryString, 2);
		result = Solution54.nextNumber(num);
		System.out.println("binary number: \t\t" + Integer.toBinaryString(num));
		printResult(result);
		System.out.println("---------------------------------------------------------");
		

	}

}
