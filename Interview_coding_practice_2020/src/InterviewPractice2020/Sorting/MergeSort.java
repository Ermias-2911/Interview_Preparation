package InterviewPractice2020.Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int arr[]) {

        if (arr.length > 1) {

            int m = arr.length / 2;

            int[] L = new int[m];
            int[] R = new int[arr.length - m];


            // Coping value to Right array
            for (int i = 0; i < R.length; i++) {

                R[i] = arr[m + i];

            }

            System.out.println("The value of Righ Array" + Arrays.toString(R));

            // Coping value to Left array
            for (int j = 0; j < m; j++) {

                L[j] = arr[j];

            }

            mergeSort(L);

            mergeSort(R);

            merge(arr, L, R);

        }

    }

    public static void merge(int[] arr, int[] L, int[] R) {

        int i = 0, j = 0, k = 0;

        while (i < L.length && j < R.length) {

            if (L[i] < R[j]) {

                arr[k] = L[i];
                i++;
            } else {

                arr[k] = R[j];
                j++;
            }

            k++;

        }

        while (i < L.length) {

            arr[k] = L[i];
            i++;
            k++;

        }

        while (j < R.length) {

            arr[k] = R[j];
            j++;
            k++;
        }

    }

    // Driver method to test above
    public static void main(String args[]) {
        int arr[] = {5, 10, 6, 7, 11, 13, 1, 4, 2};

        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {

            System.out.println("Sorted array " + arr[i]);
        }

    }

}

