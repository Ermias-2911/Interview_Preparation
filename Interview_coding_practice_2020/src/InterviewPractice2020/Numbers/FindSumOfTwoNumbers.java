package InterviewPractice2020.Numbers;

import java.util.*;
// The sum of tow numbers indices.
// Note this only work for non duplicate numbers since we can't save duplicate value in Map as a key.
public class FindSumOfTwoNumbers {

	public static  int[]  sumOfTwoNumber(int[] num, int target){
		Map<Integer, Integer> map = new HashMap<>();

		for(int i =0; i < num.length; i++){
			int sum = target -	num[i];
			if(map.containsKey(sum)){

				return  new int[] { map.get(sum), i};
			}else{
				map.put(num[i], i);
			}
		}
		return  new int[0];
	}

	public static void main(String args[]) throws Exception {
		int[] arr = {4, 6, 2, 7, 19, 12, 3};
		int n = 10;

		int[] result = sumOfTwoNumber(arr, n);
		System.out.println(" Sum of two numbers indexes are: ====> " + Arrays.toString(result));

	}
}
