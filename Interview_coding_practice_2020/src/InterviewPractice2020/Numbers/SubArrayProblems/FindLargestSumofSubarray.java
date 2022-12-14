package InterviewPractice2020.Numbers.SubArrayProblems;

// Given an array arr[] of size N. The task is to find the sum of the contiguous subarray within a arr[] with the largest sum.
public class FindLargestSumofSubarray {


    // Function Call
    static int maxSubArraySum(int arr[])
    {
        int size = arr.length;
        int max = Integer.MIN_VALUE;
        int current_max = 0;

        for (int i = 0; i < size; i++) {

            current_max = current_max + arr[i];

            if (max < current_max)
                max = current_max;

            // Reset -current_max to 0 (to ignore - sum)
            if (current_max < 0)
                current_max = 0;
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Largest contiguous sum is "
                + maxSubArraySum(a));
    }
}