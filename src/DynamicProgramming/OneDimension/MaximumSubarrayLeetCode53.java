package DynamicProgramming.OneDimension;
import java.util.*;

public class MaximumSubarrayLeetCode53 {

	//Kadan algo
	public int maxSubArrayMethod1(int[] nums) {
		int curr = nums[0];
		int best = nums[0];

		for(int i = 1; i < nums.length; i++){
			curr = Math.max(nums[i], curr + nums[i]);
			best = Math.max(best, curr);
		}
		return best;
	}

	public int maxSubArrayMethod2(int[] nums) {
		return 0;
	}

	public int maxSubArrayMethod3(int[] nums) {
		return 0;
	}

	private static void runTest(MaximumSubarrayLeetCode53 solver,
	                            int[] nums, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : nums = " + Arrays.toString(nums));
		System.out.println("Expected  : " + expected);

		int method1 = solver.maxSubArrayMethod1(nums);
		int method2 = solver.maxSubArrayMethod2(nums);
		int method3 = solver.maxSubArrayMethod3(nums);

		System.out.printf("Method 1         : %-10d %s%n",
				method1, method1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				method2, method2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				method3, method3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		MaximumSubarrayLeetCode53 solver =
				new MaximumSubarrayLeetCode53();

		System.out.println("=================================================");
		System.out.println("Maximum Subarray - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{-2,1,-3,4,-1,2,1,-5,4},
				6,
				"Test 1");

		runTest(solver,
				new int[]{1},
				1,
				"Test 2");

		runTest(solver,
				new int[]{5,4,-1,7,8},
				23,
				"Test 3");
	}
}