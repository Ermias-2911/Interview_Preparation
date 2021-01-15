package InterviewPractice2020.Numbers;

import java.util.Arrays;

// Author Jeremiah Haile
// Solved using model-based technique.
// Minimum value is known, So we can use model-based
public class MissingNumbersWithModelBased {

	public static void main(String[] args) {

		int arr[] = {20, 6, 10, 3, 7};
		int difference = 0;
		int result = 0;

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		// Specify the size of temp array.
		int max = (arr[arr.length - 1] - arr[0]);
		int[] temp = new int[max + 1];

		// Copy value of arr to corresponding temp array
		for (int i = 0; i < arr.length - 1; i++) {

			// To save the first arr value
			if (i == 0) {
				temp[0] = arr[0];
			}
			difference = arr[i + 1] - arr[i];
			result = result + difference;
			temp[result] = arr[i + 1];
		}
		for (int j = 0; j < temp.length - 1; j++) {

			if (temp[j] == 0) {
				int tem = temp[j - 1] + 1;
				temp[j] = tem;

				System.out.println(" Missing Number:  " + tem);
			}
		}
	}
}
