package InterviewPractice2020.StringMunipulation;

public class StringReverseUsingReversLoop {

	static void reverse(String input) {

		for (int i = input.length() - 1; i >= 0; i--)
			System.out.print(input.charAt(i));
	}

	public static void main(String args[]) {
		String input = "Programming";
		reverse(input);
	}
}