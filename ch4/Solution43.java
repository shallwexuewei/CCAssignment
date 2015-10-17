package ch4.cbc.xuewei.ece.cmu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution43 {

	public static List<List<Integer>> getListOfDepth(TreeNode root) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (root == null) {
			// when it's empty, return empty list
			return result;
		}
		
		// use DFS to build the result list
		dfs(root, 0, result);
		return result;
	}

	private static void dfs(TreeNode node, int depth, ArrayList<List<Integer>> result) {
		List<Integer> currentList;
		
		// if it's the fist entry in that depth, we need to creat a new list
		if (depth >= result.size()) {
			currentList = new LinkedList<Integer>();
			result.add(currentList);
		} 
		// else just assign the according list to "currentList"
		else {
			currentList = result.get(depth);
		}
		
		// add value
		currentList.add(node.val);
		
		// search the left subtree and right subtree
		depth++;
		if (node.left != null) {
			dfs(node.left, depth, result);
		}
		if (node.right != null) {
			dfs(node.right, depth, result);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		List<List<Integer>> result = Solution43.getListOfDepth(root);
		for(int i = 0; i < result.size(); i++) {
			for(int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}

}
