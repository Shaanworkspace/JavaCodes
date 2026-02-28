package DynamicProgramming.TwoDimension.Subsequence;
import java.util.*;

public class DeleteOperationForTwoStringsLeetCode583 {

	public int minDistanceRecursion(String word1, String word2) {
		int lcs = longestCommonSubsequenceTabulation(word1,word2);
		return word1.length()+word2.length()-(2*lcs);
	}
	public int longestCommonSubsequenceTabulation(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int[][] dp = new int[l1 + 1][l2 + 1];
		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[l1][l2];
	}

	public int minDistanceRecursionMemo(String word1, String word2) {
		return 0;
	}

	public int minDistanceTabulation(String word1, String word2) {
		return 0;
	}

	private static void runTest(DeleteOperationForTwoStringsLeetCode583 solver,
	                            String word1, String word2, int expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : word1 = \"" + word1 + "\", word2 = \"" + word2 + "\"");
		System.out.println("Expected  : " + expected);

		int recursion = solver.minDistanceRecursion(word1, word2);
		int memo = solver.minDistanceRecursionMemo(word1, word2);
		int tabulation = solver.minDistanceTabulation(word1, word2);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		DeleteOperationForTwoStringsLeetCode583 solver = new DeleteOperationForTwoStringsLeetCode583();

		System.out.println("=================================================");
		System.out.println("Delete Operation for Two Strings - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"sea",
				"eat",
				2,
				"Test 1");

		runTest(solver,
				"leetcode",
				"etco",
				4,
				"Test 2");
	}
}