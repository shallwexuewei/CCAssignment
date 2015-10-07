package ch5.cbc.xuewei.ece.cmu;

public class Solution57 {
	public static int pairwiseSwap(int num){
		int evenPositions = num & 0xaaaaaaaa;
		int oddPositions = num & 0x55555555;
		// be careful not to use >> instead of >>>
		return ((evenPositions >>> 1) | (oddPositions << 1));
	}

	public static void main(String[] args) {
		int n = Integer.parseInt("1011001101010101", 2);
		System.out.println("before:\t" + Integer.toBinaryString(n));
		System.out.println("after:\t" + Integer.toBinaryString(Solution57.pairwiseSwap(n)));

	}

}
