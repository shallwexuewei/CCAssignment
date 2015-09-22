package ch3.cbc.xuewei.ece.cmu;

import java.util.EmptyStackException;

public class Solution31 {

	public class ThreeStack {
		private int[] content;
		private int[] starts;
		private int[] limits;
		private int[] ends;
		private int stackNum;

		public ThreeStack(int capacity) {
			stackNum = 3;
			content = new int[stackNum * capacity];
			starts = new int[stackNum];
			limits = new int[stackNum];
			ends = new int[stackNum];
			int startIndex = 0;
			for (int i = 0; i < stackNum; i++) {
				starts[i] = startIndex;
				ends[i] = startIndex;
				startIndex += capacity;
				limits[i] = startIndex;
			}
		}
		
		public void push(int stackIndex, int value){
			if(ends[stackIndex] < limits[stackIndex]){
				content[ends[stackIndex]] = value;
				ends[stackIndex]++;
			}
		}
		
		public void pop(int stackIndex){
			if(isEmpty(stackIndex)){
				throw new EmptyStackException();
			}
			if(ends[stackIndex] > starts[stackIndex]){
				ends[stackIndex]--;
			}
		}
		
		public int peak(int stackIndex){
			if(isEmpty(stackIndex) == false){
				return content[ends[stackIndex]];
			} else {
				// the way to deal with the exception
				throw new EmptyStackException();
			}
		}
		
		public boolean isEmpty(int stackIndex){
			return (starts[stackIndex] == ends[stackIndex]);
		}
		
		public void print(){
			for(int i = 0; i < stackNum; i++){
				System.out.print("stack#"+i+":");
				if(ends[stackNum] > 0) {
					int startIndex = starts[stackNum];
					System.out.print(content[startIndex]);
					for(int j = 1; j < ends[stackNum]; j++){
						System.out.print(",");
						System.out.print(content[stackNum+j]);
					}
				}
				System.out.println();
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
