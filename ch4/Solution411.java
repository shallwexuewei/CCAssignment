package ch4.cbc.xuewei.ece.cmu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution411 {

	/**
	 * Develop a binary search tree with the function to get random node, in
	 * addition to insert, find, and delete
	 */
	public static class RandomTree {

		private RandomTreeNode root = null;

		/**
		 * The class of the tree node
		 */
		public static class RandomTreeNode {
			public int size;
			public RandomTreeNode left;
			public RandomTreeNode right;
			public int val;

			public RandomTreeNode(int val) {
				this.val = val;
				size = 1;
			}

			/**
			 * @return size of the tree given "this" as root
			 */
			public int getSize() {
				return size;
			}

		}

		/**
		 * @return random node
		 */
		public RandomTreeNode getRandomNode() {
			// if empty tree
			if (root == null) {
				return null;
			}

			Random random = new Random();
			int i = random.nextInt(getSize());
			return getIthNode(i);
		}

		/**
		 * @param i
		 *            : the index of the node that should be returned
		 * @return the node of index i
		 */
		private RandomTreeNode getIthNode(int i) {
			return getIthNode(root, i);
		}

		/**
		 * @param node
		 *            : current node in the traversal
		 * @param i
		 *            : the index of the node that should be returned
		 * @return the node of index i in the subtree given root of current node
		 */
		private RandomTreeNode getIthNode(RandomTreeNode node, int i) {
			int leftSize = 0;
			if (node.left != null) {
				leftSize = node.left.size;
			}

			// in the left subtree
			if (i < leftSize) {
				return getIthNode(node.left, i);
			}
			// exactly current node
			else if (i == leftSize) {
				return node;
			}
			// in the right sub tree
			else {
				// subtract the size of left sub tree and current node
				i -= leftSize + 1;
				return getIthNode(node.right, i);
			}
		}

		/**
		 * @param val
		 *            : the inserted value
		 * @TimeComplexity: O(k) where k is the depth of the tree
		 */
		public void insert(int val) {
			if (root == null) {
				root = new RandomTreeNode(val);
			} else {
				insert(root, val);
			}
		}

		/**
		 * @param node
		 *            : current root of the subtree
		 * @param val
		 *            : the value needed to be inserted in the subtree
		 */
		private void insert(RandomTreeNode node, int val) {

			int nodeVal = node.val;
			// update the size of every ancestor nodes
			node.size++;
			// the new node should be in the left subtree
			if (val < nodeVal) {
				// the insert position found
				if (node.left == null) {
					node.left = new RandomTreeNode(val);
				} else {
					insert(node.left, val);
				}
			}
			// the new node should be in the right subtree
			else {
				// the insert position found
				if (node.right == null) {
					node.right = new RandomTreeNode(val);
				} else {
					insert(node.right, val);
				}
			}
		}

		/**
		 * @param val
		 *            : the node needs to be found
		 * @return true if the node is found, else return false
		 * @TimeComplexity: O(k) where k is the depth of the tree
		 */
		public RandomTreeNode find(int val) {
			return find(root, val);
		}

		/**
		 * @param node
		 *            : current root of the subtree
		 * @param val
		 *            : the value needed to be found in the subtree
		 */
		private RandomTreeNode find(RandomTreeNode node, int val) {
			if (node == null) {
				return null;
			}

			// found
			if (node.val == val) {
				return node;
			}
			// search left subtree
			else if (node.val > val) {
				return find(node.left, val);
			}
			// search right subtree
			else {
				return find(node.right, val);
			}
		}

		/**
		 * @param val
		 *            : the value needs to be deleted
		 */
		public void delete(int val) {
			// update the root
			root = delete(root, val);
		}

		/**
		 * @param node
		 *            : given node
		 * @return the offspring that has the minimum number in the subtree of
		 *         the node
		 * 
		 *         it is for deletion implement
		 */
		public RandomTreeNode getMin(RandomTreeNode node) {
			// the node is found if current node has no left subtree
			if (node.left == null) {
				return node;
			}
			// else continue searching
			else {
				return getMin(node);
			}
		}

		/**
		 * @param node
		 *            : current node
		 * @return updated node after deleting the minimum
		 * 
		 * @motivation it is for deletion implement
		 * 
		 */
		private RandomTreeNode deleteMin(RandomTreeNode node) {
			if (node.left == null) {
				return node.right;
			}

			// go left until finding a node with a null left link
			// and replacing that node by its right link
			node.left = deleteMin(node.left);

			// update the size of each influenced node
			node.size = 1 + node.left.size + node.right.size;
			return node;
		}

		private RandomTreeNode delete(RandomTreeNode node, int val) {
			if (node == null) {
				return null;
			}

			// it's in the left subtree
			if (val < node.val) {
				// update the left subtree
				node.left = delete(node.left, val);
			}
			// it's in the right subtree
			else if (val > node.val) {
				// update the right subtree
				node.right = delete(node.right, val);
			}
			// when the node is the target!
			else {
				// no right child, just let left child replace current node.
				if (node.right == null) {
					return node.left;
				}
				// no left child, just let right child replace current node.
				if (node.left == null) {
					return node.right;
				}

				// replace with successor
				RandomTreeNode temp = node;
				// let the minimum offspring of right subtree replace deleted
				// node
				node = getMin(temp.right);
				// assigned the updated right subtree to the "right" of new
				// current node, it's a recusive process.
				node.right = deleteMin(temp.right);
				// update left subtree
				node.left = temp.left;
			}

			// update size
			node.size = 1;
			if(node.left != null) {
				node.size += node.left.size;
			}
			if(node.right != null) {
				node.size += node.right.size;
			}
			return node;
		}

		/**
		 * @return the size of the tree
		 */
		public int getSize() {
			if (root == null) {
				return 0;
			} else {
				return root.size;
			}
		}

		public void printTree() {
			System.out.println("The tree is: ");
			firstOrderTraverse(root);
			System.out.println();
		}

		private void firstOrderTraverse(RandomTreeNode node) {
			if (node != null) {
				System.out.print(node.val);
				System.out.print('{');
				firstOrderTraverse(node.left);
				System.out.print(',');
				firstOrderTraverse(node.right);
				System.out.print('}');
			} else {
				System.out.print("null");
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandomTree tree = new RandomTree();
		tree.insert(0);
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.printTree();
		System.out.println();

		System.out.println("Test (10 cases):");
		for (int i = 0; i < 10; i++) {
			System.out.println(tree.getRandomNode().val);
		}
		

		System.out.println();
		System.out.println("-------------------------");
		System.out.println("after delete 4:");
		tree.delete(4);
		tree.printTree();
		System.out.println();

		System.out.println("Test (10 cases):");
		for (int i = 0; i < 10; i++) {
			System.out.println(tree.getRandomNode().val);
		}
	}

}
