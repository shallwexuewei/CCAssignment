package ch2.cbc.xuewei.ece.cmu;

public class ListNode {
	private ListNode next;
	private int value;

	public ListNode(int value) {
		super();
		this.value = value;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public static void print(ListNode head){
		if(head != null) {
			System.out.print(head.value);
		}
		ListNode current = head.getNext();
		while(current != null){
			System.out.print("->");
			System.out.print(current.value);
			current = current.getNext();
		}
		System.out.println();
	}

	public static void printWithLoop(ListNode head, int realLen){
		if(head != null) {
			System.out.print(head.value);
		}
		int i = 0;
		ListNode current = head.getNext();
		while(i < realLen*2){
			System.out.print("->");
			System.out.print(current.value);
			current = current.getNext();
			i++;
		}
		System.out.println();
	}
}
