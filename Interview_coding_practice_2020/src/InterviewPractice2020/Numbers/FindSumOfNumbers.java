package InterviewPractice2020.Numbers;

import java.util.*;

public class FindSumOfNumbers {

	public static void findSum(int[] arr, int n) {
		Queue<Integer> save = new PriorityQueue<>();

		//Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int target = n - arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (target == arr[j]) {
					save.add(i);
					save.add(j);
				}
//				if (target > arr[j]) {
//					break;
//				}
			}
		}
		while (!save.isEmpty()) {
			System.out.println(save.poll() + " : " + save.poll());
		}
	}
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public static void findSum2(int[] arr, int n) {
		List<Integer> li = new ArrayList<>();
		li.add(-1);
		li.add(-1);
		int[][] copyArray = new int[arr.length][2];
		int[][] arrR = new int[arr.length/2][2];
		for (int i = 0; i < arr.length; i++) {
			copyArray[i][0] = arr[i];
			copyArray[i][1] = i;
		}

		Arrays.sort(copyArray, (a, b) -> a[0] - b[0]);

		int i = 0;
		int j = copyArray.length - 1;
		int max = 0;
		int ii = 0;
		while (i < j) {
			int sum = copyArray[j][0] + copyArray[i][0];
			if (sum > n) {
				j--;
			} else {
				if (sum >= max) {
					max = sum;

					arrR[ii][0] = copyArray[i][1];
					arrR[ii][1] = copyArray[j][1];
					//ii++;
//					li.set(0,copyArray[i][1]);
//					li.set(1,copyArray[j][1]);
				}
				i++;
			}
		}

		System.out.println(" Output from second ");
		for (int x = 0; x <= arrR.length - 1; x++) {
			if(arrR[x][0] == 0 && arrR[x][1] == 0){
				break;
			}else{
				System.out.println(arrR[x][0] + " : " + arrR[x][1]);
			}

		}
	}

	public static void main(String args[]) throws Exception {
		int[] arr = {4, 6, 2, 7, 19, 12, 3};
		int n = 10;
		findSum(arr, n);
		findSum2(arr, n);

		System.out.println(" <==================  Sorted Output =================> ");

	}
}
