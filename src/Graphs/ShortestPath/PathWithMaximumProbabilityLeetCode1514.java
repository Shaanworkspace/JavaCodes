package Graphs.ShortestPath;

import java.util.*;

public class PathWithMaximumProbabilityLeetCode1514 {

	static class Pair implements Comparable<Pair>{
		int node;
		double prob;

		Pair(int node,double prob){
			this.node = node;
			this.prob = prob;
		}

		@Override
		public int compareTo(Pair pair) {
			return Double.compare(this.prob,pair.prob);
		}
	}

	// BFS style (probability relaxation without priority)
	public double maxProbabilityBFS(int n,
	                                int[][] edges,
	                                double[] succProb,
	                                int start,
	                                int end) {

		//making adj List
		List<List<Pair>> adjList = new ArrayList<>();
		for(int i =0;i<n;i++) adjList.add(new ArrayList<>());
		int idx =0;
		for(int[] a : edges){
			int u = a[0],v=a[1];
			double prob = succProb[idx++];
			adjList.get(u).add(new Pair(v,prob));
		}


		double[] probs = new double[n];
		probs[start] =1;

		// to build max heap
		PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		priorityQueue.add(new Pair(start,1));

		while (!priorityQueue.isEmpty()){
			Pair top = priorityQueue.poll();
			for(Pair a : adjList.get(top.node)){
				double total = top.prob * a.prob; // Probability is always multiplicative in nature
				if(total>probs[a.node]){
					probs[a.node] = total;
					priorityQueue.add(new Pair(a.node,total));
				}
			}
		}
		return probs[end];
	}

	// PriorityQueue / Dijkstra-style (max heap on probability)
	public double maxProbabilityPriorityQueue(int n,
	                                          int[][] edges,
	                                          double[] succProb,
	                                          int start,
	                                          int end) {
		return 0.0;
	}

	// Try-it-yourself / custom logic slot
	public double maxProbabilityTryYourself(int n,
	                                        int[][] edges,
	                                        double[] succProb,
	                                        int start,
	                                        int end) {
		return 0.0;
	}

	private static void runTest(PathWithMaximumProbabilityLeetCode1514 solver,
	                            int n,
	                            int[][] edges,
	                            double[] succProb,
	                            int start,
	                            int end,
	                            double expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : n = " + n +
				", edges = " + Arrays.deepToString(edges) +
				", succProb = " + Arrays.toString(succProb) +
				", start = " + start +
				", end = " + end);
		System.out.println("Expected  : " + expected);

		double bfs = solver.maxProbabilityBFS(n, edges, succProb, start, end);
		double pq = solver.maxProbabilityPriorityQueue(n, edges, succProb, start, end);
		double custom = solver.maxProbabilityTryYourself(n, edges, succProb, start, end);

		System.out.printf("BFS              : %-10.5f %s%n",
				bfs, Math.abs(bfs - expected) < 1e-5 ? "PASS" : "FAIL");
		System.out.printf("PriorityQueue    : %-10.5f %s%n",
				pq, Math.abs(pq - expected) < 1e-5 ? "PASS" : "FAIL");
		System.out.printf("Try Yourself     : %-10.5f %s%n",
				custom, Math.abs(custom - expected) < 1e-5 ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		PathWithMaximumProbabilityLeetCode1514 solver =
				new PathWithMaximumProbabilityLeetCode1514();

		System.out.println("=================================================");
		System.out.println("Path With Maximum Probability - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				3,
				new int[][]{{0,1},{1,2},{0,2}},
				new double[]{0.5,0.5,0.2},
				0,
				2,
				0.25,
				"Test 1");

		runTest(solver,
				3,
				new int[][]{{0,1},{1,2},{0,2}},
				new double[]{0.5,0.5,0.3},
				0,
				2,
				0.3,
				"Test 2");

		runTest(solver,
				3,
				new int[][]{{0,1}},
				new double[]{0.5},
				0,
				2,
				0.0,
				"Test 3");
	}
}
