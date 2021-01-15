package InterviewPractice2020.Numbers;
// Author Ermias Haile
// August 20, 2020
// Finding Longest Sum In Sub Array
// Slide Window Technique
public class FindingLongestSumInSubArray {
		public static int findLongestSumSubArray(int[] arr, int find) {
			int sum = 0;
			int counter = 0;
			int max = 0;
			int index = 0;

			while (counter <= arr.length - 1) {
				sum = sum + arr[counter];

				while (sum > find) {
					int decrement = sum - arr[index];
					if (decrement < find) {
						sum = decrement;
					} else {
						break;
					}
					index++;
				}

				if (sum == find) {
					// we pass counter -  index + 1 (plus 1 is to avoid starting point of 0) because index location might not be the same as counter
					max = Math.max(max, counter - index + 1);
				}
				counter++;
			}
			return max;
		}

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		public static int findLongestSumSubArray2(int[] arr, int find) {
			int sum = 0;
			int rightIndex = 0;
			int max = 0;
			int leftIndex = 0;

			while (rightIndex <= arr.length - 1) {

				if (sum <= find) {
					if (sum == find) {
						max = Math.max(max, rightIndex - leftIndex);
					}
					sum = sum + arr[rightIndex];
					rightIndex++;
				} else {
					sum = sum - arr[leftIndex];
					leftIndex++;
				}
			}
			System.out.println(" value: " + max);
			return max;
		}

		public static void main(String[] args) {
			int[] arr = {1, 2, 3, 4, 5, 7, 8, 9, 10};
			int find = 9;
			int result = findLongestSumSubArray(arr, find);
			int result2 = findLongestSumSubArray2(arr, find);
			System.out.println("Result: " + result);
			System.out.println("Result2: " + result2);
		}
	}