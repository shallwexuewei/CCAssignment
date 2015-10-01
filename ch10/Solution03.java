package ch10.cbc.xuewei.ece.cmu;

public class Solution03 {

    public static int searchInRotatedArray(int array[], int x){
        int low = 0;
        int high = array.length - 1;
        int mid;

        while (low < high){
            mid = (low + high) / 2;

            if (array[mid] == x){
                return mid;
            }
            else if (array[mid] < x && array[high] > x){
                low = mid + 1;
            }
            else if (array[mid] < x && array[high] < x){
                high = mid - 1;
            }
            else if (array[mid] > x && array[low] < x){
				high = mid - 1;
            }
            else if (array[mid] > x && array[low] > x){
                low = mid + 1;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int a[] = {8, 7, 1, 2};
		System.out.println(Solution03.searchInRotatedArray(a, 7));
		System.out.println(Solution03.searchInRotatedArray(a, 9));
	}

}
