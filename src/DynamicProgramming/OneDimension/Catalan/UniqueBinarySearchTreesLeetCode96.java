package DynamicProgramming.OneDimension.Catalan;

import java.util.*;

public class UniqueBinarySearchTreesLeetCode96 {

	public int numTreesRecursion(int n) {
		return 0;
	}

	public int numTreesRecursionMemo(int n) {
		return 0;
	}

	public int numTreesTabulation(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1; dp[1] =1;
		for(int i = 2 ;i<=n;i++){
			for(int  j =1;j<=i;j++){
				dp[i] +=(dp[j-1] * dp[i-j]);
			}
		}
		return dp[n];
	}

	private static void runTest(UniqueBinarySearchTreesLeetCode96 solver,
	                            int n, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : n = " + n);
		System.out.println("Expected  : " + expected);

		int recursion = solver.numTreesRecursion(n);
		int memo = solver.numTreesRecursionMemo(n);
		int tabulation = solver.numTreesTabulation(n);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		UniqueBinarySearchTreesLeetCode96 solver =
				new UniqueBinarySearchTreesLeetCode96();

		System.out.println("=================================================");
		System.out.println("Unique Binary Search Trees - Tests");
		System.out.println("=================================================\n");

		runTest(solver, 3, 5, "Test 1");
		runTest(solver, 1, 1, "Test 2");
	}
}
