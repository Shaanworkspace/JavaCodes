package Graphs.ShortestPath;

import java.util.*;

public class CheapestFlightsWithinKStopsLeetCode787 {
	static class Triplet implements Comparable<Triplet>{
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
			return (this.stops == triplet.stops) ? Integer.compare(this.cost,triplet.cost) : Integer.compare(this.stops,triplet.stops);
		}
	}

	static class Pair {
		int node;
		int cost;

		Pair(int node,int cost){
			this.node = node;
			this.cost = cost;
		}
	}

	// BFS / level-based (K stops constraint)
	public int findCheapestPriceBFS(int n,
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

		List<List<Pair>> adjList = new ArrayList<>();
		for(int i =0;i<n;i++) adjList.add(new ArrayList<>());
		for(int[] flight : flights){
			int u = flight[0],v=flight[1],w=flight[2];
			adjList.get(u).add(new Pair(v,w));
		}

		int[] ans = new int[n];
		Arrays.fill(ans,Integer.MAX_VALUE);
		PriorityQueue<Triplet> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Triplet(src,0,0));
		ans[src]=0;

		while(!priorityQueue.isEmpty()){
			Triplet top = priorityQueue.poll();
			int node = top.node,stops = top.stops,cost = top.cost;
			if(stops == k+1) continue;
			for(Pair pair:adjList.get(node)){
				int totalCost = cost + pair.cost;

				if(totalCost<ans[pair.node]){
					ans[pair.node]= totalCost;
					priorityQueue.add(new Triplet(pair.node,totalCost,stops+1));
				}
			}
		}

		return (ans[dst] == Integer.MAX_VALUE) ? -1 : ans[dst];
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

		int bfs = solver.findCheapestPriceBFS(n, flights, src, dst, k);
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
						{0,1,100},
						{1,2,100},
						{2,0,100},
						{1,3,600},
						{2,3,200}
				},
				0,
				3,
				1,
				700,
				"Test 1");

		runTest(solver,
				3,
				new int[][]{
						{0,1,100},
						{1,2,100},
						{0,2,500}
				},
				0,
				2,
				1,
				200,
				"Test 2");

		runTest(solver,
				3,
				new int[][]{
						{0,1,100},
						{1,2,100},
						{0,2,500}
				},
				0,
				2,
				0,
				500,
				"Test 3");
	}
}
