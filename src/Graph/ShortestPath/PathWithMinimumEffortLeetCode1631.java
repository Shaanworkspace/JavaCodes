package Graph.ShortestPath;

import java.util.*;

public class PathWithMinimumEffortLeetCode1631 {

	class Triplets implements Comparable<Triplets> {
		int dis;
		int x;
		int y;

		public Triplets(int dis, int x, int y) {
			this.dis = dis;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Triplets o) {
			return Integer.compare(this.dis, o.dis);
		}
	}


	public int minimumEffortPathMethod1(int[][] heights) {
		int row = heights.length;
		int col = heights[0].length;

		int[][] distanceMatrix = new int[row][col];
		for (int[] a : distanceMatrix) Arrays.fill(a, Integer.MAX_VALUE);
		distanceMatrix[0][0] = 0;


		PriorityQueue<Triplets> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Triplets(0, 0, 0));

		while (!priorityQueue.isEmpty()) {
			Triplets curr = priorityQueue.poll();
			int dis = curr.dis;
			int x = curr.x;
			int y = curr.y;
			if (x == row - 1 && y == col - 1) return dis;

			int[] ax = {0, 0, 1, -1};
			int[] ay = {1, -1, 0, 0};

			for (int i = 0; i < 4; i++) {
				int nextX = x + ax[i];
				int nextY = y + ay[i];

				if (nextY >= 0 && nextX >= 0 && nextX < row && nextY < col) {
					int distance = Math.abs(heights[x][y] - heights[nextX][nextY]);
					int val = Math.max(distance, dis);
					if(val < distanceMatrix[nextX][nextY]){
						distanceMatrix[nextX][nextY] = val;
						priorityQueue.add(new Triplets(val, nextX, nextY));
					}
				}
			}
		}
		return -1;
	}

	public int minimumEffortPathMethod2(int[][] heights) {
		return 0;
	}

	public int minimumEffortPathMethod3(int[][] heights) {
		return 0;
	}

	private static void runTest(PathWithMinimumEffortLeetCode1631 solver,
	                            int[][] heights, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(heights));
		System.out.println("Expected  : " + expected);

		int m1 = solver.minimumEffortPathMethod1(heights);
		int m2 = solver.minimumEffortPathMethod2(heights);
		int m3 = solver.minimumEffortPathMethod3(heights);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		PathWithMinimumEffortLeetCode1631 solver =
				new PathWithMinimumEffortLeetCode1631();

		System.out.println("=================================================");
		System.out.println("Path With Minimum Effort - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{1, 2, 2},
						{3, 8, 2},
						{5, 3, 5}
				},
				2,
				"Test 1");

		runTest(solver,
				new int[][]{
						{1, 2, 3},
						{3, 8, 4},
						{5, 3, 5}
				},
				1,
				"Test 2");

		runTest(solver,
				new int[][]{
						{1, 2, 1, 1, 1},
						{1, 2, 1, 2, 1},
						{1, 2, 1, 2, 1},
						{1, 2, 1, 2, 1},
						{1, 1, 1, 2, 1}
				},
				0,
				"Test 3");
	}
}