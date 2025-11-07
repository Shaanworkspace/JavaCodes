package array.Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutationLeetCode31 {

    // ===========================================================
    // 🐢 Brute‑Force Approach (baseline)
    // ===========================================================
    public int[] nextPermutationBrute(int[] nums) {
        int[] arr = nums.clone();

        /*
        now we need to store the permutated arrays like:
        All permutations =
                [
                   [1, 2, 3],
                   [1, 3, 2],
                   [2, 1, 3],
                   [2, 3, 1],
                   [3, 1, 2],
                   [3, 2, 1]
                ]
         */
        List<int[]> list = new ArrayList<>();

        generate(arr, 0, list);


        return arr;
    }

    private void generate(int[] arr, int index, List<int[]> all) {
        if (index == arr.length) {
            all.add(arr.clone());
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            generate(arr, index + 1, all);
            swap(arr, index, i); // backtrack
        }
    }

    // Easy swap helper
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (for tracing logic)
    // ===========================================================
    public int[] nextPermutationTryYourSelf(int[] nums) {
        // TODO: Implement your detailed / step‑by‑step version
        return new int[0]; // demo placeholder
    }

    // ===========================================================
    // ⚡ Optimized O(n) In‑place Solution
    // ===========================================================
    public void nextPermutation(int[] nums) {
        // TODO: Implement final optimized solution
        // (find pivot, swap, reverse suffix)
    }

    // ===========================================================
    // 🧾 Test Runner — compares all results and prints ✅ / ❌
    // ===========================================================
    private static void runTest(NextPermutationLeetCode31 solver,
                                int[] nums, int[] expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input     : " + Arrays.toString(nums));
        System.out.println("Expected  : " + Arrays.toString(expected));

        int[] brute = solver.nextPermutationBrute(nums.clone());
        int[] your  = solver.nextPermutationTryYourSelf(nums.clone());
        int[] optArr = nums.clone();
        solver.nextPermutation(optArr);

        System.out.printf("Brute Force      : %-20s %s%n",
                Arrays.toString(brute), Arrays.equals(brute, expected) ? "✅" : "❌");
        System.out.printf("TryYourSelf      : %-20s %s%n",
                Arrays.toString(your), Arrays.equals(your, expected) ? "✅" : "❌");
        System.out.printf("Optimized (O(n)) : %-20s %s%n",
                Arrays.toString(optArr), Arrays.equals(optArr, expected) ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        NextPermutationLeetCode31 solver = new NextPermutationLeetCode31();

        System.out.println("=================================================");
        System.out.println("🔁  Next Permutation — Tests");
        System.out.println("=================================================\n");

        runTest(solver, new int[]{1, 2, 3}, new int[]{1, 3, 2}, "Test 1");
        runTest(solver, new int[]{3, 2, 1}, new int[]{1, 2, 3}, "Test 2");
        runTest(solver, new int[]{1, 1, 5}, new int[]{1, 5, 1}, "Test 3");
        runTest(solver, new int[]{1, 3, 2}, new int[]{2, 1, 3}, "Test 4");
    }
}
