package ch6.cbc.xuewei.ece.cmu;

public class Solution69 {

	public static void main(String[] args) {
		/*
		 * The person toggle (open the locker if it's closed, or close the locker) 
		 * every ith locker in the ith iteration, given i in the range [1, 100]
		 * 
		 * So in ith iteration, the indices of the locker that are toggles are the 
		 * multiple of i.
		 * 
		 * Therefore, if after 100 iterations, the locker is open, it means that
		 * the index of the locker has odd number of factors. 
		 * 
		 * For every number A, if there is a factor a < sqrt(A), then there is 
		 * a compliment b = A/a and b > sqrt(A). So there are always even number
		 * of factors except that A has one factor of sqrt(A). 
		 * 
		 * So given index 1 to 100, there are 10 numbers satisfy the condition:
		 * 1 = 1*1, 4 = 2*2, 9 = 3*3, ..., 100 = 10*10
		 * 
		 * So finally there are 10 lockers open.
		 */

	}

}
