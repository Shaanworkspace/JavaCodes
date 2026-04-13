package Graph.ShortestPath;

import java.util.*;

public class FindTheCityLeetCode1334 {

	// Try yourself
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int[][] dis = new int[n][n];
		for (int[] a : dis) Arrays.fill(a, Integer.MAX_VALUE);
		for (int i = 0; i < n; i++) dis[i][i] = 0;

		for (int[] a : edges) {
			int u = a[0];
			int v = a[1];
			int w = a[2];

			dis[u][v] = w;
			dis[v][u] = w;
		}

		// Floyd Warshell
		for (int via = 0; via < n; via++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (dis[i][via] == Integer.MAX_VALUE || dis[via][j] == Integer.MAX_VALUE) continue;
					dis[i][j] = Math.min(dis[i][j], dis[i][via] + dis[via][j]);
				}
			}
		}

		int[] res = new int[n];
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int count =0;
			for (int j = 0; j < n; j++) {
				if (dis[i][j] != Integer.MAX_VALUE && dis[i][j] <= distanceThreshold) count++;
			}
			min = Math.min(min,count);
			res[i] = count;
		}

		for (int j = n-1; j >=0;j--) {
			if (res[j]==min) return j;
		}
		return -1;
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
