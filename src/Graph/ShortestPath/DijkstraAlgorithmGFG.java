package Graph.ShortestPath;

import java.util.*;

public class DijkstraAlgorithmGFG {

	class Pair implements Comparable<Pair> {
		int weight;
		int node;

		Pair(int w, int n) {
			weight = w;
			node = n;
		}


		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public int[] dijkstraMethod1(int V, int[][] edges, int src) {
		ArrayList<ArrayList<Pair>> adjM = new ArrayList<>();
		for (int i = 0; i < V; i++) adjM.add(new ArrayList<>());
		for (int[] a : edges) {
			int u = a[0];
			int v = a[1];
			int w = a[2];

			adjM.get(u).add(new Pair(w, v));
			adjM.get(v).add(new Pair(w, u));
		}

		int[] dis = new int[V];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[src] = 0;

		PriorityQueue<Pair> queue = new PriorityQueue<>();
		queue.add(new Pair(0, src));

		while (!queue.isEmpty()) {
			Pair curr = queue.poll();
			int currNode = curr.node;
			int currWeight = curr.weight;
			if (currWeight > dis[currNode]) continue;
			for (Pair p : adjM.get(currNode)) {
				if (dis[p.node] > currWeight + p.weight) {
					dis[p.node] = currWeight + p.weight;
					queue.add(new Pair(dis[p.node], p.node));
				}
			}
		}
		return dis;
	}

	public int[] dijkstraMethod2(int V, int[][] edges, int src) {
		return new int[V];
	}

	public int[] dijkstraMethod3(int V, int[][] edges, int src) {
		return new int[V];
	}

	private static void runTest(DijkstraAlgorithmGFG solver,
	                            int V, int[][] edges, int src,
	                            int[] expected, String testName) {

		System.out.println(testName);
		System.out.println("V         : " + V);
		System.out.println("Edges     : " + Arrays.deepToString(edges));
		System.out.println("Source    : " + src);
		System.out.println("Expected  : " + Arrays.toString(expected));

		int[] m1 = solver.dijkstraMethod1(V, edges, src);
		int[] m2 = solver.dijkstraMethod2(V, edges, src);
		int[] m3 = solver.dijkstraMethod3(V, edges, src);

		System.out.printf("Method 1         : %-20s %s%n",
				Arrays.toString(m1), Arrays.equals(m1, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-20s %s%n",
				Arrays.toString(m2), Arrays.equals(m2, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-20s %s%n",
				Arrays.toString(m3), Arrays.equals(m3, expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		DijkstraAlgorithmGFG solver = new DijkstraAlgorithmGFG();

		System.out.println("=================================================");
		System.out.println("Dijkstra Algorithm - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				3,
				new int[][]{{0, 1, 1}, {1, 2, 3}, {0, 2, 6}},
				2,
				new int[]{4, 3, 0},
				"Test 1");

		runTest(solver,
				5,
				new int[][]{{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2, 3, 2}, {3, 4, 10}},
				0,
				new int[]{0, 4, 8, 10, 10},
				"Test 2");
	}
}
