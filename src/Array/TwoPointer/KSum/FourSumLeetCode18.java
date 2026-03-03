package Array.TwoPointer.KSum;

import java.util.*;

public class FourSumLeetCode18 {

	// Method 1: Brute force idea (try yourself)
	public List<List<Integer>> fourSumMethod1(int[] nums, int target) {
		return new ArrayList<>();
	}

	// Method 2: Better approach (sorting + loops) (try yourself)
	public List<List<Integer>> fourSumMethod2(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		int n = nums.length;
		if (n < 4) return ans;


		Arrays.sort(nums);

		for (int i = 0; i < n - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;

			for (int j = i + 1; j < n - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) continue;

				int left = j + 1;
				int right = n - 1;

				while (left < right) {
					long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

						left++;
						right--;

						while (left < right && nums[left] == nums[left - 1]) left++;
						while (left < right && nums[right] == nums[right + 1]) right--;
					}
					else if (sum < target) {
						left++;
					}
					else {
						right--;
					}
				}
			}
		}
		return ans;
	}

	// Method 3: Optimized (two pointer technique) (try yourself)
	public List<List<Integer>> fourSumMethod3(int[] nums, int target) {
		return new ArrayList<>();
	}

	private static void runTest(FourSumLeetCode18 solver,
	                            int[] nums, int target,
	                            List<List<Integer>> expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(nums));
		System.out.println("Target    : " + target);
		System.out.println("Expected  : " + expected);

		List<List<Integer>> r1 = solver.fourSumMethod1(nums, target);
		List<List<Integer>> r2 = solver.fourSumMethod2(nums, target);
		List<List<Integer>> r3 = solver.fourSumMethod3(nums, target);

		System.out.printf("Method 1        : %-25s%n", r1);
		System.out.printf("Method 2        : %-25s%n", r2);
		System.out.printf("Method 3        : %-25s%n", r3);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		FourSumLeetCode18 solver =
				new FourSumLeetCode18();

		System.out.println("=================================================");
		System.out.println("4Sum - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1,0,-1,0,-2,2},
				0,
				Arrays.asList(
						Arrays.asList(-2,-1,1,2),
						Arrays.asList(-2,0,0,2),
						Arrays.asList(-1,0,0,1)
				),
				"Test 1");

		runTest(solver,
				new int[]{2,2,2,2,2},
				8,
				Arrays.asList(
						Arrays.asList(2,2,2,2)
				),
				"Test 2");
	}
}