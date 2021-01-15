package InterviewPractice2020.StringMunipulation;
// Author Ermias Haile
// August 27, 2020
// Number Palindrome
public class StringPalindrome {

	public static boolean palindrome(String st) {

		if (st.isEmpty()) {
			return false;
		}

		StringBuilder sb= new StringBuilder(st);
		sb.reverse();
		System.out.println("sb reverse 	" + sb.toString());

		return st.equals(sb.toString());
	}

	public static void main(String[] args) {
		String st = "abcdcba";

		boolean result = palindrome(st);
		System.out.println(st + " is Palindrome: " + result);
	}
}