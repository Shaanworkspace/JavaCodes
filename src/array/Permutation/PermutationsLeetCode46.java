package array.Permutation;

import java.util.*;

public class PermutationsLeetCode46 {

    // ===========================================================
    // Brute‑Force Approach (baseline)
    // ===========================================================
    public List<List<Integer>> permuteBrute(int[] nums) {
        // TODO: implement brute‑force permutation generator
        return new ArrayList<>(); // demo placeholder
    }

    // ===========================================================
    // TryYourSelf Variant (for practice / debug prints)
    // ===========================================================
    public List<List<Integer>> permuteTryYourSelf(int[] nums) {
        // TODO: implement your own traced version
        return new ArrayList<>(); // demo placeholder
    }

    // ===========================================================
    // ⚡ Optimized Backtracking Approach — O(n × n!)
    // ===========================================================
    public List<List<Integer>> permute(int[] nums) {
        // TODO: implement optimized backtracking algorithm
        return new ArrayList<>(); // demo placeholder
    }

    // ===========================================================
    // 🧾 Test Runner — compares all methods, prints ✅ / ❌
    // ===========================================================
    private static void runTest(PermutationsLeetCode46 solver,
                                int[] nums, List<List<Integer>> expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input     : " + Arrays.toString(nums));
        System.out.println("Expected  : " + expected);

        List<List<Integer>> brute = solver.permuteBrute(nums.clone());
        List<List<Integer>> your  = solver.permuteTryYourSelf(nums.clone());
        List<List<Integer>> opt   = solver.permute(nums.clone());

        System.out.printf("Brute Force      : %-40s %s%n",
                brute, brute.equals(expected) ? "✅" : "❌");
        System.out.printf("TryYourSelf      : %-40s %s%n",
                your,  your.equals(expected) ? "✅" : "❌");
        System.out.printf("Optimized (O(n!)) : %-40s %s%n",
                opt,   opt.equals(expected) ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        PermutationsLeetCode46 solver = new PermutationsLeetCode46();

        System.out.println("=================================================");
        System.out.println("🔁  Permutations — Tests");
        System.out.println("=================================================\n");

        runTest(solver,
                new int[]{1, 2, 3},
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 1, 3),
                        Arrays.asList(2, 3, 1),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(3, 2, 1)
                ),
                "Test 1");

        runTest(solver,
                new int[]{0, 1},
                Arrays.asList(
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 0)
                ),
                "Test 2");

        runTest(solver,
                new int[]{1},
                Arrays.asList(
                        Arrays.asList(1)
                ),
                "Test 3");
    }
}