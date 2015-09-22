package ch3.cbc.xuewei.ece.cmu;

import java.util.Stack;

public class Solution35 {
	public Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> minTopStack = new Stack<Integer>();
		while(stack.isEmpty() == false){
			int temp = stack.pop();
			// note the relation of stack and minTopStack in the following loop
			// don't confuse the two.
			while(minTopStack.isEmpty() == false && minTopStack.peek() < temp) {
				stack.push(minTopStack.pop());
			}
			minTopStack.push(temp);
		}
		return minTopStack;
	}

	public static void main(String[] args) {
		int testCase[] = { 7, 10, 12, 8, 1, 3, 5};
		Stack<Integer> stack = new Stack<Integer>();
		for(int i:testCase){
			stack.push(i);
		}
		Solution35 s = new Solution35();
		Stack<Integer> newStack = s.sortStack(stack);
		System.out.println("new stack:");
		while(!newStack.isEmpty()){
			System.out.println(newStack.pop());
		}

	}

}
