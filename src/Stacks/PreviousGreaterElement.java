package Stacks;

import java.util.*;

public class PreviousGreaterElement {

	// Method 1
	public int[] previousGreaterElementMethod1(int[] arr) {
		return new int[arr.length];
	}

	// Method 2
	public int[] previousGreaterElementMethod2(int[] arr) {
		return new int[arr.length];
	}

	private static void runTest(PreviousGreaterElement solver,
	                            int[] arr, int[] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(arr));
		System.out.println("Expected  : " + Arrays.toString(expected));

		int[] r1 = solver.previousGreaterElementMethod1(arr);
		int[] r2 = solver.previousGreaterElementMethod2(arr);

		System.out.printf("Method 1  : %-20s %s%n",
				Arrays.toString(r1), Arrays.equals(r1, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2  : %-20s %s%n",
				Arrays.toString(r2), Arrays.equals(r2, expected) ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		PreviousGreaterElement solver = new PreviousGreaterElement();

		runTest(solver, new int[]{4,5,2,10}, new int[]{-1,-1,5,-1}, "Test 1");
		runTest(solver, new int[]{3,2,1}, new int[]{-1,3,2}, "Test 2");
		runTest(solver, new int[]{1,3,2,4}, new int[]{-1,-1,3,-1}, "Test 3");
		runTest(solver, new int[]{6,8,0,1,3}, new int[]{-1,-1,8,8,8}, "Test 4");
	}
}