package ch4.cbc.xuewei.ece.cmu;

public class Solution45 {

	/**
	 * @param root
	 *            : a root node of a tree
	 * @return: whether it is a binary search tree
	 * 
	 *          use depth first search to solve the problem
	 * 
	 */
	public static boolean isValidBST(TreeNode root) {
		// a empty tree is a binary search tree
		if (root == null) {
			return true;
		}
		return dfs(root, -1, -1);
	}

	/**
	 * @param node
	 *            : current node
	 * @param low
	 *            : the lowest bound that the value of current node should
	 *            satisfy, exclusively
	 * @param high
	 *            : the lowest bound that the value of current node should
	 *            satisfy, exclusively
	 * @return whether the subtree of current node is a binary search tree
	 */
	private static boolean dfs(TreeNode node, int low, int high) {
		int val = node.val;
		// val should be less than high to satisfy the requirement of BST
		if (high != -1 && val >= high) {
			return false;
		}
		// val should be larger than low to satisfy the requirement of BST
		if (low != -1 && val <= low) {
			return false;
		}

		// if there is left subtree, search it
		if (node.left != null) {
			// current value would be the upper bound of left subtree
			if (!dfs(node.left, low, val)) {
				return false;
			}
		}
		// if there is right subtree, search it
		if (node.right != null) {
			// current value would be the lower bound of right subtree
			if (!dfs(node.right, val, high)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		System.out.println(Solution45.isValidBST(root));
		root.left.left.left = new TreeNode(5);
		System.out.println(Solution45.isValidBST(root));

	}

}
