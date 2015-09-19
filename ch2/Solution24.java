package ch2.cbc.xuewei.ece.cmu;

public class Solution24 {
	public static ListNode partition(ListNode head, int x) {
		ListNode largerHead = null;
		ListNode largerTail = null;
		ListNode smallerTail = null;
		ListNode newHead = null;
		ListNode current = head;
		while (current != null) {
			if (current.getValue() < x) {
				if (newHead == null) {
					newHead = current;
				}
				if (smallerTail != null) {
					smallerTail.setNext(current);
				}
				smallerTail = current;
			} else {
				if (largerHead == null) {
					largerHead = current;
					largerTail = current;
				} else {
					largerTail.setNext(current);
					largerTail = current;
				}
			}
			current = current.getNext();
		}
		if (smallerTail == null) {
			newHead = largerHead;
		} else {
			smallerTail.setNext(largerHead);
		}
		
		// make sure that largerTail is not null!
		if(largerTail != null){
			largerTail.setNext(null);
		}
		return newHead;
	}

	public static void main(String[] args) {
		// test cases:
		// empty list
		// only smaller values in the list
		// only larger values in the list
		// only larger or equal values in the list
		// only smaller or equal values in the list
		// only one entry in the list
		// only two entries in the list
		// many entries include smaller values and larger values.
		
		// the test case on the book:
		ListNode node = new ListNode(3);
		ListNode head = node;
		node.setNext(new ListNode(5));
		node = node.getNext();
		node.setNext(new ListNode(8));
		node = node.getNext();
		node.setNext(new ListNode(5));
		node = node.getNext();
		node.setNext(new ListNode(10));
		node = node.getNext();
		node.setNext(new ListNode(2));
		node = node.getNext();
		node.setNext(new ListNode(1));
				
		System.out.println("the original list:");
		ListNode.print(head);
		head = Solution24.partition(head, 5);
		System.out.println("after patition [partition=5]:");
		ListNode.print(head);
	}

}
