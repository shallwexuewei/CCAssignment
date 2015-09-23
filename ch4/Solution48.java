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
				ancestor2 = ancestor2.parent;
			}
			if (ancestor2 == ancestor1) {
				return ancestor1;
			}
			ancestor1 = ancestor1.parent;
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
