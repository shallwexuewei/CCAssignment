package ch10.cbc.xuewei.ece.cmu;

public class Solution06 {

	public static void main(String[] args) {
		/*
		 * 20GB file is too big to place in the normal memory, so we need to
		 * split the file and sort part by part. For example, we could read 1GB
		 * firstly, sort the 1GB data, and then put back into the disk. and then
		 * read the second 1GB data, sort and put back...
		 * Every time we sort, we store the start address of the data. 
		 * So after sorting every 1GB data, we could merge and sort every single part. 
		 * 
		 */

	}

}
