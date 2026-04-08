package Graphs.DFS;

import java.util.*;

public class DFSOfGraphGFG {

	public ArrayList<Integer> dfsMethod1(ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> arr = new ArrayList<>();
		boolean[] vis = new boolean[adj.size()];
		dfs(adj, arr,0, vis);
		return arr;
	}

	private void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> arr, int idx, boolean[] vis) {
		if(vis[idx]) return;
		vis[idx] = true;
		arr.add(idx);
		for(int  a : adj.get(idx)){
			if(!vis[a]) {
				dfs(adj,arr,a,vis);
			}
		}
	}

	public ArrayList<Integer> dfsMethod2(ArrayList<ArrayList<Integer>> adj) {
		return new ArrayList<>();
	}

	public ArrayList<Integer> dfsMethod3(ArrayList<ArrayList<Integer>> adj) {
		return new ArrayList<>();
	}

	private static void runTest(DFSOfGraphGFG solver,
	                            ArrayList<ArrayList<Integer>> adj,
	                            ArrayList<Integer> expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + adj);
		System.out.println("Expected  : " + expected);

		ArrayList<Integer> m1 = solver.dfsMethod1(adj);
		ArrayList<Integer> m2 = solver.dfsMethod2(adj);
		ArrayList<Integer> m3 = solver.dfsMethod3(adj);

		System.out.printf("Method 1         : %-15s %s%n",
				m1, m1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-15s %s%n",
				m2, m2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-15s %s%n",
				m3, m3.equals(expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		DFSOfGraphGFG solver = new DFSOfGraphGFG();

		System.out.println("=================================================");
		System.out.println("DFS of Graph - Tests");
		System.out.println("=================================================\n");

		ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
		adj1.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
		adj1.add(new ArrayList<>(Arrays.asList(0)));
		adj1.add(new ArrayList<>(Arrays.asList(0, 4)));
		adj1.add(new ArrayList<>(Arrays.asList(0)));
		adj1.add(new ArrayList<>(Arrays.asList(2)));

		runTest(solver,
				adj1,
				new ArrayList<>(Arrays.asList(0, 2, 4, 3, 1)),
				"Test 1");

		ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
		adj2.add(new ArrayList<>(Arrays.asList(1, 2)));
		adj2.add(new ArrayList<>(Arrays.asList(0, 2)));
		adj2.add(new ArrayList<>(Arrays.asList(0, 1, 3, 4)));
		adj2.add(new ArrayList<>(Arrays.asList(2)));
		adj2.add(new ArrayList<>(Arrays.asList(2)));

		runTest(solver,
				adj2,
				new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4)),
				"Test 2");
	}
}