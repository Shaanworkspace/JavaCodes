package Array.Matrix;

import java.util.*;

public class MatrixSimilarityAfterCyclicShiftsLeetCode2946 {

	public boolean areSimilarMethod1(int[][] mat, int k) {
		int row = mat.length;
		int col = mat[0].length;
		k = k % col;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int newRCol = (j + k) % col;
				int newLCol = (j - k + col) % col;
			}
		}
		return false;
	}

	public boolean areSimilarMethod2(int[][] mat, int k) {
		return false;
	}

	public boolean areSimilarMethod3(int[][] mat, int k) {
		return false;
	}

	private static void runTest(MatrixSimilarityAfterCyclicShiftsLeetCode2946 solver,
	                            int[][] mat, int k, boolean expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : mat = " + Arrays.deepToString(mat) + ", k = " + k);
		System.out.println("Expected  : " + expected);

		boolean m1 = solver.areSimilarMethod1(mat, k);
		boolean m2 = solver.areSimilarMethod2(mat, k);
		boolean m3 = solver.areSimilarMethod3(mat, k);

		System.out.printf("Method 1         : %-10s %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10s %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10s %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		MatrixSimilarityAfterCyclicShiftsLeetCode2946 solver =
				new MatrixSimilarityAfterCyclicShiftsLeetCode2946();

		System.out.println("=================================================");
		System.out.println("Matrix Similarity After Cyclic Shifts - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9}
				},
				4,
				false,
				"Test 1");

		runTest(solver,
				new int[][]{
						{1, 2, 1, 2},
						{5, 5, 5, 5},
						{6, 3, 6, 3}
				},
				2,
				true,
				"Test 2");

		runTest(solver,
				new int[][]{
						{2, 2},
						{2, 2}
				},
				3,
				true,
				"Test 3");
	}
}