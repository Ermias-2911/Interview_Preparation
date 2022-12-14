package InterviewPractice2020.Numbers.SubArrayProblems;
// Given an array print all the sum of the subset generated from it, in the increasing order.
// Input: N = 3, arr[] = {5,2,1}
//
//Output: 0,1,2,3,5,6,7,8 = 32

public class FindSumOfAllSubsets {

    static int sumOfSubset(int[] arr, int n) {

        int times = (int) Math.pow(2, n - 1);

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + (arr[i] * times);
        }

        return sum;
    }


    public static void main(String args[]) {

        System.out.println(" <<<<<>>>>>>");
        int[] arr = {5, 2, 1};
        int n = arr.length;
        System.out.println(sumOfSubset(arr, n));
    }

}