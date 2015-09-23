package ch4.cbc.xuewei.ece.cmu;

public class Solution412 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.right == null && root.left == null) {
			if (sum == root.val)
				return true;
			else
				return false;
		}
		return dfs(root, root.val, sum);
	}

	public boolean dfs(TreeNode node, int patialSum, int sum) {
		if (node.left != null) {
			if (node.left.left == null && node.left.right == null) {
				if (patialSum + node.left.val == sum)
					return true;
			} else {
				if (dfs(node.left, patialSum + node.left.val, sum))
					return true;
			}
		}
		if (node.right != null) {
			if (node.right.left == null && node.right.right == null) {
				if (patialSum + node.right.val == sum)
					return true;
			} else {
				if (dfs(node.right, patialSum + node.right.val, sum))
					return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
