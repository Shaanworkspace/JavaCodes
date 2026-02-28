package Array.SlidingWindow;

import java.util.*;

public class MinimumDifferenceBetweenHighestAndLowestOfKScoresLeetCode1984 {

	public int minimumDifferenceBrute(int[] nums, int k) {
		int n = nums.length;
		if(n==1 || k==1) return 0;
		if(n<k) return 0;
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i + k - 1 < n; i++) {
			int currentDiff = nums[i + k - 1] - nums[i];
			diff = Math.min(diff, currentDiff);
		}
		return diff;
	}


	public int minimumDifferenceTryYourSelf(int[] nums, int k) {
		return 0;
	}

	public int minimumDifference(int[] nums, int k) {
		return 0;
	}

	private static void runTest(MinimumDifferenceBetweenHighestAndLowestOfKScoresLeetCode1984 solver,
	                            int[] nums, int k, int expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : nums = " + Arrays.toString(nums) + ", k = " + k);
		System.out.println("Expected  : " + expected);

		int brute = solver.minimumDifferenceBrute(nums.clone(), k);
		int your  = solver.minimumDifferenceTryYourSelf(nums.clone(), k);
		int opt   = solver.minimumDifference(nums.clone(), k);

		System.out.printf("Brute Force      : %-10d %s%n",
				brute, brute == expected ? "PASS" : "FAIL");
		System.out.printf("TryYourSelf      : %-10d %s%n",
				your,  your == expected ? "PASS" : "FAIL");
		System.out.printf("Optimized (O(n log n)) : %-10d %s%n",
				opt,   opt == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		MinimumDifferenceBetweenHighestAndLowestOfKScoresLeetCode1984 solver = new MinimumDifferenceBetweenHighestAndLowestOfKScoresLeetCode1984();

		System.out.println("=================================================");
		System.out.println("Minimum Difference Between Highest and Lowest of K Scores - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{90},
				1,
				0,
				"Test 1");

		runTest(solver,
				new int[]{9, 4, 1, 7},
				2,
				2,
				"Test 2");

		runTest(solver,
				new int[]{87063, 61094, 44530, 21297, 95857, 93551, 9918},
				6,
				74560,
				"Test 3");
	}
}