package Backtracking;

import java.util.*;

public class MinimumPathSumLeetCode64 {

	public int minPathSumBrute(int[][] grid) {

		return 1;
	}

	int[][] dp1;
	public int minPathSumTryYourSelf(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		dp1 = new int[m][n];

		// initialize dp with -1
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp1[i][j] = -1;
			}
		}
		return helper(0, 0, grid, dp1);
	}

	private int helper(int row, int col, int[][] grid, int[][] dp1) {
		if (row >= grid.length || col >= grid[0].length) return Integer.MAX_VALUE;
		int curr = grid[row][col];
		if (row == grid.length - 1 && col == grid[0].length - 1) return curr;


		if (dp1[row][col] != -1) {
			return dp1[row][col];
		}
		int right = helper(row, col + 1, grid, dp1);
		int down = helper(row + 1, col, grid, dp1);

		dp1[row][col] = grid[row][col] + Math.min(right, down);
		return dp1[row][col];
	}


	int[][] dp;

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		dp = new int[m][n];

		// initialize dp with -1
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}

		return finderDP(grid, 0, 0, m, n);

	}

	private int finderDP(int[][] grid, int row, int col, int m, int n) {

		// out of boundary
		if (row >= m || col >= n) {
			return Integer.MAX_VALUE;
		}

		// destination
		if (row == m - 1 && col == n - 1) {
			return grid[row][col];
		}


		if (dp[row][col] != -1) {
			return dp[row][col];
		}

		int right = finderDP(grid, row, col + 1, m, n);
		int down = finderDP(grid, row + 1, col, m, n);

		dp[row][col] = grid[row][col] + Math.min(right, down);
		return dp[row][col];
	}


	int minPath = Integer.MAX_VALUE;

	public int minPathSumBacktrack(int[][] grid) {
		minPath = Integer.MAX_VALUE;
		finder(grid, 0, 0, 0, grid.length, grid[0].length);
		return minPath;
	}


	private void finder(int[][] grid, int row, int col, int sum, int m, int n) {
		if (sum >= minPath) return;

		if (row >= m || col >= n) {
			return;
		}
		sum += grid[row][col];

		if (row == m - 1 && col == n - 1) {
			if (sum < minPath) {
				minPath = sum;
				System.out.println(minPath);
				return;
			}
		}
		finder(grid, row + 1, col, sum, m, n);
		finder(grid, row, col + 1, sum, m, n);
	}


	private static void printGrid(int[][] grid) {
		for (int[] row : grid) {
			System.out.println(Arrays.toString(row));
		}
	}

	private static void runTest(MinimumPathSumLeetCode64 solver,
	                            int[][] grid, int expected, String name) {
		System.out.println(name);
		System.out.println("Input:");
		printGrid(grid);

		int brute = solver.minPathSumBrute(grid);
		int your = solver.minPathSumTryYourSelf(grid);
		int opt = solver.minPathSum(grid);
		int optBack = solver.minPathSumBacktrack(grid);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("Optimized  Backtrack      : " + optBack);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		MinimumPathSumLeetCode64 solver = new MinimumPathSumLeetCode64();

		int[][] grid1 = {
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
		};

		int[][] grid2 = {
				{1, 2, 3},
				{4, 5, 6}
		};

		runTest(solver, grid1, 7, "Test 1");
		runTest(solver, grid2, 12, "Test 2");
	}
}