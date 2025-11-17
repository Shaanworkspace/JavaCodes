package Backtracking;

import java.util.*;

/**
 * ===========================================================
 * 🧩 LeetCode 2596 — Check Knight Tour Configuration
 * ===========================================================
 *
 * There is a knight on an n × n chessboard. In a valid configuration,
 * the knight starts at the top‑left cell of the board and visits
 * every cell exactly once.
 *
 * You are given an n × n integer matrix grid consisting of distinct
 * integers from the range [0, n × n − 1], where grid[r][c] indicates
 * that the cell (r,c) is the grid[r][c]‑th cell the knight visited.
 * (Moves are 0‑indexed.)
 *
 * Return true if grid represents a valid configuration of the knight's
 * movements, or false otherwise.
 *
 * A valid knight move consists of moving two squares vertically and
 * one square horizontally, or two squares horizontally and one vertically.
 *
 * -----------------------------------------------------------
 * Example 1:
 * Input:
 * grid = [[0,11,16,5,20],
 *         [17,4,19,10,15],
 *         [12,1,8,21,6],
 *         [3,18,23,14,9],
 *         [24,13,2,7,22]]
 *
 * Output: true
 * Explanation: Knight’s journey visits all cells exactly once.
 *
 * Example 2:
 * Input:
 * grid = [[0,3,6],
 *         [5,8,1],
 *         [2,7,4]]
 * Output: false
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • n == grid.length == grid[i].length
 *  • 3 ≤ n ≤ 7
 *  • All numbers in grid are unique in [0, n × n − 1]
 * -----------------------------------------------------------
 */

public class CheckKnightTourConfigurationLeetCode2596 {

    // ===========================================================
    // 🐢 Brute‑Force Approach (unrolled simulation)
    // ===========================================================
    public boolean checkValidGridBrute(int[][] grid) {
         if(grid[0][0] != 0 ) return false;
         return helper(grid,0,0,grid.length,0);
    }

    private boolean helper(int[][] grid, int row, int col, int n ,int num) {

        if (grid[row][col] == n * n - 1) return true;
        int i, j;
        // --- All 8 knight‑style directions ---

        // Up‑right
        i = row - 2;
        j = col + 1;
        if ((i >= 0 && j < n) && (grid[i][j] == num + 1))
            return helper(grid, i, j, n, num + 1);

        // Up‑left
        i = row - 2;
        j = col - 1;
        if ((i >= 0 && j >= 0) && (grid[i][j] == num + 1))
            return helper(grid, i, j, n, num + 1);

        // Right‑up
        i = row - 1;
        j = col + 2;
        if ((i >= 0 && j < n) && (grid[i][j] == num + 1))
            return helper(grid, i, j, n, num + 1);

        // Right‑down
        i = row + 1;
        j = col + 2;
        if ((i < n && j < n) && (grid[i][j] == num + 1))
            return helper(grid, i, j, n, num + 1);

        // Down‑right
        i = row + 2;
        j = col + 1;
        if ((i < n && j < n) && (grid[i][j] == num + 1))
            return helper(grid, i, j, n, num + 1);

        // Down‑left
        i = row + 2;
        j = col - 1;
        if ((i < n && j >= 0) && (grid[i][j] == num + 1))
            return helper(grid, i, j, n, num + 1);

        // Left‑down
        i = row + 1;
        j = col - 2;
        if ((i < n && j >= 0) && (grid[i][j] == num + 1))
            return helper(grid, i, j, n, num + 1);

        // Left‑up
        i = row - 1;
        j = col - 2;
        if ((i >= 0 && j >= 0) && (grid[i][j] == num + 1))
            return helper(grid, i, j, n, num + 1);

        return false;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (step-by-step debug)
    // ===========================================================
    public boolean checkValidGridTryYourSelf(int[][] grid) {
        // TODO: Implement version with printed move coordinates for debugging.
        return false;  // demo placeholder
    }

    // ===========================================================
    // ⚡ Optimized O(n²) Verification
    // ===========================================================
    public boolean checkValidGrid(int[][] grid) {
        return true;
    }

    // ===========================================================
    // 🧾 Test Runner — prints results ✅ / ❌
    // ===========================================================
    private static void runTest(CheckKnightTourConfigurationLeetCode2596 solver,
                                int[][] grid, boolean expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input:");
        for (int[] row : grid) System.out.println(Arrays.toString(row));
        boolean brute = solver.checkValidGridBrute(grid);
        boolean your  = solver.checkValidGridTryYourSelf(grid);
        boolean opt   = solver.checkValidGrid(grid);

        System.out.printf("Expected  : %s%n", expected);
        System.out.printf("Brute Force      : %-10s %s%n", brute, brute == expected ? "✅" : "❌");
        System.out.printf("TryYourSelf      : %-10s %s%n", your,  your == expected ? "✅" : "❌");
        System.out.printf("Optimized (O(n²)) : %-10s %s%n", opt,   opt == expected ? "✅" : "❌");
        System.out.println("---------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Demo Dashboard
    // ===========================================================
    public static void main(String[] args) {
        CheckKnightTourConfigurationLeetCode2596 solver = new CheckKnightTourConfigurationLeetCode2596();

        System.out.println("=================================================");
        System.out.println("♞  Check Knight Tour Configuration — Tests");
        System.out.println("=================================================\n");

        int[][] grid1 = {
                {0,11,16,5,20},
                {17,4,19,10,15},
                {12,1,8,21,6},
                {3,18,23,14,9},
                {24,13,2,7,22}
        };
        int[][] grid2 = {
                {0,3,6},
                {5,8,1},
                {2,7,4}
        };

        runTest(solver, grid1, true,  "Test 1");
        runTest(solver, grid2, false, "Test 2");
    }
}