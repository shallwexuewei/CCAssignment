package ch1.cbc.xuewei.ece.cmu;

public class Solution18 {
	public static void zeroMatrix(int[][] matrix){
		int m = matrix.length;
		if(m == 0){
			return;
		}
		int n = matrix[0].length;
		boolean[] zeroCols = new boolean[n];
		for(int i = 0; i < m; i++){
			boolean zeroRow = false;
			for(int j = 0; j < n; j++){
				int val = matrix[i][j];
				if(val == 0) {
					if(zeroCols[j] == false){
						zeroCols[j] = true;
						for(int row = 0; row < i; row++){
							matrix[row][j] = 0;
						}
					}
					if(zeroRow == false){
						zeroRow = true;
						for(int col = 0; col < j; col++){
							matrix[i][col] = 0;
						}
					}
				} else if(zeroCols[j] || zeroRow){
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		// test case:
		
		// 1. matrix type
		// empty matrix
		// 1*1 matrix
		// 1*10 matrix
		// 10*1 matrix
		// 2*2 matrix
		// 3*3 matrix
		// 2*20 matrix
		// 10*10 matrix
		
		// 2. zero number
		// 0
		// 1
		// 2
		// 3 and 2 of them in the same row
		// 4 and 2 of them in the same column
		// 5 and 2 of them in the same row while 2 of them in the same column
		// all zeros in the matrix

		
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
		
		Solution18.zeroMatrix(input);
		
		System.out.println("output:");
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}

}
