package BitManipulation;
import java.util.*;

public class MaximumXOROfTwoNumbersLeetCode421 {

	public int findMaximumXORMethod1(int[] nums) {
		return 0;
	}

	public int findMaximumXORMethod2(int[] nums) {
		return 0;
	}

	public int findMaximumXORMethod3(int[] nums) {
		return 0;
	}

	private static void runTest(MaximumXOROfTwoNumbersLeetCode421 solver,
	                            int[] nums, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : nums = " + Arrays.toString(nums));
		System.out.println("Expected  : " + expected);

		int method1 = solver.findMaximumXORMethod1(nums);
		int method2 = solver.findMaximumXORMethod2(nums);
		int method3 = solver.findMaximumXORMethod3(nums);

		System.out.printf("Method 1         : %-10d %s%n",
				method1, method1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				method2, method2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				method3, method3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		MaximumXOROfTwoNumbersLeetCode421 solver =
				new MaximumXOROfTwoNumbersLeetCode421();

		System.out.println("=================================================");
		System.out.println("Maximum XOR of Two Numbers in an Array - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{3,10,5,25,2,8},
				28,
				"Test 1");

		runTest(solver,
				new int[]{14,70,53,83,49,91,36,80,92,51,66,70},
				127,
				"Test 2");
	}
}