package Graphs.BFS.Matrix;

import java.util.*;

public class RottenOrangesGFG {

	class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int orangesRotMethod1(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		int noOf1s = 0;
		Queue<Pair> queue = new LinkedList<>();
		//Traverse to find no of 1s and Including 2s in Queue
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int val = mat[i][j];
				if (val == 1) {
					noOf1s++;
				} else if (val == 2) {
					queue.offer(new Pair(i, j));
				}
			}
		}
		if (noOf1s == 0) return 0;
		if (queue.isEmpty()) return -1;


		int time = 0;
		int[] cr = {0, 0, -1, 1};
		int[] cc = {-1, 1, 0, 0};
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean changed = false;

			for (int i = 0; i < size; i++) {
				Pair curr = queue.poll();
				int currx = curr.x;
				int curry = curr.y;

				for (int j = 0; j < 4; j++) {
					int nr = currx + cr[j];
					int nc = curry + cc[j];

					if (nr >= 0 && nr < row && nc >= 0 && nc < col && mat[nr][nc] == 1) {
						mat[nr][nc] = 2;
						noOf1s--;
						queue.offer(new Pair(nr, nc));
						changed = true;
					}
				}
			}
			if (changed) time++;
		}
		return (noOf1s == 0) ? time : -1;
	}

	public int orangesRotMethod2(int[][] mat) {
		return 0;
	}

	public int orangesRotMethod3(int[][] mat) {
		return 0;
	}

	private static void runTest(RottenOrangesGFG solver,
	                            int[][] mat, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(mat));
		System.out.println("Expected  : " + expected);

		int m1 = solver.orangesRotMethod1(mat);
		int m2 = solver.orangesRotMethod2(mat);
		int m3 = solver.orangesRotMethod3(mat);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		RottenOrangesGFG solver = new RottenOrangesGFG();

		System.out.println("=================================================");
		System.out.println("Rotten Oranges - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{2, 1, 0, 2, 1},
						{1, 0, 1, 2, 1},
						{1, 0, 0, 2, 1}
				},
				2,
				"Test 1");

		runTest(solver,
				new int[][]{
						{2, 1, 0, 2, 1},
						{0, 0, 1, 2, 1},
						{1, 0, 0, 2, 1}
				},
				-1,
				"Test 2");
	}
}