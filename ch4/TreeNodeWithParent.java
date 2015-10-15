package ch4.cbc.xuewei.ece.cmu;

public class TreeNodeWithParent {
	public int val;
	private TreeNodeWithParent left;
	private TreeNodeWithParent right;
	private TreeNodeWithParent parent;

	public TreeNodeWithParent(int x) {
		this.val = x;
	}

	public TreeNodeWithParent(int x, TreeNodeWithParent parent) {
		this.val = x;
		this.parent = parent;
	}

	public void setLeft(TreeNodeWithParent left) {
		this.left = left;
		left.setParent(this);
	}
	
	public void setRight(TreeNodeWithParent right) {
		this.right = right;
		right.setParent(this);
	}

	public TreeNodeWithParent getParent() {
		return parent;
	}

	public void setParent(TreeNodeWithParent parent) {
		this.parent = parent;
	}

	public TreeNodeWithParent getLeft() {
		return left;
	}

	public TreeNodeWithParent getRight() {
		return right;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
