package InterviewPractice2020.Numbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TheSumOfTwoNumberHashset {

	static void printpairs(int arr[], int sum) {
		List<Integer> s = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];

			// checking for condition
			if (temp >= 0 && s.contains(temp)) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
				System.out.println("Pair with given sum index is " + sum + " is (" + i + ", " + s.indexOf(temp) + ")");
			}
			s.add(arr[i]);
		}
	}

	// Main to test the above function
	public static void main(String[] args) {
		int A[] = {15, 1, 45, 6, 10, 8};
		int n = 16;
		printpairs(A, n);
	}
}

