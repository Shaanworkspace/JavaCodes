package Graphs.Basics.BFS;

import java.util.*;

public class UndirectedGraphCycleGFG {
	public boolean isCycleBrute(int V, int[][] edges) {
		List<List<Integer>> adjList = new ArrayList<>();
		convertToAdjList(V,edges,adjList);
		boolean[] isVisited = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!isVisited[i]) {
			Queue<Pair> q = new LinkedList<>();
			q.offer(new Pair(i,-1));
				while (!q.isEmpty()) {
					Pair current = q.poll();
					int node = current.node;
					int parent = current.parent;
					for (int neighbor : adjList.get(node)) {
						if (!isVisited[neighbor]) {
							isVisited[neighbor] = true;
							q.add(new Pair(neighbor, node));
						} else if (neighbor != parent) {
							// Found a visited node not equal to parent → cycle!
							return true;
						}
					}
				}
		}}
		return false;
	}
	static class Pair{
		int node;
		int parent;
		Pair(int n , int p){
			node=n;
			parent=p;
		}
	}

	public static void convertToAdjList(int v,int[][] edges,List<List<Integer>> adjList){
		for(int i =0;i<v;i++) adjList.add(new ArrayList<>());
		for (int[] curr : edges) {
			adjList.get(curr[0]).add(curr[1]);
			adjList.get(curr[1]).add(curr[0]);
		}
	}

	public boolean isCycleTryYourSelf(int V, int[][] edges) {
		return false;
	}

	public boolean isCycle(int V, int[][] edges) {
		return false;
	}

	private static void runTest(UndirectedGraphCycleGFG solver,
	                            int V, int[][] edges, boolean expected, String name) {
		System.out.println(name);
		System.out.println("V = " + V + ", E = " + edges.length);
		if (edges.length <= 20) {
			System.out.println("Edges: " + Arrays.deepToString(edges));
		} else {
			System.out.println("Edges: [Large input - " + edges.length + " edges]");
		}

		boolean brute = solver.isCycleBrute(V, edges);
		boolean your  = solver.isCycleTryYourSelf(V, edges);
		boolean opt   = solver.isCycle(V, edges);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		UndirectedGraphCycleGFG solver = new UndirectedGraphCycleGFG();

		int[][] edges1 = {{0,1}, {0,2}, {1,2}, {2,3}};
		int[][] edges2 = {{0,1}, {1,2}, {2,3}};
		int[][] edges3 = {{0,1}, {1,2}, {2,0}, {3,4}};
		int[][] edges4 = {{0,1}, {2,3}};
		int[][] edges5 = {{0,1}, {1,2}, {2,3}, {3,4}, {4,0}};
		int[][] edges6 = {};

		int[][] edges7 = {
				{1,321}, {1,499}, {1,694}, {1,1360},
				{2,115}, {2,881},
				{3,1592},
				{4,846},
				{5,1085},
				{6,1654},
				{7,691}, {7,872}, {7,1172}, {7,1243}, {7,1721},
				{9,844}, {9,984},
				{12,724},
				{13,353}, {13,895}, {13,1107},
				{15,1514},
				{20,1679},
				{22,329}, {22,759},
				{23,124}, {23,1003},
				{24,1239}
		};

		runTest(solver, 4, edges1, true, "Test 1");
		runTest(solver, 4, edges2, false, "Test 2");
		runTest(solver, 5, edges3, true, "Test 3");
		runTest(solver, 4, edges4, false, "Test 4");
		runTest(solver, 5, edges5, true, "Test 5");
		runTest(solver, 3, edges6, false, "Test 6");
		runTest(solver, 1805, edges7, true, "Test 7 - Large GFG Case");
	}
}