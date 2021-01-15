package InterviewPractice2020.StringMunipulation;

public class  FindDuplicateChar {

	public static void main(String[] args) {

		String str = "abcdabghplhhnfl".toLowerCase();

		// create a integer array for 26 alphabets.
		// where index 0,1,2.. will be the container for frequency of a,b,c...
		Integer[] ar = new Integer[26];

		// fill the integer array with character frequency.
		for (int i = 0; i < str.length(); i++) {
			int j = str.charAt(i) - 'a';
			if (ar[j] == null) {
				ar[j] = 1;
			} else {
				ar[j] += 1;
			}
		}
		// print only those alphabets having frequency greater then 1.
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != null && ar[i] > 1) {
				char c = (char) (97 + i);
				System.out.println("'" + c + "' comes " + ar[i] + " times.");
			}
		}
	}
}
