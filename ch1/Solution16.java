package ch1.cbc.xuewei.ece.cmu;

public class Solution16 {

	public static String stringCompression(String str) {
		int len = str.length();
		if (len < 2) {
			return str;
		}

		StringBuilder stringBuilder = new StringBuilder();
		char preChar = str.charAt(0);
		int cnt = 1;
		int i = 1;
		for (i = 1; i < len; i++) {
			if (str.charAt(i) == preChar) {
				cnt++;
			} else {
				stringBuilder.append(preChar);
				stringBuilder.append(cnt);
				cnt = 1;
				preChar = str.charAt(i);
			}
		}
		
		// don't forget to add the last one to stringBuilder!
		if(i != 1){
			stringBuilder.append(preChar);
			stringBuilder.append(cnt);
		}
		
		
		if (stringBuilder.length() < len) {
			return stringBuilder.toString();
		} else {
			return str;
		}
	}

	public static void main(String[] args) {
		String input = "aa";
		System.out.println(input+":"+Solution16.stringCompression(input));
		input = "ab";
		System.out.println(input+":"+Solution16.stringCompression(input));
		input = "aA";
		System.out.println(input+":"+Solution16.stringCompression(input));
		input = "aabcccccaaa";
		System.out.println(input+":"+Solution16.stringCompression(input));
		input = "aAbcdefgg";
		System.out.println(input+":"+Solution16.stringCompression(input));

	}

}
