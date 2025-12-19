package DynamicProgramming.OneDimension.HouseRobber;

import java.util.*;

/**
 * ===========================================================
 * 💰 LeetCode 198 — House Robber
 * ===========================================================
 *
 * You are a professional robber planning to rob houses
 * along a street. Each house has some money stashed, but
 * adjacent houses have security systems — you cannot rob
 * two directly adjacent houses.
 *
 * Given an integer array nums representing the money
 * in each house, return the maximum sum you can rob
 * without alerting the police.
 *
 * -----------------------------------------------------------
 * Example 1:
 * Input : nums = [1,2,3,1]
 * Output: 4
 *
 * Example 2:
 * Input : nums = [2,7,9,3,1]
 * Output: 12
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 1 ≤ nums.length ≤ 100
 *  • 0 ≤ nums[i] ≤ 400
 * -----------------------------------------------------------
 */

public class HouseRobberLeetCode198 {

    // Not allowed : WRONG Attempt
    /*
    public int rob(int[] nums) {
        int a = 0;
        int b =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i%2==0){
                a+=nums[i];
            } else{
                b+=nums[i];
            }
        }

        return Math.max(a,b);
    }
     */

    // ===========================================================
    // Brute‑Force Approach (pure recursion)
    // ===========================================================
    public int robBrute(int[] nums) {
        return robRecursion(nums, 0);
    }

    private int robRecursion(int[] nums, int idx) {
        if (idx >= nums.length) return 0;
        int robFrom0 = nums[idx] + robRecursion(nums, idx + 2);
        int robFrom1 = robRecursion(nums, idx + 1);
        return Math.max(robFrom0,robFrom1);
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (memoized recursion / tracing)
    // ===========================================================
    public int robTryYourSelf(int[] nums) {
        // TODO: implement with prints to trace state decisions
        return 0; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized DP — O(n) time, O(1) extra space
    // ===========================================================
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        return robRecursionDp(nums, 0,dp);
    }
    private int robRecursionDp(int[] nums, int idx,int[] dp) {
        if (idx >= nums.length) return 0;
        if(dp[idx]!=0) return dp[idx];
        int robFrom0 = nums[idx] + robRecursion(nums, idx + 2);
        int robFrom1 = robRecursion(nums, idx + 1);
        int ans = Math.max(robFrom0,robFrom1);
        dp[idx] = ans;
        return ans;
    }

    // ===========================================================
    // 🧾 Test Runner — compare all outputs
    // ===========================================================
    private static void runTest(HouseRobberLeetCode198 solver,
                                int[] nums, int expected, String name) {
        System.out.println("🔹 " + name);
        System.out.println("Input: " + Arrays.toString(nums));

        int brute = solver.robBrute(nums);
        int your  = solver.robTryYourSelf(nums);
        int opt   = solver.rob(nums);

        System.out.println("Expected : " + expected);
        System.out.printf("Brute Force      : %-4d%n", brute);
        System.out.printf("TryYourSelf      : %-4d%n", your);
        System.out.printf("Optimized (O(n)) : %-4d%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Demo Dashboard
    // ===========================================================
    public static void main(String[] args) {
        HouseRobberLeetCode198 solver = new HouseRobberLeetCode198();

        System.out.println("=================================================");
        System.out.println("💰  House Robber — Tests");
        System.out.println("=================================================\n");

        runTest(solver, new int[]{1,2,3,1}, 4,  "Test 1");
        runTest(solver, new int[]{2,7,9,3,1}, 12, "Test 2");
        runTest(solver, new int[]{0}, 0, "Test 3");
    }
}