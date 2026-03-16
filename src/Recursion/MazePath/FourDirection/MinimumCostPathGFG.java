package Recursion.MazePath.FourDirection;

import java.util.*;

public class MinimumCostPathGFG {

	public int minimumCostPathMethod1(int[][] grid) {
		return helper(grid, 0, 0, 0);
	}

	private int helper(int[][] grid, int row, int col, int cost) {
		if (row == grid.length - 1 && col == grid[0].length - 1) return cost + grid[row][col];
		int[] r = {-1, 1, 0, 0};
		int[] c = {0, 0, -1, 1};
		int min = Integer.MAX_VALUE;
		int temp = grid[row][col];
		grid[row][col] = -1;
		for (int i = 0; i < 4; i++) {
			int currRow = row + r[i];
			int currCol = col + c[i];
			if (currCol >= 0 && currCol < grid[0].length && currRow >= 0 && currRow < grid.length &&
					grid[currRow][currCol] != -1) {
				int cost1 = helper(grid, currRow, currCol, cost + temp);
				min = Math.min(min, cost1);
			}
		}
		grid[row][col] = temp;

		return min;
	}
	public int minimumCostPathMethod2(int[][] grid) {
		return 0;
	}
	public int minimumCostPathMethod3(int[][] grid) {
		return 0;
	}

	private static void runTest(MinimumCostPathGFG solver,
	                            int[][] grid, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : grid = " + Arrays.deepToString(grid));
		System.out.println("Expected  : " + expected);

		int m1 = solver.minimumCostPathMethod1(grid);
		int m2 = solver.minimumCostPathMethod2(grid);
		int m3 = solver.minimumCostPathMethod3(grid);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		MinimumCostPathGFG solver = new MinimumCostPathGFG();

		System.out.println("=================================================");
		System.out.println("Minimum Cost Path - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{9, 4, 9, 9},
						{6, 7, 6, 4},
						{8, 3, 3, 7},
						{7, 4, 9, 10}
				},
				43,
				"Test 1");

		runTest(solver,
				new int[][]{
						{4, 4},
						{3, 7}
				},
				14,
				"Test 2");
	}
}