package ch4.cbc.xuewei.ece.cmu;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution49 {
	/**
	 * @param node
	 *            : given node of binary search tree
	 * @return all possible sequence to produce the binary search tree whose
	 *         root is the given node
	 */
	public static ArrayList<LinkedList<Integer>> BSTSequences(TreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		LinkedList<Integer> prefix = new LinkedList<Integer>();

		// no more nodes to add in
		if (node == null) {
			result.add(prefix);
			return result;
		}

		// as long as the middle node has been added, all smaller values
		// inserted will go to the left subtree of the node, and all larger
		// values inserted will go to the right subtree of the node, so we need
		// to add the middle value (current tree's root) firstly
		prefix.add(node.val);

		// produce all possible sequence from left and right sub trees firstly
		// and then they can be used to weave to larger sequence.
		ArrayList<LinkedList<Integer>> leftSequences = BSTSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSequences = BSTSequences(node.right);

		// weave the sub lists to get larger sequence
		for (LinkedList<Integer> left : leftSequences) {
			for (LinkedList<Integer> right : rightSequences) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, prefix, weaved);
				result.addAll(weaved);
			}
		}
		return result;
	}

	/**
	 * @param left
	 *            : sequence produced by the left subtree
	 * @param right
	 *            : sequence produced by the right subtree
	 * @param prefix
	 *            : prefix of the result lists
	 * @param weavedLists
	 *            : the result -- all possible sequences after combining left
	 *            and right sub sequences
	 */
	public static void weaveLists(LinkedList<Integer> left,
			LinkedList<Integer> right, LinkedList<Integer> prefix,
			ArrayList<LinkedList<Integer>> weavedLists) {
		// If one list is empty, directly add the other list after the prefix
		if (left.size() == 0 || right.size() == 0) {
			LinkedList<Integer> weavedList = new LinkedList<Integer>();
			weavedList.addAll(prefix); // or you can use
			// LinkedList<Integer> weavedList = (LinkedList<Integer>)
			// prefix.clone();
			// but do not use weavedList = prefix, because it will modify
			// "prefix" according to whatever you do on the variable
			// "weavedList"
			weavedList.addAll(left);
			weavedList.addAll(right);
			weavedLists.add(weavedList);
			return;
		}

		// remove the head of the left, and add it to the prefix
		// recursively run the function "weavelists".
		// In this way, we guarantee that all elements in the left
		// subsequence is added in order, but it doesn't matter how
		// the elements of right sub sequence are inserted between them
		int head = left.removeFirst();
		prefix.addLast(head);
		weaveLists(left, right, prefix, weavedLists);
		// Remember to recover left and prefix after weaveList
		prefix.removeLast();
		left.addFirst(head);

		// remove the head of the right, and add it to the prefix
		// recursively run weavelists
		// In this way, we guarantee that all elements in the right
		// subsequence is added in order but it doesn't matter how
		// the elements of left sub sequence are inserted between them
		head = right.removeFirst();
		prefix.addLast(head);
		weaveLists(left, right, prefix, weavedLists);
		// Remember to recover right and prefix after weaveList
		prefix.removeLast();
		right.addFirst(head);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		ArrayList<LinkedList<Integer>> result = Solution49.BSTSequences(root);
		for (LinkedList<Integer> list : result) {
			for (int i : list) {
				System.out.print(i);
				System.out.print(' ');
			}
			System.out.println();
		}
	}

}
