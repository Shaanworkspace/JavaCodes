package Graph.BFS.Matrix;

import java.util.*;

public class ShortestPathBinaryMatrixLeetCode1091 {

	class DistancePair implements Comparable<DistancePair> {
		int dis;
		int x;
		int y;

		public DistancePair(int dis, int x, int y) {
			this.dis = dis;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(DistancePair o) {
			return Integer.compare(this.dis, o.dis);
		}
	}

	public int shortestPathBinaryMatrixMethod1(int[][] grid) {

		int[][] mat = new int[grid.length][grid[0].length];
		for (int[] a : mat) {
			Arrays.fill(a, Integer.MAX_VALUE);
		}

		//Dijkastra
		PriorityQueue<DistancePair> queue = new PriorityQueue<>();
		if (grid[0][0] != 0) return -1;
		queue.add(new DistancePair(1, 0, 0));
		mat[0][0] = 1;
		while (!queue.isEmpty()) {
			DistancePair curr = queue.poll();
			int dis = curr.dis;
			int x = curr.x;
			int y = curr.y;

			if (x == grid.length - 1 && y == grid[0].length - 1) return dis;

			int[] ax = {0, 0, 1, -1, -1, 1, 1, -1};
			int[] ay = {1, -1, 0, 0, -1, -1, 1, 1};

			for (int i = 0; i < 8; i++) {
				int nextX = x + ax[i];
				int nextY = y + ay[i];

				if (nextY >= 0 && nextX >= 0 && nextX < grid.length && nextY < grid[0].length && grid[nextX][nextY] == 0 && mat[nextX][nextY] > dis + 1) {
					mat[nextX][nextY] = dis + 1;
					queue.add(new DistancePair(dis + 1, nextX, nextY));
				}
			}

		}
		return (mat[grid.length - 1][grid[0].length - 1] != Integer.MAX_VALUE) ? mat[grid.length - 1][grid[0].length - 1] : -1;
	}

	public int shortestPathBinaryMatrixMethod2(int[][] grid) {
		return 0;
	}

	public int shortestPathBinaryMatrixMethod3(int[][] grid) {
		return 0;
	}

	private static void runTest(ShortestPathBinaryMatrixLeetCode1091 solver,
	                            int[][] grid, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(grid));
		System.out.println("Expected  : " + expected);

		int m1 = solver.shortestPathBinaryMatrixMethod1(copy(grid));
		int m2 = solver.shortestPathBinaryMatrixMethod2(copy(grid));
		int m3 = solver.shortestPathBinaryMatrixMethod3(copy(grid));

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	private static int[][] copy(int[][] grid) {
		int[][] newGrid = new int[grid.length][];
		for (int i = 0; i < grid.length; i++) {
			newGrid[i] = Arrays.copyOf(grid[i], grid[i].length);
		}
		return newGrid;
	}

	public static void main(String[] args) {

		ShortestPathBinaryMatrixLeetCode1091 solver =
				new ShortestPathBinaryMatrixLeetCode1091();

		System.out.println("=================================================");
		System.out.println("Shortest Path in Binary Matrix - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{0, 1},
						{1, 0}
				},
				2,
				"Test 1");

		runTest(solver,
				new int[][]{
						{0, 0, 0},
						{1, 1, 0},
						{1, 1, 0}
				},
				4,
				"Test 2");

		runTest(solver,
				new int[][]{
						{1, 0, 0},
						{1, 1, 0},
						{1, 1, 0}
				},
				-1,
				"Test 3");
	}
}