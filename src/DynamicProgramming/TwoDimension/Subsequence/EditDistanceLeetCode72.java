package DynamicProgramming.TwoDimension.Subsequence;

public class EditDistanceLeetCode72 {

	public int minDistanceRecursion(String word1, String word2) {
		StringBuilder a = new StringBuilder(word1);
		StringBuilder b = new StringBuilder(word2);
		return helpRecursion(a, b, a.length() - 1, b.length() - 1);
	}

	private int helpRecursion(StringBuilder a, StringBuilder b, int i, int j) {
		if(i<0) return j+1;
		if(j<0) return i+1;
		if (a.charAt(i) == b.charAt(j))
			return helpRecursion(a, b, i - 1, j - 1);

		int del = helpRecursion(a, b, i - 1, j);
		int rep = helpRecursion(a, b, i - 1, j - 1);
		int ins = helpRecursion(a, b, i, j - 1);
		return 1+ Math.min(del,Math.min(rep,ins));

	}

	public int minDistanceRecursionMemo(String word1, String word2) {
		StringBuilder a = new StringBuilder(word1);
		StringBuilder b = new StringBuilder(word2);
		int[][] dp = new int[a.length()+1][b.length()+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		return helpRecursionMemo(a, b, a.length() - 1, b.length() - 1,dp);
	}

	private int helpRecursionMemo(StringBuilder a, StringBuilder b, int i, int j, int[][] dp) {
		if(i<0) return j+1;
		if(j<0) return i+1;
		if(dp[i][j]!=-1) return dp[i][j];
		if (a.charAt(i) == b.charAt(j))
			return dp[i][j] = helpRecursionMemo(a, b, i - 1, j - 1, dp);

		int del = helpRecursionMemo(a, b, i - 1, j, dp);
		int rep = helpRecursionMemo(a, b, i - 1, j - 1, dp);
		int ins = helpRecursionMemo(a, b, i, j - 1, dp);
		return dp[i][j] = 1+ Math.min(del,Math.min(rep,ins));

	}

	public int minDistanceTabulation(String word1, String word2) {
		return 0;
	}

	private static void runTest(EditDistanceLeetCode72 solver,
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
		EditDistanceLeetCode72 solver = new EditDistanceLeetCode72();

		System.out.println("=================================================");
		System.out.println("Edit Distance - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"horse",
				"ros",
				3,
				"Test 1");

		runTest(solver,
				"intention",
				"execution",
				5,
				"Test 2");
	}
}