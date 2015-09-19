package ch2.cbc.xuewei.ece.cmu;

import java.util.Stack;

public class Solution26 {
	public static boolean isPalindrome(ListNode head){
		// assume that empty list return false;
		if(head == null){
			return false;
		}
		
		Stack<Integer> half = new Stack<Integer>();
		
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.getNext() != null){
			half.push(slow.getValue());
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		// when the length of the list is odd number!
		if(fast != null){
			slow = slow.getNext();
		}
		
		while(slow != null){
			int value = half.pop();
			if(slow.getValue() != value){
				return false;
			}
			// don't forget to type the next line
			slow = slow.getNext();
		}
		return true;
		
		
	}

	public static void main(String[] args) {
		// test cases:
		// empty list
		// only one entry
		// only two entries with different values
		// only two entries with the same value
		// only three entries that is palindrome
		// only three entries that is not palindrome
		// ten entries that is palindrome
		// ten entries that is not palindrome

		ListNode l1 = new ListNode(3);
		l1.setNext(new ListNode(7));
		ListNode current = l1.getNext();
		current.setNext(new ListNode(1));
		current = current.getNext();
		current.setNext(new ListNode(5));
		current = current.getNext();
		current.setNext(new ListNode(5));
		current = current.getNext();
		current.setNext(new ListNode(1));
		current = current.getNext();
		current.setNext(new ListNode(7));
		current = current.getNext();
		current.setNext(new ListNode(3));
		

		System.out.println("input:");
		ListNode.print(l1);
		
		System.out.println("output:");
		System.out.println(Solution26.isPalindrome(l1));
		

		System.out.println("-----------------------------------");

		current = current.getNext();
		current.setNext(new ListNode(3));

		System.out.println("input:");
		ListNode.print(l1);
		
		System.out.println("output");
		System.out.println(Solution26.isPalindrome(l1));
		
		
	}

}
