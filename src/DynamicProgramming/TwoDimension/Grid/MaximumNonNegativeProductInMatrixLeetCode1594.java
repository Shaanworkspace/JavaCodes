package DynamicProgramming.TwoDimension.Grid;
import java.util.*;

public class MaximumNonNegativeProductInMatrixLeetCode1594 {
	long MOD = 1_000_000_007L;
	public int maxProductPathRecursion(int[][] grid) {
		long[] ss = solve(grid,0,0);
		if(ss[0]<0){
			return -1;
		}else{
			return (int)(ss[0] % MOD);
		}
	}

	private long[] solve(int[][] grid, int row, int col) {
		int rowM = grid.length,colM = grid[0].length;
		if(row==rowM-1 && col == colM-1) return new long[]{grid[row][col],grid[row][col]};
		int curr = grid[row][col];

		long maxVal = Long.MIN_VALUE;
		long minVal = Long.MAX_VALUE;

		if (col + 1 < colM) {
			long[] right = solve(grid, row, col + 1);
			maxVal = Math.max(maxVal, Math.max(curr * right[0], curr * right[1]));
			minVal = Math.min(minVal, Math.min(curr * right[0], curr * right[1]));
		}

		if (row + 1 < rowM) {
			long[] down = solve(grid, row + 1, col);
			maxVal = Math.max(maxVal, Math.max(curr * down[0], curr * down[1]));
			minVal = Math.min(minVal, Math.min(curr * down[0], curr * down[1]));
		}

		return new long[]{maxVal, minVal};
	}


	Long[][][] dp1;
	public int maxProductPathRecursionMemo(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		dp1 = new Long[m][n][2];

		long[] ss = solve1(grid,0,0,dp1);
		if(ss[0]<0){
			return -1;
		}else{
			return (int)(ss[0] % MOD);
		}
	}

	private long[] solve1(int[][] grid, int row, int col, Long[][][] dp) {
		int rowM = grid.length,colM = grid[0].length;
		if(row==rowM-1 && col == colM-1) return new long[]{grid[row][col],grid[row][col]};
		if (dp[row][col][0] != null)
			return new long[]{dp[row][col][0], dp[row][col][1]};
		int curr = grid[row][col];

		long maxVal = Long.MIN_VALUE;
		long minVal = Long.MAX_VALUE;

		if (col + 1 < colM) {
			long[] right = solve1(grid, row, col + 1, dp1);
			maxVal = Math.max(maxVal, Math.max(curr * right[0], curr * right[1]));
			minVal = Math.min(minVal, Math.min(curr * right[0], curr * right[1]));
		}

		if (row + 1 < rowM) {
			long[] down = solve1(grid, row + 1, col, dp1);
			maxVal = Math.max(maxVal, Math.max(curr * down[0], curr * down[1]));
			minVal = Math.min(minVal, Math.min(curr * down[0], curr * down[1]));
		}

		dp[row][col][0] = maxVal;
		dp[row][col][1] = minVal;

		return new long[]{maxVal, minVal};
	}

	public int maxProductPathTabulation(int[][] grid) {
		return 0;
	}

	private static void runTest(MaximumNonNegativeProductInMatrixLeetCode1594 solver,
	                            int[][] grid, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(grid));
		System.out.println("Expected  : " + expected);

		int recursion = solver.maxProductPathRecursion(grid);
		int memo = solver.maxProductPathRecursionMemo(grid);
		int tabulation = solver.maxProductPathTabulation(grid);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		MaximumNonNegativeProductInMatrixLeetCode1594 solver =
				new MaximumNonNegativeProductInMatrixLeetCode1594();

		System.out.println("=================================================");
		System.out.println("Maximum Non Negative Product in a Matrix - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{-1,-2,-3},
						{-2,-3,-3},
						{-3,-3,-2}
				},
				-1,
				"Test 1");

		runTest(solver,
				new int[][]{
						{1,-2,1},
						{1,-2,1},
						{3,-4,1}
				},
				8,
				"Test 2");

		runTest(solver,
				new int[][]{
						{1,3},
						{0,-4}
				},
				0,
				"Test 3");
	}
}