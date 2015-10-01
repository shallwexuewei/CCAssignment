package ch10.cbc.xuewei.ece.cmu;

public class RankTreeNode {
	public int leftSize = 0;
	public RankTreeNode left;
	public RankTreeNode right;
	public int value = 0;

	public RankTreeNode(int i) {
		value = i;
	}

	public void insert(int i) {
		if (i < value) {
			leftSize++;
			if (left == null) {
				left = new RankTreeNode(i);
			} else {
				left.insert(i);
			}
		} else {
			if (right == null) {
				right = new RankTreeNode(i);
			} else {
				right.insert(i);
			}
		}
	}

	public int getRank(int i) {
		if (i == value) {
			return leftSize;
		} else if (i < value) {
			if (left == null) {
				return -1;
			} else {
				return left.getRank(i);
			}
		} else {
			if (right == null) {
				return -1;
			}
			int rightRank = right.getRank(i);
			if (rightRank == -1) {
				return -1;
			} else {
				// i itself should be considered, so there is 1 in the sum
				// formula
				return leftSize + 1 + rightRank;
			}
		}
	}
}
