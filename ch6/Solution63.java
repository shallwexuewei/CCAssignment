package ch6.cbc.xuewei.ece.cmu;

public class Solution63 {

	public static void main(String[] args) {
		/*
		 * Sign one side of the a domino as 0, and the other side of it as 1.
		 * then we could tag the chess board as follows (2 symbolize the corner that has been cut off.)
		 * 
		 * 0 1 0 1 0 1 0 2
		 * 1 0 1 0 1 0 1 0
		 * 0 1 0 1 0 1 0 1
		 * 1 0 1 0 1 0 1 0
		 * 0 1 0 1 0 1 0 1
		 * 1 0 1 0 1 0 1 0
		 * 0 1 0 1 0 1 0 1
		 * 2 0 1 0 1 0 1 0
		 * 
		 * We can count and find there are 32 0s and 30 1s in the chessboard. 
		 * If we exchange 1 and 0, there would be 32 1s and 30 0s in the chessboard. 
		 * However, we need to place 31 dominos, which means that we need at least 32 0s and 32 1s. 
		 * So the 31 dominos cannot cover the entire board.
		 */
	}

}
