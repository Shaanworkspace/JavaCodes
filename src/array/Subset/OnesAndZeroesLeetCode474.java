package array.Subset;

import java.util.*;

public class OnesAndZeroesLeetCode474 {

    // ===========================================================
    // 🐢 Brute‑Force Approach (Try all subsets)
    // Hint: Recursively include/exclude each string, track 0s/1s
    // ===========================================================
    public int findMaxFormBrute(String[] strs, int m, int n) {
        // TODO: Recursively try all 2^len combinations
        return 0; // dummy placeholder
    }

    // ===========================================================
    // ✍️ TryYourSelf (Recursion + Memoization)
    // Hint: Use 3D HashMap/array to cache (index, m, n) states
    // ===========================================================
    public int findMaxFormTryYourSelf(String[] strs, int m, int n) {
        // TODO: Top-down DP with memoization
        return 0; // dummy placeholder
    }

    // ===========================================================
    // ⚡ Optimized (3D DP or optimized 2D DP)
    // Hint: dp[i][j] = max items with i zeros and j ones
    // ===========================================================
    public int findMaxForm(String[] strs, int m, int n) {
        // TODO: Bottom-up DP, iterate backwards to optimize space
        return 0; // dummy placeholder
    }

    // ===========================================================
    // Helper: Count zeros and ones in a string
    // ===========================================================
    private static int[] countZerosOnes(String s) {
        int zeros = 0, ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
            else ones++;
        }
        return new int[]{zeros, ones};
    }

    // ===========================================================
    // 🧾 Test Runner — compares all versions and prints ✅ / ❌
    // ===========================================================
    private static void runTest(OnesAndZeroesLeetCode474 solver,
                                String[] strs, int m, int n, int expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Strings : " + Arrays.toString(strs));
        System.out.println("m (0's) : " + m);
        System.out.println("n (1's) : " + n);
        System.out.println("Expected: " + expected);

        int brute = solver.findMaxFormBrute(strs, m, n);
        int your  = solver.findMaxFormTryYourSelf(strs, m, n);
        int opt   = solver.findMaxForm(strs, m, n);

        System.out.printf("Brute (All subsets)  : %-5d %s%n", brute, brute == expected ? "✅" : "❌");
        System.out.printf("TryYourSelf (Memo)   : %-5d %s%n", your,  your == expected ? "✅" : "❌");
        System.out.printf("Optimized (DP)       : %-5d %s%n", opt,   opt == expected ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        OnesAndZeroesLeetCode474 solver = new OnesAndZeroesLeetCode474();

        System.out.println("=================================================");
        System.out.println("🔢  Ones and Zeroes (0-1 Knapsack Variant)");
        System.out.println("=================================================\n");

        runTest(solver,
                new String[]{"10", "0001", "111001", "1", "0"}, 5, 3,
                4,
                "Test 1");

        runTest(solver,
                new String[]{"10", "0", "1"}, 1, 1,
                2,
                "Test 2");

        runTest(solver,
                new String[]{"0", "0", "1", "1"}, 2, 2,
                4,
                "Test 3 (all strings fit)");

        runTest(solver,
                new String[]{"10", "0001", "111001"}, 3, 4,
                2,
                "Test 4");
    }
}
