package array;

import java.util.*;

public class FrequencyOfMostFrequentElementLeetCode1838 {

    // ===========================================================
    // 🐢 Brute‑Force Approach (baseline)
    // ===========================================================
    public int maxFrequencyBrute(int[] nums, int k) {

        return k;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (for step‑by‑step experiments)
    // ===========================================================
    public int maxFrequencyTryYourSelf(int[] nums, int k) {
        // TODO: implement your own traced / debug version
        return 0; // demo placeholder
    }

    // ===========================================================
    // ⚡ Optimized O(nlogn) Sliding‑Window Solution
    // ===========================================================
    public int maxFrequency(int[] nums, int k) {

        return k;
    }

    // ===========================================================
    // 🧾 Test Runner — compares all versions, prints ✅ / ❌
    // ===========================================================
    private static void runTest(FrequencyOfMostFrequentElementLeetCode1838 solver,
                                int[] nums, int k, int expected, String testName) {

        System.out.println("🔹 " + testName);
        System.out.println("Nums   : " + Arrays.toString(nums));
        System.out.println("k      : " + k);
        System.out.println("Expected : " + expected);

        int brute = solver.maxFrequencyBrute(nums.clone(), k);
        int your  = solver.maxFrequencyTryYourSelf(nums.clone(), k);
        int opt   = solver.maxFrequency(nums.clone(), k);

        System.out.printf("Brute Force (slow)   : %-5d %s%n", brute, brute == expected ? "✅" : "❌");
        System.out.printf("TryYourSelf (debug)  : %-5d %s%n", your,  your == expected ? "✅" : "❌");
        System.out.printf("Optimized (O(n logn)): %-5d %s%n", opt,   opt == expected ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        FrequencyOfMostFrequentElementLeetCode1838 solver =
                new FrequencyOfMostFrequentElementLeetCode1838();

        System.out.println("=================================================");
        System.out.println("Frequency of the Most Frequent Element — Tests");
        System.out.println("=================================================\n");

        runTest(solver, new int[]{1, 2, 4}, 5, 3, "Test 1");
        runTest(solver, new int[]{1, 4, 8, 13}, 5, 2, "Test 2");
        runTest(solver, new int[]{3, 9, 6}, 2, 1, "Test 3");
    }
}