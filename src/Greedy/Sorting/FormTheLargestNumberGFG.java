package Greedy.Sorting;

import java.util.*;

public class FormTheLargestNumberGFG {

	// Method 1: Basic approach (try yourself)
	public String largestNumberMethod1(int[] arr) {
		String[] nums = new String[arr.length];
		for (int i = 0; i < arr.length; i++) nums[i] = String.valueOf(arr[i]);

		Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

		if (nums[0].equals("0")) return "0";

		StringBuilder str = new StringBuilder();
		for (String s : nums) str.append(s);
		return str.toString();
	}

	// Method 2: Optimized approach (try yourself)
	public String largestNumberMethod2(int[] arr) {
		return "";
	}

	// Method 3: Best / final approach (try yourself)
	public String largestNumberMethod3(int[] arr) {
		return "";
	}

	private static void runTest(FormTheLargestNumberGFG solver,
	                            int[] arr, String expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(arr));
		System.out.println("Expected  : " + expected);

		String r1 = solver.largestNumberMethod1(arr);
		String r2 = solver.largestNumberMethod2(arr);
		String r3 = solver.largestNumberMethod3(arr);

		System.out.printf("Method 1        : %-15s %s%n",
				r1, r1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-15s %s%n",
				r2, r2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3        : %-15s %s%n",
				r3, r3.equals(expected) ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		FormTheLargestNumberGFG solver =
				new FormTheLargestNumberGFG();

		System.out.println("=================================================");
		System.out.println("Form the Largest Number - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{3, 30, 34, 5, 9},
				"9534330",
				"Test 1");

		runTest(solver,
				new int[]{54, 546, 548, 60},
				"6054854654",
				"Test 2");

		runTest(solver,
				new int[]{3, 4, 6, 5, 9},
				"96543",
				"Test 3");
	}
}