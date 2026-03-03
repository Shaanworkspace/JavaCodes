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
	int sum1,min;
	public int threeSumClosestMethod2(int[] nums, int target) {
		// Generate all subsequence
		sum1=0;
		min=Integer.MAX_VALUE;
		generateSumOfThree(nums,target,0,0,0);
		return sum1;
	}

	private void generateSumOfThree(int[] nums, int target, int idx, int sum, int len) {
		if (len == 3) {
			int diff = Math.abs(sum - target);
			if (diff < min) {
				min = diff;
				sum1 = sum;
			}
			return;
		}

		if (idx >= nums.length) return;
		//pick
		generateSumOfThree(nums,target,idx+1,sum+nums[idx], len+1);

		//skip
		generateSumOfThree(nums,target,idx+1,sum, len);
	}

	// Method 3: Optimized two-pointer approach (try yourself)
	public int threeSumClosestMethod3(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		int closest = nums[0] + nums[1] + nums[2];

		for (int i = 0; i < n - 2; i++) {
			int left = i + 1;
			int right = n - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (Math.abs(sum - target) < Math.abs(closest - target)) {
					closest = sum;
				}

				if (sum < target) {
					left++;
				} else if (sum > target) {
					right--;
				} else {
					return sum;
				}
			}
		}
		return closest;
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

		runTest(solver,
				new int[]{0,1,2},
				3,
				3,
				"Test 3");
	}
}