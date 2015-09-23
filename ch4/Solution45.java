package ch4.cbc.xuewei.ece.cmu;

public class Solution45 {

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return dfs(root, -1, -1);
	}

	private boolean dfs(TreeNode node, int low, int high) {
		int val = node.val;
		if (high != -1 && val >= high) {
			return false;
		}
		if (low != -1 && val <= low) {
			return false;
		}
		if (node.left != null) {
			if (!dfs(node.left, low, val))
				return false;
		}
		if (node.right != null && !dfs(node.right, val, high)) {
			return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
