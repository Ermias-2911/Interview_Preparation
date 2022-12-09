package InterviewPractice2020.Numbers;
import java.util.Arrays;


// Find the maximum product of two integers in an array
// Solution has a time complexity O(n.log(n)) if we use 2 nested loop time complexity will be O(n^2)
 class FindMaximumProductOfTwoIntegers {


    public static int[] findMaximumProduct(int[] arr){
        int[] reArray = new int[2];
        Arrays.sort(arr);
        int lastIndex = arr.length-1;

        if( (arr[0] * arr[1]) > (arr[lastIndex-1] * arr[lastIndex] )){
            reArray[0] = arr[0];
            reArray[1] = arr[1];
        }else {
            reArray[0] = arr[lastIndex-1];
            reArray[1] = arr[lastIndex];
        }

        return reArray;
    }


    // Second Way with O(n) time complexity
    public static void findMaximumProducts(int[] arr)
    {

        int max1 = arr[0], max2 = Integer.MIN_VALUE;
        int min1 = arr[0], min2 = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++)
        {
            // To find two max numbers
            if (arr[i] > max1)
            {
                max2 = max1;
                max1 = arr[i];

            } else if (arr[i] > max2) {
                max2 = arr[i];
            }

            // To find two min numbers
            if (arr[i] < min1)
            {
                min2 = min1;
                min1 = arr[i];
            } else if (arr[i] < min2) {
                min2 = arr[i];
            }

            // otherwise, ignore the element
        }


        if (max1 * max2 > min1 * min2) {
            System.out.print("  Pair is (" + max1 + ", " + max2 + ")");
        }
        else {
            System.out.print("  Pair is (" + min1 + ", " + min2 + ")");
        }
    }


    public static void main (String[] args)
    {
        int[] arr = { -10, -3, 5, 6, -2 };
        findMaximumProducts(arr);
        System.out.println( " ");
        int[] result = findMaximumProduct(arr);
        System.out.println(" The maximum product of two integers are ==> " + Arrays.toString(result));
    }
}

