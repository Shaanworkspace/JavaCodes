package array;

import java.util.Arrays;

public class ContainerWithMostWaterLeetCode11 {

    // ===========================================================
    // 🧠 Optimized O(n) Two‑Pointer Solution
    // ===========================================================
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }

    // ===========================================================
    // 🐢 Brute‑Force O(n²) Solution
    // ===========================================================
    public int maxAreaBrute(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    // ===========================================================
    // 🧪 Try‑YourSelf Version — smarter comparison style
    // ===========================================================
    public int maxAreaTryYourSelf(int[] height) {
        int n = height.length;
        int max=0,i = 0,j=n-1;

        while(i<j){
            int area = Math.min(height[i],height[j])*(j-i);

            max = Math.max(max, area);

            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }

    // ===========================================================
    // 🧾 Unified Test Runner — prints Brute, TryYourSelf, Optimized results
    // ===========================================================
    private static void runTest(ContainerWithMostWaterLeetCode11 solver,
                                int[] heights, int expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Heights          : " + Arrays.toString(heights));
        System.out.println("Expected Output  : " + expected);

        int brute = solver.maxAreaBrute(heights);
        int trySelf = solver.maxAreaTryYourSelf(heights);
        int opt = solver.maxArea(heights);

        System.out.println("Brute Force (O²)         : " + brute + (brute == expected ? " ✅" : " ❌"));
        System.out.println("TryYourSelf (custom loop) : " + trySelf + (trySelf == expected ? " ✅" : " ❌"));
        System.out.println("Optimized (O(n))         : " + opt + (opt == expected ? " ✅" : " ❌"));
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Test Dashboard
    // ===========================================================
    public static void main(String[] args) {
        ContainerWithMostWaterLeetCode11 solver = new ContainerWithMostWaterLeetCode11();

        System.out.println("=================================================");
        System.out.println("🏞️  Container With Most Water — Tests");
        System.out.println("=================================================\n");

        runTest(solver, new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49, "Test 1");
        runTest(solver, new int[]{1, 1}, 1, "Test 2");
        runTest(solver, new int[]{4, 3, 2, 1, 4}, 16, "Test 3");
        runTest(solver, new int[]{1, 2, 1}, 2, "Test 4");
        runTest(solver, new int[]{2, 3, 10, 5, 7, 8, 9}, 36, "Test 5");
    }
}