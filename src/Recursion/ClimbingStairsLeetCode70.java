package Recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ClimbingStairsLeetCode70 {

    // ===========================================================
    // 🐢 Brute‑Force Recursion (exponential time)
    // ===========================================================
    int count;
    public int climbStairsBrute(int n) {
        count = 0;
        climb(n,0);
        return count;
    }

    private void climb(int n, int srt) {
        if(srt == n){
            count++;
        }
        if(srt>n) return;
        climb(n,srt+1);
        climb(n,srt+2);
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (Memoization / debug prints)
    // ===========================================================
    public int climbStairsTryYourSelf(int n) {
	    return n;
    }

    // ===========================================================
    // ⚡ Optimized DP / Fibonacci Iteration — O(n) , O(1) space
    // ===========================================================
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climb2(n,dp);
    }

    private int climb2(int n, int[] dp) {
        if(dp[n] != -1) return dp[n];
        if(n== 1 || n==2) return n;
        return dp[n] = climb2(n-1,dp)+climb2(n-2,dp);
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
        int opt   = solver.climbStairs(n);

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
    }
}