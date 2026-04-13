package Graph.BFS.Matrix;

import java.util.*;

public class RottingOrangesLeetCode994 {

	static class Pair {
		int x;
		int y;

		Pair(int xa, int ya) {
			x = xa;
			y = ya;
		}
	}

	// this is multi - BFS
	public int orangesRottingBrute(int[][] grid) {
		Queue<Pair> queue = new LinkedList<>();
		int row = grid.length;
		int col = grid[0].length;
		int freshOranges = 0;
		int minutes = 0;
		//adding all rotten oranges to queue
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Pair(i, j));
				}
				if (grid[i][j] == 1) {
					freshOranges++;
				}
			}
		}
		if (freshOranges == 0) return 0;


		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean rottedThisMinute = false;

			for (int i = 0; i < size; i++) {
				Pair curr = queue.poll();
				int r = curr.x;
				int c = curr.y;

				// UP
				if (r - 1 >= 0 && grid[r - 1][c] == 1) {
					grid[r - 1][c] = 2;
					queue.add(new Pair(r - 1, c));
					freshOranges--;
					rottedThisMinute = true;
				}

				// LEFT
				if (c - 1 >= 0 && grid[r][c - 1] == 1) {
					grid[r][c - 1] = 2;
					queue.add(new Pair(r, c - 1));
					freshOranges--;
					rottedThisMinute = true;
				}

				// DOWN
				if (r + 1 < row && grid[r + 1][c] == 1) {
					grid[r + 1][c] = 2;
					queue.add(new Pair(r + 1, c));
					freshOranges--;
					rottedThisMinute = true;
				}

				// RIGHT (fixed boundary)
				if (c + 1 < col && grid[r][c + 1] == 1) {
					grid[r][c + 1] = 2;
					queue.add(new Pair(r, c + 1));
					freshOranges--;
					rottedThisMinute = true;
				}
			}

			if (rottedThisMinute) {
				minutes++;
			}
		}
		if (freshOranges > 0) {
			return -1;
		}
		return minutes;
	}

	public int orangesRottingTryYourSelf(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int count = -1;
		int freshOranges = 0;
		Queue<Pair> queue = new ArrayDeque<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Pair(i, j));
				}
				if (grid[i][j] == 1) {
					freshOranges++;
				}
			}
		}
		if (freshOranges == 0) return 0;

		while (!queue.isEmpty()) {
			int si = queue.size();
			for (int s = 0; s < si; s++) {
				Pair p = queue.poll();
				int r = p.x;
				int c = p.y;

				int[] cr = {0, 0, -1, 1};
				int[] cc = {-1, 1, 0, 0};

				for (int i = 0; i < 4; i++) {
					int nr = r + cr[i];
					int nc = c + cc[i];
					if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
						queue.add(new Pair(nr, nc));
						grid[nr][nc] = 2;
						freshOranges--;
					}
				}
			}
			count++;
		}

		if(freshOranges!=0) return -1;
		return count;
	}

	public int orangesRotting(int[][] grid) {
		return 0;
	}

	private static int[][] copyGrid(int[][] grid) {
		int[][] copy = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			copy[i] = Arrays.copyOf(grid[i], grid[i].length);
		}
		return copy;
	}

	private static void printGrid(int[][] grid) {
		for (int[] row : grid) {
			System.out.println(Arrays.toString(row));
		}
	}

	private static void runTest(RottingOrangesLeetCode994 solver,
	                            int[][] grid, int expected, String name) {
		System.out.println(name);
		System.out.println("Input:");
		printGrid(grid);

		int brute = solver.orangesRottingBrute(copyGrid(grid));
		int your = solver.orangesRottingTryYourSelf(copyGrid(grid));
		int opt = solver.orangesRotting(copyGrid(grid));

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		RottingOrangesLeetCode994 solver = new RottingOrangesLeetCode994();

		int[][] grid1 = {
				{2, 1, 1},
				{1, 1, 0},
				{0, 1, 1}
		};

		int[][] grid2 = {
				{2, 1, 1},
				{0, 1, 1},
				{1, 0, 1}
		};

		int[][] grid3 = {
				{0, 2}
		};
		int[][] grid4 = {
				{0}
		};

		runTest(solver, grid1, 4, "Test 1");
		runTest(solver, grid2, -1, "Test 2");
		runTest(solver, grid3, 0, "Test 3");
		runTest(solver, grid4, 0, "Test 4");
	}
}