package ch1.cbc.xuewei.ece.cmu;

public class Solution15 {


	public static boolean oneAway(String str1, String str2){
		int len1 = str1.length();
		int len2 = str2.length();
		if(len1 > len2){
			int temp = len1;
			len1 = len2;
			len2 = temp;
			String tempStr = str1;
			str1 = str2;
			str2 = tempStr;
		}
		if(len2 - len1 > 1){
			return false;
		}
		
		boolean equalLen = false;
		if(len1 == len2){
			equalLen = true;
		}
		
		int i = 0;
		int j = 0;
		boolean skiped = false;
		while(i < len1 && j < len2){
			if(str1.charAt(i) == str2.charAt(j)){
				i++;
				j++;
			} else{
				j++;
				// don't forget it's different between equal len and unequal len
				if(equalLen){
					i++;
				}
				if(skiped == true){
					return false;
				} else {
					skiped = true;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {


		String str1 = "pale";
		String str2 = "ple";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution15.oneAway(str1, str2));
		
		str1 = "pales";
		str2 = "pale";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution15.oneAway(str1, str2));

		str1 = "pale";
		str2 = "bale";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution15.oneAway(str1, str2));

		str2 = "bake";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution15.oneAway(str1, str2));

		str1 = "abcdeff";
		str2 = "bagdcef";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution15.oneAway(str1, str2));

		str1 = "abcdefh";
		str2 = "bagdcef";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution15.oneAway(str1, str2));

		str1 = "abcdef";
		str2 = "bagdcef";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution15.oneAway(str1, str2));
	}

}
