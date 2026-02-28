package Array.Matrix.PrefixSum;

import java.util.*;

public class NumberOfSubmatrixHaveSumXGFG {

	// Method 1: Brute force (try yourself)
	public static void printMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {          // loop for rows

			for (int j = 0; j < matrix[i].length; j++) {  // loop for columns
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println(); // move to next line after each row
		}
	}
	public int countSquareMethod1(int[][] mat, int x) {
		int row = mat.length,col = mat[0].length;
		for(int i = 0; i <row;i++){
			for(int j =1;j<col;j++){
				mat[i][j] = mat[i][j-1] + mat[i][j];
			}
		}

		return row;
	}

	// Method 2: Better approach using prefix sum (try yourself)
	public int countSquareMethod2(int[][] mat, int x) {
		return 0;
	}

	// Method 3: Optimized prefix sum approach (try yourself)
	public int countSquareMethod3(int[][] mat, int x) {
		return 0;
	}

	private static void runTest(NumberOfSubmatrixHaveSumXGFG solver,
	                            int[][] mat, int x,
	                            int expected, String testName) {

		System.out.println(testName);
		System.out.println("Matrix    : " + Arrays.deepToString(mat));
		System.out.println("Target X  : " + x);
		System.out.println("Expected  : " + expected);

		int r1 = solver.countSquareMethod1(mat, x);
		int r2 = solver.countSquareMethod2(mat, x);
		int r3 = solver.countSquareMethod3(mat, x);

		System.out.printf("Method 1        : %-5d %s%n",
				r1, r1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-5d %s%n",
				r2, r2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3        : %-5d %s%n",
				r3, r3 == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		NumberOfSubmatrixHaveSumXGFG solver =
				new NumberOfSubmatrixHaveSumXGFG();

		System.out.println("=================================================");
		System.out.println("Number of Square Submatrices with Sum X - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{2, 4, 7, 8, 10},
						{3, 1, 1, 1, 1},
						{9, 11, 1, 2, 1},
						{12, -17, 1, 1, 1}
				},
				10,
				3,
				"Test 1");

		runTest(solver,
				new int[][]{
						{3, 3, 5, 3},
						{2, 2, 2, 6},
						{11, 2, 2, 4}
				},
				1,
				0,
				"Test 2");
	}
}