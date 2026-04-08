package Graphs;

import java.util.*;

public class NumberOfOperationsToMakeNetworkConnectedLeetCode1319 {

	public int makeConnectedMethod1(int n, int[][] connections) {
		if (connections.length < n - 1) return -1;
		List<List<Integer>> adjM = new ArrayList<>();
		for (int i = 0; i < n; i++) adjM.add(new ArrayList<>());
		for (int[] a : connections) {
			int u = a[0];
			int v = a[1];

			adjM.get(u).add(v);
			adjM.get(v).add(u);
		}

		boolean[] vis = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				dfs(i, vis,-1,adjM);
				count++;
			}
		}
		return count-1;
	}

	private void dfs(int node, boolean[] vis, int parent, List<List<Integer>> adjM) {
		vis[node] = true;
		for(int a : adjM.get(node)){
			if(a==parent) continue;
			if(!vis[a]) dfs(a,vis, node, adjM);
		}
	}

	public int makeConnectedMethod2(int n, int[][] connections) {
		return 0;
	}

	public int makeConnectedMethod3(int n, int[][] connections) {
		return 0;
	}

	private static void runTest(NumberOfOperationsToMakeNetworkConnectedLeetCode1319 solver,
	                            int n, int[][] connections, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : n = " + n + ", connections = " + Arrays.deepToString(connections));
		System.out.println("Expected  : " + expected);

		int m1 = solver.makeConnectedMethod1(n, connections);
		int m2 = solver.makeConnectedMethod2(n, connections);
		int m3 = solver.makeConnectedMethod3(n, connections);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		NumberOfOperationsToMakeNetworkConnectedLeetCode1319 solver =
				new NumberOfOperationsToMakeNetworkConnectedLeetCode1319();

		System.out.println("=================================================");
		System.out.println("Number of Operations to Make Network Connected - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				4,
				new int[][]{{0, 1}, {0, 2}, {1, 2}},
				1,
				"Test 1");

		runTest(solver,
				6,
				new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}},
				2,
				"Test 2");

		runTest(solver,
				6,
				new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}},
				-1,
				"Test 3");
	}
}