package Recursion;

import java.util.*;

public class ClimbingStairsLeetCode70 {

    // ===========================================================
    // 🐢 Brute‑Force Recursion (exponential time)
    // ===========================================================
    public int climbStairsBrute(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return n;
        // very slow for n>40
        return climbStairsBrute(n - 1) + climbStairsBrute(n - 2);
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (Memoization / debug prints)
    // ===========================================================
    public int climbStairsTryYourSelf(int n) {
        if(n<=0) return 1;
        if(n<3) return n;
        int startByOneStep = climbStairsTryYourSelf(n-1);
        int startBySecondStep = climbStairsTryYourSelf(n-2);
        return startBySecondStep+startByOneStep;
    }

    // ===========================================================
    // ⚡ Optimized DP / Fibonacci Iteration — O(n) , O(1) space
    // ===========================================================
    public int climbStairs(int n, Map<Integer, Integer> memo) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return n;

        if (memo.containsKey(n)) return memo.get(n);

        int one = climbStairs(n - 1, memo);
        int two = climbStairs(n - 2, memo);
        int total = one + two;
        memo.put(n, total);

        // step‑by‑step trace (optional)
        // System.out.printf("n=%d -> %d%n", n, total);
        return total;
    }

    // ===========================================================
    // 🧾 Test Runner — prints all versions with ✅ / ❌
    // ===========================================================
    private static void runTest(ClimbingStairsLeetCode70 solver,
                                int n, int expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Steps (n) : " + n);
        System.out.println("Expected  : " + expected);

        int brute = solver.climbStairsBrute(n);
        int your  = solver.climbStairsTryYourSelf(n);
        int opt   = solver.climbStairs(n, new HashMap<>());

        System.out.printf("Brute Recursion      : %-5d %s%n", brute, brute == expected ? "✅" : "❌");
        System.out.printf("TryYourSelf (Memo)   : %-5d %s%n", your,  your == expected ? "✅" : "❌");
        System.out.printf("Optimized (O(n))     : %-5d %s%n", opt,   opt == expected ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        ClimbingStairsLeetCode70 solver = new ClimbingStairsLeetCode70();

        System.out.println("=================================================");
        System.out.println("📈  Climbing Stairs — Three Versions");
        System.out.println("=================================================\n");

        runTest(solver, 1, 1, "Test 1");
        runTest(solver, 2, 2, "Test 2");
        runTest(solver, 3, 3, "Test 3");
        runTest(solver, 5, 8, "Test 4");
        runTest(solver, 10, 89, "Test 5");

        // Note: Avoid very large n for brute recursion (n > 40) to prevent long runtimes.
        // If needed, you can test optimized only like:
        // int n = 45; System.out.println("Optimized(45) = " + solver.climbStairs(45)); // 1836311903
    }
}