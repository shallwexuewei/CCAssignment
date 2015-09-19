package ch1.cbc.xuewei.ece.cmu;

public class Solution14 {
	public static boolean palindromePermutation(String str){
		int len = str.length();

		// every bit in bitVector stands for the number of a character
		int bitVector = 0;
		for(int i = 0; i < len; i++){
			int hashVal = mapCharToNum(str.charAt(i));
			if(hashVal != -1){
				int singleCh = 1 << hashVal;
				if((bitVector & singleCh) == 0){
					bitVector |= singleCh;
				} else {
					bitVector &= ~singleCh;
				}
			}
		}
		
		// if at most one bit is 1, return true
		if((bitVector == 0) || ((bitVector&(bitVector-1)) == 0)){
			return true;
		}
		return false;
	}
	
	/*
	 * Map a character to a integer
	 * input: a character
	 * output: the hash value of the character
	 */
	private static int mapCharToNum(char ch){
		int aNum = Character.getNumericValue('a');
		int zNum = Character.getNumericValue('z');
		int ANum = Character.getNumericValue('A');
		int ZNum = Character.getNumericValue('Z');
		
		int chNum = Character.getNumericValue(ch);
		if(chNum >= aNum && chNum <= zNum) {
			return chNum - aNum;
		} else if (chNum >= ANum && chNum <= ZNum){
			return chNum - ANum;
		}
		return -1;
	}

	public static void main(String[] args) {
		String input = "Tact Coa";
		System.out.println(input+":"+Solution14.palindromePermutation(input));
		input = "Tact Cob";
		System.out.println(input+":"+Solution14.palindromePermutation(input));
		input = "TactCoa";
		System.out.println(input+":"+Solution14.palindromePermutation(input));
		input = "tactcoa";
		System.out.println(input+":"+Solution14.palindromePermutation(input));
		input = "tactcoaa";
		System.out.println(input+":"+Solution14.palindromePermutation(input));

	}

}
