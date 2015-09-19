package ch1.cbc.xuewei.ece.cmu;

public class Solution19 {
	public static boolean stringRotation(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 != len2){
			return false;
		}
		
		// assume two empty strings are rotation of each other. 
		if(len1 == 0) {
			return true;
		}
		
		
		String s1s1 = s1+s1;
		return Solution19.isSubstring(s1s1, s2);
	}

	private static boolean isSubstring(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 == len2){
			return s1.equals(s2);
		}
		// make sure that s1 is shorter than s2
		else if (len1 > len2){
			int temp = len1;
			len1 = len2;
			len2 = temp;
			String tempStr  = s1;
			s1 = s2;
			s2 = tempStr;
		}
		return (s2.indexOf(s1) != -1);
	}

	public static void main(String[] args) {
		// Test cases:
		// 2 empty string
		// 2 strings with different length
		// 2 strings with the same length but not rotation of each other
		// 2 strings that are rotation of each other.
		String str1 = "abcdef";
		String str2 = "bagdcef";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution19.stringRotation(str1, str2));
		

		str1 = "waterbottle";
		str2 = "erbottlewat";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution19.stringRotation(str1, str2));
	}

}
