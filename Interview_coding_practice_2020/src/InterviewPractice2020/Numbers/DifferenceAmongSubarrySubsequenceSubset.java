package InterviewPractice2020.Numbers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifferenceAmongSubarrySubsequenceSubset {

    // Subarray
    // {nums, C, E} is a subsequence of {nums, B, C, D, E}, but not a substring, and {nums, B, C} is both a subarray and a subsequence.
    // A subarray is a slice from a contiguous array (i.e., occupy consecutive positions) and inherently maintains the
    // order of elements. For example, the subarrays of array {1, 2, 3} are {1}, {1, 2}, {1, 2, 3}, {2}, {2, 3}, and {3}
    // contiguous subarray is just another name for a subarray

    // Function to print all subarrays of the specified array
    public static void printAllSubarrays(List<Integer> input)
    {

        for (int i = 0; i < input.size(); i++)
        {
            // consider all subarrays ending at `j`
            for (int j = i; j < input.size(); j++)
            {
                System.out.println(input.subList(i, j + 1));
            }
        }
    }

    // Substring
    // A substring is almost similar to a subarray, but it is in the context of strings.
    // Ex. string 'apple' are 'apple', 'appl', 'pple', 'app', 'ppl', 'ple', 'ap', 'pp', 'pl', 'le', 'a', 'p', 'l', 'e', ''.
    // Function to print all non-empty substrings of the specified string
    public static void printAllSubstrings(String str)
    {
        int n = str.length();

        for (int i = 0; i < n; i++)
        {

            for (int j = i; j < n; j++) {
                System.out.print("'" + str.substring(i, j + 1) + "', ");
            }
        }
    }

    // Subsequence
    // A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the
    // order of the remaining elements. {nums, B, D} is a subsequence of sequence {nums, B, C, D, E} obtained after removing {C} and {E}.
    // {nums, C, E} is a subsequence of {nums, B, C, D, E}, but not a substring, and {nums, B, C} is both a subarray and a subsequence.
    // Generating all subsequences of an array/string is equivalent to generating a power set of an array/string. 0 and 2^n-1
    // Time complexity O(n*2^n)

    // Function to print all subsequences of the specified string
    public static void findPowerSet(String str)
    {
        int strSize = str.length();

        // N stores the total number of subsets
        int N = (int)Math.pow(2, strSize);

        List<String> result = new ArrayList<>();

        // generate each subset one by one
        for (int i = 0; i < N; i++)
        {
            StringBuilder sb = new StringBuilder();

            // check every bit of `i`
            for (int j = 0; j < strSize; j++)
            {
                // if j'th bit of `i` is set, print S[j]
                //  a<<b=a*(2^b)  ( means shifting the bits of the number ‘a’ on left side by ‘b’ times)
                // This checks for set(we use this check to find poer set in most problems)
                if ((i & (1 << j)) != 0) {
//                    System.out.println(" Value of (1 <<j): " + (1 <<j));
                    sb.append(str.charAt(j));
                }
            }
            result.add("'" + sb.toString() + "'");
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        String st = "apple";
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(" \n<<<<<<<<<<<<<<<<<<<<<<<<<< Subarray >>>>>>>>>>>>>>>>>>>>>>>>> ");
        printAllSubarrays(input);
        System.out.println(" \n<<<<<<<<<<<<<<<<<<<<<<<<<< Substring >>>>>>>>>>>>>>>>>>>>>>>>> ");
        printAllSubstrings(st);
        System.out.println(" ");
        System.out.println(" \n<<<<<<<<<<<<<<<<<<<<<<<<<< Subsequence >>>>>>>>>>>>>>>>>>>>>>>>> ");
        findPowerSet(st);
    }
}