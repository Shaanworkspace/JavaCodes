package Graph.DFS;

import java.util.*;

public class FloodFillLeetCode733 {

	static class Pair {
		int x;
		int y;

		Pair(int xa, int ya) {
			x = xa;
			y = ya;
		}
	}
	public int[][] floodFillBrute(int[][] image, int sr, int sc, int color) {
		int m = image.length;
		int n = image[0].length;
		int[][] isVisited = new int[m][n];

		if (image[sr][sc] == color) return image;

		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(sr,sc));
		image[sr][sc] = color;
		isVisited[sr][sc]=1;
		while(!queue.isEmpty()){
			Pair curr = queue.poll();
			int r = curr.x;
			int c = curr.y;

			// UP
			if (r - 1 >= 0 && image[r - 1][c] != 0 && isVisited[r-1][c]!=1) {
				image[r - 1][c] = color;
				isVisited[r-1][c]=1;
				queue.add(new Pair(r - 1, c));
			}

			// LEFT
			if (c - 1 >= 0 && image[r][c - 1] != 0 && isVisited[r][c-1]!=1) {
				image[r][c - 1] = color;
				isVisited[r][c-1]=1;
				queue.add(new Pair(r, c - 1));
			}

			// DOWN
			if (r + 1 < m && image[r + 1][c] !=0 && isVisited[r+1][c]!=1) {
				image[r + 1][c] = color;
				isVisited[r+1][c]=1;
				queue.add(new Pair(r + 1, c));
			}

			// RIGHT (fixed boundary)
			if (c + 1 < n && image[r][c + 1] != 0 && isVisited[r][c+1]!=1)  {
				image[r][c + 1] = color;
				isVisited[r][c+1]=1;
				queue.add(new Pair(r, c + 1));
			}
		}
		return image;
	}

	public int[][] floodFillTryYourSelf(int[][] image, int sr, int sc, int color) {
		return null;
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		return null;
	}

	private static int[][] copyGrid(int[][] grid) {
		int[][] copy = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			copy[i] = Arrays.copyOf(grid[i], grid[i].length);
		}
		return copy;
	}

	private static void printGrid(int[][] grid) {
		if (grid == null) {
			System.out.println("null");
			return;
		}
		for (int[] row : grid) {
			System.out.println(Arrays.toString(row));
		}
	}

	private static void runTest(FloodFillLeetCode733 solver,
	                            int[][] image, int sr, int sc, int color,
	                            int[][] expected, String name) {
		System.out.println(name);
		System.out.println("Input:");
		printGrid(image);
		System.out.println("sr = " + sr + ", sc = " + sc + ", color = " + color);

		int[][] brute = solver.floodFillBrute(copyGrid(image), sr, sc, color);
		int[][] your  = solver.floodFillTryYourSelf(copyGrid(image), sr, sc, color);
		int[][] opt   = solver.floodFill(copyGrid(image), sr, sc, color);

		System.out.println("Expected:");
		printGrid(expected);
		System.out.println("Brute Force:");
		printGrid(brute);
		System.out.println("TryYourSelf:");
		printGrid(your);
		System.out.println("Optimized:");
		printGrid(opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		FloodFillLeetCode733 solver = new FloodFillLeetCode733();

		int[][] image1 = {
				{1, 1, 1},
				{1, 1, 0},
				{1, 0, 1}
		};
		int[][] expected1 = {
				{2, 2, 2},
				{2, 2, 0},
				{2, 0, 1}
		};

		int[][] image2 = {
				{0, 0, 0},
				{0, 0, 0}
		};
		int[][] expected2 = {
				{0, 0, 0},
				{0, 0, 0}
		};

		runTest(solver, image1, 1, 1, 2, expected1, "Test 1");
		runTest(solver, image2, 0, 0, 0, expected2, "Test 2");
	}
}