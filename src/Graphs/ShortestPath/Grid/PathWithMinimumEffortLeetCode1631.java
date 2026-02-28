package Graphs.ShortestPath.Grid;

import java.util.*;

public class PathWithMinimumEffortLeetCode1631 {

	static class Triplet implements Comparable<Triplet>{
		int r;
		int c;
		int cost;

		Triplet(int r,int c,int cost){
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Triplet pair) {
			return (pair.cost == this.cost)  ? this.r- pair.r : this.cost-pair.cost;
		}
	}

	// BFS style (binary search + BFS idea or relaxed grid traversal)
	public int minimumEffortPathBFS(int[][] heights) {
		return 0;
	}

	public int minimumEffortPathPriorityQueue(int[][] heights) {
		int n = heights.length;
		int m = heights[0].length;

		int[][] ans = new int[n][m];
		for(int i =0;i<n;i++)
			for (int j =0;j<m;j++)
				ans[i][j] = Integer.MAX_VALUE;


		PriorityQueue<Triplet> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Triplet(0,0,0));

		int[] chR = {-1,1,0,0}; // UP, DOWN , Left , Right
		int[] chC = {0,0,-1,1};

		while(!priorityQueue.isEmpty()){
			Triplet triplet = priorityQueue.poll();

			int r = triplet.r;
			int c = triplet.c;
			int cost = triplet.cost;

			for(int i =0;i<4;i++){
				int newR = r+chR[i],newC= c+chC[i];

				if(newR<0 || newR>=n || newC<0 || newC>=m) continue;

				int newCost = Math.abs(heights[r][c]-heights[newR][newC]);
				newCost= Math.max(newCost,cost);

				if(ans[newR][newC]>newCost){
					ans[newR][newC]=newCost;
					priorityQueue.add(new Triplet(newR,newC,newCost));
				}
			}
		}
		return ans[n-1][m-1];
	}

	// Try-it-yourself / custom experimentation slot
	public int minimumEffortPathTryYourself(int[][] heights) {
		return 0;
	}

	private static void runTest(PathWithMinimumEffortLeetCode1631 solver,
	                            int[][] heights,
	                            int expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : heights = " + Arrays.deepToString(heights));
		System.out.println("Expected  : " + expected);

		int bfs = solver.minimumEffortPathBFS(heights);
		int pq = solver.minimumEffortPathPriorityQueue(heights);
		int custom = solver.minimumEffortPathTryYourself(heights);

		System.out.printf("BFS              : %-5d %s%n",
				bfs, bfs == expected ? "PASS" : "FAIL");
		System.out.printf("PriorityQueue    : %-5d %s%n",
				pq, pq == expected ? "PASS" : "FAIL");
		System.out.printf("Try Yourself     : %-5d %s%n",
				custom, custom == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		PathWithMinimumEffortLeetCode1631 solver =
				new PathWithMinimumEffortLeetCode1631();

		System.out.println("=================================================");
		System.out.println("Path With Minimum Effort - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{{1,2,2},{3,8,2},{5,3,5}},
				2,
				"Test 1");

		runTest(solver,
				new int[][]{{1,2,3},{3,8,4},{5,3,5}},
				1,
				"Test 2");

		runTest(solver,
				new int[][]{
						{1,2,1,1,1},
						{1,2,1,2,1},
						{1,2,1,2,1},
						{1,2,1,2,1},
						{1,1,1,2,1}
				},
				0,
				"Test 3");
	}
}
