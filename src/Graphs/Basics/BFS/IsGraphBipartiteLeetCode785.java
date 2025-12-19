package Graphs.Basics.BFS;
import java.util.*;

public class IsGraphBipartiteLeetCode785 {

	public boolean isBipartiteBrute(int[][] graph) {
		int n = graph.length;
		int[] color = new int[n];
		Arrays.fill(color,-1);

		//Red -> 0
		//Black -> 1
		for(int i =0;i<n;i++){
			if(color[i]==-1){
				if (!bfs(graph, i, color)) {
					// Found a conflict in this component
					return false;
				}
			}
		}
		return true;
	}
	private boolean bfs(int[][] graph, int root, int[] color) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(root);
		color[root] = 0;
		while(!queue.isEmpty()){
			int node = queue.poll();
			for (int neighbor : graph[node]) {
				if (color[neighbor] == -1) {
					color[neighbor] = 1 - color[node];
					queue.offer(neighbor);
				} else if (color[neighbor] == color[node]) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean isBipartiteTryYourSelf(int[][] graph) {
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

		boolean brute = solver.isBipartiteBrute(graph);
		boolean your  = solver.isBipartiteTryYourSelf(graph);
		boolean opt   = solver.isBipartite(graph);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		IsGraphBipartiteLeetCode785 solver = new IsGraphBipartiteLeetCode785();

		int[][] graph1 = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
		int[][] graph2 = {{1,3}, {0,2}, {1,3}, {0,2}};
		int[][] graph3 = {{1}, {0,3}, {3}, {1,2}};
		int[][] graph4 = {{}, {2,4,6}, {1,4,8,9}, {7,8}, {1,2,8,9}, {6,9}, {1,5,7,8,9}, {3,6,9}, {2,3,4,6,9}, {2,4,5,6,7,8}};
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
