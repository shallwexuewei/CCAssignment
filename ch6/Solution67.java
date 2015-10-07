package ch6.cbc.xuewei.ece.cmu;

import java.util.Random;

public class Solution67 {

	public static double apocalypse(int nFamilies) {
		int nBoys = 0;
		int nGirls = nFamilies;
		for (int i = 0; i < nFamilies; i++) {
			nBoys += getSonsNumber();
		}
		return nGirls / (double) (nBoys + nGirls);
	}

	public static int getSonsNumber() {
		Random random = new Random();
		int nSons = 0;
		boolean isGirl = random.nextBoolean();
		// keep giving birth until having a daughter
		while (!isGirl) {
			nSons++;
			isGirl = random.nextBoolean();
		}
		return nSons;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int n = 500000*(i+1);
			System.out.println(n + ":" + Solution67.apocalypse(n));
		}

		/*
		 * Assume that any family would give birth until having a daughter, and
		 * they will stop giving birth right after having one daughter. Given G
		 * as girls and B as boys, then the sequences of the giving birth would
		 * be: G, BG, BBG, BBBG, ..., (n Bs)G The probability of the every entry
		 * in the above sequences are: 1/2, 1/4, 1/8, 1/16, ... (1/2^n) So
		 * multiply the number of boys and the related probability and we get
		 * the average boys' number of every family:
		 * sum((i-1)/2^i), 
		 * given i being the index of the above sequences, and the indices begin from 1.
		 * And because every family has a daughter, the average girls' number is 1.
		 * Therefore, the gender ratio should be sum((i-1)/2^i)
		 * 
		 */
	}

}
