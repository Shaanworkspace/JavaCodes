package Graph.ShortestPath;
import java.util.*;

public class FloydWarshallGFG {

	public void floydWarshallMethod1(int[][] dist) {
		int n = dist.length;

		// dis [i][j] = min(dis[i][j],dis[i][via] + dis[via][j])

		for(int via = 0;via<n;via++){
			for(int i =0;i<n;i++){
				for(int j =0;j<n;j++){
					if(dist[i][via] == 100000000 || dist[via][j] == 100000000 ) continue;
					dist[i][j]= Math.min(dist[i][j],dist[i][via] + dist[via][j]);
				}
			}
		}

	}

	public void floydWarshallMethod2(int[][] dist) {
	}

	public void floydWarshallMethod3(int[][] dist) {
	}

	private static void runTest(FloydWarshallGFG solver,
	                            int[][] dist, int[][] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(dist));
		System.out.println("Expected  : " + Arrays.deepToString(expected));

		int[][] d1 = copyMatrix(dist);
		int[][] d2 = copyMatrix(dist);
		int[][] d3 = copyMatrix(dist);

		solver.floydWarshallMethod1(d1);
		solver.floydWarshallMethod2(d2);
		solver.floydWarshallMethod3(d3);

		System.out.printf("Method 1         : %-20s %s%n",
				Arrays.deepToString(d1), Arrays.deepEquals(d1, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-20s %s%n",
				Arrays.deepToString(d2), Arrays.deepEquals(d2, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-20s %s%n",
				Arrays.deepToString(d3), Arrays.deepEquals(d3, expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	private static int[][] copyMatrix(int[][] mat) {
		int n = mat.length;
		int[][] copy = new int[n][];
		for (int i = 0; i < n; i++) {
			copy[i] = Arrays.copyOf(mat[i], mat[i].length);
		}
		return copy;
	}

	public static void main(String[] args) {

		FloydWarshallGFG solver = new FloydWarshallGFG();

		System.out.println("=================================================");
		System.out.println("Floyd Warshall - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{0, 4, 100000000, 5, 100000000},
						{100000000, 0, 1, 100000000, 6},
						{2, 100000000, 0, 3, 100000000},
						{100000000, 100000000, 1, 0, 2},
						{1, 100000000, 100000000, 4, 0}
				},
				new int[][]{
						{0, 4, 5, 5, 7},
						{3, 0, 1, 4, 6},
						{2, 6, 0, 3, 5},
						{3, 7, 1, 0, 2},
						{1, 5, 5, 4, 0}
				},
				"Test 1");

		runTest(solver,
				new int[][]{
						{0, -1, 2},
						{1, 0, 100000000},
						{3, 1, 0}
				},
				new int[][]{
						{0, -1, 2},
						{1, 0, 3},
						{2, 1, 0}
				},
				"Test 2");
	}
}