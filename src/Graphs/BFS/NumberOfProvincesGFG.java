package Graphs.BFS;

import java.util.*;

public class NumberOfProvincesGFG {

	public int numProvincesMethod1(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean[] vis = new boolean[V];
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (vis[i]) continue;
			dfs(adj, i, vis);
			count++;
		}
		return count;
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adjMatrix, int node, boolean[] vis) {
		vis[node] = true;
		for (int i = 0; i < adjMatrix.get(node).size(); i++) {
			int val = adjMatrix.get(node).get(i);
			if (val == 0 || i == node) continue;
			if (!vis[i]) dfs(adjMatrix, i, vis);
			vis[i] = true;
		}
	}

	public int numProvincesMethod2(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean[] vis = new boolean[V];
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (vis[i]) continue;
			bfs(adj, i, vis);
			count++;
		}
		return count;
	}

	private void bfs(ArrayList<ArrayList<Integer>> adjMatrix, int node, boolean[] vis) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(node);
		vis[node] = true;
		while(!queue.isEmpty()){
			int ele = queue.poll();
			vis[ele] = true;
			for (int i = 0; i < adjMatrix.get(ele).size(); i++) {
				int val = adjMatrix.get(ele).get(i);
				if (val == 0 || i == node) continue;
				if(!vis[i]) queue.add(i);
			}

		}
	}

	public int numProvincesMethod3(ArrayList<ArrayList<Integer>> adj, int V) {
		return 0;
	}

	private static void runTest(NumberOfProvincesGFG solver,
	                            ArrayList<ArrayList<Integer>> adj, int V, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : adj = " + adj + ", V = " + V);
		System.out.println("Expected  : " + expected);

		int m1 = solver.numProvincesMethod1(adj, V);
		int m2 = solver.numProvincesMethod2(adj, V);
		int m3 = solver.numProvincesMethod3(adj, V);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	private static ArrayList<ArrayList<Integer>> toAdjList(int[][] matrix) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			for (int j = 0; j < matrix[i].length; j++) {
				row.add(matrix[i][j]);
			}
			adj.add(row);
		}
		return adj;
	}

	public static void main(String[] args) {

		NumberOfProvincesGFG solver = new NumberOfProvincesGFG();

		System.out.println("=================================================");
		System.out.println("Number of Provinces - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				toAdjList(new int[][]{
						{1, 0, 1},
						{0, 1, 0},
						{1, 0, 1}
				}),
				3,
				2,
				"Test 1");

		runTest(solver,
				toAdjList(new int[][]{
						{1, 1},
						{1, 1}
				}),
				2,
				1,
				"Test 2");
	}
}
