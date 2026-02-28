package Array;

import java.util.*;

public class FindClosestPairFromTwoArraysGFG {

	// Method 1: Brute force (try yourself)
	public ArrayList<Integer> findClosestPairMethod1(int[] arr1, int[] arr2, int x) {
		int a = 0, b = 0, min = Integer.MAX_VALUE;
		// Generate all pairs
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				int arr1Ele = arr1[i];
				int arr2Ele = arr2[j];
				int absDiff = Math.abs(x - (arr1Ele + arr2Ele));
				if (absDiff < min) {
					a = arr1Ele;
					b = arr2Ele;
					min = absDiff;
				}
			}
		}
		// Return
		return new ArrayList<>(List.of(a, b));
	}

	// Method 2: Better approach (try yourself)
	public ArrayList<Integer> findClosestPairMethod2(int[] arr1, int[] arr2, int x) {
		int i = 0;
		int j = arr2.length - 1;
		int minDiff = Integer.MAX_VALUE;
		int a = 0, b = 0;

		while (i < arr1.length && j >= 0) {
			int sum = arr1[i] + arr2[j];
			int diff = Math.abs(x - sum);

			if (diff < minDiff) {
				minDiff = diff;
				a = arr1[i];
				b = arr2[j];
			}

			if (sum > x) {
				j--;
			} else {
				i++;
			}
		}
		return new ArrayList<>(List.of(a, b));
	}

	// Method 3: Optimized two-pointer approach (try yourself)
	public ArrayList<Integer> findClosestPairMethod3(int[] arr1, int[] arr2, int x) {
		return new ArrayList<>();
	}

	private static void runTest(FindClosestPairFromTwoArraysGFG solver,
	                            int[] arr1, int[] arr2, int x,
	                            List<Integer> expected, String testName) {

		System.out.println(testName);
		System.out.println("arr1     : " + Arrays.toString(arr1));
		System.out.println("arr2     : " + Arrays.toString(arr2));
		System.out.println("x        : " + x);
		System.out.println("Expected : " + expected);

		List<Integer> r1 = solver.findClosestPairMethod1(arr1, arr2, x);
		List<Integer> r2 = solver.findClosestPairMethod2(arr1, arr2, x);
		List<Integer> r3 = solver.findClosestPairMethod3(arr1, arr2, x);

		System.out.printf("Method 1        : %-15s%n", r1);
		System.out.printf("Method 2        : %-15s%n", r2);
		System.out.printf("Method 3        : %-15s%n", r3);

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		FindClosestPairFromTwoArraysGFG solver =
				new FindClosestPairFromTwoArraysGFG();

		System.out.println("=================================================");
		System.out.println("Find Closest Pair From Two Arrays - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1, 4, 5, 7},
				new int[]{10, 20, 30, 40},
				32,
				Arrays.asList(1, 30),
				"Test 1");

		runTest(solver,
				new int[]{1, 4, 5, 7},
				new int[]{10, 20, 30, 40},
				50,
				Arrays.asList(7, 40),
				"Test 2");
	}
}