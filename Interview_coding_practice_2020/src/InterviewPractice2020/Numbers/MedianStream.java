package InterviewPractice2020.Numbers;

import java.util.*;

// Author Ermias Haile
// August 26, 2020
// Median Stream

// The median of a list of integers is defined as follows. If the integers were to be sorted, then:
// If there are an odd number of integers, then the median is equal to the middle integer in the sorted order.
// Otherwise, if there are an even number of integers, then the median is equal to the average of the two middle-most integers in the sorted order.

public class MedianStream {


	public static int[] findMedian(int[] arr) {

		// Write your code here
		int fastIndex = 0;
		int counter = 0;
		int[] output = new int[arr.length];
		output[0] = arr[0];
		List<Integer> list = new ArrayList<>();


		while (fastIndex < arr.length) {

			counter += arr[fastIndex];
			list.add(arr[fastIndex]);

			if (fastIndex <= 1) {
				if (fastIndex == 1) {
					output[fastIndex] = counter / 2;
				}
			}

			if ((fastIndex % 2 == 0 && fastIndex == 2) || fastIndex % 2 == 0 && fastIndex > 2) {
				Collections.sort(list);
				output[fastIndex] = list.get((fastIndex + 1) / 2);
			}

			if (fastIndex % 2 == 1 && fastIndex >= 3) {
				Collections.sort(list);
				int midleOffset = fastIndex / 2;
				output[fastIndex] = (list.get(midleOffset) + list.get(midleOffset + 1)) / 2;
			}
			fastIndex++;
		}
		return output;
	}


	public static void main(String[] args) {
		// expected_1 = {5, 10, 5, 4};
		int[] arr_1 = {5, 15, 1, 3};

		// expected_2 = {2, 3, 4, 3, 4, 3};
		int[] arr_2 = {2, 4, 7, 1, 5, 3};


		int[] result = findMedian(arr_2);
		System.out.println(" Output of median : " + Arrays.toString(result));
	}
}
