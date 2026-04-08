package DynamicProgramming;

import java.util.*;

public class ChocolatesPickupGFG {

	public int maxChocolateRecursion(int[][] grid) {
		return finder(grid,0,0,grid[0].length-1);
	}

	private int finder(int[][] grid, int row, int c1, int c2) {

		if(row==grid.length){
			return 0;
		}
		int curr = grid[row][c1];
		if(c1!=c2){
			curr+=grid[row][c2];
		}

		int max =0;
		for(int i =-1 ; i<=1;i++){ // if robo1 goes this
			for(int j =-1;j<=1;j++){ // and for any robo1 moves , robo2 have 3 directions to move
				int nr = row+1;
				int nc1 = c1+i;
				int nc2 = c2+j;

				if(nc1< grid[0].length && nc1>=0 && nc2>=0 && nc2<grid[0].length) {
					max = Math.max(max,finder(grid,nr,nc1,nc2));
				}
			}
		}

		return curr+max;
	}




	Integer[][][] dp;
	public int maxChocolateRecursionMemo(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		dp = new Integer[row+1][col+1][col+1];
		return finder2(grid,0,0,grid[0].length-1,dp);
	}

	private int finder2(int[][] grid, int row, int c1, int c2, Integer[][][] dp) {

		if(row==grid.length){
			return 0;
		}
		if(dp[row][c1][c2]!=null) return dp[row][c1][c2];
		int curr = grid[row][c1];
		if(c1!=c2){
			curr+=grid[row][c2];
		}

		int max =0;
		for(int i =-1 ; i<=1;i++){ // if robo1 goes this
			for(int j =-1;j<=1;j++){ // and for any robo1 moves , robo2 have 3 directions to move
				int nr = row+1;
				int nc1 = c1+i;
				int nc2 = c2+j;

				if(nc1< grid[0].length && nc1>=0 && nc2>=0 && nc2<grid[0].length) {
					max = Math.max(max,finder2(grid,nr,nc1,nc2,dp));
				}
			}
		}

		return dp[row][c1][c2] = curr+max;
	}



	public int maxChocolateTabulation(int[][] grid) {
		return 0;
	}

	private static void runTest(ChocolatesPickupGFG solver,
	                            int[][] grid, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(grid));
		System.out.println("Expected  : " + expected);

		int recursion = solver.maxChocolateRecursion(grid);
		int memo = solver.maxChocolateRecursionMemo(grid);
		int tabulation = solver.maxChocolateTabulation(grid);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		ChocolatesPickupGFG solver = new ChocolatesPickupGFG();

		System.out.println("=================================================");
		System.out.println("Chocolates Pickup - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{4, 1, 2},
						{3, 6, 1},
						{1, 6, 6},
						{3, 1, 2}
				},
				32,
				"Test 1");
	}
}