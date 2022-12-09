package InterviewPractice2020.StringMunipulation;
// Author Ermias Haile
// LeetCode Question
// August 20, 2020

// BackSpaceStringComparson
public class BackSpaceStringComparson {

		public static boolean backSpace(String s, String t) {
			StringBuilder sResult = new StringBuilder();
			StringBuilder tResult = new StringBuilder();
			int len = Math.max(s.length(), t.length());
			for (int i = 0; i < len; i++) {

				if (i < s.length()) {
					if (s.charAt(i) != '#') {
						sResult.append(s.charAt(i));
					} else if (sResult.length() != 0 && s.charAt(i) == '#') {
						sResult.deleteCharAt(sResult.length() - 1);
					}

				}

				if (i < t.length()) {
					if (t.charAt(i) != '#')
						tResult.append(t.charAt(i));
					if (tResult.length() != 0 && t.charAt(i) == '#') {
						tResult.deleteCharAt(tResult.length() - 1);
					}
				}
			}

			System.out.println("Result " + sResult.toString());
			System.out.println("Result " + tResult.toString());
			if (sResult.compareTo(tResult) == 0) {
				return true;
			}

			return false;
		}


		public static void main(String[] args) {

//		String s = "ab#c";
//		String  t = "ad#c#";
//			String s = "a#c";
//			String t = "b";
		String s = "ab##";
		String t = 	"c#d#";

			System.out.println(" Result: " + backSpace(s, t));
		}
	}

