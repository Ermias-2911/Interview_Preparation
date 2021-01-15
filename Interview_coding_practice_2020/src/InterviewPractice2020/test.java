package InterviewPractice2020;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

// Author Ermias Haile
// December 10-2020
// Count Periods of stabel velocity
// Count the number of period of time when the movement is stable between consecutive number
// The movement between two consecutive number remain the same (it doesn't change the velocity)


public class test {

    public static int minMoves(List<Integer> arr) {
        int j = -1;
        int count = 1;

        for (int i = 0; i < arr.size(); i++) {

            if (arr.get(i) < 1) {
                j++;
                int temp = arr.get(j);
                arr.set(j, arr.get(i));
                arr.set(i, temp);
                count++;
            }
        }

        if (count == 1) {
            return 0;
        } else {
            return count;
        }
    }


    public static void main(String args[]) {

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);

        int s = minMoves(arr);
        System.out.println("re : " + s);

        List<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(0);
        arr2.add(1);
        arr2.add(0);
        arr2.add(0);
        arr2.add(0);
        arr2.add(0);
        arr2.add(1);
        minMoves(arr2);
        int s1 = minMoves(arr2);
        System.out.println("re1 : " + s1);


    }
}



