package DynamicProgramming.TwoDimension.Grid;
import java.util.*;

public class MaximalSquareLeetCode221 {

	public int maximalSquareMethod1(char[][] matrix) {
		return 0;
	}

	public int maximalSquareMethod2(char[][] matrix) {
		return 0;
	}

	public int maximalSquareMethod3(char[][] matrix) {
		return 0;
	}

	private static void runTest(MaximalSquareLeetCode221 solver,
	                            char[][] matrix, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : matrix = " + Arrays.deepToString(matrix));
		System.out.println("Expected  : " + expected);

		int m1 = solver.maximalSquareMethod1(matrix);
		int m2 = solver.maximalSquareMethod2(matrix);
		int m3 = solver.maximalSquareMethod3(matrix);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		MaximalSquareLeetCode221 solver = new MaximalSquareLeetCode221();

		System.out.println("=================================================");
		System.out.println("Maximal Square - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new char[][]{
						{'1','0','1','0','0'},
						{'1','0','1','1','1'},
						{'1','1','1','1','1'},
						{'1','0','0','1','0'}
				},
				4,
				"Test 1");

		runTest(solver,
				new char[][]{
						{'0','1'},
						{'1','0'}
				},
				1,
				"Test 2");

		runTest(solver,
				new char[][]{
						{'0'}
				},
				0,
				"Test 3");
	}
}