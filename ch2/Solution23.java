package ch2.cbc.xuewei.ece.cmu;

public class Solution23 {

	public static void deleteMiddleNode(ListNode node){
		if(node == null) 
			return;
		if(node.getNext() == null)
			return;
		ListNode next = node.getNext();
		node.setValue(next.getValue());
		node.setNext(next.getNext());
	}
	
	public static void main(String[] args) {
		// Test cases:
		// empty list
		// remove the last entry in the list
		// remove the 2nd last entry in the list
		// remove the middle in the list
		// remove the head in the list

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
		ListNode middle = current;
		current = current.getNext();
		current.setNext(new ListNode(5));
		

		System.out.println("input:");
		ListNode.print(l1);
		System.out.print("the list beginning from the node:");
		ListNode.print(middle);
		
		System.out.println("output");
		Solution23.deleteMiddleNode(middle);
		ListNode.print(l1);
	}

}
