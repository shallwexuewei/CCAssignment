package ch4.cbc.xuewei.ece.cmu;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution49 {
	// It's too complex, I have to code on the reference answer to finish it
	// in time. Though I have understood the thoughts, it's still too complex to
	// implement correctly in short time.
	ArrayList<LinkedList<Integer>> BSTSequences(TreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		LinkedList<Integer> prefix = new LinkedList<Integer>();

		if (node == null) {
			result.add(prefix);
			return result;
		}

		prefix.add(node.val);

		ArrayList<LinkedList<Integer>> leftSequences = BSTSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSequences = BSTSequences(node.right);

		// weave
		for (LinkedList<Integer> left : leftSequences) {
			for (LinkedList<Integer> right : rightSequences) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}

	void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		// one list is empty. Add remainder to [a cloned] prefix and store
		// result.
		if (first.size() == 0 || second.size() == 0) {
			// Note that here clone() is used to hard copy
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}

		// Remember to recover first and prefix after weaveList
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);

		// Remember to recover second and prefix after weaveList
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
