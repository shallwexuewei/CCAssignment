package ch6.cbc.xuewei.ece.cmu;

public class Solution64 {
	public static void main(String[] args) {
		/*
		 * Every ant can choose two directions: clockwise and counterclockwise. 
		 * Because their speeds are the same, there is one and only one way to prevent collision:
		 * all ants are going toward the same direction.
		 * As every ant randomly picks a direction, assume it's evenly random, then the probability:
		 * p(clockwise) = p(counterclockwise) = 0.5
		 * Assume the decision of each ant is independent from others, then the probability that 
		 * all 3 ants go toward the same direction is
		 * p(clockwise)^3 + p(counterclockwise)^3 = 0.25
		 * So if they don't move toward the same direction, they collide, the probability is:
		 * p(collision) = 1 - 0.25 = 0.75.
		 * 
		 * The probability of collision with n ants on an n-vertex polygon is calculated similarly.
		 * The probability that n ants go toward the same direction is 
		 * p(clockwise)^n + p(counterclockwise)^n = 0.5^n + 0.5^n = 2*0.5^n = 0.5^(n-1)
		 * So the probability to collide is 
		 * p(collision) = 1 - 0.5^(n-1)
		 */

	}

}
