package Collections.Set;

import java.util.*;

public class UnionOfArraysWithDuplicatesGFG {

	// Method 1: Brute force idea (try yourself)
	public static ArrayList<Integer> findUnionMethod1(int[] a, int[] b) {
		HashSet<Integer> set = new HashSet<>();
		for(int i : a){
			set.add(i);
		}
		for(int ele : b) set.add(ele);

		return new ArrayList<>(set);
	}

	// Method 2: Better approach using extra data structure (try yourself)
	public static ArrayList<Integer> findUnionMethod2(int[] a, int[] b) {
		return new ArrayList<>();
	}

	// Method 3: Optimized / expected approach (try yourself)
	public static ArrayList<Integer> findUnionMethod3(int[] a, int[] b) {
		return new ArrayList<>();
	}

	private static void runTest(int[] a, int[] b,
	                            ArrayList<Integer> expected, String testName) {

		System.out.println(testName);
		System.out.println("Array A  : " + Arrays.toString(a));
		System.out.println("Array B  : " + Arrays.toString(b));
		System.out.println("Expected : " + expected);

		ArrayList<Integer> r1 = findUnionMethod1(a, b);
		ArrayList<Integer> r2 = findUnionMethod2(a, b);
		ArrayList<Integer> r3 = findUnionMethod3(a, b);

		Collections.sort(r1);
		Collections.sort(r2);
		Collections.sort(r3);

		System.out.printf("Method 1        : %-15s %s%n",
				r1, r1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-15s %s%n",
				r2, r2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3        : %-15s %s%n",
				r3, r3.equals(expected) ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		System.out.println("=================================================");
		System.out.println("Union of Arrays with Duplicates - Tests");
		System.out.println("=================================================\n");

		runTest(
				new int[]{1, 2, 3, 2, 1},
				new int[]{3, 2, 2, 3, 3, 2},
				new ArrayList<>(Arrays.asList(1, 2, 3)),
				"Test 1"
		);

		runTest(
				new int[]{1, 2, 3},
				new int[]{4, 5, 6},
				new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
				"Test 2"
		);

		runTest(
				new int[]{1, 2, 1, 1, 2},
				new int[]{2, 2, 1, 2, 1},
				new ArrayList<>(Arrays.asList(1, 2)),
				"Test 3"
		);
	}
}