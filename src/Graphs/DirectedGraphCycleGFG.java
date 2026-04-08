package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectedGraphCycleGFG {

	public boolean hasCycleMethod1(int V, int[][] edges) {
		boolean[] vis = new boolean[V];
		boolean[] thisRecursion = new boolean[V];
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

		for (int[] a : edges) {
			adj.get(a[0]).add(a[1]);
			adj.get(a[1]).add(a[0]);
		}
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				if (detectDFS(adj, vis, thisRecursion, i, -1)) return true;
			}
		}
		return false;
	}

	private boolean detectDFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] thisRecursion, int node, int parent) {

		vis[node] = true;
		for(int i : adj.get(node)){

		}
		return false;
	}

	public boolean hasCycleMethod2(int V, int[][] edges) {

		return false;
	}


	public boolean hasCycleMethod3(int V, int[][] edges) {
		return false;
	}

	private static void runTest(UndirectedGraphCycleGFG solver,
	                            int V, int[][] edges, boolean expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : V = " + V + ", edges = " + Arrays.deepToString(edges));
		System.out.println("Expected  : " + expected);

		boolean m1 = solver.hasCycleMethod1(V, edges);
		boolean m2 = solver.hasCycleMethod2(V, edges);
		boolean m3 = solver.hasCycleMethod3(V, edges);

		System.out.printf("Method 1         : %-10b %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10b %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10b %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		UndirectedGraphCycleGFG solver = new UndirectedGraphCycleGFG();

		System.out.println("=================================================");
		System.out.println("Directed Graph Cycle - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				4,
				new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}},
				true,
				"Test 1");

		runTest(solver,
				4,
				new int[][]{{0, 1}, {1, 2}, {2, 3}},
				false,
				"Test 2");
	}
}