package Graph.DFS;
import java.util.*;

public class LongestCycleInGraphGFG {

	public int longestCycleMethod1(int V, int[][] edges) {
		return 0;
	}

	public int longestCycleMethod2(int V, int[][] edges) {
		return 0;
	}

	public int longestCycleMethod3(int V, int[][] edges) {
		return 0;
	}

	private static void runTest(LongestCycleInGraphGFG solver,
	                            int V, int[][] edges, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : V = " + V + ", edges = " + Arrays.deepToString(edges));
		System.out.println("Expected  : " + expected);

		int m1 = solver.longestCycleMethod1(V, edges);
		int m2 = solver.longestCycleMethod2(V, edges);
		int m3 = solver.longestCycleMethod3(V, edges);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		LongestCycleInGraphGFG solver = new LongestCycleInGraphGFG();

		System.out.println("=================================================");
		System.out.println("Length of Longest Cycle in a Graph - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				7,
				new int[][]{
						{0,5},{1,0},{2,4},{3,1},{4,6},{5,6},{6,3}
				},
				5,
				"Test 1");

		runTest(solver,
				8,
				new int[][]{
						{0,1},{1,2},{2,3},{3,0},{4,1},{5,4},{6,2},{7,6}
				},
				4,
				"Test 2");
	}
}