package Graph.BFS.Matrix;
import java.util.*;

public class NumberOfEnclavesLeetCode1020 {

	public int numEnclavesMethod1(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		// top - right
		for (int i = 0; i < col; i++) if (grid[0][i] == 1) dfs(grid, 0, i);
		// down - right
		for (int i = 0; i < col; i++) if (grid[row - 1][i] == 1) dfs(grid, row - 1, i);
		// right - down
		for (int i = 0; i < row; i++) if (grid[i][col - 1] == 1) dfs(grid, i, col - 1);
		// left - down
		for (int i = 0; i < row; i++) if (grid[i][0] == 1) dfs(grid, i, 0);

		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(grid[i][j] == 1){
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(int[][] grid, int row, int col) {
		grid[row][col] = 0;
		int[] cr = {0, 0, -1, 1};
		int[] cc = {-1, 1, 0, 0};
		int n = grid.length;
		int m = grid[0].length;

		for (int i = 0; i < 4; i++) {
			int nr = row + cr[i];
			int nc = col + cc[i];

			if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
				dfs(grid, nr, nc);
			}
		}
	}

	public int numEnclavesMethod2(int[][] grid) {
		return 0;
	}

	public int numEnclavesMethod3(int[][] grid) {
		return 0;
	}

	private static void runTest(NumberOfEnclavesLeetCode1020 solver,
	                            int[][] grid, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(grid));
		System.out.println("Expected  : " + expected);

		int m1 = solver.numEnclavesMethod1(grid);
		int m2 = solver.numEnclavesMethod2(grid);
		int m3 = solver.numEnclavesMethod3(grid);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		NumberOfEnclavesLeetCode1020 solver =
				new NumberOfEnclavesLeetCode1020();

		System.out.println("=================================================");
		System.out.println("Number of Enclaves - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{0,0,0,0},
						{1,0,1,0},
						{0,1,1,0},
						{0,0,0,0}
				},
				3,
				"Test 1");

		runTest(solver,
				new int[][]{
						{0,1,1,0},
						{0,0,1,0},
						{0,0,1,0},
						{0,0,0,0}
				},
				0,
				"Test 2");
	}
}