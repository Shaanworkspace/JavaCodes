package Graph;

import java.util.*;

public class UndirectedGraphCycleGFG {

	public boolean hasCycleMethod1(int V, int[][] edges) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

		for (int[] a : edges) {
			adj.get(a[0]).add(a[1]);
			adj.get(a[1]).add(a[0]);
		}

		boolean[] vis = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				if (detectDFS(adj, vis, i, -1)) return true;
			}
		}
		return false;
	}

	private boolean detectDFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node, int parent) {
		vis[node] = true;
		for (int a : adj.get(node)) {
			if (a == parent) continue;
			if (vis[a]) return true;
			if (detectDFS(adj, vis, a, node)) return true;
		}
		return false;
	}

	public boolean hasCycleMethod2(int V, int[][] edges) {
		boolean[] vis = new boolean[V];
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

		for (int[] a : edges) {
			adj.get(a[0]).add(a[1]);
			adj.get(a[1]).add(a[0]);
		}
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				if (detectBFS(adj, vis, i)) return true;
			}
		}
		return false;
	}


	private boolean detectBFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{node, -1});
		vis[node] = true;

		while (!queue.isEmpty()) {
			int[] cu = queue.poll();
			int curr = cu[0], parent = cu[1];
			for (int nei : adj.get(curr)) {
				if (!vis[nei]) {
					vis[nei] = true;
					queue.add(new int[]{nei, curr});
				} else if (nei != parent) {
					return true;
				}
			}
		}
		return false;
	}


	public boolean hasCycleMethod3(int V, int[][] edges) {
		List<List<Integer>> adjM = new ArrayList<>();

		for (int i = 0; i < V; i++) adjM.add(new ArrayList<>());
		for (int[] a : edges) {
			int u = a[0];
			int v = a[1];
			adjM.get(u).add(v);
			adjM.get(v).add(u);
		}


		for (int i = 0; i < V; i++) {
			boolean[] vis = new boolean[V];
			if (dfs(i, -1, vis, adjM)){
				return true;
			}
		}
		return false;
	}

	private boolean dfs(int node, int parent, boolean[] vis, List<List<Integer>> adjM) {
		vis[node] = true;
		for (int a : adjM.get(node)) {
			if (!vis[a]) {
				return dfs(a, node, vis, adjM);
			}
			if (vis[a] && a != parent) return true;
		}
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
		System.out.println("Undirected Graph Cycle - Tests");
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