package ch4.cbc.xuewei.ece.cmu;

public class Solution44 {
	public static boolean checkBalanced(TreeNode root) {
		// assume that a empty tree is balanced
		if (root == null) {
			return true;
		}

		// use depth first search to solve the problem
		if (dfs(root, 0) == -1) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * @param node
	 *            : current node
	 * @param depth
	 *            : current depth
	 * @return: -1 if the subtree of the node is not balanced, else return the
	 *          depth of this subtree whose root is the node
	 */
	private static int dfs(TreeNode node, int depth) {

		int leftDepth = depth;
		if (node.left != null) {
			// to get the depth of the left subtree
			leftDepth = dfs(node.left, depth + 1);
			// if left subtree is not balanced, directly return -1
			if (leftDepth == -1) {
				return -1;
			}
		}

		int rightDepth = depth;
		if (node.right != null) {
			// to get the depth of the right subtree
			rightDepth = dfs(node.right, depth + 1);
			// if right subtree is not balanced, directly return -1
			if (rightDepth == -1) {
				return -1;
			}
		}

		// calculate the difference of two subtrees
		int diff = leftDepth - rightDepth;
		// if the difference cannot satisfy the requirement of balanced tree,
		// return -1
		if (diff < -1 || diff > 1) {
			return -1;
		}
		// else return the larger depth of subtrees
		else {
			return diff > 0 ? leftDepth : rightDepth;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		System.out.println(Solution44.checkBalanced(root));
		root.left.left.left = new TreeNode(5);
		System.out.println(Solution44.checkBalanced(root));

	}

}
