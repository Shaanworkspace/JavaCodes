package DynamicProgramming.OneDimension;
import java.util.*;

public class PaintingTheFenceGFG {

	public int countWaysRecursion(int n, int k) {
		return 0;
	}

	public int countWaysRecursionMemo(int n, int k) {
		return 0;
	}

	public int countWaysTabulation(int n, int k) {
		return 0;
	}

	private static void runTest(PaintingTheFenceGFG solver,
	                            int n, int k, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : n = " + n + ", k = " + k);
		System.out.println("Expected  : " + expected);

		int recursion = solver.countWaysRecursion(n, k);
		int memo = solver.countWaysRecursionMemo(n, k);
		int tabulation = solver.countWaysTabulation(n, k);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		PaintingTheFenceGFG solver = new PaintingTheFenceGFG();

		System.out.println("=================================================");
		System.out.println("Painting the Fence - Tests");
		System.out.println("=================================================\n");

		runTest(solver, 3, 2, 6, "Test 1");
		runTest(solver, 2, 4, 16, "Test 2");
	}
}