package Array.TwoPointer;

import java.util.*;

public class ThreeSumClosestLeetCode16 {

	// Method 1: Brute force idea (try yourself)
	public int threeSumClosestMethod1(int[] nums, int target) {
		int sum =0;

		// generate all three pairs
		




		return sum;

	}

	// Method 2: Better approach (sorting + improvement) (try yourself)
	public int threeSumClosestMethod2(int[] nums, int target) {
		return 0;
	}

	// Method 3: Optimized two-pointer approach (try yourself)
	public int threeSumClosestMethod3(int[] nums, int target) {
		return 0;
	}

	private static void runTest(ThreeSumClosestLeetCode16 solver,
	                            int[] nums, int target,
	                            int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(nums));
		System.out.println("Target    : " + target);
		System.out.println("Expected  : " + expected);

		int r1 = solver.threeSumClosestMethod1(nums, target);
		int r2 = solver.threeSumClosestMethod2(nums, target);
		int r3 = solver.threeSumClosestMethod3(nums, target);

		System.out.printf("Method 1        : %-5d %s%n",
				r1, r1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-5d %s%n",
				r2, r2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3        : %-5d %s%n",
				r3, r3 == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		ThreeSumClosestLeetCode16 solver =
				new ThreeSumClosestLeetCode16();

		System.out.println("=================================================");
		System.out.println("3Sum Closest - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{-1,2,1,-4},
				1,
				2,
				"Test 1");

		runTest(solver,
				new int[]{0,0,0},
				1,
				0,
				"Test 2");
	}
}