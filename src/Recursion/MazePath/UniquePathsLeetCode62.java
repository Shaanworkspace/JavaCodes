package Recursion.MazePath;


import java.util.*;

public class UniquePathsLeetCode62 {

    // ===========================================================
    // 🐢 Brute‑Force Recursion (exponential)
    // Moves only Right or Down.         1‑based size	(1,1) --> (m,n)
    // ===========================================================
    public int uniquePathsBrute(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 || n == 1) return 1; // Base: reached goal → one complete path found
        int rightWays = uniquePathsBrute(m, n - 1);
        int downWays = uniquePathsBrute(m - 1, n);
        return  rightWays+ downWays;
    }

    // ===========================================================
    // ✍️ TryYourSelf (Top‑Down DP with Memoization)
    // ===========================================================
    public int uniquePathsTryYourSelf(int m, int n, int[][] memo) {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 || n == 1) return 1;
        if (memo[m][n] != 0) return memo[m][n];
        memo[m][n] = uniquePathsTryYourSelf(m - 1, n, memo) + uniquePathsTryYourSelf(m, n - 1, memo);
        return memo[m][n];
    }

    // ===========================================================
    // ⚡ Optimized (Combinatorics) — O(min(m, n)) time, O(1) space
    // Number of paths = C(m+n-2, m-1)
    // ===========================================================
    public int uniquePaths(int m, int n) {
        int total = m + n - 2;
        int k = Math.min(m - 1, n - 1);
        long ans = 1;
        for (int i = 1; i <= k; i++) {
            ans = ans * (total - k + i) / i;
        }
        return (int) ans;
    }

    // ===========================================================
    // 🧾 Test Runner — compares all versions and prints ✅ / ❌
    // ===========================================================
    private static void runTest(UniquePathsLeetCode62 solver,
                                int m, int n, int expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Grid (m x n): " + m + " x " + n);
        System.out.println("Expected    : " + expected);

        int brute = solver.uniquePathsBrute(m, n);
        int memo  = solver.uniquePathsTryYourSelf(m, n, new int[m + 1][n + 1]);
        int opt   = solver.uniquePaths(m, n);

        System.out.printf("Brute Recursion      : %-6d %s%n", brute, brute == expected ? "✅" : "❌");
        System.out.printf("TryYourSelf (Memo)   : %-6d %s%n", memo,  memo == expected ? "✅" : "❌");
        System.out.printf("Optimized (Comb)     : %-6d %s%n", opt,   opt == expected ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        UniquePathsLeetCode62 solver = new UniquePathsLeetCode62();

        System.out.println("=================================================");
        System.out.println("🧭  Unique Paths (Robot Grid) — Three Versions");
        System.out.println("=================================================\n");

        runTest(solver, 3, 7, 28, "Test 1");
        runTest(solver, 3, 2, 3,  "Test 2");
        runTest(solver, 1, 1, 1,  "Test 3");
        runTest(solver, 2, 3, 3,  "Test 4");
        runTest(solver, 5, 5, 70, "Test 5");
        // If you add bigger grids, brute recursion may be slow. Memo + Optimized will still pass instantly.
    }
}