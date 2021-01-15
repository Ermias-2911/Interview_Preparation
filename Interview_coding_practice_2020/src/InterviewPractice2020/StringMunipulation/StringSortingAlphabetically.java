package InterviewPractice2020.StringMunipulation;

import java.util.Arrays;

public class StringSortingAlphabetically {

// Author Jeremiah Haile
// Solved used brute force technique.

	public static String stringSort(String ss) {

		String[] s = ss.split(" ");

		for (int j = 0; j < s.length; j++) {
			for (int i = j + 1; i < s.length; i++) {

				// It compare character by character and give the difference in number
				if (s[j].compareTo(s[i]) > 0) {
					swap(i, j, s);
				}
			}
		}
		return Arrays.toString(s);

		// System.out.println(Arrays.toString(s));
	}

	// To swap
	public static void swap(int i, int j, String[] s) {
		String temp = s[j];
		s[j] = s[i];
		s[i] = temp;
	}

	public static void main(String args[]) {

		String s = "Apple Banana Orange Bluebery Pich";
		System.out.println();
		String g = stringSort(s);

		System.out.println(g);

		// System.out.println(result);
	}
}