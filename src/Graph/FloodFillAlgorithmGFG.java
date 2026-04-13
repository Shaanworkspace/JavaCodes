package Graph;

import java.util.*;

public class FloodFillAlgorithmGFG {

	public int[][] floodFillMethod1(int[][] image, int sr, int sc, int newColor) {
		int initialColor = image[sr][sc];
		if (initialColor == newColor) return image;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{sr, sc});
		image[sr][sc] = newColor;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			int[] cr = {0, 0, -1, 1};
			int[] cc = {-1, 1, 0, 0};
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + cr[i];
				int nc = curr[1] + cc[i];

				if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == initialColor) {
					queue.add(new int[]{nr, nc});
					image[nr][nc] = newColor;
				}
			}
		}
		return image;
	}

	public int[][] floodFillMethod2(int[][] image, int sr, int sc, int newColor) {
		return new int[0][0];
	}

	public int[][] floodFillMethod3(int[][] image, int sr, int sc, int newColor) {
		return new int[0][0];
	}

	private static void runTest(FloodFillAlgorithmGFG solver,
	                            int[][] image, int sr, int sc, int newColor,
	                            int[][] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : image = " + Arrays.deepToString(image) +
				", sr = " + sr + ", sc = " + sc + ", newColor = " + newColor);
		System.out.println("Expected  : " + Arrays.deepToString(expected));

		int[][] m1 = solver.floodFillMethod1(copy(image), sr, sc, newColor);
		int[][] m2 = solver.floodFillMethod2(copy(image), sr, sc, newColor);
		int[][] m3 = solver.floodFillMethod3(copy(image), sr, sc, newColor);

		System.out.printf("Method 1         : %-10s %s%n",
				"Checked", Arrays.deepEquals(m1, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10s %s%n",
				"Checked", Arrays.deepEquals(m2, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10s %s%n",
				"Checked", Arrays.deepEquals(m3, expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	private static int[][] copy(int[][] image) {
		int[][] newImg = new int[image.length][];
		for (int i = 0; i < image.length; i++) {
			newImg[i] = Arrays.copyOf(image[i], image[i].length);
		}
		return newImg;
	}

	public static void main(String[] args) {

		FloodFillAlgorithmGFG solver = new FloodFillAlgorithmGFG();

		System.out.println("=================================================");
		System.out.println("Flood Fill Algorithm - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{1, 1, 1, 0},
						{0, 1, 1, 1},
						{1, 0, 1, 1}
				},
				1, 2, 2,
				new int[][]{
						{2, 2, 2, 0},
						{0, 2, 2, 2},
						{1, 0, 2, 2}
				},
				"Test 1");

		runTest(solver,
				new int[][]{
						{0, 1, 0},
						{0, 1, 0}
				},
				0, 1, 0,
				new int[][]{
						{0, 0, 0},
						{0, 0, 0}
				},
				"Test 2");
	}
}