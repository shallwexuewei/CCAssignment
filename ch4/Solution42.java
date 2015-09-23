package ch4.cbc.xuewei.ece.cmu;

public class Solution42 {
	public TreeNode sortedArrayToBST(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return null;
		return subtree(nums, 0, len - 1);
	}

	private TreeNode subtree(int[] nums, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = subtree(nums, start, mid - 1);
		node.right = subtree(nums, mid + 1, end);
		return node;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
