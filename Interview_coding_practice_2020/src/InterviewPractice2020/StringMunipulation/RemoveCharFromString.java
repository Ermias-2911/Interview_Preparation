package InterviewPractice2020.StringMunipulation;

public class RemoveCharFromString {

	public static void remove(String st, char x) {
StringBuilder   s = new StringBuilder(st);
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == x) {
				s.deleteCharAt(i);
				System.out.println("The string after char moved is " + s.toString());
			}
		}
	}

	public static void main(String[] args) {

		char x = 'G';
		String st = "ABGCD";
		remove(st, x);
	}
}

