package ch4.cbc.xuewei.ece.cmu;

public class Solution48 {

	/**
	 * @param node1
	 *            : the 1st node
	 * @param node2
	 *            : the 2nd node
	 * @return the first common ancestor of the two nodes.
	 */
	public static TreeNodeWithParent firstCommonAncestor(
			TreeNodeWithParent node1, TreeNodeWithParent node2) {
		// if the two nodes is the same node, return null
		if (node1 == node2) {
			return null;
		}

		TreeNodeWithParent ancestor1 = node1;
		while (ancestor1 != null) {
			TreeNodeWithParent ancestor2 = node2;
			TreeNodeWithParent commonAncestor = null;
			
			// for ever level of ancestor of the 1st node, 
			// to check whether any level of ancestor of 2nd node is the same node with it.
			while (ancestor2 != null) {
				// found
				if(ancestor2 == ancestor1) {
					commonAncestor = ancestor1;
					break;
				}
				
				ancestor2 = ancestor2.getParent();
			}
			// the first common ancestor
			if (commonAncestor != null) {
				return commonAncestor;
			}
			ancestor1 = ancestor1.getParent();
		}
		return null;
	}

	public static void main(String[] args) {
		/*
		 * If there is no links to the parents, 
		 * then we need to 
		 * 1. check firstly whether the two nodes have the same root
		 * 2. after the 1st step, we can have the root node
		 * 3. from the root node, travel down. At every level, check 
		 * whether the two nodes are in the same subtree (same side):
		 * if yes, continue traveling down
		 * else, return current node
		 * 
		 */
		
		// answer : 1
		TreeNodeWithParent node1 = new TreeNodeWithParent(1);
		TreeNodeWithParent node2 = new TreeNodeWithParent(2);
		node1.setLeft(node2);
		TreeNodeWithParent node3 = new TreeNodeWithParent(3);
		node1.setRight(node3);
		System.out.println(Solution48.firstCommonAncestor(node1, node2).val);
		
		// answer : 2
		TreeNodeWithParent node4 = new TreeNodeWithParent(4);
		node2.setLeft(node4);
		System.out.println(Solution48.firstCommonAncestor(node4, node2).val);
	}

}
