package Greedy.Interval;

import java.util.*;

public class MergeIntervalsLeetCode56 {

	public int[][] merge(int[][] intervals) {
		int n = intervals.length;
		if(n==1) return intervals;

		Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
		int[][] ans = new int[n][2];
		int idx = 0;
		ans[0][0] = intervals[0][0];
		ans[0][1] = intervals[0][1];

		for(int i =1;i<n;i++){
			if (ans[idx][1] >= intervals[i][0]) {
				ans[idx][1] = Math.max(ans[idx][1], intervals[i][1]);
			}
			else {
				idx++;
				ans[idx][0] = intervals[i][0];
				ans[idx][1] = intervals[i][1];
			}
		}
		return Arrays.copyOf(ans, idx + 1);
	}

	private static void runTest(MergeIntervalsLeetCode56 solver,
	                            int[][] intervals, int[][] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(intervals));
		System.out.println("Expected  : " + Arrays.deepToString(expected));

		int[][] result = solver.merge(intervals);

		System.out.printf("Result          : %-30s %s%n",
				Arrays.deepToString(result),
				Arrays.deepEquals(result, expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		MergeIntervalsLeetCode56 solver =
				new MergeIntervalsLeetCode56();

		System.out.println("=================================================");
		System.out.println("Merge Intervals - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{{1,3},{2,6},{8,10},{15,18}},
				new int[][]{{1,6},{8,10},{15,18}},
				"Test 1");

		runTest(solver,
				new int[][]{{1,4},{4,5}},
				new int[][]{{1,5}},
				"Test 2");

		runTest(solver,
				new int[][]{{4,7},{1,4}},
				new int[][]{{1,7}},
				"Test 3");
	}
}
