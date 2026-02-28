package DynamicProgramming.OneDimension;
import java.util.*;

public class VisitArrayPositionsToMaximizeScoreLeetCode2786 {

	public long maxScoreRecursion(int[] nums, int x) {
		int max =0;
		return helperRecursion(0, nums, x, 0, -1);
	}

	private long helperRecursion(int i, int[] nums, int penalty,
	                             long currSum, int lastParity) {
		if (i == nums.length) {
			return currSum;
		}


		long skip = helperRecursion(i + 1, nums, penalty, currSum, lastParity);
		int currParity = nums[i] % 2;
		long pick = (lastParity == -1 || lastParity == currParity) ? helperRecursion(
				i + 1,
				nums,
				penalty,
				currSum + nums[i],
				currParity
		) : helperRecursion(
				i + 1,
				nums,
				penalty,
				currSum + nums[i] - penalty,
				currParity
		);
		return Math.max(skip, pick);
	}

	public long maxScoreRecursionMemo(int[] nums, int x) {
		return 0;
	}

	public long maxScoreTabulation(int[] nums, int x) {
		return 0;
	}

	private static void runTest(VisitArrayPositionsToMaximizeScoreLeetCode2786 solver,
	                            int[] nums, int x, long expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : nums = " + Arrays.toString(nums) + ", x = " + x);
		System.out.println("Expected  : " + expected);

		long recursion = solver.maxScoreRecursion(nums.clone(), x);
		long memo = solver.maxScoreRecursionMemo(nums.clone(), x);
		long tabulation = solver.maxScoreTabulation(nums.clone(), x);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		VisitArrayPositionsToMaximizeScoreLeetCode2786 solver = new VisitArrayPositionsToMaximizeScoreLeetCode2786();

		System.out.println("=================================================");
		System.out.println("Visit Array Positions to Maximize Score - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{2, 3, 6, 1, 9, 2},
				5,
				13,
				"Test 1");

		runTest(solver,
				new int[]{2, 4, 6, 8},
				3,
				20,
				"Test 2");
	}
}