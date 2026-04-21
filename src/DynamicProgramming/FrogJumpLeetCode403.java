package DynamicProgramming;
import java.util.*;

public class FrogJumpLeetCode403 {

	public boolean canCrossRecursion(int[] stones) {
		return false;
	}

	public boolean canCrossRecursionMemo(int[] stones) {
		return false;
	}

	public boolean canCrossTabulation(int[] stones) {
		return false;
	}

	private static void runTest(FrogJumpLeetCode403 solver,
	                            int[] stones, boolean expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : stones = " + Arrays.toString(stones));
		System.out.println("Expected  : " + expected);

		boolean r = solver.canCrossRecursion(stones);
		boolean m = solver.canCrossRecursionMemo(stones);
		boolean t = solver.canCrossTabulation(stones);

		System.out.printf("Recursion        : %-10b %s%n",
				r, r == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10b %s%n",
				m, m == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10b %s%n",
				t, t == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		FrogJumpLeetCode403 solver = new FrogJumpLeetCode403();

		System.out.println("=================================================");
		System.out.println("Frog Jump - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{0,1,3,5,6,8,12,17},
				true,
				"Test 1");

		runTest(solver,
				new int[]{0,1,2,3,4,8,9,11},
				false,
				"Test 2");
	}
}
