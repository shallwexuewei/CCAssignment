package ch4.cbc.xuewei.ece.cmu;

public class Solution48 {

	// assume the treeNode has the link to the parent.
	public static TreeNodeWithParent firstCommonAncestor(
			TreeNodeWithParent node1, TreeNodeWithParent node2) {
		if (node1 == node2) {
			return null;
		}

		TreeNodeWithParent ancestor1 = node1;
		while (ancestor1 != null) {
			TreeNodeWithParent ancestor2 = node2;
			while (ancestor2 != ancestor1 && ancestor2 != null) {
				ancestor2 = ancestor2.getParent();
			}
			// the first common ancestor
			if (ancestor2 == ancestor1) {
				return ancestor1;
			}
			ancestor1 = ancestor1.getParent();
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNodeWithParent node1 = new TreeNodeWithParent(1);
		TreeNodeWithParent node2 = new TreeNodeWithParent(2);
		node1.setLeft(node2);
		TreeNodeWithParent node3 = new TreeNodeWithParent(3);
		node1.setRight(node3);
		System.out.println(Solution48.firstCommonAncestor(node1, node2).val);
	}

}
