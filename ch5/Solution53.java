package ch5.cbc.xuewei.ece.cmu;

import java.util.LinkedList;

public class Solution53 {

	
	public static int flipBitToWin(int num){
		// use two arrays to store the number of continuous 1s and 0s
		LinkedList<Integer> oneNums = new LinkedList<Integer>(); 
		LinkedList<Integer> zeroNums = new LinkedList<Integer>(); 
		
		// the flag to 
		boolean oneFound = false;
		
		// use cnt to store the number of current continuous 1s or 0s
		int cnt = 0;
		
		// use pre0 to store whether the previous value is 0.
		boolean pre0 = true;

		// there are 32 bits in an integer
		for(int i = 0; i < 32; i++){
			// set all bits 0 except the last one;
			int oneBit = num&1;
			if(oneBit == 0){
				// only begin the real content when come across the first 1
				if(oneFound){
					if(pre0) {
						cnt++;
					} else {
						pre0 = true;
						oneNums.add(cnt);
						cnt = 1;
					}
				} 
			} else {
				// to symbolize whether the first 1 is found
				if(!oneFound) {
					oneFound = true;
					pre0 = false;
				}
				if(pre0){
					pre0 = false;
					zeroNums.add(cnt);
					cnt = 1;
				} else {
					cnt++;
				}
			}
			// be careful not to use >>, because logical shift is required
			num >>>= 1;
		}
		
		// if the last bits are 0s, discard the number, because it is useless
		// we only need the numbers of 0s who are between 1s
		// by doing this, we make sure the length of oneNums is one larger than the length of zeroNums
		if(pre0){
			zeroNums.removeLast();
		}
		
		// the minimum value of max is 1, because we flip one 0 to 1, so at least 1
		int max = 1;
		for(int i = 0; i < zeroNums.size(); i++){
			if(zeroNums.get(i) == 1) {
				// it's sure that the length of oneNums is one larger than the length of zeroNums
				// so i+1 will not case outOfBound exception
				int currentLen = oneNums.get(i) + oneNums.get(i+1) + 1;
				if( currentLen > max){
					max = currentLen;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int n = 1775;
		System.out.println(Integer.toBinaryString(n) + ":" + Solution53.flipBitToWin(n));
	}

}
