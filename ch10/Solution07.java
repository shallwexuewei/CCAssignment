package ch10.cbc.xuewei.ece.cmu;

public class Solution07 {
	/*
	 * parameter: the array return: the missing integer or if not found, return
	 * -1
	 */
	public static int MissingInt(int[] nums) {
		// only non-negative integer, so the size should be:
		long size = (long) Integer.MAX_VALUE + 1;
		byte[] bitField = new byte[(int) size / 8];

		for (int i = 0; i < nums.length; ++i)
			bitField[nums[i] / 8] |= 1 << (nums[i] % 8);

		for (int i = 0; i < bitField.length; ++i) {
			for (int j = 0; j < 8; ++j) {
				int bit = nums[i] & (1 << j);
				if (bit == 0)
					return i * 8 + j;
			}
		}
		// if no non-negative integer found is missing, return -1
		return -1;
	}

	public static void main(String[] args) {
		/*
		 * follow up: if we have only 10MB memory, we could be divide the data
		 * into partitions whose memory cost is less than 10MB. And then read
		 * data in the memory, to count the number of the numbers in each
		 * smaller ranges, like 0-2000. If the count is not consistent with the
		 * size of the range, we can be sure the number is in that range. 
		 * And then we can use the above solution to find the number.
		 */
	}

}
