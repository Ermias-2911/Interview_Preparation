package InterviewPractice2020.Searching;

public class BinarySearch {

	public static int binnarySearch(int[] arr, int t) {

		int left = 0;
		int right = arr.length;

		while (left <= right) {

			int middle = left + (right - left) / 2;
			if (t == arr[middle]) {
				return middle;
			} else if (t < arr[middle]) {
				right = middle - 1;
			} else if (t > arr[middle]) {
				left = middle + 1;
			}
		}
		return 0;
	}

	public static void main(String args[]) {
		int[] arr = {2, 4, 6, 7, 9, 10, 12, 16};
		int n = arr.length;
		int t = 10;
		System.out.println(t + " Found at index " + binnarySearch(arr, t));
		int x = 41;
	}
}