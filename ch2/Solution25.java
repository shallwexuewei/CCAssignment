package ch2.cbc.xuewei.ece.cmu;

public class Solution25 {

	public static ListNode sumLists(ListNode head1, ListNode head2){
		if(head1 == null){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		ListNode p1 = head1;
		ListNode p2 = head2;
		ListNode result = null;
		ListNode current = null;
		ListNode pre = null;
		int carry = 0;
		while(p1 != null || p2 != null){
			int sum = carry;
			if(p1 == null){
				sum += p2.getValue();
			} else if(p2 == null){
				sum += p1.getValue();
			} else {
				sum += p1.getValue() + p2.getValue();
			}
			if(sum > 9){
				carry = 1;
				sum = sum  - 10;
			} else if(carry == 1){
				carry = 0;
			}
			current = new ListNode(sum);
			if(result == null){
				result = current;
			} else {
				pre.setNext(current);
			}
			pre = current;
			p1 = p1.getNext();
			p2 = p2.getNext();
		} 
		if(carry != 0){
			// be careful not to type result instead of current by mistake in the next line
			current.setNext(new ListNode(1));
		}
		return result;
	}
	
	public static void main(String[] args) {
		// test cases
		// two lists with the same length
		// two lists with different length and previous one is longer
		// two lists with different length and latter one is longer
		// two empty lists
		// one of two is empty
		
		ListNode l1 = new ListNode(7);
		l1.setNext(new ListNode(1));
		ListNode current = l1.getNext();
		current.setNext(new ListNode(6));

		ListNode l2 = new ListNode(5);
		l2.setNext(new ListNode(9));
		ListNode current2 = l2.getNext();
		current2.setNext(new ListNode(2));
		
		System.out.println("input:");
		ListNode.print(l1);
		ListNode.print(l2);
		
		System.out.println("output");
		ListNode result = Solution25.sumLists(l1, l2);
		ListNode.print(result);
		System.out.println("------------------------------------------------");
		

		current2.setNext(new ListNode(9));
		
		System.out.println("input:");
		ListNode.print(l1);
		ListNode.print(l2);
		
		System.out.println("output");
		result = Solution25.sumLists(l1, l2);
		ListNode.print(result);

	}

}
