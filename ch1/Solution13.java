package ch1.cbc.xuewei.ece.cmu;

public class Solution13 {

	public static void urlify(char[] chars, int trueLen) {
		int spaceNum = 0;
		for (int i = 0; i < trueLen; i++) {
			if (chars[i] == ' ') {
				spaceNum++;
			}
		}

		// the variable "end" updates the index of the end of the new array that
		// haven't been updated
		int end = trueLen + spaceNum*3 - 1;
		for (int i = trueLen - 1; i > -1; i--) {
			if (chars[i] == ' ') {
				chars[end] = '0';
				end--;
				chars[end] = '2';
				end--;
				chars[end] = '%';
			} else if (end != i) {
				chars[end] = chars[i];
			}
			end--;
		}
	}

	public static void main(String[] args) {
		String str = "Mr John Smith         ";
		char[] chars = str.toCharArray();
		Solution13.urlify(chars, 13);
		System.out.println(new String(chars));
	}

}
