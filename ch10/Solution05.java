package ch10.cbc.xuewei.ece.cmu;

public class Solution05 {

	public static int sparseSearch(String[] strings, String str) {
		int first = 0;
		int last = strings.length;
		int mid;

		while (first <= last) {
			mid = (last + first) / 2;

			if (strings[mid].isEmpty()) {
				int left = mid - 1;
				int right = mid + 1;
				while (true) {
					if (left < first && right > last) {
						return -1;
					} else if (right <= last && !strings[right].isEmpty()) {
						mid = right;
						break;
					} else if (left >= first && !strings[left].isEmpty()) {
						mid = left;
						break;
					}
					right++;
					left--;
				}
			}

			if (str.equals(strings[mid])) {
				return mid;
			} else if (strings[mid].compareTo(str) < 0) { // Search right
				first = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String[] strs = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		System.out.println(Solution05.sparseSearch(strs, "ball")); // 4

	}

}
