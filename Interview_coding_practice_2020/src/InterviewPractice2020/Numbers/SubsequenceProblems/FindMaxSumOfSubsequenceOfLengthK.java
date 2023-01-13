package InterviewPractice2020.Numbers.SubsequenceProblems;
import java.util.*;


// Find a subsequence of nums of length k that has the largest sum. A subsequence is an array that can be
// derived from another array by deleting some or no elements without changing the order of the remaining elements.
public class FindMaxSumOfSubsequenceOfLengthK {

    public static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] twoDArray = new int[n][2];

        // Copy nums array with their value and indexes to twoDArray
        for (int i = 0; i < n; ++i) {
            twoDArray[i] = new int[]{i, nums[i]};
        }

        // Reverse twoDArray by value not key. or by using  Arrays.sort(twoDArrayCopy, Comparator.comparingInt(a -> -a[0]));
        Arrays.sort(twoDArray, (a, b) -> b[1] -a[1] );

        System.out.println(" <<<<<<  2d Array sorted by value ( Arrays.sort(twoDArray, (a, b) -> b[1] -a[1]) or Arrays.sort(twoDArrayCopy, Comparator.comparingInt(a -> -a[0])) ) >>>>>>");
        for(int[] a : twoDArray){
            System.out.println(Arrays.toString(a));
        }

        // Copy twoDArrayCopy Array from twoDArray 2D Array K size
        int[][] twoDArrayCopy = Arrays.copyOf(twoDArray, k);

        System.out.println(" <<<<<<  Copy of 2d Array with K size  >>>>>");
        System.out.println(" ");
        for(int[] a : twoDArrayCopy){
            System.out.println(Arrays.toString(a));
        }

        // Sort by Index
        // Arrays.sort(twoDArrayCopy, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(twoDArrayCopy, (a, b) -> a[0] - b[0]);

        System.out.println(" ");
        System.out.println(" <<<<<<  2d Array sorted by index (Arrays.sort(twoDArray, (a, b) -> a[0] - b[0]) ) or Arrays.sort(twoDArrayCopy, Comparator.comparingInt(a -> a[0]))  >>>>>");
        for(int[] a : twoDArrayCopy){
            System.out.println(Arrays.toString(a));
        }

        int[] resultArray = new int[k];
        for (int i = 0; i < k; ++i) {
            resultArray[i] = twoDArrayCopy[i][1];
        }
        return resultArray;
    }

    public static void main(String args[]) throws Exception {
        int[] arr = {4, 6, 2, 7, 19, 12, 3};
        int[] arr2 = {63,-74,61,-17,-55,-59,-10,2,-60,-65};
        int[] arr3 = {2,1,3,3};
        int[] arr4 =  {-1,-2,3,4};
        int[] arr5 = {-8,-94,-30,-98,-27,62,26};
        int k = 7;

        int[] newA = maxSubsequence(arr5 , k);
        System.out.println(" A subsequence of nums of length K that has a largest sum  is: ====> " +  Arrays.toString(newA));
    }
}


