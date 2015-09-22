package ch3.cbc.xuewei.ece.cmu;

import java.util.Stack;

public class Solution32 {
	public static class MinStack {
		private int min;
		private Stack<Integer> stack;

		public MinStack() {
			this.min = Integer.MAX_VALUE;
			stack = new Stack<Integer>();
		}

		public void push(int x) {
			stack.push(min);
			if (x < min) {
				this.min = x;
			}
			stack.push(x);

		}

		public int pop() {
			int temp = stack.pop();
			min = stack.pop();
			return temp;
		}

		public int min() {
			return min;
		}

		public void clear() {
			stack.clear();
			min = Integer.MAX_VALUE;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(2);
		minStack.push(0);
		minStack.push(3);
		minStack.push(0);
		System.out.println(minStack.min()+" (the answer should be 0)");
		System.out.println(minStack.pop()+" (the answer should be 0)");
		System.out.println(minStack.min()+" (the answer should be 0)");
		System.out.println(minStack.pop()+" (the answer should be 3)");
		System.out.println(minStack.min()+" (the answer should be 0)");
		System.out.println(minStack.pop()+" (the answer should be 0)");
		System.out.println(minStack.min()+" (the answer should be 2)");

		System.out.println("---------------------------------");
		minStack.clear();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-1);
		System.out.println(minStack.min()+" (the answer should be -2)");
		System.out.println(minStack.pop()+" (the answer should be -1)");
		System.out.println(minStack.min()+" (the answer should be -2)");

		System.out.println("---------------------------------");
		minStack.clear();
		minStack.push(-3);
		System.out.println(minStack.min()+" (the answer should be -3)");
	}
}
