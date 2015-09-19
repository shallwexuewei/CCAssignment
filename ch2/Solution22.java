package ch2.cbc.xuewei.ece.cmu;

public class Solution22 {
	
	
	public static ListNode kth2last(ListNode head, int k){
		ListNode p1 = head;
		ListNode p2 = head;
		
		for(int i = 0; i < k; i++){
			// need to consider the situation "out of bounds"
			if(p1 == null){
				return null;
			}
			p1 = p1.getNext();
		}
		
		while(p1 != null){
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		return p2;
	}
	
	public static void main(String[] args) {
		// test cases
		// empty list
		// only one entry, and k = 0
		// only one entry, and k = 1
		// two entry, k = 1;
		// two entry, k = 3;
		// 10 entries, k = 11;
		// 10 entries, k = 0;

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
		int k = 2;
		System.out.println("k:"+k);
		
		System.out.println("output");
		ListNode result = Solution22.kth2last(l1, k);
		ListNode.print(result);
	}

}
