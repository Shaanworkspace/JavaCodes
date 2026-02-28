package Graphs.DFS;

import java.util.*;

public class FindEventualSafeStatesLeetCode802 {

	public List<Integer> eventualSafeNodesDFS(int[][] graph) {
		return new ArrayList<>();
	}

	public List<Integer> eventualSafeNodesBFS(int[][] graph) {
		int n = graph.length;
		//Make REVERSE Adj List with graph
		List<List<Integer>> adjM = new ArrayList<>();
		for (int i = 0; i < n; i++) adjM.add(new ArrayList<>());
		for (int i = 0; i < n; i++) {
			for (int a : graph[i]) {
				adjM.get(a).add(i);
			}
		}
		System.out.println(adjM);

		int[] inbound = new int[n];
		for (List<Integer> a : adjM) for (int b : a) inbound[b] = inbound[b] + 1;


		Queue<Integer> queue = new LinkedList<>();
		// adding all which have 0 inbound
		for (int i = 0; i < n; i++) if (inbound[i] == 0) queue.add(i);

		List<Integer> res = new ArrayList<>();
		while (!queue.isEmpty()) {
			int top = queue.poll();
			res.add(top);
			for (int a : adjM.get(top)) {
				inbound[a] = inbound[a] - 1;
				if (inbound[a] == 0) queue.offer(a);
			}
		}
		Collections.sort(res);
		return res;
	}

	private static void runTest(FindEventualSafeStatesLeetCode802 solver,
	                            int[][] graph,
	                            List<Integer> expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : graph = " + Arrays.deepToString(graph));
		System.out.println("Expected  : " + expected);

		List<Integer> dfs = solver.eventualSafeNodesDFS(graph);
		List<Integer> bfs = solver.eventualSafeNodesBFS(graph);

		System.out.printf("DFS              : %-20s %s%n",
				dfs, dfs.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("BFS              : %-20s %s%n",
				bfs, bfs.equals(expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		FindEventualSafeStatesLeetCode802 solver =
				new FindEventualSafeStatesLeetCode802();

		System.out.println("=================================================");
		System.out.println("Find Eventual Safe States - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}},
				Arrays.asList(2, 4, 5, 6),
				"Test 1");

		runTest(solver,
				new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}},
				Arrays.asList(4),
				"Test 2");
	}
}
