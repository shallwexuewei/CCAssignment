package ch1.cbc.xuewei.ece.cmu;

public class Solution11 {
	public static boolean isUnique(String str){
		// Guarantee that str is not null
		if(str == null){
			return false;
		}

		// Unicode char ranges from 0x0000 to 0xffff, so the size should be 65536 
		boolean[] existed = new boolean[65536]; 
		int len = str.length();
		if(len > 65536){
			return false;
		}
		for(int i = 0; i < len; i++ ){
			if(existed[str.charAt(i)]) {
				return false;
			} else {
				existed[str.charAt(i)] = true;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		String input = "aa";
		System.out.println(input+":"+Solution11.isUnique(input));
		input = "ab";
		System.out.println(input+":"+Solution11.isUnique(input));
		input = "aA";
		System.out.println(input+":"+Solution11.isUnique(input));
		input = "aAbcdefg";
		System.out.println(input+":"+Solution11.isUnique(input));
		input = "aAbcdefgg";
		System.out.println(input+":"+Solution11.isUnique(input));
	}
}
