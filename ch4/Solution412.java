package ch4.cbc.xuewei.ece.cmu;

import java.util.HashMap;

public class Solution412 {
	/*
	 * Because the path does not need to start or end at the root or a leaf, so
	 * we need to traverse all possible middle paths. If we use brute force
	 * method, calculate the sums from every node to any child of it, the worst
	 * time complexity can be O(N^2), given N as the number of nodes. However,
	 * when we traverse one node to its leaf, we have calculated the partial sum
	 * in the traversal process, we could store the partial sums, and reuse them
	 * in the calculation of any possible path. In this way, we can reduce the
	 * running time from O(N^2) to O(N) !
	 */
	public static int countPathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;

		// the map store the partial sum of any ancestor of current node.
		HashMap<Integer, Integer> partialSum2cnt = new HashMap<Integer, Integer>();
		// assume there is a virtual node above the root, and add the partial
		// sum
		// of that node in the hash map partialSum2cnt. It's useful if the
		// target
		// path starts from the root.
		updatePatialSum2cnt(partialSum2cnt, 0, 1);
		return dfs(root, 0, sum, partialSum2cnt);
	}

	public static int dfs(TreeNode node, int partialSum, int sum,
			HashMap<Integer, Integer> partialSum2cnt) {
		if (node == null) {
			return 0;
		}

		partialSum += node.val;
		// cnt store the number of all eligible paths that ends at current
		// nodes.
		int cnt = 0;

		// by calculating complementSum, we can use it to retrieve the number of
		// of eligible nodes. Assume any eligible node that has the partial sum
		// of complementSum from the root node as C.
		// The path from C.child to current node has the target sum.
		int complementSum = partialSum - sum;
		if (partialSum2cnt.containsKey(complementSum)) {
			cnt += partialSum2cnt.get(complementSum);
		}

		// add current node's partial sum to the hash map partialSum2cnt
		updatePatialSum2cnt(partialSum2cnt, partialSum, 1);

		// depth first search the children nodes, and accumulate their results
		cnt += dfs(node.left, partialSum, sum, partialSum2cnt);
		cnt += dfs(node.right, partialSum, sum, partialSum2cnt);

		// remove current node's partial sum so as not to influence 
		// the nodes that are not current node's offspring.
		updatePatialSum2cnt(partialSum2cnt, partialSum, -1);
		return cnt;
	}

	public static void updatePatialSum2cnt(
			HashMap<Integer, Integer> partialSum2cnt, int sum, int delta) {
		if (!partialSum2cnt.containsKey(sum)) {
			partialSum2cnt.put(sum, delta);
		} else {
			partialSum2cnt.put(sum, partialSum2cnt.get(sum) + delta);
		}
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		System.out.println(Solution412.countPathSum(root1, 1));

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right = new TreeNode(1);
		root.left.right.right = new TreeNode(2);
		root.right = new TreeNode(-3);
		root.right.right = new TreeNode(11);
		System.out.println(Solution412.countPathSum(root, 8));
	}

}
