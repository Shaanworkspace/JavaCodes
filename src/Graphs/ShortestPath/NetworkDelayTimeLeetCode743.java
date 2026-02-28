package Graphs.ShortestPath;
import java.util.*;

public class NetworkDelayTimeLeetCode743 {

	static class Pair implements Comparable<Pair>{
		int node;
		int time;

		Pair(int node,int time){
			this.node = node;
			this.time = time;
		}

		@Override
		public int compareTo(Pair pair) {
			return (pair.time == this.time)  ? this.node- pair.node : this.time-pair.time;
		}
	}


	// Dijkstra using PriorityQueue (recommended)
	public int networkDelayTimePriorityQueue(int[][] times, int n, int src) {
		//Making adj List
		List<List<Pair>> adjList = new ArrayList<>();
		for(int i =0;i<=n;i++) adjList.add(new ArrayList<>());
		for(int[] time : times){
			int u = time[0],v=time[1],w=time[2];
			adjList.get(u).add(new Pair(v,w));
		}

		int[] cost = new int[n+1];
		Arrays.fill(cost,Integer.MAX_VALUE);
		cost[src] =0;

		PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Pair(src,0));

		while(!priorityQueue.isEmpty()){
			Pair top = priorityQueue.poll();
			if(top.time>cost[top.node]) continue;

			for(Pair p : adjList.get(top.node)){
				int totalTime = top.time + p.time;
				if(totalTime<cost[p.node]){
					cost[p.node] = totalTime;
					priorityQueue.add(new Pair(p.node,totalTime));
				}
			}
		}

		int max = -1;
		for (int i = 1; i <= n; i++) {
			if (cost[i] == Integer.MAX_VALUE) return -1;
			max = Math.max(max, cost[i]);
		}
		return max;
	}


	public int networkDelayTimeBellmanFord(int[][] times, int n, int src) {
		int[] cost = new int[n+1];
		Arrays.fill(cost,Integer.MAX_VALUE);
		cost[src] =0;

		for(int i =1;i<=n-1;i++){
			for(int j = 0;j<times.length;j++){
				int u = times[j][0];
				int v = times[j][1];
				int wt = times[j][2];

				if(cost[u]!=Integer.MAX_VALUE && cost[u] + wt < cost[v]){
					cost[v] = cost[u]+wt;
				}
			}
		}


		int max = -1;
		for (int i = 1; i <= n; i++) {
			if (cost[i] == Integer.MAX_VALUE) return -1;
			max = Math.max(max, cost[i]);
		}
		return max;
	}
	// Optional: brute / try-yourself placeholder
	public int networkDelayTimeTryYourself(int[][] times, int n, int k) {
		return 0;
	}

	private static void runTest(NetworkDelayTimeLeetCode743 solver,
	                            int[][] times,
	                            int n,
	                            int k,
	                            int expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : times = " + Arrays.deepToString(times)
				+ ", n = " + n + ", k = " + k);
		System.out.println("Expected  : " + expected);

		int bfs = solver.networkDelayTimeBellmanFord(times, n, k);
		int pq = solver.networkDelayTimePriorityQueue(times, n, k);
		int custom = solver.networkDelayTimeTryYourself(times, n, k);

		System.out.printf("BellMan ford    : %-5d %s%n",
				bfs, bfs == expected ? "PASS" : "FAIL");
		System.out.printf("PriorityQueue    : %-5d %s%n",
				pq, pq == expected ? "PASS" : "FAIL");
		System.out.printf("Try Yourself     : %-5d %s%n",
				custom, custom == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		NetworkDelayTimeLeetCode743 solver =
				new NetworkDelayTimeLeetCode743();

		System.out.println("=================================================");
		System.out.println("Network Delay Time - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{{2,1,1},{2,3,1},{3,4,1}},
				4,
				2,
				2,
				"Test 1");

		runTest(solver,
				new int[][]{{1,2,1}},
				2,
				1,
				1,
				"Test 2");

		runTest(solver,
				new int[][]{{1,2,1}},
				2,
				2,
				-1,
				"Test 3");
	}
}
