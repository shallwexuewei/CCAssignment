package ch10.cbc.xuewei.ece.cmu;

public class Solution08 {
	public static void findDuplicates(int[] nums) {
		int len = nums.length;
		int N = 32000 / 8;
		byte[] bitVector = new byte[N];
		for (int i = 0; i < len; ++i) {
			int index = (nums[i] - 1) / 8;
			int offset = (nums[i] - 1) % 8;
			if ((bitVector[index] & (1 << offset)) == 0) {
				bitVector[index] |= 1 << offset;
			} else { // duplicate found
				System.out.println(nums[i]);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 1, 2, 5 };
		Solution08.findDuplicates(nums);

	}

}
