package DynamicProgramming.TwoDimension.Grid;

import java.util.*;

public class MinimumFallingPathSumLeetCode931 {

	public int minFallingPathSumRecursion(int[][] matrix) {

		int row = matrix.length;
		int col = matrix[0].length;

		int[] nr = {1, 1, 1};
		int[] nc = {-1, 0, 1};
		for (int i = row - 2; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				int minV = Integer.MAX_VALUE;
				for (int a = 0; a < 3; a++) {
					int newR = i + nr[a];
					int newC = j + nc[a];
					if(newR>=0 && newR<row && newC>=0 && newC<col){
						minV = Math.min(matrix[newR][newC],minV);
					}
				}
				matrix[i][j] +=minV;
			}
		}

		int res = Integer.MAX_VALUE;
		for(int i =0;i<col;i++){
			res = Math.min(matrix[0][i],res);
		}
		return res;
	}

	public int minFallingPathSumRecursionMemo(int[][] matrix) {
		return 0;
	}

	public int minFallingPathSumTabulation(int[][] matrix) {
		return 0;
	}

	private static void runTest(MinimumFallingPathSumLeetCode931 solver,
	                            int[][] matrix, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(matrix));
		System.out.println("Expected  : " + expected);

		int recursion = solver.minFallingPathSumRecursion(matrix);
		int memo = solver.minFallingPathSumRecursionMemo(matrix);
		int tabulation = solver.minFallingPathSumTabulation(matrix);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		MinimumFallingPathSumLeetCode931 solver =
				new MinimumFallingPathSumLeetCode931();

		System.out.println("=================================================");
		System.out.println("Minimum Falling Path Sum - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{2,1,3},
						{6,5,4},
						{7,8,9}
				},
				13,
				"Test 1");

		runTest(solver,
				new int[][]{
						{-19,57},
						{-40,-5}
				},
				-59,
				"Test 2");
	}
}