package Graph.ShortestPath;

import java.util.*;

public class CheapestFlightsWithinKStopsLeetCode787 {
	static class Triplet implements Comparable<Triplet> {
		int node;
		int cost;
		int stops;

		public Triplet(int node, int cost, int stops) {
			this.node = node;
			this.cost = cost;
			this.stops = stops;
		}

		@Override
		public int compareTo(Triplet triplet) {
			return Integer.compare(this.cost, triplet.cost);
		}
	}

	static class Pair {
		int node;
		int cost;

		Pair(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}

	// BFS / level-based (K stops constraint)
	public int findCheapestPriceMethod1(int n,
	                                    int[][] flights,
	                                    int src,
	                                    int dst,
	                                    int k) {
		return 0;
	}

	// PriorityQueue / Dijkstra-style (state = node, cost, stops)
	public int findCheapestPricePriorityQueue(int n,
	                                          int[][] flights,
	                                          int src,
	                                          int dst,
	                                          int k) {

		List<List<Pair>> adjM = new ArrayList<>();
		for (int i = 0; i < n; i++) adjM.add(new ArrayList<>());
		for (int[] a : flights) {
			int source = a[0];
			int destination = a[1];
			int cost = a[2];
			adjM.get(source).add(new Pair(destination, cost));
		}

		int[][] dist = new int[n][k + 2];
		for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

		dist[src][0] = 0;

		PriorityQueue<Triplet> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Triplet(src, 0, 0));

		while (!priorityQueue.isEmpty()) {
			Triplet curr = priorityQueue.poll();
			int node = curr.node;
			int cost = curr.cost;
			int stops = curr.stops;

			if(node == dst) return cost;
			if (stops > k) continue;
			for (Pair a : adjM.get(node)) {
				int newCost = cost + a.cost;
				if (newCost < dist[a.node][stops + 1]) {
					dist[a.node][stops + 1] = newCost;
					priorityQueue.add(new Triplet(a.node, newCost, stops + 1));
				}
			}
		}
		return -1;
	}

	// Try-it-yourself / alternative idea (e.g., Bellman-Ford with K edges)
	public int findCheapestPriceTryYourself(int n,
	                                        int[][] flights,
	                                        int src,
	                                        int dst,
	                                        int k) {
		return 0;
	}

	private static void runTest(CheapestFlightsWithinKStopsLeetCode787 solver,
	                            int n,
	                            int[][] flights,
	                            int src,
	                            int dst,
	                            int k,
	                            int expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : n = " + n +
				", flights = " + Arrays.deepToString(flights) +
				", src = " + src +
				", dst = " + dst +
				", k = " + k);
		System.out.println("Expected  : " + expected);

		int bfs = solver.findCheapestPriceMethod1(n, flights, src, dst, k);
		int pq = solver.findCheapestPricePriorityQueue(n, flights, src, dst, k);
		int custom = solver.findCheapestPriceTryYourself(n, flights, src, dst, k);

		System.out.printf("BFS              : %-6d %s%n",
				bfs, bfs == expected ? "PASS" : "FAIL");
		System.out.printf("PriorityQueue    : %-6d %s%n",
				pq, pq == expected ? "PASS" : "FAIL");
		System.out.printf("Try Yourself     : %-6d %s%n",
				custom, custom == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		CheapestFlightsWithinKStopsLeetCode787 solver =
				new CheapestFlightsWithinKStopsLeetCode787();

		System.out.println("=================================================");
		System.out.println("Cheapest Flights Within K Stops - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				4,
				new int[][]{
						{0, 1, 100},
						{1, 2, 100},
						{2, 0, 100},
						{1, 3, 600},
						{2, 3, 200}
				},
				0,
				3,
				1,
				700,
				"Test 1");

		runTest(solver,
				3,
				new int[][]{
						{0, 1, 100},
						{1, 2, 100},
						{0, 2, 500}
				},
				0,
				2,
				1,
				200,
				"Test 2");

		runTest(solver,
				3,
				new int[][]{
						{0, 1, 100},
						{1, 2, 100},
						{0, 2, 500}
				},
				0,
				2,
				0,
				500,
				"Test 3");
	}
}
