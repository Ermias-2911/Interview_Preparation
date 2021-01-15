package InterviewPractice2020.Numbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindTotalSubArrayOfFixedLength {
    public static void countRequest(List<Integer> sub, List<Integer> request) {


        Collections.sort(sub);

        System.out.println("lis: " + sub.toString());
        int result = 0;
        long startTime = System.nanoTime();
        for (int j = 0; j < request.size(); j++) {
            result += findSubLength(sub, request.get(j));
        }
        long endTime = System.nanoTime();
        long resu = endTime - startTime;
        System.out.println("re: " + result + " execution time: " + resu);


    }

    public static int findSubLength(List<Integer> lis, int sub) {
        int leftIndex = 0;
        int count = 0;
        int i = 0;

        while (i < lis.size() && leftIndex < lis.size()) {

            if (lis.get(i) <= sub) {
                count++;
                i++;
            } else if (count >= 4) {

                if (count == 4) {
                    lis.subList(leftIndex, i).clear();
                    return count;
                }
                leftIndex++;
                count--;
            } else {
                return count;
            }

        }
        return count;
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 4, 7, 5, 8, 12, 9, 6, 10, 3};
        int[] ar = {8, 11, 12};

        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> request = Arrays.stream(ar)
                .boxed()
                .collect(Collectors.toList());

        countRequest(list, request);

    }
}



