package InterviewPractice2020.Numbers.SubsequenceProblems;

// Given an integer array, find the maximum sum of subsequence where the subsequence contains no element at adjacent positions.
// The time complexity of the above solution is O(n) and requires O(n) extra space
// Input:  { 1, 2, 9, 4, 5, 0, 4, 11, 6 }
//Output: The maximum sum is 26
//
//The maximum sum is formed by subsequence { 1, 9, 5, 11 }

import java.util.Arrays;

public class FindMaxSumOfSubsequenceWithNoAdjacentElements {

    public static int findMaxSumSubsequence(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // base case
        if (nums.length == 1) {
            return nums[0];
        }

        System.out.println(" Array nums: ===> " + Arrays.toString(nums));
        // store maximum sum until index `i-2`
        int prev_prev = nums[0];

        // stores maximum sum until index `i-1`
        int prev = Integer.max(nums[0], nums[1]);

        System.out.println(" <<<<<<<<<<<< Loop Start >>>>>>>>>>>>> ");
        // start from index 2
        for (int i = 2; i < nums.length; i++) {

            // `curr` stores the maximum sum until index `i`
            int curr = Integer.max(nums[i], Integer.max(prev, prev_prev + nums[i]));
            System.out.println(" ****** curr = Integer.max(nums[i], Integer.max(prev, prev_prev + nums[i])) *********");
            System.out.println(" curr ===> " + curr + " max(" + nums[i] + " , " + "Integer.max(" + prev + " , " + " (" + prev_prev + " + " + nums[i] + " ))");

            prev_prev = prev;
            System.out.println(" prev_prev = prev : ===> " + prev_prev);

            prev = curr;
            System.out.println(" prev = curr : ===> " + prev);
            System.out.println(" ");
        }

        // return maximum sum
        return prev;
    }

        public static void main (String[] args){
            int[] nums = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
            System.out.println("The maximum sum is " + findMaxSumSubsequence(nums));
            // Expected output: The maximum sum is formed by subsequence { 1, 9, 5, 11 }
        }
}