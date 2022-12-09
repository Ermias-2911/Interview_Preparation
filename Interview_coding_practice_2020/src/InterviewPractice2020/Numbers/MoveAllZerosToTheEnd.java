package InterviewPractice2020.Numbers;
import java.util.Arrays;

// Move all zeros present in an array to the end. Time complexity is O(n)
public class MoveAllZerosToTheEnd {

    public static void reorder(int[] A)
    {
        int k = 0;


        for (int i: A)
        {
            if (i != 0) {
                A[k++] = i;
            }
        }

        for (int i = k; i < A.length; i++) {
            A[i] = 0;
        }
    }

    // Using Swap Time complexity O(n)
    public static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Function to move all zeros present in the array to the end
    public static void partition(int[] A)
    {
        int j = 0;

        for (int i = 0; i < A.length; i++)
        {
            if (A[i] != 0)        // pivot is 0
            {
                swap(A, i, j);
                j++;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] A = { 6, 0, 8, 2, 3, 0, 4, 0, 1 };

        partition(A);
        System.out.println(Arrays.toString(A));
    }
}