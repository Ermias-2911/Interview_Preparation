package InterviewPractice2020.StringMunipulation;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class OrderStringAlphabeticallyBruteForce {
// Author Jeremiah Haile

		// Sorting words ascending order
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

		// Sorting words descending order
		public static String[] reverseWords(String st){
			String[] stArray = st.split(" ");
			Arrays.sort(stArray, Collections.reverseOrder());
			return stArray;
		}

		// Sorting words ascending order
		public static String[] sortedWords(String st){
			String[] stArray = st.split(" ");
			Arrays.sort(stArray);
			return stArray;
		}


		public static void main(String args[]) {

			String s = "Apple Banana Orange Bluebery Pich Appl Apple";
			String[] ss = {"Apple" , "Banana" , "Orange" ,"Bluebery" , "Pich" ," Appl", "Apple"};

			String[] result = reverseWords(s);
			System.out.println(" Words Sort descending order using Arrays.sort(st, Collections.reverseOrder()): ===> " +  Arrays.toString(result));

			System.out.println(" ");
			String[] result1 = sortedWords(s);
			System.out.println(" Words Sort ascending order using Arrays.sort(st): ===> " +  Arrays.toString(result1));

			System.out.println(" ");
			String resu = stringSort(s);
			System.out.println(" Words sort ascending order using swap: ===> " + resu);
		}
	}

