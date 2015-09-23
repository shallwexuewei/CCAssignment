package ch4.cbc.xuewei.ece.cmu;

public class Solution44 {
	public boolean isBalanced(TreeNode root) {
		// assume that a empty tree is balanced
		if (root == null) {
			return true;
		}
		if (dfs(root, 0) == -1) {
			return false;
		} else {
			return true;
		}

	}

	// return -1 if the subtree of the node is not balanced
	// or return the depth of this subtree whose root is the node
	private int dfs(TreeNode node, int depth) {
		int leftDepth = depth;
		if (node.left != null) {
			leftDepth = dfs(node.left, depth + 1);
		}
		if (leftDepth == -1) {
			return -1;
		}

		int rightDepth = depth;
		if (node.right != null) {
			rightDepth = dfs(node.right, depth + 1);
		}
		if (rightDepth == -1) {
			return -1;
		}

		int diff = leftDepth - rightDepth;
		if (diff < -1 || diff > 1) {
			return -1;
		} else if (diff > 0) {
			return leftDepth;
		} else {
			return rightDepth;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
