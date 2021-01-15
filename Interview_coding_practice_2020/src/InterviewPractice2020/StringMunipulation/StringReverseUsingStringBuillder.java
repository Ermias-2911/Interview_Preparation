package InterviewPractice2020.StringMunipulation;

public class StringReverseUsingStringBuillder {

	public static void reversString(String st) {
		StringBuilder s = new StringBuilder();
		s.append(st);

		s = s.reverse();
		System.out.println(s);
	}

	public static void main(String[] args) {
		String input = "Geeks For Geeks";
		reversString(input);
	}
}
