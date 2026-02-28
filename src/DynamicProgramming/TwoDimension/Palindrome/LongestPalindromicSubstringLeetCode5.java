package DynamicProgramming.TwoDimension.Palindrome;
import java.util.*;

public class LongestPalindromicSubstringLeetCode5 {

	public String longestPalindromeRecursion(String s) {
		return "";
	}

	public String longestPalindromeRecursionMemo(String s) {
		return "";
	}

	public String longestPalindromeTabulation(String s) {
		int n = s.length(),max = 0,r=0,c=0;

		int[][] dp = new int[n][n];

		for (int k = 0; k < n; k++) { // will traverse in upper row
			int i = 0, j = k;
			while (j < n) {
				if (i == j) {
					dp[i][j] = 1;
					int len = Math.max(j-i+1,max);
					if( max != len){
						max = len;
						r=i;
						c=j;
					}
				} else if (j == i + 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 1;
						int len = Math.max(j-i+1,max);
						if( max != len){
							max = len;
							r=i;
							c=j;
						}
					}

				} else {
					//greater than 2
					if (s.charAt(i) == s.charAt(j)) {
						if (dp[i + 1][j - 1] == 1) {
							dp[i][j] = 1;
							int len = Math.max(j-i+1,max);
							if( max != len){
								max = len;
								r=i;
								c=j;
							}
						}
					}
				}
				i++;
				j++;
			}
		}
		return s.substring(r,c+1);
	}

	private static void runTest(LongestPalindromicSubstringLeetCode5 solver,
	                            String s, String expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : s = \"" + s + "\"");
		System.out.println("Expected  : \"" + expected + "\"");

		String recursion = solver.longestPalindromeRecursion(s);
		String memo = solver.longestPalindromeRecursionMemo(s);
		String tabulation = solver.longestPalindromeTabulation(s);

		System.out.printf("Recursion        : %-10s %s%n",
				recursion, recursion.length() == expected.length() ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10s %s%n",
				memo, memo.length() == expected.length() ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10s %s%n",
				tabulation, tabulation.length() == expected.length() ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		LongestPalindromicSubstringLeetCode5 solver =
				new LongestPalindromicSubstringLeetCode5();

		System.out.println("=================================================");
		System.out.println("Longest Palindromic Substring - Tests");
		System.out.println("=================================================\n");

		runTest(solver, "babad", "bab", "Test 1");
		runTest(solver, "cbbd", "bb", "Test 2");
	}
}

