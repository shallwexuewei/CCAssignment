package ch4.cbc.xuewei.ece.cmu;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public static void printTree(TreeNode root) {
		firstOrderTraverse(root);
	}

	private static void firstOrderTraverse(TreeNode node) {
		if (node != null) {
			System.out.print(node.val);
			System.out.print('{');
			firstOrderTraverse(node.left);
			System.out.print(',');
			firstOrderTraverse(node.right);
			System.out.print('}');
		} else {
			System.out.print("null");
		}
	}

	public static void main(String[] args) {
	}

}
