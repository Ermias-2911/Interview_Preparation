package InterviewPractice2020.Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Author Ermias Haile
// December 03-2020
// Find the total max length of 4 sub array of request from sub array.
// sub = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12]
// request[8, 11, 12]
// Output 5, 6, 7, 8
// Output 3, 4, 9, 10
// Output 1, 2, 12
// total 11

public class FindTotalSubArrayOfFixedLengthWithWhileLoop {


    public static void countRequest(List<Integer> sub, List<Integer> request) {

        Collections.sort(sub);
        System.out.println("lis: " + sub.toString());
        int leftIndex = 0;
        int count = 0;
        int total = 0;
        int i = 0;
        int j = 1;
        int requestValue = request.get(0);
        long startTime = System.nanoTime();

        while (i < sub.size() && leftIndex < sub.size()) {


            // request[8, 11, 12]     <=    sub = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12]
            if (sub.get(i) <= requestValue) {
                count++;
                i++;
                if (i == sub.size() && count <= 4) {
                    total += count;
                } else if (i == sub.size()) {
                    total += 4;
                }
            } else {
                // Then check max sub length
                if (count >= 4) {

                    if (count == 4) {
                        // remove the targeted subarray
                        sub.subList(leftIndex, i).clear();
                        total += count;

                        // get the next request value
                        if (j < request.size()) {
                            requestValue = request.get(j);
                            j++;
                        } else {
                            break;
                        }

                        i = 0;
                        leftIndex = 0;
                        count = 0;
                    } else {
                        leftIndex++;
                        count--;
                    }

                } else {
                    total += count;
                    // remove the targeted subarray
                    sub.subList(leftIndex, i).clear();

                    // get the next request value
                    if (j < request.size()) {
                        requestValue = request.get(j);
                        j++;
                    } else {
                        break;
                    }

                    i = 0;
                    leftIndex = 0;
                    count = 0;
                }

            }
        }
        long endTime = System.nanoTime();
        long resu = endTime - startTime;
        System.out.println("result: " + total  + " execution time taken: " + resu);
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 4, 7, 5, 8, 9, 6, 10, 3, 12};
        int[] ar = {3, 8, 12};

        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> request = Arrays.stream(ar)
                .boxed()
                .collect(Collectors.toList());

        countRequest(list, request);

    }
}




