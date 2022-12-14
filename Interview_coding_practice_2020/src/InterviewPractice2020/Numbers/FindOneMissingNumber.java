package InterviewPractice2020.Numbers;

import java.util.Arrays;

public class FindOneMissingNumber {
    public static int missinfNumber(int[] arr) {
        int n = arr.length;
        int i, total;
        total = (n + 1) * (n + 2) / 2;
        for (i = 0; i < n; i++)
            total -= arr[i];
        return total;
    }

    public static void main(String args[]) throws Exception {
        int[] arr = {4, 6, 2, 7, 3, 8, 1};

     int result = missinfNumber(arr);
        System.out.println(" The missing number is: ====> " + result);

    }
}

