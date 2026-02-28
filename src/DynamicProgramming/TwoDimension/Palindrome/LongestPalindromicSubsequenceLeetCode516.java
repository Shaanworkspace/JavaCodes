package DynamicProgramming.TwoDimension.Palindrome;

public class LongestPalindromicSubsequenceLeetCode516 {

	public int longestPalindromeSubseqRecursion(String s) {
		return helpRecursion(0, s.length()-1, s);
	}

	private int helpRecursion(int i, int j, String s) {
		if (i > j) return 0;
		if (i == j) return 1;
		if (s.charAt(i) == s.charAt(j)) {
			return 2 + helpRecursion(i + 1, j - 1, s);
		}
		return Math.max(helpRecursion(i + 1, j, s), helpRecursion(i, j - 1, s));
	}

	public int longestPalindromeSubseqRecursionMemo(String s) {
		// length bhi n tk aur n tk
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		return helpRecursionMemo(0, n-1, s,dp);
	}

	private int helpRecursionMemo(int i, int j, String s, int[][] dp) {
		if (i > j) return 0;
		if (i == j) return 1;
		if(dp[i][j]!=-1) return dp[i][j];
		if (s.charAt(i) == s.charAt(j)) return dp[i][j] = 2 + helpRecursionMemo(i + 1, j - 1, s,dp);
		else return dp[i][j] = Math.max(helpRecursionMemo(i + 1, j, s,dp), helpRecursionMemo(i, j - 1, s,dp));
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

	private static void runTest(LongestPalindromicSubsequenceLeetCode516 solver,
	                            String s, int expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : s = \"" + s + "\"");
		System.out.println("Expected  : " + expected);

		int recursion = solver.longestPalindromeSubseqRecursion(s);
		int memo = solver.longestPalindromeSubseqRecursionMemo(s);
		int tabulation = solver.longestPalindromeSubseqTabulation(s);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		LongestPalindromicSubsequenceLeetCode516 solver = new LongestPalindromicSubsequenceLeetCode516();

		System.out.println("=================================================");
		System.out.println("Longest Palindromic Subsequence - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"bbbab",
				4,
				"Test 1");

		runTest(solver,
				"cbbd",
				2,
				"Test 2");
	}
}