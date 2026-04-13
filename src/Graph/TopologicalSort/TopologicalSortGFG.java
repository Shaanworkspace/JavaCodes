package Graph.TopologicalSort;

import java.util.*;

public class TopologicalSortGFG {

	public ArrayList<Integer> topoSortMethod1(int V, int[][] edges) {
		Stack<Integer> stack = new Stack<>();
		boolean[] vis = new boolean[V];

		ArrayList<ArrayList<Integer>> adjM = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adjM.add(new ArrayList<>());
		}
		for(int[] a : edges){
			int u = a[0];
			int v = a[1];
			adjM.get(u).add(v);
		}
		for(int i =0;i<V;i++){
			if(!vis[i]) dfs(adjM,i,vis,stack);
		}

		ArrayList<Integer> res = new ArrayList<>();
		while(!stack.isEmpty()){
			res.add(stack.pop());
		}
		return res;
	}

	private void dfs(ArrayList<ArrayList<Integer>> edges, int node, boolean[] vis, Stack<Integer> stack) {
		vis[node] = true;
		for(int a : edges.get(node)){
			if(!vis[a]) dfs(edges, a, vis, stack);
		}
		stack.push(node);
	}

	public ArrayList<Integer> topoSortMethod2(int V, int[][] edges) {
		ArrayList<Integer> res = new ArrayList<>();
		return res;
	}

	public ArrayList<Integer> topoSortMethod3(int V, int[][] edges) {
		return new ArrayList<>();
	}

	private static void runTest(TopologicalSortGFG solver,
	                            int V, int[][] edges, String testName) {

		System.out.println(testName);
		System.out.println("Input     : V = " + V + ", edges = " + Arrays.deepToString(edges));

		ArrayList<Integer> m1 = solver.topoSortMethod1(V, edges);
		ArrayList<Integer> m2 = solver.topoSortMethod2(V, edges);
		ArrayList<Integer> m3 = solver.topoSortMethod3(V, edges);

		System.out.printf("Method 1         : %-20s %s%n",
				m1, isValidTopoSort(V, edges, m1) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-20s %s%n",
				m2, isValidTopoSort(V, edges, m2) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-20s %s%n",
				m3, isValidTopoSort(V, edges, m3) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	private static boolean isValidTopoSort(int V, int[][] edges, ArrayList<Integer> topo) {
		if (topo.size() != V) return false;

		int[] pos = new int[V];
		for (int i = 0; i < V; i++) {
			pos[topo.get(i)] = i;
		}

		for (int[] e : edges) {
			if (pos[e[0]] > pos[e[1]]) return false;
		}
		return true;
	}

	public static void main(String[] args) {

		TopologicalSortGFG solver = new TopologicalSortGFG();

		System.out.println("=================================================");
		System.out.println("Topological Sort - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				4,
				new int[][]{{3, 0}, {1, 0}, {2, 0}},
				"Test 1");

		runTest(solver,
				6,
				new int[][]{{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5, 2}},
				"Test 2");
	}
}