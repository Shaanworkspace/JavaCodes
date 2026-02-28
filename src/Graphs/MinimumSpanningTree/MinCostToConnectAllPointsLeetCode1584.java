package Graphs.MinimumSpanningTree;
import java.util.*;

public class MinCostToConnectAllPointsLeetCode1584 {

	static class Triplet implements Comparable<Triplet>{
		int node;
		int parent;
		int cost;

		Triplet(int node, int parent, int cost){
			this.node = node;
			this.parent = parent;
			this.cost = cost;
		}

		@Override
		public int compareTo(Triplet pair) {
			return (pair.cost == this.cost)  ? this.node - pair.node : this.cost-pair.cost;
		}
	}

	public int minCostConnectPoints(int[][] points) {
		int n = points.length,sum=0;
		boolean[] vis = new boolean[n];
		PriorityQueue<Triplet> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Triplet(0,-1,0));

		while (!priorityQueue.isEmpty()){
			Triplet triplet = priorityQueue.poll();
			int node = triplet.node,parent = triplet.parent,cost = triplet.cost;
			if(vis[node]) continue;
			vis[node] = true;
			sum+=cost;

			for(int i=0;i<n;i++){
				if(i==node || i== parent || vis[i]) continue;

				int x1 = points[node][0], y1 = points[node][1];
				int x2 = points[i][0],y2 = points[i][1];
				int manhattanHeight = Math.abs(x2-x1) + Math.abs(y2-y1);
				priorityQueue.add(new Triplet(i,node,manhattanHeight));
			}
		}
		return sum;
	}

	private static void runTest(MinCostToConnectAllPointsLeetCode1584 solver,
	                            int[][] points, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(points));
		System.out.println("Expected  : " + expected);

		int result = solver.minCostConnectPoints(points);

		System.out.printf("Result          : %-10d %s%n",
				result, result == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		MinCostToConnectAllPointsLeetCode1584 solver =
				new MinCostToConnectAllPointsLeetCode1584();

		System.out.println("=================================================");
		System.out.println("Min Cost to Connect All Points - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}},
				20,
				"Test 1");

		runTest(solver,
				new int[][]{{3,12},{-2,5},{-4,1}},
				18,
				"Test 2");
	}
}
