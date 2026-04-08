package Graphs;

import java.util.*;

public class MinimumHeightRootsGFG {

	public ArrayList<Integer> minHeightRootMethod1(int V, int[][] edges) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		List<List<Integer>> adjM = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			res.add(new ArrayList<>());
			adjM.add(new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {
			adjM.get(edges[i][1]).add(edges[i][0]);
			adjM.get(edges[i][0]).add(edges[i][1]);
		}

		for (int i = 0; i < V; i++) {
			res.get(height(adjM, i, -1)).add(i);
		}

		for (int i = 0; i < res.size(); i++) {
			if (!res.get(i).isEmpty()) return res.get(i);
		}

		return new ArrayList<>();
	}

	private int height(List<List<Integer>> adjM, int node, int parent) {
		if (adjM.get(node).size() == 1 && parent != -1) return 0;
		int max = 0;

		for (int nod : adjM.get(node)) {
			if (nod == parent) continue;
			max = Math.max(max, height(adjM, nod, node));
		}
		return 1 + max;
	}


	public List<Integer> minHeightRootMethod2(int V, int[][] edges) {
		ArrayList<Integer> res = new ArrayList<>();
		if (V == 1) return res;

		//making adj matrix
		ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
		int[] indegree = new int[V];
		for (int i = 0; i < V; i++) {
			adjMatrix.add(new ArrayList<>());
		}

		// adding to adjMatrix with indf7c6eegree array
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];

			indegree[v]++;
			indegree[u]++;

			adjMatrix.get(u).add(v);
			adjMatrix.get(v).add(u);
		}


		Queue<Integer> queue = new LinkedList<>();

		// Adding all leaf element to queue
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 1) queue.offer(i);
		}

		while (V > 2) {
			int n = queue.size();
			V -= n;
			for (int i = 0; i < n; i++) {
				int curr = queue.poll();
				for(int a : adjMatrix.get(curr)){
					indegree[a]--;
					if(indegree[a]==1) queue.add(a);
				}
			}
		}
		while (!queue.isEmpty()) {
			res.add(queue.poll());
		}
		return res;
	}

	public ArrayList<Integer> minHeightRootMethod3(int V, int[][] edges) {
		return new ArrayList<>();
	}

	private static void runTest(MinimumHeightRootsGFG solver,
	                            int V, int[][] edges, List<Integer> expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : V = " + V + ", edges = " + Arrays.deepToString(edges));
		System.out.println("Expected  : " + expected);

		List<Integer> m1 = solver.minHeightRootMethod1(V, edges);
		List<Integer> m2 = solver.minHeightRootMethod2(V, edges);
		List<Integer> m3 = solver.minHeightRootMethod3(V, edges);

		System.out.printf("Method 1         : %-15s %s%n",
				m1, m1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-15s %s%n",
				m2, m2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-15s %s%n",
				m3, m3.equals(expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		MinimumHeightRootsGFG solver = new MinimumHeightRootsGFG();

		System.out.println("=================================================");
		System.out.println("Minimum Height Roots - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				5,
				new int[][]{{0, 2}, {1, 2}, {2, 3}, {3, 4}},
				Arrays.asList(2, 3),
				"Test 1");

		runTest(solver,
				4,
				new int[][]{{0, 1}, {0, 2}, {0, 3}},
				Arrays.asList(0),
				"Test 2");
	}
}