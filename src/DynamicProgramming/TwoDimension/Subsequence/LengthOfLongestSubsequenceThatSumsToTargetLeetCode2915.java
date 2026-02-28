package DynamicProgramming.TwoDimension.Subsequence;

import java.util.*;

public class LengthOfLongestSubsequenceThatSumsToTargetLeetCode2915 {

	public int lengthOfLongestSubsequenceRecursion(List<Integer> nums, int target) {
		long ans = RecursionHelper(0,nums,target);
		return (int) ans;
	}

	private long RecursionHelper(int idx, List<Integer> nums, int target) {
		if (idx == nums.size()) {
			return (target == 0)? 0 : -1;
		}
		//to make subsequence either we pick or skip
		long skip = RecursionHelper(idx+1,nums,target);
		if(target-nums.get(idx)<0) return skip;
		long pick = -1;
		if (target >= nums.get(idx)) {
			pick = RecursionHelper(idx + 1, nums, target - nums.get(idx));
			if (pick != -1) pick++;
		}
		return Math.max(skip,pick);
	}

	public int lengthOfLongestSubsequenceRecursionMemo(List<Integer> nums, int target) {
		int n = nums.size();
		long[][] dp = new long[n][target+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		long ans = RecursionMemoHelper2(n-1,nums,target,dp);
		return (int) ans;
	}

	private long RecursionMemoHelper(int idx, List<Integer> nums, int target,long[][] dp ) {
		if (idx == nums.size())  {
			return (target == 0)? 0 : -1;
		}

		if(dp[idx][target]!=-1) return dp[idx][target];
		long skip = RecursionMemoHelper(idx+1,nums,target,dp);
		if(target-nums.get(idx)<0) return (dp[idx][target]=skip);
		long pick = -1;
		if (target >= nums.get(idx)) {
			pick = RecursionMemoHelper(idx + 1, nums, target - nums.get(idx),dp);
			if (pick != -1) pick++;
		}
		return dp[idx][target]=Math.max(skip,pick);
	}

	private long RecursionMemoHelper2(int idx, List<Integer> nums, int target,long[][] dp ) {
		if (idx < 0) {
			return (target == 0)? 0 : -1;
		}

		if(dp[idx][target]!=-1) return dp[idx][target];
		long skip = RecursionMemoHelper2(idx-1,nums,target,dp);
		if(target-nums.get(idx)<0) return (dp[idx][target]=skip);
		long pick = -1;
		if (target >= nums.get(idx)) {
			pick = RecursionMemoHelper2(idx - 1, nums, target - nums.get(idx),dp);
			if (pick != -1) pick++;
		}
		return dp[idx][target]=Math.max(skip,pick);
	}

	public int lengthOfLongestSubsequenceTabulation(List<Integer> nums, int target) {
		int n = nums.size();
		long[][] dp = new long[n][target+1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= target; j++) {
				dp[i][j] = -1;
			}
		}
		dp[0][0] = 0;
		if (nums.getFirst() <= target) {
			dp[0][nums.getFirst()] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				long skip = dp[i - 1][j];
				long pick = -1;
				if (j >= nums.get(i) && dp[i - 1][j - nums.get(i)] != -1) {
					pick = dp[i- 1][j - nums.get(i)] + 1;
				}
				dp[i][j]=Math.max(skip,pick);
			}
		}
		return (int) dp[n-1][target];
	}

	private static void runTest(LengthOfLongestSubsequenceThatSumsToTargetLeetCode2915 solver,
	                            List<Integer> nums, int target, int expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : nums = " + nums + ", target = " + target);
		System.out.println("Expected  : " + expected);

		int recursion = solver.lengthOfLongestSubsequenceRecursion(new ArrayList<>(nums), target);
		int memo = solver.lengthOfLongestSubsequenceRecursionMemo(new ArrayList<>(nums), target);
		int tabulation = solver.lengthOfLongestSubsequenceTabulation(new ArrayList<>(nums), target);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		LengthOfLongestSubsequenceThatSumsToTargetLeetCode2915 solver = new LengthOfLongestSubsequenceThatSumsToTargetLeetCode2915();

		System.out.println("=================================================");
		System.out.println("Length of Longest Subsequence That Sums to Target - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				Arrays.asList(1, 2, 3, 4, 5),
				9,
				3,
				"Test 1");

		runTest(solver,
				Arrays.asList(4, 1, 3, 2, 1, 5),
				7,
				4,
				"Test 2");

		runTest(solver,
				Arrays.asList(1, 1, 5, 4, 5),
				3,
				-1,
				"Test 3");
	}
}