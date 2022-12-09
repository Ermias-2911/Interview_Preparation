package InterviewPractice2020.Numbers;
//  Get the profit by first finding min value and subtracting from max value.
public class FindMinNumberAndMaxNumberThenSubtract {

    public static int maxProfit(int [] arr){
     if(arr.length == 0){
         return 0;
     }
     int min = arr[0];
     int max = 0;

     for (int i =0; i < arr.length; i++){
         if(arr[i] < min){
             min = arr[i];
         }
         if(arr[i] - min > max){
             max = arr[i] - min;
         }
     }

     return max;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(arr);
        System.out.println(" The max profix after we subract min from max is:  ==> " + result);
    }
}
