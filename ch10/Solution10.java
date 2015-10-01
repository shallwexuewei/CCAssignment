package ch10.cbc.xuewei.ece.cmu;

public class Solution10 {
	public static RankTreeNode track(RankTreeNode root, int number) {
		if (root == null) {
			root = new RankTreeNode(number);
		} else {
			root.insert(number);
		}
		return root;
	}

	public static int getRankOfNumber(RankTreeNode root, int number) {
		return root.getRank(number);
	}

	public static void main(String[] args) {
		int[] a = { 5, 1, 4, 4, 5, 9, 7, 13, 3 };
		RankTreeNode root = null;
		for (int i : a) {
			root = Solution10.track(root, i);
		}
		System.out.println(Solution10.getRankOfNumber(root, 1)); // output: 0
		System.out.println(Solution10.getRankOfNumber(root, 3)); // output: 1
		System.out.println(Solution10.getRankOfNumber(root, 4)); // output: 2 or
																	// 3 are
																	// both ok
	}
}
