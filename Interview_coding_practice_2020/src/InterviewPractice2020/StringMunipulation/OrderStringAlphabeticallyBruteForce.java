package InterviewPractice2020.StringMunipulation;
import java.util.Arrays;
import java.util.Scanner;


public class OrderStringAlphabeticallyBruteForce {

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
		}

		// To swap
		public static void swap(int i, int j, String[] s) {
			String temp = s[j];
			s[j] = s[i];
			s[i] = temp;
		}

		public static void main(String args[]) {

			String s = "Apple Banana Orange Bluebery Pich Appl";
			String[] ss = {"Apple" , "Banana" , "Orange" ,"Bluebery" , "Pich" ," Appl", "Apple"};
			Arrays.sort(ss);

			System.out.println("from Arrays.sort: " + Arrays.toString(ss));
			String g = stringSort(s);

			System.out.println(g);
		}
	}

