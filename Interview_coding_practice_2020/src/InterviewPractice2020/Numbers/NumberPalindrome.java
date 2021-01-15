package InterviewPractice2020.Numbers;

// Author Ermias Haile
// August 25, 2020
// Number Palindrome

public class NumberPalindrome {

	public static boolean palindrome(int num) {
		if (num == 0 || num < 0) {
			return false;
		}
		int reverseNumber = 0;
		int copyNum = num;


		while (copyNum > 0) {
			int getOneDigit = copyNum % 10;
			reverseNumber = reverseNumber * 10 + getOneDigit;
			copyNum /= 10;

		}
		return reverseNumber == num;
	}

	public static void main(String[] args) {
		int numbers = 1220221;

		boolean result = palindrome(numbers);
		System.out.println(numbers + " is Palinorome: " + result);
	}
}