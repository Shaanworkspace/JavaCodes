package array.SlidingWindow;

import java.util.Arrays;

public class MinimumSizeSubarraySumLeetCode209 {

    // ===========================================================
    // 🧠 Optimized O(n) Sliding‑Window Approach
    // ===========================================================
    public int minSubArrayLen(int target, int[] nums) {
        // TODO: implement optimized sliding‑window logic
        return 0; // demo placeholder
    }

    // ===========================================================
    // 🐢 Brute‑Force O(n²) Approach
    // ===========================================================
    public int minSubArrayLenBrute(int target, int[] nums) {
        // TODO: implement brute‑force baseline logic
        return 0; // demo placeholder
    }

    // ===========================================================
    // ✍️ TryYourSelf (for learning / trace experiments)
    // ===========================================================
    public int minSubArrayLenTryYourSelf(int target, int[] nums) {
        int i =0,j=0,sum=0,n= nums.length,length=Integer.MAX_VALUE;

        while(j<n){
            //Expand the window by including nums[j]
            sum +=nums[j];

            // Shrink from left as long as sum >= target
            while(sum >= target){
                length=Math.min(length,j-i+1);
                sum -= nums[i++];
            }

            j++; // move right end forward
        }


        // If we never found valid subarray
        return (length == Integer.MAX_VALUE) ? 0 : length;
    }

    // ===========================================================
    // 🧾 Test Runner — compare all versions with ✅ / ❌ status
    // ===========================================================
    private static void runTest(MinimumSizeSubarraySumLeetCode209 solver,
                                int target, int[] nums, int expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Target  : " + target);
        System.out.println("Nums    : " + Arrays.toString(nums));
        System.out.println("Expected: " + expected);

        int brute = solver.minSubArrayLenBrute(target, nums);
        int your  = solver.minSubArrayLenTryYourSelf(target, nums);
        int opt   = solver.minSubArrayLen(target, nums);

        System.out.printf("Brute Force (O²)    : %-5d %s%n", brute, brute == expected ? "✅" : "❌");
        System.out.printf("TryYourSelf (trace) : %-5d %s%n", your,  your == expected ? "✅" : "❌");
        System.out.printf("Optimized (O(n))    : %-5d %s%n", opt,   opt == expected ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — starter dashboard
    // ===========================================================
    public static void main(String[] args) {
        MinimumSizeSubarraySumLeetCode209 solver = new MinimumSizeSubarraySumLeetCode209();

        System.out.println("=================================================");
        System.out.println("📏  Minimum Size Subarray Sum — Three Versions 🌟");
        System.out.println("=================================================\n");

        runTest(solver, 7,  new int[]{2,3,1,2,4,3}, 2, "Test 1");
        runTest(solver, 4,  new int[]{1,4,4}, 1, "Test 2");
        runTest(solver, 11, new int[]{1,1,1,1,1,1,1,1}, 0, "Test 3");
        runTest(solver, 15, new int[]{5,1,3,5,10,7,4,9,2,8}, 2, "Test 4");
    }
}