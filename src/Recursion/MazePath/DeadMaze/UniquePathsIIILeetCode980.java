package Recursion.MazePath.DeadMaze;

import java.util.*;

/**
 * ===========================================================
 * LeetCode 980 — Unique Paths III
 * ===========================================================

 * You are given an m×n grid where:
 *   • 1 → starting square (only one exists)
 *   • 2 → ending square (only one exists)
 *   • 0 → empty square (walkable)
 *   • -1 → obstacle (cannot walk)

 * Return the number of 4‑directional walks from start to end
 * that visit every non‑obstacle square exactly once.
 * -----------------------------------------------------------
 * Example 1:
 * Input : grid = [[1,0,0,0],
 *                 [0,0,0,0],
 *                 [0,0,2,-1]]
 * Output: 2

 * Example 2:
 * Input : grid = [[1,0,0,0],
 *                 [0,0,0,0],
 *                 [0,0,0,2]]
 * Output: 4

 * Example 3:
 * Input : grid = [[0,1],
 *                 [2,0]]
 * Output: 0

 * -----------------------------------------------------------
 * Constraints:
 *  1 ≤ m, n ≤ 20,  1 ≤ m × n ≤ 20
 *  −1 ≤ grid[i][j] ≤ 2
 *  Exactly one 1 (start) and one 2 (end).
 * -----------------------------------------------------------
 */

public class UniquePathsIIILeetCode980 {

    // ===========================================================
    // Brute‑Force Approach (try all paths)
    // ===========================================================
    public int uniquePathsIII_Brute(int[][] grid) {
        int stRow=0,stCol=0,count=0;
        for(int i = 0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if((grid[i][j]==1)){
                    stRow=i;
                    stCol=j;
                }
                if((grid[i][j]==0)){
                    count++;
                }
            }
        }

        // As 1 is also a non- Obstetrical
        count++;


        return finder(grid,stRow,stCol,count);
    }

    private int finder(int[][] grid, int row, int col, int remaining) {


        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1) {
            return 0;
        }
        if(grid[row][col] == 2 ){
            return remaining == 0 ? 1 : 0;
        }

        int ch = grid[row][col];
        grid[row][col] = -1;


        int sum=0;
        sum+=finder(grid,row+1,col,remaining-1);
        sum+=finder(grid,row-1,col,remaining-1);
        sum+=finder(grid,row,col+1,remaining-1);
        sum+=finder(grid,row,col-1,remaining-1);
        grid[row][col] = ch;

        /*
        ye lagane ki jroort nai kuki, humne upr hi dekh liya aadr remaining 0 nhi hoga to path add mt kro
        --> remaining++;
         */
        return sum;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (for trace / debug practice)
    // ===========================================================
    public int uniquePathsIII_TryYourSelf(int[][] grid) {
        // TODO: Implement recursive traced version
        return 0; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized Backtracking Solution — O(m×n×4^(m×n))
    // ===========================================================
    public int uniquePathsIII(int[][] grid) {
        // TODO: Implement optimized backtracking solution
        return 0; // placeholder
    }

    // ===========================================================
    // 🧾 Test Runner — prints each variant’s output
    // ===========================================================
    private static void runTest(UniquePathsIIILeetCode980 solver,
                                int[][] grid, int expected, String testName) {
        System.out.println("🔹 " + testName);
        for (int[] row : grid) System.out.println(Arrays.toString(row));
        System.out.println("Expected: " + expected);

        int brute = solver.uniquePathsIII_Brute(grid);
        int your  = solver.uniquePathsIII_TryYourSelf(grid);
        int opt   = solver.uniquePathsIII(grid);

        System.out.printf("Brute Force      : %-5s%n", brute);
        System.out.printf("TryYourSelf      : %-5s%n", your);
        System.out.printf("Optimized (O(4^(m×n))) : %-5s%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Test Dashboard
    // ===========================================================
    public static void main(String[] args) {
        UniquePathsIIILeetCode980 solver = new UniquePathsIIILeetCode980();

        System.out.println("=================================================");
        System.out.println("🧭  Unique Paths III — Tests");
        System.out.println("=================================================\n");

        int[][] grid1 = {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,2,-1}
        };
        int[][] grid2 = {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,0,2}
        };
        int[][] grid3 = {
                {0,1},
                {2,0}
        };

        runTest(solver, grid1, 2, "Test 1");
        runTest(solver, grid2, 4, "Test 2");
        runTest(solver, grid3, 0, "Test 3");
    }
}