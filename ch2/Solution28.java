package ch2.cbc.xuewei.ece.cmu;

public class Solution28 {

	public static ListNode loopDetected(ListNode head){
		
		if(head == null ){
			return null;
		}
		ListNode slow = head.getNext();
		if(slow == null){
			return null;
		}
		ListNode fast = slow.getNext();
		while(slow != null){
			if(fast == null || fast.getNext() == null){
				return null;
			}
			// the following branch requires that slow and fast don't start from the head together
			if(fast == slow){
				break;
			}
			
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		// find the beginning
		slow = head;
		while(slow != fast){
			slow = slow.getNext();
			fast = fast.getNext();
		}
		return slow;
	}

	
	public static void main(String[] args) {
		// test cases:
		// empty list
		// one entry the the next is itself
		// one entry without loop
		// two entries with loop beginning from the head
		// two entries with loop beginning from the tail
		// three entries without loop
		// three entries with loop beginning from the tail
		// ten entries with loop beginning in the middle
		

		ListNode l1 = new ListNode(0);
		l1.setNext(new ListNode(1));
		ListNode current = l1.getNext();
		current.setNext(new ListNode(2));
		current = current.getNext();
		current.setNext(new ListNode(3));
		current = current.getNext();
		current.setNext(new ListNode(4));
		current = current.getNext();
		current.setNext(new ListNode(5));
		current = current.getNext();
		current.setNext(new ListNode(6));
		ListNode middle = current;
		current = current.getNext();
		current.setNext(middle);
		

		System.out.println("input:");
		ListNode.printWithLoop(l1, 7);
		System.out.print("the loop beginning from the node:");
		ListNode.printWithLoop(middle, 7);
		
		System.out.println("output");
		ListNode result = Solution28.loopDetected(l1);
		ListNode.printWithLoop(result, 7);
	}

}
