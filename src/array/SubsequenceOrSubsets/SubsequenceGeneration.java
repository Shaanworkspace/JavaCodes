package array.SubsequenceOrSubsets;

import java.util.*;

/**
 * ===========================================================
 * 🧩 Subsequence / Subset Generation
 * ===========================================================
 *
 * Given an integer array, generate all possible subsequences (subsets)
 * and print/return them.
 *
 * Subsequence → any sequence derived by deleting zero or more
 * elements without changing the order of the remaining elements.
 *
 * Example:
 * Input : [3, 5, 6]
 * Output: [ ], [3], [5], [6], [3,5], [3,6], [5,6], [3,5,6]
 */

public class SubsequenceGeneration {

    // ===========================================================
    // Brute‑Force Approach (contiguous subsearrays)
    // ===========================================================
    public static void subsequenceBruteForce(int[] arr) {
        System.out.println("Brute‑Force (contiguous subarrays):");
        for (int j = 0; j < arr.length; j++) {
            for (int k = j; k < arr.length; k++) {
                System.out.print("[");
                for (int l = j; l <= k; l++) {
                    System.out.print(arr[l]);
                    if (l < k) System.out.print(", ");
                }
                System.out.print("]   ");
            }
        }
        System.out.println("\n--------------------------------------------\n");
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant
    // ===========================================================
    public static List<List<Integer>> subsequenceTryYourSelf(int[] arr) {
        ArrayList<Integer> adder = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        generateSub(arr,0,adder,result);
        return result;
    }

    private static void generateSub(int[] arr, int idx, ArrayList<Integer> adder, List<List<Integer>> result) {

        if(idx== arr.length){
            result.add(new ArrayList<>(adder));
            return;
        }

        //without index taken
        generateSub(arr,idx+1,adder,result);

        //with index taken
        adder.add(arr[idx]);
        generateSub(arr,idx+1,adder,result);

        adder.removeLast();
    }

    // ===========================================================
    // ⚡ Optimized Backtracking Approach — O(2ⁿ)
    // ===========================================================
    public static List<List<Integer>> generateSubsequences(int[] arr) {

        return List.of(List.of());
    }

    // ===========================================================
    // 🧾 Test Runner — executes all methods
    // ===========================================================
    private static void runTest(int[] arr, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input: " + Arrays.toString(arr) + "\n");

        subsequenceBruteForce(arr);
        subsequenceTryYourSelf(arr);
        List<List<Integer>> all = generateSubsequences(arr);
        System.out.println("⚡ Optimized (all subsequences):");
        for (List<Integer> subset : all)
            System.out.print(subset + " ");
        System.out.println("\n--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Dashboard
    // ===========================================================
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("🧩  Subsequence / Subset Generation — Tests");
        System.out.println("=================================================\n");

        runTest(new int[]{3, 5, 6, 7}, "Test 1");
        runTest(new int[]{1, 2}, "Test 2");
        runTest(new int[]{4}, "Test 3");
    }
}

