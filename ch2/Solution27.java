package ch2.cbc.xuewei.ece.cmu;

public class Solution27 {
	
	public static ListNode intersection(ListNode head1, ListNode head2){
		if(head1 == null || head2 == null){
			return null;
		}
		
		int len1 = 1;
		ListNode p1 = head1;
		while(p1.getNext() != null){
			len1++;
			p1 = p1.getNext();
		}
		
		int len2 = 1;
		ListNode p2 = head2;
		while(p2.getNext() != null){
			len2++;
			p2 = p2.getNext();
		}
		
		if(p1 != p2){
			return null;
		}
		
		if(len1 > len2){
			int temp = len1;
			len1 = len2;
			len2 = temp;
			ListNode tempP = head1;
			head1 = head2;
			head2 = tempP;
		}
		
		int diff = len2-len1;
		int i = 0;
		p2 = head2;
		while(i < diff){
			p2 = p2.getNext();
			i++;
		}
		
		p1 = head1;
		while(p1 != p2){
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		return p1;
	}

	public static void main(String[] args) {

		// test cases
		// two lists with intersection but only the last entry intersects
		// two lists without intersection but same values in the last
		// two lists with the same length without intersection
		// two lists with the same length with intersection in the middle
		// two lists with different length and previous one is longer and there is intersection
		// two lists with different length and latter one is longer and there is intersection
		// two empty lists
		// one of two is empty
		
		ListNode l1 = new ListNode(3);
		l1.setNext(new ListNode(1));
		ListNode current = l1.getNext();
		current.setNext(new ListNode(5));
		current = l1.getNext();
		current.setNext(new ListNode(9));

		ListNode l2 = new ListNode(4);
		l2.setNext(new ListNode(6));
		ListNode current2 = l2.getNext();
		current2.setNext(new ListNode(7));
		
		current = current.getNext();
		current2 = current2.getNext();
		current.setNext(current2);

		current2.setNext(new ListNode(2));
		current2 = current2.getNext();
		current2.setNext(new ListNode(1));
		
		System.out.println("input:");
		ListNode.print(l1);
		ListNode.print(l2);
		
		System.out.println("output");
		ListNode result = Solution27.intersection(l1, l2);
		ListNode.print(result);

	}

}
