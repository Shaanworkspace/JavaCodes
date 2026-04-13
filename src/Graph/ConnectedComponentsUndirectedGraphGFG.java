package Graph;

import java.util.*;

public class ConnectedComponentsUndirectedGraphGFG {

	public ArrayList<ArrayList<Integer>> getComponentsMethod1(int V, int[][] edges) {
		if (V == 0) return new ArrayList<>();
		ArrayList<ArrayList<Integer>> adjM = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adjM.add(new ArrayList<>());
		}
		for (int[] a : edges) {
			int u = a[0];
			int v = a[1];

			adjM.get(u).add(v);
			adjM.get(v).add(u);
		}

		boolean[] vis = new boolean[V];
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			if (!vis[i]) bfs(adjM, vis, i, res);
		}
		return res;
	}

	private void bfs(ArrayList<ArrayList<Integer>> adjM, boolean[] vis, int node, ArrayList<ArrayList<Integer>> res) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(node);
		vis[node] = true;
		ArrayList<Integer> part = new ArrayList<>();
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			part.add(curr);
			for (int a : adjM.get(curr)) {
				if (!vis[a]) {
					vis[a] = true;
					queue.add(a);
				}
			}
		}
		res.add(part);
	}

	public ArrayList<ArrayList<Integer>> getComponentsMethod2(int V, int[][] edges) {
		return new ArrayList<>();
	}

	public ArrayList<ArrayList<Integer>> getComponentsMethod3(int V, int[][] edges) {
		return new ArrayList<>();
	}

	private static void runTest(ConnectedComponentsUndirectedGraphGFG solver,
	                            int V, int[][] edges,
	                            ArrayList<ArrayList<Integer>> expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : V = " + V + ", edges = " + Arrays.deepToString(edges));
		System.out.println("Expected  : " + expected);

		ArrayList<ArrayList<Integer>> m1 = solver.getComponentsMethod1(V, edges);
		ArrayList<ArrayList<Integer>> m2 = solver.getComponentsMethod2(V, edges);
		ArrayList<ArrayList<Integer>> m3 = solver.getComponentsMethod3(V, edges);

		System.out.printf("Method 1         : %-20s %s%n",
				m1, "CHECK");
		System.out.printf("Method 2         : %-20s %s%n",
				m2, "CHECK");
		System.out.printf("Method 3         : %-20s %s%n",
				m3, "CHECK");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		ConnectedComponentsUndirectedGraphGFG solver =
				new ConnectedComponentsUndirectedGraphGFG();

		System.out.println("=================================================");
		System.out.println("Connected Components in an Undirected Graph - Tests");
		System.out.println("=================================================\n");

		ArrayList<ArrayList<Integer>> expected1 = new ArrayList<>();
		expected1.add(new ArrayList<>(Arrays.asList(0, 1, 2)));
		expected1.add(new ArrayList<>(Arrays.asList(3, 4)));

		runTest(solver,
				5,
				new int[][]{{0, 1}, {2, 1}, {3, 4}},
				expected1,
				"Test 1");

		ArrayList<ArrayList<Integer>> expected2 = new ArrayList<>();
		expected2.add(new ArrayList<>(Arrays.asList(0, 1, 6)));
		expected2.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
		expected2.add(new ArrayList<>(Arrays.asList(5)));

		runTest(solver,
				7,
				new int[][]{{0, 1}, {6, 0}, {2, 4}, {2, 3}, {3, 4}},
				expected2,
				"Test 2");
	}
}