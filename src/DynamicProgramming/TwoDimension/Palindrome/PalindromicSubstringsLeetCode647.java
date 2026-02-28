package DynamicProgramming.TwoDimension.Palindrome;

import java.util.*;

public class PalindromicSubstringsLeetCode647 {

	public int countSubstringsRecursion(String s) {
		return 0;
	}

	public int countSubstringsRecursionMemo(String s) {
		return 0;
	}

	public int countSubstringsTabulation(String s) {
		int n = s.length(), count = 0;

		int[][] dp = new int[n][n];

		for (int k = 0; k < n; k++) { // will traverse in upper row
			int i = 0, j = k;
			while (j < n) {
				if (i == j) {
					dp[i][j] = 1;
					count++;
				} else if (j == i + 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 1;
						count++;
					}
				} else {
					//greater than 2
					if (s.charAt(i) == s.charAt(j)) {
						if (dp[i + 1][j - 1] == 1) {
							dp[i][j] = 1;
							count++;
						}
					}
				}
				i++;
				j++;
			}
		}
		return count;
	}

	private static void runTest(PalindromicSubstringsLeetCode647 solver,
	                            String s, int expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : s = \"" + s + "\"");
		System.out.println("Expected  : " + expected);

		int recursion = solver.countSubstringsRecursion(s);
		int memo = solver.countSubstringsRecursionMemo(s);
		int tabulation = solver.countSubstringsTabulation(s);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		PalindromicSubstringsLeetCode647 solver = new PalindromicSubstringsLeetCode647();

		System.out.println("=================================================");
		System.out.println("Palindromic Substrings - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"abc",
				3,
				"Test 1");

		runTest(solver,
				"aaa",
				6,
				"Test 2");
	}
}