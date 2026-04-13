package Graph.ShortestPath;

import java.util.*;

public class ShortestPathInDAGGFG {

	class Pair {
		int data;
		int weight;

		Pair(int d, int w) {
			data = d;
			weight = w;
		}
	}

	public int[] shortestPathMethod1(int V, int E, int[][] edges) {
		ArrayList<ArrayList<Pair>> adjM = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adjM.add(new ArrayList<>());
		}

		boolean[] vis = new boolean[V];
		for (int[] a : edges) {
			int u = a[0];
			int v = a[1];
			int w = a[2];

			adjM.get(u).add(new Pair(v, w));
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < V; i++) {
			if (!vis[i]) dfs(adjM, i, stack, vis);
		}
		int[] dis = new int[V];
		Arrays.fill(dis, Integer.MAX_VALUE);

		dis[0] = 0;
		while (!stack.isEmpty()) {
			int data = stack.pop();
			for (Pair a : adjM.get(data)) {
				if (dis[data] != Integer.MAX_VALUE) {
					dis[a.data] = Math.min(dis[a.data], a.weight + dis[data]);
				}
			}
		}

		for(int i =0;i<dis.length;i++){
			if(dis[i]==Integer.MAX_VALUE) dis[i] = -1;
		}
		return dis;
	}

	private void dfs(ArrayList<ArrayList<Pair>> adjM, int node, Stack<Integer> stack, boolean[] vis) {
		vis[node] = true;

		for (Pair a : adjM.get(node)) {
			int data = a.data;
			if (!vis[data]) dfs(adjM, data, stack, vis);
		}

		stack.push(node);
	}

	public int[] shortestPathMethod2(int V, int E, int[][] edges) {
		return new int[V];
	}

	public int[] shortestPathMethod3(int V, int E, int[][] edges) {
		return new int[V];
	}

	private static void runTest(ShortestPathInDAGGFG solver,
	                            int V, int E, int[][] edges,
	                            int[] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : V = " + V + ", E = " + E);
		System.out.println("Edges     : " + Arrays.deepToString(edges));
		System.out.println("Expected  : " + Arrays.toString(expected));

		int[] m1 = solver.shortestPathMethod1(V, E, edges);
		int[] m2 = solver.shortestPathMethod2(V, E, edges);
		int[] m3 = solver.shortestPathMethod3(V, E, edges);

		System.out.printf("Method 1         : %-20s %s%n",
				Arrays.toString(m1), Arrays.equals(m1, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-20s %s%n",
				Arrays.toString(m2), Arrays.equals(m2, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-20s %s%n",
				Arrays.toString(m3), Arrays.equals(m3, expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		ShortestPathInDAGGFG solver = new ShortestPathInDAGGFG();

		System.out.println("=================================================");
		System.out.println("Shortest Path in DAG - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				4,
				2,
				new int[][]{{0, 1, 2}, {0, 2, 1}},
				new int[]{0, 2, 1, -1},
				"Test 1");

		runTest(solver,
				6,
				7,
				new int[][]{
						{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2},
						{1, 2, 3}, {2, 3, 6}, {5, 3, 1}
				},
				new int[]{0, 2, 3, 6, 1, 5},
				"Test 2");
	}
}