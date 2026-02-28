package Backtracking;

import java.util.*;

/**
 * ===========================================================
 * 🍪 LeetCode 2305 — Fair Distribution of Cookies
 * ===========================================================
 * You are given an integer Array cookies[] where cookies[i]
 * is the number of cookies in the i-th bag. You must distribute
 * the bags among k children such that the unfairness
 * (maximum cookies given to any child) is minimized.
 *
 * This file includes ONLY method skeletons.
 * Implement the logic yourself.
 */

public class FairDistributionCookiesLeetCode2305 {

    // ===========================================================
    // Brute-Force Method (to implement)
    // ===========================================================
    public int distributeCookiesBrute(int[] cookies, int k) {
        return 1;
    }

    // ===========================================================
    // TryYourSelf Method (to implement)
    // ===========================================================
    public int distributeCookiesTryYourSelf(int[] cookies, int k) {
        return 2;
    }


    // ===========================================================
    // Optimized Backtracking Method (to implement)
    // ===========================================================
    public int distributeCookies(int[] cookies, int k) {
        return -1; // TODO
    }

    // ===========================================================
    // Utility — Check correctness
    // ===========================================================
    private static boolean isEqual(int a, int b) {
        return a == b;
    }

    // ===========================================================
    // Utility — Print arrays
    // ===========================================================
    private static void printArray(int[] arr) {
        System.out.println("Cookies : " + Arrays.toString(arr));
    }

    // ===========================================================
    // Test Runner with ✔ or ✘
    // ===========================================================
    private static void runTest(
            FairDistributionCookiesLeetCode2305 solver,
            int[] cookies,
            int k,
            int expected,
            String testName) {

        System.out.println("🔹 " + testName);
        printArray(cookies);
        System.out.println("k       : " + k);
        System.out.println("Expected Unfairness : " + expected + "\n");

        int brute = solver.distributeCookiesBrute(cookies, k);
        int yours = solver.distributeCookiesTryYourSelf(cookies, k);
        int opt   = solver.distributeCookies(cookies, k);

        boolean bOK = isEqual(brute, expected);
        boolean yOK = isEqual(yours, expected);
        boolean oOK = isEqual(opt, expected);

        System.out.println("Your Outputs:");
        System.out.println("Brute-Force : " + brute + "   " + (bOK ? "✔ Correct" : "✘ Wrong"));
        System.out.println("TryYourSelf : " + yours + "   " + (yOK ? "✔ Correct" : "✘ Wrong"));
        System.out.println("Optimized   : " + opt   + "   " + (oOK ? "✔ Correct" : "✘ Wrong"));

        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // PSVM — Dashboard
    // ===========================================================
    public static void main(String[] args) {

        FairDistributionCookiesLeetCode2305 solver =
                new FairDistributionCookiesLeetCode2305();

        System.out.println("=================================================");
        System.out.println("🍪  Fair Distribution of Cookies — Auto Tester");
        System.out.println("=================================================\n");

        runTest(
                solver,
                new int[]{8, 15, 10, 20, 8},
                2,
                31,
                "Test 1"
        );

        runTest(
                solver,
                new int[]{6, 1, 3, 2, 2, 4, 1, 2},
                3,
                7,
                "Test 2"
        );

        runTest(
                solver,
                new int[]{1, 2, 3, 4, 5},
                2,
                9,
                "Test 3"
        );

        runTest(
                solver,
                new int[]{5, 5, 5, 5},
                4,
                5,
                "Test 4"
        );
    }
}
