package ch6.cbc.xuewei.ece.cmu;

import java.util.LinkedList;
import java.util.Random;

public class Solution610 {
	
	public static class Strip {
		private LinkedList<Integer> bottlesTested = new LinkedList<Integer>();
		private boolean positive = false;
		
		public void addTestedbottle(int bottleIndex, boolean isPoisoned) {
			bottlesTested.add(bottleIndex);
			if(isPoisoned) {
				this.positive = isPoisoned;
			}
		}
		
		public boolean isPositive() {
			return positive;
		}
		
	}
	
	/*
	 * the index of bottles in the range [0, 999]
	 */
	public static int findPoisonedBottle(boolean[] bottles, Strip[] strips) {
		
		dropAndTest(bottles, strips);
		
		// after seven days
		return getPoisonedBottleIndex(strips);
	}
	
	public static void dropAndTest(boolean[] bottles, Strip[] strips) {
		for(int i = 0; i < bottles.length; i++) {
//			String binaryString = Integer.toBinaryString(i);
//			int len = binaryString.length();
//			
//			// calculate the number of 0 before the leftmost 1 in 10 bits binary number.
//			int numLeft0 = 10-len;
//			for(int j = 0; j < binaryString.length(); j++) {
//				int indexInTenBits = numLeft0 + j;
//				if(binaryString.charAt(j) == 1) {
//					strips[indexInTenBits].addTestedbottle(i);
//				}
//			}
			
			// compared to the algorithm implemented above, 
			// the following algorithm doesn't use strings.
			// because bit operations are faster than operations on strings,
			// the following implementation would be slightly faster.
			int bitIndex = 0;
			int shiftedbottleIndex = i;
			while(shiftedbottleIndex > 0) {
				if((shiftedbottleIndex & 1) == 1) {
					strips[bitIndex].addTestedbottle(i, bottles[i]);
				}
				bitIndex++;
				// it doesn't matter to use >> or >>> here
				// because there are only 10 bits, much less than 32 bits (the size of integers)
				shiftedbottleIndex >>= 1;
			}
		}
		
	}

	public static int getPoisonedBottleIndex(Strip[] strips) {
		int bottleIndex = 0;
		for (int i = 0; i < strips.length; i++) {
			if (strips[i].isPositive()) {
				bottleIndex |= 1 << i;
			}
		}
		return bottleIndex;
	}

	public static void main(String[] args) {
		boolean[] bottles = new boolean[1000];
		Strip[] strips = new Strip[10];
		for(int i = 0; i < strips.length; i++) {
			strips[i] = new Strip();
		}
		Random random = new Random();
		int poisonBottle = random.nextInt(1000);
		bottles[poisonBottle] = true;

		System.out.println("The answer should be " + poisonBottle);
		System.out.println("The index returned by the program: " + Solution610.findPoisonedBottle(bottles, strips));
		System.out.println("---------------------------------");
		
		poisonBottle = 999; 
		bottles = new boolean[1000];
		for(int i = 0; i < strips.length; i++) {
			strips[i] = new Strip();
		}
		bottles[poisonBottle] = true;

		System.out.println("The answer should be " + poisonBottle);
		System.out.println("The index returned by the program: " + Solution610.findPoisonedBottle(bottles, strips));
		
		/*
		 * There are 10 test strips and 1000 bottles of soda, 
		 * and there is 1 bottle is poisoned.
		 * Noticed that the binary presentation of 1000 is 1111101000 that contains just 10 bits.
		 * So every positive number less or equal to 1000 can be represented by 10 bits binary number.
		 * 
		 * We can index the bottle from 1 to 1000, and calculate their binary representation.
		 * Meanwhile index the test strips from 1 to 10.
		 * For every binary representation, we index the least significant bit to the most significant
		 * bit as 1 to 10.
		 * So for every bottle, we collect the indices of the bits that are 1, assume the indices set as S.
		 * Then for every index i in S, we drop a single drop of that bottle to the test strip that has
		 * the same index i.
		 * 
		 * After 7 days, we can see some strips would be turned positive. 
		 * Then we can write a 10 bits binary number according to the index of positive-turned strips.
		 * For example, if the strips of index 2, 7, 9 are turned positive, that means the bottle with 
		 * binary representation of 0101000010 is poisoned, namely 322th bottle.
		 * So totally we can use only 7 days to find the poisoned bottle.
		 *
		 * 
		 */

	}

}
