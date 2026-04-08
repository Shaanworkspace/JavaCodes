package Array;
import java.util.*;

public class CountSubmatricesTopLeftLessThanKLeetCode3070 {

	public int countSubmatricesMethod1(int[][] grid, int k) {
		int cout=0;
		for(int i =0;i<grid.length;i++){
			for(int j =0;j<grid[0].length;j++){
				if(i-1>=0) grid[i][j] += grid[i-1][j];
				if(j-1>=0) grid[i][j] += grid[i][j-1];
				if(i-1>=0 && j-1>=0) grid[i][j] -= grid[i-1][j-1];

				if(grid[i][j]<k) cout++;
				
			}
		}
		return cout;
	}

	public int countSubmatricesMethod2(int[][] grid, int k) {
		return 0;
	}

	public int countSubmatricesMethod3(int[][] grid, int k) {
		return 0;
	}

	private static void runTest(CountSubmatricesTopLeftLessThanKLeetCode3070 solver,
	                            int[][] grid, int k, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : grid = " + Arrays.deepToString(grid) + ", k = " + k);
		System.out.println("Expected  : " + expected);

		int m1 = solver.countSubmatricesMethod1(grid, k);
		int m2 = solver.countSubmatricesMethod2(grid, k);
		int m3 = solver.countSubmatricesMethod3(grid, k);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		CountSubmatricesTopLeftLessThanKLeetCode3070 solver =
				new CountSubmatricesTopLeftLessThanKLeetCode3070();

		System.out.println("=================================================");
		System.out.println("Count Submatrices with Top-Left and Sum <= k - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{{7,6,3},{6,6,1}},
				18,
				4,
				"Test 1");

		runTest(solver,
				new int[][]{{7,2,9},{1,5,0},{2,6,6}},
				20,
				6,
				"Test 2");
	}
}