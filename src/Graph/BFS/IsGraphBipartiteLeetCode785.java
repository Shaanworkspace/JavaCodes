package Graph.BFS;

import java.util.*;

public class IsGraphBipartiteLeetCode785 {

	public boolean isBipartiteMethod1(int[][] graph) {
		int n = graph.length;
		int[] color = new int[n];
		Arrays.fill(color, -1);
		for (int i = 0; i < n; i++) {
			if (color[i] == -1) {
				if (!dfs(graph, i, color, 0)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean dfs(int[][] graph, int node, int[] color, int col) {
		color[node] = col;
		for (int a : graph[node]) {
			if (color[a] == -1) {
				if (!dfs(graph, a, color, 1 - col)) {
					return false;
				}
			} else if (color[a] == color[node]) {
				return false;
			}
		}
		return true;
	}

	public boolean isBipartiteMethod2(int[][] graph) {
		return false;
	}

	public boolean isBipartite(int[][] graph) {
		return false;
	}

	private static void runTest(IsGraphBipartiteLeetCode785 solver,
	                            int[][] graph, boolean expected, String name) {
		System.out.println(name);
		System.out.println("Graph (adjacency list):");
		for (int i = 0; i < graph.length; i++) {
			System.out.println(i + " -> " + Arrays.toString(graph[i]));
		}

		boolean brute = solver.isBipartiteMethod1(graph);
		boolean your = solver.isBipartiteMethod2(graph);
		boolean opt = solver.isBipartite(graph);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		IsGraphBipartiteLeetCode785 solver = new IsGraphBipartiteLeetCode785();

		int[][] graph1 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
		int[][] graph2 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
		int[][] graph3 = {{1}, {0, 3}, {3}, {1, 2}};
		int[][] graph4 = {{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}};
		int[][] graph5 = {{1}, {0}};
		int[][] graph6 = {{}};
		runTest(solver, graph1, false, "Test 1");
		runTest(solver, graph2, true, "Test 2");
		runTest(solver, graph3, true, "Test 3");
		runTest(solver, graph4, false, "Test 4");
		runTest(solver, graph5, true, "Test 5");
		runTest(solver, graph6, true, "Test 6");
	}
}
