package InterviewPractice2020.Numbers.SubArrayProblems;

// Find the contiguous subarray with an array which has the largest product.
public class FindMaximumProductOfSubarray {

public  static int maxProduct(int[] arr){
    if(arr.length == 0){
        return 0;
    }
    int minProduct = arr[0];
    int maxProduct = arr[0];
    int sol = arr[0];

    for(int i =1; i < arr.length; i++){

        int temp1 = Math.min(arr[i] * minProduct, arr[i] * maxProduct);
        int temp2 = Math.max(arr[i] * maxProduct, arr[i] * minProduct);

        System.out.println(" temp1 = Math.min(arr[i] * minProduct, arr[i] * maxProduct): ===> " + temp1);
        System.out.println(" temp1 = Math.min(" + arr[i] *  minProduct + " , " +  arr[i] * maxProduct + "): ===> " + temp1);

        System.out.println(" temp2 = Math.max(arr[i] * maxProduct, arr[i] * minProduct): ===> " + temp2);
        System.out.println(" temp2 = Math.max(" + arr[i] *  minProduct + " , " +  arr[i] * maxProduct + "): ===> " + temp2);
        System.out.println(" ");

        minProduct =  Math.min(temp1,arr[i]);
        maxProduct =  Math.max(temp2,arr[i]);
        sol = Math.max(sol, maxProduct);

    }
    return  sol;
}

    public static void main (String[] args)
    {
        int[] arr = { 2, 3, -2,4 };
        int[] arr2 = { 2, 0, -2,-4 };

        int result = maxProduct(arr2);
        System.out.println(" Maximum product of subarray is: ===> " + result);
    }
}
