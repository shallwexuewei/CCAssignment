package ch2.cbc.xuewei.ece.cmu;

import java.util.HashSet;

public class Solution21 {

	public static void removeDups(ListNode root){
		HashSet<Integer> hashSet = new HashSet<Integer>();
		ListNode pre = null;
		ListNode current = root;
		while(current != null){
			// the next line should use current.getValue() instead of current!
			if(hashSet.contains(current.getValue())){
				pre.setNext(current.getNext());
			} else {
				hashSet.add(current.getValue());
				pre = current;
			}
			current = current.getNext();
		}
	}
	
	public static void main(String[] args) {
		
		/*
		 * FOLLOW UP:
		 * If a temporary buffer is not allowed, we can use two pointers, 
		 * one points to the current list node, and the other traverse all nodes after it. 
		 * If any node is duplicate of current node, delete it. 
		 * Though it costs O(1) space, compared to O(N) running time of the above algorithm, 
		 * it costs O(N^2) running time, given N as the length of the list.
		 */
		
		// test case:
		// empty list
		// only one entry in the list
		// two entries in the list with different values
		// two entries in the list with the same value
		// ten entries in the list with some duplicates.
		// fifteen entries in the list and all are the same value.
		// twenty entries with no duplicates.

		ListNode l1 = new ListNode(3);
		l1.setNext(new ListNode(1));
		ListNode current = l1.getNext();
		current.setNext(new ListNode(1));
		current = current.getNext();
		current.setNext(new ListNode(9));
		current = current.getNext();
		current.setNext(new ListNode(5));
		current = current.getNext();
		current.setNext(new ListNode(9));
		current = current.getNext();
		current.setNext(new ListNode(7));
		current = current.getNext();
		current.setNext(new ListNode(5));
		

		System.out.println("input:");
		ListNode.print(l1);
		
		System.out.println("output:");
		Solution21.removeDups(l1);
		ListNode.print(l1);
	}

}
