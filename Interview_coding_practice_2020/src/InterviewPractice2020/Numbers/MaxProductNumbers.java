package InterviewPractice2020.Numbers;
// Author Ermias Haile
// August 25, 2020
// Max Produc numbers

public class MaxProductNumbers {

		public static int maxProduct(int[] nums) {
			int current_max = nums[0];
			int current_min = 1;

			int prev_max = nums[0];
			int prev_min = nums[0];
			int ans = nums[0];

			for (int i = 1; i < nums.length; i++) {
				current_max = Math.max(prev_max * nums[i], Math.max(prev_min * nums[i], nums[i]));
				current_min = Math.min(prev_max * nums[i], Math.min(prev_min * nums[i], nums[i]));

				ans = Math.max(ans, current_max);

				prev_max = current_max;
				prev_min = current_min;
			}
			return ans;
		}

		public static void main(String[] args) {
			int[] nums = {2, 3, -2, 4};

			int result = maxProduct(nums);
			System.out.println(" Max product is : " + result);
		}
	}
