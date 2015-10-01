package ch10.cbc.xuewei.ece.cmu;

public class Solution04 {
	public static int sortedSearch(Listy list, int val) {
		int upperBound = 1;
		while (list.elementAt(upperBound) != -1
				&& list.elementAt(upperBound) < val) {
			upperBound *= 2;
		}
		return binarySearch(list, val, upperBound / 2, upperBound);
	}

	public static int binarySearch(Listy list, int val, int low, int high) {
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			int middle = list.elementAt(mid);
			// the difference from the normal binary search lies here:
			// "|| middle == -1"
			if (middle > val || middle == -1) {
				high = mid - 1;
			} else if (middle < val) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Listy l = new Listy();
		int[] a = { 1, 2, 3, 4, 5, 6 };
		for (int i : a) {
			l.add(i);
		}
		System.out.println(Solution04.sortedSearch(l, 3));
		System.out.println(Solution04.sortedSearch(l, 6));
		System.out.println(Solution04.sortedSearch(l, 7));

	}

}
