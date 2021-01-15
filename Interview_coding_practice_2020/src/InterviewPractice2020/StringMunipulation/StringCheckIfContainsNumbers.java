package InterviewPractice2020.StringMunipulation;

import java.util.ArrayList;

public class StringCheckIfContainsNumbers {

	public static void containsNumber(String str) {

		for (int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))){
				System.out.println("It contains Numbers at Index " + i);
			}

			int check = (str.charAt(i) - '0');
			if (check >= 0 && check <= 9) {
				System.out.println("It contains Numbers at Index " + i);
				return;
			}
		}
		System.out.println("It doesn't contain Numbers");
	}

	// Driver code
	public static void main(String[] args) {
		String str = "whhhhhg88";
		containsNumber(str);
	}
}

