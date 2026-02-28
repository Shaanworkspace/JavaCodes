package DynamicProgramming.TwoDimension.Subsequence;

public class ShortestCommonSupersequenceLeetCode1092 {

	public String shortestCommonSupersequenceRecursion(String str1, String str2) {
		return "";
	}

	public String shortestCommonSupersequenceRecursionMemo(String str1, String str2) {
		return "";
	}

	public String shortestCommonSupersequenceTabulation(String str1, String str2) {
		return "";
	}

	private static void runTest(ShortestCommonSupersequenceLeetCode1092 solver,
	                            String str1, String str2, String expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : str1 = \"" + str1 + "\", str2 = \"" + str2 + "\"");
		System.out.println("Expected  : \"" + expected + "\"");

		String recursion = solver.shortestCommonSupersequenceRecursion(str1, str2);
		String memo = solver.shortestCommonSupersequenceRecursionMemo(str1, str2);
		String tabulation = solver.shortestCommonSupersequenceTabulation(str1, str2);

		System.out.printf("Recursion        : %-15s %s%n",
				"\"" + recursion + "\"", isValidSCS(recursion, str1, str2, expected.length()) ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-15s %s%n",
				"\"" + memo + "\"", isValidSCS(memo, str1, str2, expected.length()) ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-15s %s%n",
				"\"" + tabulation + "\"", isValidSCS(tabulation, str1, str2, expected.length()) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	private static boolean isValidSCS(String scs, String str1, String str2, int expectedLen) {
		if (scs.length() != expectedLen) return false;
		return isSubsequence(str1, scs) && isSubsequence(str2, scs);
	}

	private static boolean isSubsequence(String s, String t) {
		int i = 0;
		for (int j = 0; j < t.length() && i < s.length(); j++) {
			if (s.charAt(i) == t.charAt(j)) i++;
		}
		return i == s.length();
	}

	public static void main(String[] args) {
		ShortestCommonSupersequenceLeetCode1092 solver = new ShortestCommonSupersequenceLeetCode1092();

		System.out.println("=================================================");
		System.out.println("Shortest Common Supersequence - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"abac",
				"cab",
				"cabac",
				"Test 1");

		runTest(solver,
				"aaaaaaaa",
				"aaaaaaaa",
				"aaaaaaaa",
				"Test 2");
	}
}