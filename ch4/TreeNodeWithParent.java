package ch4.cbc.xuewei.ece.cmu;

public class TreeNodeWithParent {
	public int val;
	public TreeNodeWithParent left;
	public TreeNodeWithParent right;
	public TreeNodeWithParent parent;

	public TreeNodeWithParent(int x) {
		this.val = x;
	}

	public TreeNodeWithParent(int x, TreeNodeWithParent parent) {
		this.val = x;
		this.parent = parent;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
