package Graph.MinimumSpanningTree;

import java.util.*;

public class MinimumSpanningTreeGFG {

	public int spanningTreeMethod1(int V, int[][] edges) {
		return 0;
	}

	public int spanningTreeMethod2(int V, int[][] edges) {
		return 0;
	}

	public int spanningTreeMethod3(int V, int[][] edges) {
		return 0;
	}

	private static void runTest(MinimumSpanningTreeGFG solver,
	                            int V, int[][] edges, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : V = " + V + ", edges = " + Arrays.deepToString(edges));
		System.out.println("Expected  : " + expected);

		int m1 = solver.spanningTreeMethod1(V, edges);
		int m2 = solver.spanningTreeMethod2(V, edges);
		int m3 = solver.spanningTreeMethod3(V, edges);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		MinimumSpanningTreeGFG solver = new MinimumSpanningTreeGFG();

		System.out.println("=================================================");
		System.out.println("Minimum Spanning Tree - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				3,
				new int[][]{
						{0, 1, 5},
						{1, 2, 3},
						{0, 2, 1}
				},
				4,
				"Test 1");

		runTest(solver,
				2,
				new int[][]{
						{0, 1, 5}
				},
				5,
				"Test 2");
	}
}