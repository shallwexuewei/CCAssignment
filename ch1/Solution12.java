package ch1.cbc.xuewei.ece.cmu;

public class Solution12 {
	public static boolean checkPermuataion(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		if (len1 != len2) {
			return false;
		}

		// the variable cnts is used to count the frequency of one character in
		// str1 and then decrease every time met in str2.
		// Unicode char ranges from 0x0000 to 0xffff, so the size should be
		// 65536
		int[] cnts = new int[65536];

		for (int i = 0; i < len1; i++) {
			cnts[str1.charAt(i)]++;
		}
		for (int i = 0; i < len2; i++) {
			if (cnts[str2.charAt(i)] > 0) {
				cnts[str2.charAt(i)]--;
			} else {
				// this branch means that the number of this char in str2
				// is more than the number in str1
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "a";
		String str2 = "b";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution12.checkPermuataion(str1, str2));
		str2 = "a";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution12.checkPermuataion(str1, str2));

		str1 = "ab";
		str2 = "ba";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution12.checkPermuataion(str1, str2));

		str1 = "abcdefg";
		str2 = "bagdcef";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution12.checkPermuataion(str1, str2));

		str1 = "abcdeff";
		str2 = "bagdcef";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution12.checkPermuataion(str1, str2));

		str1 = "abcdefh";
		str2 = "bagdcef";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution12.checkPermuataion(str1, str2));

		str1 = "abcdef";
		str2 = "bagdcef";
		System.out.println(str1 + "," + str2 + ":"
				+ Solution12.checkPermuataion(str1, str2));

	}

}
