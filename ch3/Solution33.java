package ch3.cbc.xuewei.ece.cmu;

import java.util.LinkedList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Solution33 {

	public static class StackOfPlates<T> {
		private LinkedList<Stack<T>> stackLinkedList;
		private int capacity; // capacity of every stack;

		public StackOfPlates(int capacity) {
			super();
			this.capacity = capacity;
		}

		public void push(T val) {
			if (isEmpty()) {
				createNewStack(val);
			} else {
				Stack<T> lastStack = getLastStack();
				int lastStackSize = lastStack.size();
				if (lastStackSize < capacity) {
					lastStack.add(val);
				} else {
					createNewStack(val);
				}
			}
		}

		public T pop() {
			if (isEmpty()) {
				throw new EmptyStackException();
			}
			Stack<T> lastStack = getLastStack();
			T val = lastStack.pop();
			if (lastStack.size() == 0) {
				stackLinkedList.removeLast();
			}
			return val;
		}

		private void createNewStack(T val) {
			Stack<T> stack = new Stack<T>();
			stack.push(val);
			stackLinkedList.add(stack);
		}

		private Stack<T> getLastStack() {
			return stackLinkedList.get(getLastIndex());
		}

		private int getLastIndex() {
			return getListSize() - 1;
		}

		private int getListSize() {
			return stackLinkedList.size();
		}

		private boolean isEmpty() {
			return (getListSize() == 0);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// follow up:
		// The stackLinkedList should be changed to ArrayList, so we could
		// access every stack in O(1) time
		// and every time popAt(i), the right stacks should remove the first
		// element ant push it to the previous one.

	}

}
