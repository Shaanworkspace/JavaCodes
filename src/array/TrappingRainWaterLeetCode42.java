package array;

import java.util.Arrays;

public class TrappingRainWaterLeetCode42 {

    // ===========================================================
    // Optimized O(n) two‑pointer solution
    // ===========================================================
    public int trap(int[] height) {
        // TODO: Implement optimized logic
        // Hint:
        // 1. Maintain two pointers left/right, and leftMax/rightMax.
        // 2. Move the smaller side inward each step,
        //    accumulate trapped water = smallerMax - height[i].
        // 3. Time O(n), Space O(1).
        return 0; // placeholder
    }

    // ===========================================================
    // Brute force O(n²) version for understanding
    // ===========================================================
    public int trapBrute(int[] height) {
        int n = height.length;
        int water = 0;
        // For each bar, find highest left & right boundaries
        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;
            for (int l = i; l >= 0; l--) leftMax = Math.max(leftMax, height[l]);
            for (int r = i; r < n; r++) rightMax = Math.max(rightMax, height[r]);
            water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }

    // ===========================================================
    // Helper for running & printing dashboards 🧾
    // ===========================================================
    private void runTest(int testNo, int[] height, int expected) {
        System.out.println("🔹 Test " + testNo);
        System.out.println("------------------------------------");
        System.out.println("Height Array : " + Arrays.toString(height));
        System.out.println("Expected     : " + expected);

        int brute = trapBrute(height.clone());
        int opt = trap(height.clone());

        System.out.println("Brute Result : " + brute);
        System.out.println("Optimized    : " + opt);
        System.out.println();
    }

    // ===========================================================
    // PSVM formatted output
    // ===========================================================
    public static void main(String[] args) {
        TrappingRainWaterLeetCode42 solver = new TrappingRainWaterLeetCode42();

        System.out.println("====================================");
        System.out.println("        Trapping Rain Water Tests");
        System.out.println("====================================\n");

        solver.runTest(1, new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6);
        solver.runTest(2, new int[]{4,2,0,3,2,5}, 9);
        solver.runTest(3, new int[]{2,0,2}, 2);
        solver.runTest(4, new int[]{3,0,0,2,0,4}, 10);

        System.out.println("====================================");
        System.out.println("        ✅  All Tests Executed");
        System.out.println("====================================");
    }
}