package ch4.cbc.xuewei.ece.cmu;

public class Solution410 {

	/**
	 * @param T1
	 *            : a much bigger tree
	 * @param T2
	 *            : a much smaller tree
	 * @return true if T2 is the subtree of T1, else return false
	 */
	public static boolean checkSubtree(TreeNode T1, TreeNode T2) {
		// Assume that a empty tree is a subtree of any tree
		if (T2 == null) {
			return true;
		}
		// use depth first search to solve the problem
		return dfs(T1, T2);
	}

	/**
	 * @param node
	 *            : a node in tree T1
	 * @param T2
	 *            : the root node of T2
	 * @return true if the node is the ancestor of T2
	 */
	private static boolean dfs(TreeNode node, TreeNode T2) {
		// if the bigger tree is empty
		if (node == null) {
			return false;
		}
		// if the values match
		else if (node.val == T2.val) {
			// to check if the two nodes are exactly same node
			if (match(node, T2)) {
				return true;
			}
		}
		boolean result = false;
		// search the left subtree
		if (node.left != null) {
			result = dfs(node.left, T2);
			if (result == true) {
				return true;
			}
		}
		// search the right subtree
		if (node.right != null) {
			result = dfs(node.right, T2);
		}
		return result;
	}

	/**
	 * @param node1
	 *            : the 1st node
	 * @param node2
	 *            : the 2nd node
	 * @return true if they are same node, else return false
	 */
	private static boolean match(TreeNode node1, TreeNode node2) {
		if (node1 == null) {
			if (node2 == null) {
				return true;
			}
			// the bigger tree is empty but subtree is not empty
			else {
				return false;
			}
		}
		// node1 != null while node2 == null
		else if (node2 == null) {
			return false;
		}

		// the values are the same
		if (node1.val == node2.val) {
			// to check whether the subtrees match
			return (match(node1.left, node2.left) && match(node1.right,
					node2.right));
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		// answer: true
		TreeNode middle = new TreeNode(3);
		TreeNode root = new TreeNode(1);
		root.left = middle;
		middle.right = new TreeNode(2);
		System.out.println(Solution410.checkSubtree(root, middle));

		// answer: false
		TreeNode anotherRoot = new TreeNode(6);
		anotherRoot.left = new TreeNode(7);
		System.out.println(Solution410.checkSubtree(root, anotherRoot));
	}

}
