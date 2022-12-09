package InterviewPractice2020.Numbers;

import java.util.Arrays;

public class SortingBinaryArrayInLinearTime {
    public static void sort(int[] arr)
    {
        // count number of 0's
        int zerosCount = 0;
        for (int value: arr)
        {
            if (value == 0) {
                zerosCount++;
            }
        }

        // put 0's at the beginning
        int k = 0;
        while (zerosCount != 0) {
            arr[k++] = 0;
            zerosCount --;
        }

        // fill all remaining elements by 1
        while (k < arr.length) {
            arr[k++] = 1;
        }
    }

    public static void main (String[] args)
    {
        int[] arr = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };

        sort(arr);

        // print the rearranged array
        System.out.println(Arrays.toString(arr));
    }
}
