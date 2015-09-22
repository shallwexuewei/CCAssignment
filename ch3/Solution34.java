package ch3.cbc.xuewei.ece.cmu;

import java.util.EmptyStackException;
import java.util.Stack;

public class Solution34 {
	public static class MyQueue<T> {
		Stack<T> stack = new Stack<T>();
		Stack<T> reverseStack = new Stack<T>();

		public void add(T x) {
			stack.add(x);
		}

		public T remove() {
			if (reverseStack.isEmpty()) {
				reverse();
			}
			return reverseStack.pop();
		}

		public T peek() {
			if (reverseStack.isEmpty()) {
				reverse();
			}
			return reverseStack.peek();
		}

		public boolean isEmpty() {
			return stack.isEmpty() && reverseStack.isEmpty();
		}
		
		public int size(){
			return stack.size() + reverseStack.size();
		}

		private void reverse() {
			while (stack.isEmpty() == false) {
				reverseStack.add(stack.pop());
			}
		}
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Integer> q = new MyQueue<Integer>();
		q.add(1);
		System.out.println(q.peek() + " (the answer should be 1)");
		System.out.println(q.isEmpty() + " (the answer should be false)");
		
		q.add(2);
		q.add(3);
		System.out.println(q.peek() + " (the answer should be 1)");
		System.out.println(q.size() + " (the answer should be 3)");
		System.out.println(q.remove() + " (the answer should be 1)");
		System.out.println(q.peek() + " (the answer should be 2)");
		System.out.println(q.isEmpty() + " (the answer should be false)");
		System.out.println(q.remove() + " (the answer should be 2)");
		System.out.println(q.peek() + " (the answer should be 3)");
		System.out.println(q.isEmpty() + " (the answer should be false)");
		System.out.println(q.remove() + " (the answer should be 3)");
		System.out.println(q.isEmpty() + " (the answer should be true)");
		
		
	}

}
