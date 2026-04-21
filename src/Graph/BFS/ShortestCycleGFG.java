package Graph.BFS;
import java.util.*;

public class ShortestCycleGFG {

	public int shortestCycleMethod1(int V, int[][] edges) {

		return 0;
	}

	public int shortestCycleMethod2(int V, int[][] edges) {
		return 0;
	}

	public int shortestCycleMethod3(int V, int[][] edges) {
		return 0;
	}

	private static void runTest(ShortestCycleGFG solver,
	                            int V, int[][] edges, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : V = " + V + ", edges = " + Arrays.deepToString(edges));
		System.out.println("Expected  : " + expected);

		int m1 = solver.shortestCycleMethod1(V, edges);
		int m2 = solver.shortestCycleMethod2(V, edges);
		int m3 = solver.shortestCycleMethod3(V, edges);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		ShortestCycleGFG solver = new ShortestCycleGFG();

		System.out.println("=================================================");
		System.out.println("Shortest Cycle in Graph - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				7,
				new int[][]{
						{0, 5}, {0, 6}, {5, 1}, {6, 1},
						{6, 2}, {2, 3}, {3, 4}, {1, 4}
				},
				4,
				"Test 1");

		runTest(solver,
				7,
				new int[][]{
						{0, 5}, {0, 6}, {1, 2}, {1, 4},
						{1, 5}, {1, 6}, {2, 6}, {2, 3}, {3, 4}
				},
				3,
				"Test 2");
	}
}
