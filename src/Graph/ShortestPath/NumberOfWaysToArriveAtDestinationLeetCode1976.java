package Graph.ShortestPath;

import java.util.*;

public class NumberOfWaysToArriveAtDestinationLeetCode1976 {

	class Pair implements Comparable<Pair> {
		int node;
		long time;

		public Pair(long time, int node) {
			this.time = time;
			this.node = node;
		}


		@Override
		public int compareTo(Pair o) {
			return Long.compare(this.time, o.time);
		}
	}

	public int countPathsMethod1(int n, int[][] roads) {
		int MOD = (int) 1e9 + 7;

		List<List<Pair>> adjM = new ArrayList<>();
		for (int i = 0; i < n; i++) adjM.add(new ArrayList<>());
		for (int[] a : roads) {
			int from = a[0];
			int to = a[1];
			int time = a[2];

			adjM.get(from).add(new Pair(time, to));
			adjM.get(to).add(new Pair(time, from));
		}

		long[] ways = new long[n]; // to store no. of ways count to reach at this location
		ways[0] = 1;

		long[] dist = new long[n];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[0] = 0;


		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, 0));

		while (!pq.isEmpty()) {
			Pair curr = pq.poll();
			int node = curr.node;
			long time = curr.time;

			for (Pair nei : adjM.get(node)) {
				long newDist = time + nei.time;

				if (newDist < dist[nei.node]) {
					dist[nei.node] = newDist;
					ways[nei.node] = ways[node];
					pq.add(new Pair(newDist, nei.node));
				} else if (newDist == dist[nei.node]) {
					ways[nei.node] = (ways[nei.node] + ways[node]) % MOD;
					//No need to re-enter in queue
				}
			}
		}
		return (int) (ways[n - 1] % MOD);
	}

	public int countPathsMethod2(int n, int[][] roads) {
		return 0;
	}

	public int countPathsMethod3(int n, int[][] roads) {
		return 0;
	}

	private static void runTest(NumberOfWaysToArriveAtDestinationLeetCode1976 solver,
	                            int n, int[][] roads, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : n = " + n + ", roads = " + Arrays.deepToString(roads));
		System.out.println("Expected  : " + expected);

		int m1 = solver.countPathsMethod1(n, roads);
		int m2 = solver.countPathsMethod2(n, roads);
		int m3 = solver.countPathsMethod3(n, roads);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		NumberOfWaysToArriveAtDestinationLeetCode1976 solver =
				new NumberOfWaysToArriveAtDestinationLeetCode1976();

		System.out.println("=================================================");
		System.out.println("Number of Ways to Arrive at Destination - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				7,
				new int[][]{
						{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3},
						{6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1},
						{0, 4, 5}, {4, 6, 2}
				},
				4,
				"Test 1");

		runTest(solver,
				2,
				new int[][]{
						{1, 0, 10}
				},
				1,
				"Test 2");
	}
}