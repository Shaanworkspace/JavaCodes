package Graph.BFS.Matrix;

import java.util.*;

public class DistanceOfNearestCellHaving1GFG {

	public ArrayList<ArrayList<Integer>> nearestMethod1(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		Queue<int[]> queue = new ArrayDeque<>();
		int[][] res = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					queue.add(new int[]{i, j});
					res[i][j] = 0;
				}
			}
		}


		while (!queue.isEmpty()) {
			int si = queue.size();

			for (int ii = 0; ii < si; ii++) {
				int[] curr = queue.poll();
				int[] cr = {0, 0, -1, 1};
				int[] cc = {-1, 1, 0, 0};
				for (int i = 0; i < 4; i++) {
					int nr = curr[0] + cr[i];
					int nc = curr[1] + cc[i];
					if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 0) {
						res[nr][nc] = res[curr[0]][curr[1]] + 1;
						grid[nr][nc] = -1;
						queue.add(new int[]{nr, nc});
					}
				}
			}
		}
		ArrayList<ArrayList<Integer>> resl = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> part = new ArrayList<>();
			for (int j = 0; j < m; j++) {
				part.add(res[i][j]);
			}
			resl.add(part);
		}

		return resl;
	}

	public ArrayList<ArrayList<Integer>> nearestMethod2(int[][] grid) {
		return new ArrayList<>();
	}

	public ArrayList<ArrayList<Integer>> nearestMethod3(int[][] grid) {
		return new ArrayList<>();
	}

	private static void runTest(DistanceOfNearestCellHaving1GFG solver,
	                            int[][] grid,
	                            ArrayList<ArrayList<Integer>> expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(grid));
		System.out.println("Expected  : " + expected);

		ArrayList<ArrayList<Integer>> m1 = solver.nearestMethod1(grid);
		ArrayList<ArrayList<Integer>> m2 = solver.nearestMethod2(grid);
		ArrayList<ArrayList<Integer>> m3 = solver.nearestMethod3(grid);

		System.out.printf("Method 1         : %-10s %s%n",
				"Checked", m1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10s %s%n",
				"Checked", m2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10s %s%n",
				"Checked", m3.equals(expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	private static ArrayList<ArrayList<Integer>> toList(int[][] arr) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int[] row : arr) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int val : row) temp.add(val);
			list.add(temp);
		}
		return list;
	}

	public static void main(String[] args) {

		DistanceOfNearestCellHaving1GFG solver =
				new DistanceOfNearestCellHaving1GFG();

		System.out.println("=================================================");
		System.out.println("Distance of Nearest Cell Having 1 - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{0, 1, 1, 0},
						{1, 1, 0, 0},
						{0, 0, 1, 1}
				},
				toList(new int[][]{
						{1, 0, 0, 1},
						{0, 0, 1, 1},
						{1, 1, 0, 0}
				}),
				"Test 1");

		runTest(solver,
				new int[][]{
						{1, 0, 1},
						{1, 1, 0},
						{1, 0, 0}
				},
				toList(new int[][]{
						{0, 1, 0},
						{0, 0, 1},
						{0, 1, 2}
				}),
				"Test 2");
	}
}