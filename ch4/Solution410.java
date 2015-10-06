package ch4.cbc.xuewei.ece.cmu;

public class Solution410 {

	public static boolean checkSubtree(TreeNode T1, TreeNode T2) {
		// Assume that a empty tree is a subtree of any tree
		if (T2 == null)
			return true;
		return dfs(T1, T2);
	}

	private static boolean dfs(TreeNode node, TreeNode T2) {
		if (node == null) {
			// The bigger tree is empty
			return false;
		} else if (node.val == T2.val) {
			if (match(node, T2)) {
				return true;
			}
		}
		boolean result = false;
		if (node.left != null) {
			result = dfs(node.left, T2);
		}
		if (result == true) {
			return true;
		}
		if (node.right != null) {
			result = dfs(node.right, T2);
		}
		return result;
	}

	private static boolean match(TreeNode node1, TreeNode node2) {
		if (node1 == null) {
			if (node2 == null) {
				return true;
			} else {
				// the bigger tree is empty but subtree is not empty
				return false;
			}
		} else if (node2 == null) {
			// node1 != null while node2 == null
			return false;
		}

		if (node1.val == node2.val) {
			return (match(node1.left, node2.left) && match(node1.right,
					node2.right));
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		TreeNode middle = new TreeNode(3);
		TreeNode root = new TreeNode(1);
		root.left = middle;
		middle.right = new TreeNode(2);
		System.out.println(Solution410.checkSubtree(root, middle));
		
		TreeNode anotherRoot = new TreeNode(6);
		anotherRoot.left = new TreeNode(7);
		System.out.println(Solution410.checkSubtree(root, anotherRoot));
	}

}
