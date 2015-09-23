package ch4.cbc.xuewei.ece.cmu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution43 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		dfs(root, 0, result);
		return result;
	}

	private void dfs(TreeNode node, int depth, ArrayList<List<Integer>> result) {
		List<Integer> currentList;
		if (depth >= result.size()) {
			currentList = new LinkedList<Integer>();
			result.add(currentList);
		} else {
			currentList = result.get(depth);
		}
		currentList.add(node.val);
		depth++;
		if (node.left != null) {
			dfs(node.left, depth, result);
		}
		if (node.right != null) {
			dfs(node.right, depth, result);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
