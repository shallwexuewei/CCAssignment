package ch10.cbc.xuewei.ece.cmu;

public class Solution09 {
	public static boolean sortedMatrixSearch(int[][] matrix, int elem) {
		int row = matrix.length;
		if(row == 0) {
			return false;
		}
		int col = matrix[0].length;
		int i = 0;
		int j = col - 1;
		while (i < row && j >= 0) {
			if (matrix[i][j] == elem) {
				return true;
			} else if (matrix[i][j] > elem) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 6, 8, 9 }, { 7, 10, 12 } };
		System.out.println(Solution09.sortedMatrixSearch(matrix, 7));
		System.out.println(Solution09.sortedMatrixSearch(matrix, 12));
		System.out.println(Solution09.sortedMatrixSearch(matrix, 5));

	}

}
