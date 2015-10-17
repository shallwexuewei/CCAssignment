package ch4.cbc.xuewei.ece.cmu;

public class Solution42 {
	public static TreeNode minimalTree(int[] nums) {
		int len = nums.length; 
		if (len == 0) {
			return null;
		}
		// use recursion to build the tree
		return subtree(nums, 0, len - 1);
	}

	private static TreeNode subtree(int[] nums, int start, int end) {
		if (start > end) {
			// when it's leaves' children
			return null;
		}
		
		int mid = (start + end) / 2;
		// use the middle point in the array to build the root of the subtree
		TreeNode node = new TreeNode(nums[mid]);
		// use recursion to build the left and right subtree
		node.left = subtree(nums, start, mid - 1);
		node.right = subtree(nums, mid + 1, end);
		return node;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		TreeNode root = Solution42.minimalTree(nums);
		TreeNode.printTree(root);
	}

}
