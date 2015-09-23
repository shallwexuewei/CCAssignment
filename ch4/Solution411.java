package ch4.cbc.xuewei.ece.cmu;

import java.util.ArrayList;
import java.util.Random;

public class Solution411 {
	public static TreeNode randomNode(TreeNode root){
		if(root == null) {
			return null;
		}
		ArrayList<TreeNode> nodeArrayList = new ArrayList<TreeNode>();
		inorderTravesal(root, nodeArrayList);
		
		int size = nodeArrayList.size();
		
		Random random  = new Random();
		int i = random.nextInt(size);
		return nodeArrayList.get(i);
	}
	
	private static void inorderTravesal(TreeNode node, ArrayList<TreeNode> nodeArrayList){
		nodeArrayList.add(node);
		if(node.left != null){
			inorderTravesal(node.left, nodeArrayList);
		}
		if(node.right != null){
			inorderTravesal(node.right, nodeArrayList);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
