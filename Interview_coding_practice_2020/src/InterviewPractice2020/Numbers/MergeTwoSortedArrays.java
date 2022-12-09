package InterviewPractice2020.Numbers;

// Given two sorted arrays, X[] and Y[] of size m and n each, merge elements of X[] with elements of array Y[] by
// maintaining the sorted order, i.e., fill X[] with the first m smallest elements and fill Y[] with remaining elements.
// Time complexity is O(m.n), where m is the size of the first array and n is the size of the second array.
// Input:
//
//X[] = { 1, 4, 7, 8, 10 }
//Y[] = { 2, 3, 9 }
//
//Output:
//
//X[] = { 1, 2, 3, 4, 7 }
//Y[] = { 8, 9, 10 }

import java.util.Arrays;

public class MergeTwoSortedArrays {


    public static void merge(int[] arr1, int[] arr2)
    {

        for (int i = 0; i < arr1.length; i++)
        {
            // compare the current element of `X[]` with the first element of `Y[]`
            if (arr1[i] > arr2[0])
            {
                // swap between arr1 & arr2
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;

                // Fisrst value of arr2
                int first = arr2[0];


                int j;
                for (j = 1; j < arr2.length && arr2[j] < first; j++) {
                    arr2[j - 1] = arr2[j];
                }

                arr2[j - 1] = first;
            }
        }
    }

    public static void main (String[] args)
    {
        int[] arr1 = { 1, 4, 7, 8, 10 };
        int[] arr2 = { 2, 3, 9 };

        merge(arr1, arr2);

        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }
}