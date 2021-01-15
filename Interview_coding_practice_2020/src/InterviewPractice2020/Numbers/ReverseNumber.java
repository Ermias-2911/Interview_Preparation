package InterviewPractice2020.Numbers;

public class ReverseNumber {

	private static int reverseNumbe(int num) {
		int rev_num = 0;
		while (num > 0) {
			rev_num = rev_num * 10 + num % 10;
			num = num / 10;
		}
		return rev_num;
	}

	// driver program to test above function
	public static void main(String[] args) {
		int num = 5678;
		System.out.println("Reversed Number: " + reverseNumbe(num));

	}
}
