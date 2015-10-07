package ch6.cbc.xuewei.ece.cmu;

public class Solution62 {

	public static void main(String[] args) {
		/*
		 * Assume the probability of making the hoop is p, 
		 * then the probability of winning Game 1 is p, 
		 * and the probability of winning Game 2 is 
		 * p^3 + 3(1-p)*p^2 = 3p^2-2p^3. 
		 * 
		 * Solve p > 3p^2-2p^3, given p in the range [0, 1]
		 * we get p in the range [0, 0.5)
		 * So when p < 0.5, we should play Game 1, 
		 * when p > 0.5, we should play Game 2, 
		 * when p = 0.5, the probabilities to win Game 1 and to win Game 2 are the same.
		 * 
		 */

	}

}
