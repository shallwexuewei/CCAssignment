package ch5.cbc.xuewei.ece.cmu;

public class Solution56 {

	public static int conversionNumber(int A, int B){
		// the bit of position i is 1 when the bits in the same position in A and B are different.
		int AxorB = A^B;
		
		int cnt = 0;
		while(AxorB != 0) {
			// clear the rightmost 1.
			AxorB &= (AxorB-1);
			cnt++;
		}
		return cnt;
		
	}
	
	public static void main(String[] args) {
		int A = 29;
		int B = 15;
		System.out.println("A:"+A+",B:"+B);
		
		System.out.println(Solution56.conversionNumber(A, B));
		
	}

}
