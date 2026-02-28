package Greedy.Interval;

import java.util.*;

public class MaximumOverlappingIntervalsGFG {

	// Line sweep / prefix-diff style (start +1, end -1)
	public int maxOverlappingIntervalsLineSweep(int[][] arr) {
		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int[] interval : arr) {
			int start = interval[0];
			int end = interval[1];

			map.put(start, map.getOrDefault(start, 0) + 1);
			map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
		}

		int max = 0, current = 0;

		for (int val : map.values()) {
			current += val;
			max = Math.max(max, current);
		}
		return max;
	}

	// Sorting based approach (separate start & end arrays)
	public int maxOverlappingIntervalsSorting(int[][] arr) {
		Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));

		return 0;
	}

	// Try-it-yourself / alternate logic slot
	public int maxOverlappingIntervalsTryYourself(int[][] arr) {
		return 0;
	}

	private static void runTest(MaximumOverlappingIntervalsGFG solver,
	                            int[][] arr,
	                            int expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : arr = " + Arrays.deepToString(arr));
		System.out.println("Expected  : " + expected);

		int sweep = solver.maxOverlappingIntervalsLineSweep(arr);
		int sort = solver.maxOverlappingIntervalsSorting(arr);
		int custom = solver.maxOverlappingIntervalsTryYourself(arr);

		System.out.printf("Line Sweep       : %-5d %s%n",
				sweep, sweep == expected ? "PASS" : "FAIL");
		System.out.printf("Sorting          : %-5d %s%n",
				sort, sort == expected ? "PASS" : "FAIL");
		System.out.printf("Try Yourself     : %-5d %s%n",
				custom, custom == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		MaximumOverlappingIntervalsGFG solver =
				new MaximumOverlappingIntervalsGFG();

		System.out.println("=================================================");
		System.out.println("Maximum Number of Overlapping Intervals - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{{1,2},{2,4},{3,6}},
				2,
				"Test 1");

		runTest(solver,
				new int[][]{{1,8},{2,5},{5,6},{3,7}},
				4,
				"Test 2");
	}
}
