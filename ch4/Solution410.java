package ch4.cbc.xuewei.ece.cmu;

public class Solution410 {

	public static boolean checkSubtree(TreeNode T1, TreeNode T2){
		if(T2 == null)
			return true;
		return dfs(T1, T2);		
	}
	
	private static boolean dfs(TreeNode node, TreeNode T2){
		if(node == null) {
			return false;
		} else if(node.val == T2.val) {
			if(match(node, T2)){
				return true;
			}
		}
		boolean result = false;
		if(node.left != null){
			result = dfs(node.left, T2);
		}
		if(result == true) {
			return true;
		}
		if(node.right != null){
			result = dfs(node.right, T2);
		}
		return result;
	}
	
	private static boolean match(TreeNode node1, TreeNode node2){
		if(node1 == null){
			if(node2 == null) 
				return true;
			else
				return false;
		}
		else if(node2 == null){
			return false;
		}
		boolean result = false;
		if(node1.left != null) {
			if(node2.left == null){
				return false;
			} else {
				if(!match(node1.left, node2.left))
					return false;
			}
		} else if(node2.left != null) {
			return false;
		}
		if(node1.right != null){
			if(node2.right == null){
				return false;
			} else if(!match(node1.right, node2.right)) {
				return false;
			}
		} else if (node2.right != null) {
			return false;
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
