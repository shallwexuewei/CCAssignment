package ch4.cbc.xuewei.ece.cmu;

public class Solution46 {

	public static TreeNodeWithParent successor(TreeNodeWithParent node) {
		// don't forget this corner case!
		if (node == null) {
			return null;
		}

		if (node.getRight() != null) {
			// should recurse to the left most child instead of the node.right.
			return leftMostChild(node.getRight());
		} else {
			TreeNodeWithParent parent = node.getParent();
			// find the lowest ancestor that is in the left subtree of its
			// parent
			while (parent != null && parent.getLeft() != node) {
				node = parent;
				parent = parent.getParent();
			}
			return parent;
		}
	}

	private static TreeNodeWithParent leftMostChild(TreeNodeWithParent node) {
		TreeNodeWithParent result = node;
		while (result.getLeft() != null) {
			result = result.getLeft();
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
