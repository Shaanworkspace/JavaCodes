package Array;

import java.util.*;

public class DetermineWhetherMatrixCanBeObtainedByRotationLeetCode1886 {
	public static void printMatrix(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println(); // move to next row
		}
		System.out.println();
	}

	public boolean findRotationMethod1(int[][] mat, int[][] target) {
		int rows = mat.length;
		int cols = mat[0].length;
		for (int a = 0; a < 4; a++) {
			boolean flag = true;
			reverse(mat);
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (mat[i][j] != target[i][j]) {
						flag = false;
					}
				}
			}
			if (flag) return true;
		}
		return false;
	}

	public void reverse(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;

		//transpose
		for (int i = 0; i < rows; i++) {
			for (int j = i; j < cols; j++) {
				if (i == j) continue;
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		//reverse each row : so 90 deg Clockwise
		for (int c = 0; c < rows; c++) {
			int i = 0, j = rows - 1;
			while (i < j) {
				int temp = mat[c][i];
				mat[c][i] = mat[c][j];
				mat[c][j] = temp;
				i++;
				j--;
			}
		}
	}

	public boolean findRotationMethod2(int[][] mat, int[][] target) {
		return false;
	}

	public boolean findRotationMethod3(int[][] mat, int[][] target) {
		return false;
	}

	private static void runTest(DetermineWhetherMatrixCanBeObtainedByRotationLeetCode1886 solver,
	                            int[][] mat, int[][] target, boolean expected, String testName) {

		System.out.println(testName);
		System.out.println("Input mat    : " + Arrays.deepToString(mat));
		System.out.println("Input target : " + Arrays.deepToString(target));
		System.out.println("Expected     : " + expected);

		boolean m1 = solver.findRotationMethod1(mat, target);
		boolean m2 = solver.findRotationMethod2(mat, target);
		boolean m3 = solver.findRotationMethod3(mat, target);

		System.out.printf("Method 1         : %-10s %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10s %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10s %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		DetermineWhetherMatrixCanBeObtainedByRotationLeetCode1886 solver =
				new DetermineWhetherMatrixCanBeObtainedByRotationLeetCode1886();

		System.out.println("=================================================");
		System.out.println("Determine Whether Matrix Can Be Obtained By Rotation - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{{0, 1}, {1, 0}},
				new int[][]{{1, 0}, {0, 1}},
				true,
				"Test 1");

		runTest(solver,
				new int[][]{{0, 1}, {1, 1}},
				new int[][]{{1, 0}, {0, 1}},
				false,
				"Test 2");

		runTest(solver,
				new int[][]{
						{0, 0, 0},
						{0, 1, 0},
						{1, 1, 1}
				},
				new int[][]{
						{1, 1, 1},
						{0, 1, 0},
						{0, 0, 0}
				},
				true,
				"Test 3");
	}
}