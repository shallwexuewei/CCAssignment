package ch5.cbc.xuewei.ece.cmu;

public class Solution55 {

	public static void main(String[] args) {
		/*
		 * Explain what (n & (n-1) ) == 0 does:
		 * n-1 is to set the rightmost 1 to 0 and all 0s in the right side of that 1 would become 1s
		 * so actually (n & (n-1)) is going to clear the rightmost 1 of the number n to 0.
		 * if after the rightmost 1 is cleared, n becomes 0, that means only one 1 in the binary representation of n
		 * or n is 0. In other words, it can also be used to check whether the number is the power of 2.
		 */
	}

}
