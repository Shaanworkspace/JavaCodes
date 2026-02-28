package DynamicProgramming.TwoDimension.Palindrome;

public class MinimumInsertionStepsToMakeStringPalindromeLeetCode1312 {
	public int minInsertionsRecursion(String s) {
		return s.length()-longestPalindromeSubseqTabulation(s);
	}
	public int longestPalindromeSubseqTabulation(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = 1;
		}
		for(int i = n-1; i >=0; i--) {
			for (int j = i+1; j < dp[0].length; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][n - 1];
	}

	public int minInsertionsRecursionMemo(String s) {
		return 0;
	}

	public int minInsertionsTabulation(String s) {
		return 0;
	}

	private static void runTest(MinimumInsertionStepsToMakeStringPalindromeLeetCode1312 solver,
	                            String s, int expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : s = \"" + s + "\"");
		System.out.println("Expected  : " + expected);

		int recursion = solver.minInsertionsRecursion(s);
		int memo = solver.minInsertionsRecursionMemo(s);
		int tabulation = solver.minInsertionsTabulation(s);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		MinimumInsertionStepsToMakeStringPalindromeLeetCode1312 solver = new MinimumInsertionStepsToMakeStringPalindromeLeetCode1312();

		System.out.println("=================================================");
		System.out.println("Minimum Insertion Steps to Make a String Palindrome - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"zzazz",
				0,
				"Test 1");

		runTest(solver,
				"mbadm",
				2,
				"Test 2");

		runTest(solver,
				"leetcode",
				5,
				"Test 3");
	}
}