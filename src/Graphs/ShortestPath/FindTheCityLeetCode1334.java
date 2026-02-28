package Graphs.ShortestPath;

import java.util.*;

public class FindTheCityLeetCode1334 {

	// Try yourself
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int[][] cost = new int[n][n];
		for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) cost[i][j] = Integer.MAX_VALUE;

		for (int[] a : edges) {
			int u = a[0];
			int v = a[1];
			int wt = a[2];
			cost[u][v] = wt;
			cost[v][u] = wt;
		}

		//mujhe har ek se har ek tkminCity chaiye : BellmanFORD
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (i == k) continue;
				for (int j = 0; j < n; j++) {
					if (j == k) continue;
					if (cost[i][k] != Integer.MAX_VALUE && cost[k][j] != Integer.MAX_VALUE)
						cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
				}
			}
		}

		int minCity = -1;
		int minCount = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (cost[i][j] <= distanceThreshold) count++;
			}

			if (count <= minCount) {
				minCount = count;
				minCity = i;
			}
		}
		return minCity;
	}

	private static void runTest(FindTheCityLeetCode1334 solver,
	                            int n, int[][] edges, int distanceThreshold,
	                            int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : n = " + n);
		System.out.println("Edges     : " + Arrays.deepToString(edges));
		System.out.println("Threshold : " + distanceThreshold);
		System.out.println("Expected  : " + expected);

		int result = solver.findTheCity(n, edges, distanceThreshold);

		System.out.printf("Result          : %-5d %s%n",
				result, result == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		FindTheCityLeetCode1334 solver =
				new FindTheCityLeetCode1334();

		System.out.println("=================================================");
		System.out.println("Find the City With the Smallest Number of Neighbors");
		System.out.println("=================================================\n");

		runTest(solver,
				4,
				new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}},
				4,
				3,
				"Test 1");

		runTest(solver,
				5,
				new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}},
				2,
				0,
				"Test 2");
	}
}
