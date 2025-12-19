package Graphs.Basics.BFS;

import java.util.*;

public class FindIfPathExistsLeetCode1971 {

	public boolean validPathBrute(int n, int[][] edges, int source, int destination) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		//converting to adj List
		for(int[] curr : edges){
			adjList.get(curr[0]).add(curr[1]) ;
			adjList.get(curr[1]).add(curr[0]) ;
		}

		boolean[] key = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		key[source]=true;
		queue.offer(source);
		while(!queue.isEmpty()){
			int curr = queue.poll();
			for(int a: adjList.get(curr)){
				if(!key[a]){
					if(a == destination) return true;
					key[a]=true;
					queue.offer(a);
				}
			}
		}
		return key[destination];
	}

	public boolean validPathTryYourSelf(int n, int[][] edges, int source, int destination) {
		return false;
	}

	public boolean validPath(int n, int[][] edges, int source, int destination) {
		return false;
	}

	private static void runTest(FindIfPathExistsLeetCode1971 solver,
	                            int n, int[][] edges, int source, int destination,
	                            boolean expected, String name) {
		System.out.println(name);
		System.out.println("n = " + n + ", source = " + source + ", destination = " + destination);
		System.out.println("Edges: " + Arrays.deepToString(edges));

		boolean brute = solver.validPathBrute(n, edges, source, destination);
		boolean your  = solver.validPathTryYourSelf(n, edges, source, destination);
		boolean opt   = solver.validPath(n, edges, source, destination);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		FindIfPathExistsLeetCode1971 solver = new FindIfPathExistsLeetCode1971();

		int[][] edges1 = {{0,1}, {1,2}, {2,0}};
		int[][] edges2 = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
		int[][] edges3 = {{0,1}, {1,2}, {2,3}, {3,4}};
		int[][] edges4 = {};
		int[][] edges5 = {{0,1}, {2,3}};

		runTest(solver, 3, edges1, 0, 2, true, "Test 1");
		runTest(solver, 6, edges2, 0, 5, false, "Test 2");
		runTest(solver, 5, edges3, 0, 4, true, "Test 3");
		runTest(solver, 1, edges4, 0, 0, true, "Test 4");
		runTest(solver, 4, edges5, 0, 3, false, "Test 5");
	}
}