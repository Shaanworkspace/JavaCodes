package Greedy.Interval;

import java.util.*;

public class MinimumNumberOfArrowsLeetCode452 {

	public int findMinArrowShotsBrute(int[][] points) {
		Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
		int arrow = 1,n=points.length,end = points[0][1];

		for(int i =1;i<n;i++){
			int start = points[i][0];
			if(start<=end){
				end = Math.min(end,points[i][1]);
			}else{
				arrow++;
				end = points[i][1];
			}
		}
		return arrow;
	}

	public int findMinArrowShotsRecursionMemo(int[][] points) {
		return 0;
	}

	public int findMinArrowShotsTabulation(int[][] points) {
		return 0;
	}

	private static void runTest(MinimumNumberOfArrowsLeetCode452 solver,
	                            int[][] points, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(points));
		System.out.println("Expected  : " + expected);

		int recursion = solver.findMinArrowShotsBrute(points);
		int memo = solver.findMinArrowShotsRecursionMemo(points);
		int tabulation = solver.findMinArrowShotsTabulation(points);

		System.out.printf("Recursion        : %-5d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-5d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-5d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		MinimumNumberOfArrowsLeetCode452 solver =
				new MinimumNumberOfArrowsLeetCode452();

		System.out.println("=================================================");
		System.out.println("Minimum Number of Arrows to Burst Balloons - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{{10,16},{2,8},{1,6},{7,12}},
				2,
				"Test 1");

		runTest(solver,
				new int[][]{{1,2},{3,4},{5,6},{7,8}},
				4,
				"Test 2");

		runTest(solver,
				new int[][]{{1,2},{2,3},{3,4},{4,5}},
				2,
				"Test 3");
	}
}
