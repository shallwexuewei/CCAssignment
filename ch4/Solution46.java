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

	/**
	 * @param node
	 *            : given node
	 * @return the left most child of the given node
	 */
	private static TreeNodeWithParent leftMostChild(TreeNodeWithParent node) {
		TreeNodeWithParent result = node;
		// if these if left child, continue to find the left most child
		while (result.getLeft() != null) {
			result = result.getLeft();
		}
		return result;
	}

	public static void main(String[] args) {
		
		// answer should be 3
		TreeNodeWithParent root = new TreeNodeWithParent(1);
		root.setLeft(new TreeNodeWithParent(2));
		root.setRight(new TreeNodeWithParent(3));
		System.out.println(Solution46.successor(root).val);
		
		// answer should be 4
		root.getRight().setLeft(new TreeNodeWithParent(4));
		System.out.println(Solution46.successor(root).val);
		



	}

}
