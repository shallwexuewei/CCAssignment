package ch5.cbc.xuewei.ece.cmu;

public class Solution51 {
	
	public static int insertion(int N, int M, int i, int j){
		// note that starts from j and ends at i, don't reverse them
		
		// make a number whose 0th to (j-1)th positions are all 1s
		int left1 = (~0) << (j+1);
		
		// make a number whose (i+1)th postion to the last position are all 1s
		int right1 = (1 << i) - 1;
		
		// make the mask whose jth to ith positions all all 0, while the rest are 0s
		int mask = left1 | right1;
		
		// clear N from jth to ith positions
		N &= mask;
		
		// shift M so that it will be in the proper position to merge
		M <<= i;
		
		// merge and return the result
		return N|M;
	}

	public static void main(String[] args) {
		int N = Integer.parseInt("10000000000", 2);
		int M = Integer.parseInt("10011", 2);
		int i = 2;
		int j = 6;
		System.out.println("M = 10000000000, N = 10011, i = 2, j = 6. The result should be 10001001100:");
		System.out.println(Integer.toBinaryString(Solution51.insertion(N, M, i, j)));
	}

}
