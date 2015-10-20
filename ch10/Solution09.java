package ch10.cbc.xuewei.ece.cmu;

public class Solution09 {
	/**
	 * @param matrix: sorted matrix
	 * @param target: the number to find
	 * @return true if target is found, else return false.
	 * 
	 * Use diagonal value to implement search
	 * 
	 */
	public static boolean sortedMatrixSearch(int[][] matrix, int target) {
		int row = matrix.length;
		if(row == 0) {
			return false;
		}
		int col = matrix[0].length;
		// begins from right up most element.
		int r = 0;
		int c = col - 1;
		while (r < row && c >= 0) {
			// found
			if (matrix[r][c] == target) {
				return true;
			} 
			else if (matrix[r][c] > target) {
				// only the left side numbers are less than matrix[r][c]
				c--;
			} else {
				// only the down side numbers are less than matrix[r][c]
				r++;
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
