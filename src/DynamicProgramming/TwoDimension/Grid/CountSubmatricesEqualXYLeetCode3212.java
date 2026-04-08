package DynamicProgramming.TwoDimension.Grid;

import java.util.*;

public class CountSubmatricesEqualXYLeetCode3212 {

	public int numberOfSubmatricesMethod1(char[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int[][] gridX = new int[row][col];
		int[][] gridY = new int[row][col];

		countMaker(grid, gridX, 'X');
		countMaker(grid, gridY, 'Y');

		int count=0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(gridX[i][j]==gridY[i][j] && gridX[i][j]>0) count++;
			}
		}
		return count;
	}

	private void countMaker(char[][] grid, int[][] ints, char string) {
		int row = grid.length;
		int col = grid[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j > 0) ints[i][j] += ints[i][j - 1];
				if (i > 0) ints[i][j] += ints[i - 1][j];
				if (i > 0 && j > 0) ints[i][j] -= ints[i - 1][j - 1];
				if (grid[i][j] == string) {
					ints[i][j]++;
				}
			}
		}
	}

	public int numberOfSubmatricesMethod2(char[][] grid) {
		return 0;
	}

	public int numberOfSubmatricesMethod3(char[][] grid) {
		return 0;
	}

	private static void runTest(CountSubmatricesEqualXYLeetCode3212 solver,
	                            char[][] grid, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : grid = " + Arrays.deepToString(grid));
		System.out.println("Expected  : " + expected);

		int m1 = solver.numberOfSubmatricesMethod1(grid);
		int m2 = solver.numberOfSubmatricesMethod2(grid);
		int m3 = solver.numberOfSubmatricesMethod3(grid);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		CountSubmatricesEqualXYLeetCode3212 solver =
				new CountSubmatricesEqualXYLeetCode3212();

		System.out.println("=================================================");
		System.out.println("Count Submatrices With Equal Frequency of X and Y - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new char[][]{{'X', 'Y', '.'}, {'Y', '.', '.'}},
				3,
				"Test 1");

		runTest(solver,
				new char[][]{{'X', 'X'}, {'X', 'Y'}},
				0,
				"Test 2");

		runTest(solver,
				new char[][]{{'.', '.'}, {'.', '.'}},
				0,
				"Test 3");
	}
}