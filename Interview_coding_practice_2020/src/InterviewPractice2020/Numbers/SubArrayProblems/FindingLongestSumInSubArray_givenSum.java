package InterviewPractice2020.Numbers.SubArrayProblems;

import java.util.Arrays;

// Author Ermias Haile
// August 20, 2020
// Finding Longest Sum In Sub Array
// Slide Window Technique
public class FindingLongestSumInSubArray_givenSum {

		// Used Slide Window technique for subarray
		public static int findLongestSumSubArray2(int[] arr, int find) {
			int sum = 0;
			int first_slide = 0;
			int max_count = 0;
			int second_slide = 0;

			            // Slide Window
			// second_slide -------->|
			//                        first_slide |--------> |
			while (first_slide <= arr.length - 1) {

				if (sum <= find) {
					if (sum == find) {
						max_count = Math.max(max_count, first_slide - second_slide);
					}
					sum = sum + arr[first_slide];
					first_slide++;
				} else {
					sum = sum - arr[second_slide];
					second_slide++;
				}
			}
			System.out.println(" value: " + max_count);
			return max_count;
		}

		public static void main(String[] args) {
			int[] arr = {1, 2, 3, 4, 5, 7, 8, 9, 10};
			int find = 9;
			int result = findLongestSumSubArray2(arr, find);
			System.out.println(" The longest subarray sum of " + find + " in Array " + Arrays.toString(arr) + " is: ===> " + result);
		}
	}