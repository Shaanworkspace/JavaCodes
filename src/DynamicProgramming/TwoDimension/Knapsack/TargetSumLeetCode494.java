package DynamicProgramming.TwoDimension.Knapsack;
import java.util.*;

public class TargetSumLeetCode494 {

	public int findTargetSumWaysRecursion(int[] nums, int target) {
		int n = nums.length;

		return helperRecursion(0,0,nums,target);
	}

	private int helperRecursion(int i, int sum, int[] nums, int target) {
		if(i==nums.length){
			return (sum==target) ? 1:0;
		}
		int skip = helperRecursion(i+1,sum-nums[i],nums,target);
		int pick = helperRecursion(i+1,sum+nums[i],nums,target);
		return skip+pick;
	}

	public int findTargetSumWaysRecursionMemo(int[] nums, int target) {
		int n = nums.length;
		int sum =0;
		for(int a : nums){
			sum+=a;
		}
		// length : 0 to n AND sum : 0 to 2*sum
		int[][] dp = new int[n][2*sum+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		return helperRecursionMemo(0,0,nums,target,dp,sum);
	}

	private int helperRecursionMemo(int i, int sum, int[] nums, int target, int[][] dp, int totalSum) {
		if(i==nums.length){
			return (sum==target) ? 1:0;
		}
		if(dp[i][sum+totalSum]!=-1) return dp[i][sum+totalSum];
		int skip = helperRecursionMemo(i+1,sum-nums[i],nums,target, dp, totalSum);
		int pick = helperRecursionMemo(i+1,sum+nums[i],nums,target, dp, totalSum);
		return dp[i][sum+totalSum] = (skip+pick);
	}

	public int findTargetSumWaysTabulation(int[] nums, int target) {
		return 0;
	}

	private static void runTest(TargetSumLeetCode494 solver,
	                            int[] nums, int target, int expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : nums = " + Arrays.toString(nums) + ", target = " + target);
		System.out.println("Expected  : " + expected);

		int recursion = solver.findTargetSumWaysRecursion(nums.clone(), target);
		int memo = solver.findTargetSumWaysRecursionMemo(nums.clone(), target);
		int tabulation = solver.findTargetSumWaysTabulation(nums.clone(), target);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		TargetSumLeetCode494 solver = new TargetSumLeetCode494();

		System.out.println("=================================================");
		System.out.println("Target Sum - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1, 1, 1, 1, 1},
				3,
				5,
				"Test 1");

		runTest(solver,
				new int[]{1},
				1,
				1,
				"Test 2");
	}
}