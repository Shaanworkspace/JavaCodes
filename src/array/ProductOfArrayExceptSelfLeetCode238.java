package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelfLeetCode238 {

    // ===========================================================
    // Optimized O(n) solution without using division
    // ===========================================================
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] left = new int[n];
        left[0] = 1;

        // prefix products (everything to the left of i)
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // suffix product accumulator
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = left[i] * right;
            right *= nums[i];
        }

        return res;
    }

    // ===========================================================
    // Brute force solution (O(n²)) for verification
    // ===========================================================
    public int[] productExceptSelfBrute(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) product *= nums[j];
            }
            res[i] = product;
        }
        return res;
    }

    // helper: print nicely
    private String arrayToString(int[] arr) {
        return Arrays.toString(arr);
    }

    // ===========================================================
    // PSVM with clear test output
    // ===========================================================
    public static void main(String[] args) {
        ProductOfArrayExceptSelfLeetCode238 solver = new ProductOfArrayExceptSelfLeetCode238();

        int[][] tests = {
                {1, 2, 3, 4},
                {-1, 1, 0, -3, 3},
                {0, 4, 0},
                {2, 3, 4, 5}
        };

        String[] expected = {
                "[24, 12, 8, 6]",
                "[0, 0, 9, 0, 0]",
                "[0, 0, 0]",
                "[60, 40, 30, 24]"
        };

        System.out.println("====================================");
        System.out.println("   Product of Array Except Self Tests");
        System.out.println("====================================\n");

        for (int t = 0; t < tests.length; t++) {
            int[] input = tests[t];
            System.out.println("🔹 Test " + (t + 1));
            System.out.println("------------------------------------");
            System.out.println("Input Array : " + Arrays.toString(input));
            System.out.println("Expected    : " + expected[t]);

            int[] brute = solver.productExceptSelfBrute(input);
            int[] opt = solver.productExceptSelf(input);

            System.out.println("Brute Result: " + solver.arrayToString(brute));
            System.out.println("Optimized   : " + solver.arrayToString(opt));
            System.out.println();
        }

        System.out.println("====================================");
        System.out.println("        ✅  All Tests Executed");
        System.out.println("====================================");
    }
}