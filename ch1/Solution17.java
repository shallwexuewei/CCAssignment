package ch1.cbc.xuewei.ece.cmu;

public class Solution17 {

	public static void rotate(int[][] m){
		int n = m.length;
		int mid = n/2;
		for(int layer = 0; layer < mid; layer++){
			int start = layer;
			int end = n - 1 - layer;
			for(int i = start; i < end; i++){
				int temp = m[start][i];

				int offset = i-start;
				m[start][i] = m[end-offset][start];
				m[end-offset][start] = m[end][end-offset];
				m[end][end-offset] = m[i][end];
				m[i][end] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		// test case should include 
		// empty matrix
		// 1*1 matrix
		// 2*2 matrix
		// 3*3 matrix
		// 10*10 matrix
		
		System.out.println("input:");
		int[][] input = new int[5][5];
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				int val =  i*5+j;
				input[i][j] =val;
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
		Solution17.rotate(input);
		
		System.out.println("output:");
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
