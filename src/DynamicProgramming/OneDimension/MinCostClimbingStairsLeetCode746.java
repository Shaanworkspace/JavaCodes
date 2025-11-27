package DynamicProgramming.OneDimension;
import java.util.*;

/**
 * ===========================================================
 * 🏃 LeetCode 746 — Min Cost Climbing Stairs
 * ===========================================================
 *
 * You are given an integer array cost, where cost[i] is the cost
 * of the i‑th step on a staircase. Once you pay the cost, you can
 * either climb one or two steps.
 *
 * You may start from step index 0 or 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 * -----------------------------------------------------------
 * Example 1:
 * Input : cost = [10,15,20]
 * Output: 15
 *
 * Example 2:
 * Input : cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 2 ≤ cost.length ≤ 1000
 *  • 0 ≤ cost[i] ≤ 999
 * -----------------------------------------------------------
 */

public class MinCostClimbingStairsLeetCode746 {

    // ===========================================================
    // 🐢 Brute‑Force Approach (simple recursion)
    // ===========================================================
    public int minCostClimbingStairsBrute(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return minCostRecursion(cost,n,dp);
    }

    private int minCostRecursion(int[] cost, int n,int[] dp) {
        if(dp[n]!=-1) return dp[n];
        if(n<=1) return 0;

        int srtZero = minCostRecursion(cost,n-1,dp)+cost[cost.length-n];
        int srtOne = minCostRecursion(cost,n-2,dp)+cost[cost.length-(n-1)];
        int ans = Math.min(srtZero,srtOne);
        dp[n]=ans;
        return ans;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (recursive with memo / tracing)
    // ===========================================================
    public int minCostClimbingStairsTryYourSelf(int[] cost) {
        // TODO: implement top‑down recursion with memo + debug prints
        return 0; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized Bottom‑Up DP — O(n)
    // ===========================================================
    public int minCostClimbingStairs(int[] cost) {
        // TODO: implement efficient DP to compute minimal cost
        return 0; // placeholder
    }

    // ===========================================================
    // 🧾 Test Runner — verify results across methods
    // ===========================================================
    private static void runTest(MinCostClimbingStairsLeetCode746 solver,
                                int[] cost, int expected, String name) {
        System.out.println("🔹 " + name);
        System.out.println("Input: " + Arrays.toString(cost));

        int brute = solver.minCostClimbingStairsBrute(cost);
        int your  = solver.minCostClimbingStairsTryYourSelf(cost);
        int opt   = solver.minCostClimbingStairs(cost);

        System.out.println("Expected : " + expected);
        System.out.printf("Brute Force      : %-5d%n", brute);
        System.out.printf("TryYourSelf      : %-5d%n", your);
        System.out.printf("Optimized (O(n)) : %-5d%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Demo Dashboard
    // ===========================================================
    public static void main(String[] args) {
        MinCostClimbingStairsLeetCode746 solver = new MinCostClimbingStairsLeetCode746();

        System.out.println("=================================================");
        System.out.println("🏃  Min Cost Climbing Stairs — Tests");
        System.out.println("=================================================\n");

        runTest(solver, new int[]{10,15,20}, 15, "Test 1");
        runTest(solver, new int[]{1,100,1,1,1,100,1,1,100,1}, 6, "Test 2");
    }
}