package InterviewPractice2020.Numbers;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.List;


// Author Ermias Haile
// December 10-2020
// Count Periods of stabel velocity
// Count the number of period of time when the movement is stable between consecutive number
// The movement between two consecutive number remain the same (it doesn't change the velocity)

public class CountPeriodsOfStabelVelocity {

    public static int stablePeriods(int[] arr) {
        int result = 0;
        int result1 = 0;
        for (int i = 1; i < arr.length; i++) {
            int length = 0;
            int diff = arr[i] - arr[i - 1];

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[j - 1] != diff)
                    break;
                length++;
            }
            // (length * (length + 1))/ 2 is reseteR. When length is 0, it will keep the result as it is.
            result1 += length;
            result += (length * (length + 1)) / 2;
            System.out.println("length: " + length);
            System.out.println("result1: " + result1);
            i += length;
        }
        return result;
    }


    public static void main(String args[]) {

        int[] arr = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {7, 7, 7, 7};
        int[] arr3 = {3, -1, -5, -9};
        int[] arr4 = {0, 1};

        List<int[]> testList = new ArrayList<>();
        testList.add(arr);
        testList.add(arr1);
        testList.add(arr2);
        testList.add(arr3);
        testList.add(arr4);

        System.out.println("\n>>>>>>>>>>>>>>>> Test Cases <<<<<<<<<<<<<<<<");
        for (int i = 0; i < testList.size(); i++) {
            int re = stablePeriods(testList.get(i));
            if (i == 0) {
                assertEquals(5, re);
                System.out.println("5 = " + re + " Pass");
            } else if (i == 2) {
                assertEquals(3, re);
                System.out.println("3 = " + re + " Pass");
            } else if (i == 1) {
                assertEquals(6, re);
                System.out.println("6 = " + re + " Pass");
            } else if (i == 3) {
                assertEquals(3, re);
                System.out.println("3 = " + re + " Pass");
            } else if (i == 4) {
                assertEquals(0, re);
                System.out.println("0 = " + re + " Pass");
            }
        }
    }
}




