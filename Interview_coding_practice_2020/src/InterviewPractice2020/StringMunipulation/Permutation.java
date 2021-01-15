package InterviewPractice2020.StringMunipulation;

public class Permutation {


	// Utility function to swap two characters in a character array
	private static String swap(String st, int i, int j) {
		char[]   ch = st.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return String.valueOf(ch);
	}

	// Recursive function to generate all permutations of a String
	private static void permutations(String st, int left, int right) {
		if (left == right) {
			System.out.println(st);
		}

		for (int i = left; i <= right; i++) {
			String swapped = swap(st, left, i);
			permutations(swapped,left+1, right);
		}
	}


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Function to print all the permutations of str
	static void printPermutn(String str, String ans)
	{

		// If string is empty
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);

			// Rest of the string after excluding the ith character
			String ros = str.substring(0, i) + str.substring(i + 1);
			// Recurvise call
			printPermutn(ros, ans + ch);
		}
	}

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	// generate all permutations of a String in Java
	public static void main(String[] args) {
		String st = "ABC";
		System.out.println(" >>>>>>>>>>>>>>>  Permutatin With Swap <<<<<<<<<<<<<<" );
		permutations(st, 0, st.length()-1);
		System.out.println(" >>>>>>>>>>>>>>>  Permutatin WithOut Swap <<<<<<<<<<<<<<" );
		printPermutn(st, "");
	}
}
