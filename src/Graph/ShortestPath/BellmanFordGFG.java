package Graph.ShortestPath;

import java.util.*;

public class BellmanFordGFG {

	public int[] bellmanFordMethod1(int V, int[][] edges, int src) {
		int[] dis = new int[V];
		int INF = 100000000;
		Arrays.fill(dis, INF);
		dis[src] = 0;

		for (int i = 0; i < V - 1; i++) {
			for (int[] curr : edges) {
				int u = curr[0];
				int v = curr[1];
				int w = curr[2];
				if (dis[u] != INF && dis[u] + w < dis[v]) {
					dis[v] = dis[u] + w;
				}
			}
		}

		for (int[] curr : edges) {
			int u = curr[0];
			int v = curr[1];
			int w = curr[2];

			if (dis[u] != INF && dis[u] + w < dis[v]) {
				return new int[]{-1};
			}
		}

		return dis;
	}

	public int[] bellmanFordMethod2(int V, int[][] edges, int src) {
		return new int[0];
	}

	public int[] bellmanFordMethod3(int V, int[][] edges, int src) {
		return new int[0];
	}

	private static void runTest(BellmanFordGFG solver,
	                            int V, int[][] edges, int src, int[] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : V = " + V + ", edges = " + Arrays.deepToString(edges) + ", src = " + src);
		System.out.println("Expected  : " + Arrays.toString(expected));

		int[] m1 = solver.bellmanFordMethod1(V, edges, src);
		int[] m2 = solver.bellmanFordMethod2(V, edges, src);
		int[] m3 = solver.bellmanFordMethod3(V, edges, src);

		System.out.printf("Method 1         : %-15s %s%n",
				Arrays.toString(m1), Arrays.equals(m1, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-15s %s%n",
				Arrays.toString(m2), Arrays.equals(m2, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-15s %s%n",
				Arrays.toString(m3), Arrays.equals(m3, expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		BellmanFordGFG solver = new BellmanFordGFG();

		System.out.println("=================================================");
		System.out.println("Bellman-Ford - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				5,
				new int[][]{
						{1, 3, 2}, {4, 3, -1}, {2, 4, 1},
						{1, 2, 1}, {0, 1, 5}
				},
				0,
				new int[]{0, 5, 6, 6, 7},
				"Test 1");

		runTest(solver,
				4,
				new int[][]{
						{0, 1, 4}, {1, 2, -6}, {2, 3, 5}, {3, 1, -2}
				},
				0,
				new int[]{-1},
				"Test 2");
	}
}