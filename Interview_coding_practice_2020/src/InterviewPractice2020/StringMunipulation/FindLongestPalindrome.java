package InterviewPractice2020.StringMunipulation;

public class FindLongestPalindrome {
    public static String longestPalindrome(String s) {

        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {

            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

//               |A|B|C|B|A|C|
//            |begin -->  <-- end|
//		       <--- (-)    (+) --->
    // Given a center, either one letter or two letter find longest palindrome

    public static  String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static void main(String[] args) {

        String s = "ABCBAC";
        // System.out.println(s.substring(1, (s.length() - 1)));
        System.out.println( " Longest Palindrome of " + s + " ==> " + longestPalindrome(s));

    }
    }
