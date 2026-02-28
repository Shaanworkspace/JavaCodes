package DynamicProgramming.TwoDimension.Subsequence;

public class LongestCommonSubsequenceLeetCode1143 {

	public int longestCommonSubsequenceRecursion(String text1, String text2) {
		int l1 = text1.length();
		int l2 = text2.length();
		return helperRecu(text1, l1 - 1, text2, l2 - 1);
	}

	private int helperRecu(String s1, int i, String s2, int j) {
		if(i<0 || j<0) return 0;
		if (s1.charAt(i) == s2.charAt(j))
			return 1 + helperRecu(s1, i - 1, s2, j - 1);
		return Math.max(helperRecu(s1, i - 1, s2, j), helperRecu(s1, i, s2, j - 1));
	}

	public int longestCommonSubsequenceRecursionMemo(String text1, String text2) {
		int l1 = text1.length();
		int l2 = text2.length();
		int[][] dp = new int[l1+1][l2+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		return helperRecuMemo(text1, l1 - 1, text2, l2 - 1,dp);
	}

	private int helperRecuMemo(String s1, int i, String s2, int j, int[][] dp) {
		if(i<0 || j<0) return 0;
		if(dp[i][j]!=-1) return dp[i][j];
		if (s1.charAt(i) == s2.charAt(j))
			return dp[i][j] = (1 + helperRecuMemo(s1, i - 1, s2, j - 1, dp));
		return dp[i][j] = Math.max(helperRecuMemo(s1, i - 1, s2, j, dp), helperRecuMemo(s1, i, s2, j - 1, dp));
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

	private static void runTest(LongestCommonSubsequenceLeetCode1143 solver,
	                            String text1, String text2, int expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : text1 = \"" + text1 + "\", text2 = \"" + text2 + "\"");
		System.out.println("Expected  : " + expected);

		int recursion = solver.longestCommonSubsequenceRecursion(text1, text2);
		int memo = solver.longestCommonSubsequenceRecursionMemo(text1, text2);
		int tabulation = solver.longestCommonSubsequenceTabulation(text1, text2);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		LongestCommonSubsequenceLeetCode1143 solver = new LongestCommonSubsequenceLeetCode1143();

		System.out.println("=================================================");
		System.out.println("Longest Common Subsequence - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"abcde",
				"ace",
				3,
				"Test 1");

		runTest(solver,
				"abc",
				"abc",
				3,
				"Test 2");

		runTest(solver,
				"abc",
				"def",
				0,
				"Test 3");
	}
}