package DynamicProgramming.OneDimension;

import java.util.*;

public class FrogJumpGFG {

	public int minCostRecursion(int[] height) {
		return jump(height, 0);
	}

	private int jump(int[] height, int idx) {
		if (idx == height.length - 1) return 0;
		int oneStep = jump(height, idx + 1) + Math.abs(height[idx] - height[idx + 1]);
		int twoStep = Integer.MAX_VALUE;
		if (idx + 2 < height.length) twoStep = jump(height, idx + 2) + Math.abs(height[idx] - height[idx + 2]);
		return Math.min(oneStep, twoStep);
	}


	public int minCostRecursionMemo(int[] height) {
		int[] memo = new int[height.length + 1];
		Arrays.fill(memo, -1);
		return jumpMemo(height, 0, memo);
	}

	private int jumpMemo(int[] height, int idx, int[] memo) {
		if (idx == height.length - 1) return 0;
		if (memo[idx] != -1) return memo[idx];
		int oneStep = jumpMemo(height, idx + 1, memo) + Math.abs(height[idx] - height[idx + 1]);
		int twoStep = Integer.MAX_VALUE;
		if (idx + 2 < height.length)
			twoStep = jumpMemo(height, idx + 2, memo) + Math.abs(height[idx] - height[idx + 2]);
		return memo[idx] = Math.min(oneStep, twoStep);
	}


	public int minCostTabulation(int[] height) {
		int n = height.length;
		int[] memo = new int[n];
		memo[n - 1] = 0;

		for (int i = n-2; i >=0; i--) {
			int oneStep = memo[i + 1] + Math.abs(height[i] - height[i + 1]);
			int twoStep = Integer.MAX_VALUE;
			if (i + 2 < n)
				twoStep = memo[i + 2] + Math.abs(height[i] - height[i + 2]);
			memo[i] = Math.min(oneStep, twoStep);
		}
		return memo[0];
	}

	public int minCostSpaceOptimised(int[] height) {
		int n = height.length;
		// Dp or curr -> depend on memo[i+1] and memo[i+2]
		int memo1 = 0;
		int memo2 = 0;
		int curr = 0;

		for (int i = n-2; i >=0; i--) {
			int oneStep = memo1 + Math.abs(height[i] - height[i + 1]);
			int twoStep = Integer.MAX_VALUE;
			if (i + 2 < n)
				twoStep = memo2 + Math.abs(height[i] - height[i + 2]);
			curr = Math.min(oneStep, twoStep);

			// swaping
			// memo2 -> memo1 -> curr ==> swap a step forward
			memo2 = memo1;
			memo1 = curr;
		}
		return memo1;
	}
	private static void runTest(FrogJumpGFG solver,
	                            int[] height, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : height = " + Arrays.toString(height));
		System.out.println("Expected  : " + expected);

		int r = solver.minCostRecursion(height);
		int m = solver.minCostRecursionMemo(height);
		int t = solver.minCostTabulation(height);
		int s = solver.minCostSpaceOptimised(height);

		System.out.printf("Recursion        : %-10d %s%n",
				r, r == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				m, m == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				t, t == expected ? "PASS" : "FAIL");
		System.out.printf("Space       : %-10d %s%n",
				s,s == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		FrogJumpGFG solver = new FrogJumpGFG();

		System.out.println("=================================================");
		System.out.println("Frog Jump (Min Cost) - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{20, 30, 40, 20},
				20,
				"Test 1");

		runTest(solver,
				new int[]{30, 20, 50, 10, 40},
				30,
				"Test 2");
	}
}
