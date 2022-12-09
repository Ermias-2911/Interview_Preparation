package InterviewPractice2020.Numbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            // Optimal way to check. We can use set.contains() but it is a bit slow
            if (!set.add(arr[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 2, 5,  6};
        int[] ar = {1, 2, 9, 4, 5,  6};
        boolean result = containsDuplicate(arr);
        System.out.println(Arrays.toString(arr) + " Contains Duplicate: ==> " + result);
    }
}