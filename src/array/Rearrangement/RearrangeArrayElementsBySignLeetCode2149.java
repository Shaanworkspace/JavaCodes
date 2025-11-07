package array.Rearrangement;

import java.util.Arrays;

public class RearrangeArrayElementsBySignLeetCode2149 {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ===========================================================
    // Brute‑Force Approach (baseline)
    // ===========================================================
    public int[] rearrangeArrayBrute(int[] nums) {
        // TODO: implement brute‑force rearrangement
        return new int[0]; // demo placeholder
    }

    // ===========================================================
    // TryYourSelf Variant (for step‑by‑step experiments)
    // ===========================================================
    public int[] rearrangeArrayTryYourSelf(int[] nums) {
        int i =0,n=nums.length,j=0;

        while(i<n){
            if(i%2==0){
                //its positive side
                j=i;
                while(j < n && nums[j]<0){
                    j++;
                }
            }
            else{
                //Negative vale
                j=i;
                while(j < n && nums[j]>0){
                    j++;
                }
            }
            if (j == n) break;
            swap(nums, i, j);
            i++;
        }

        return nums;
    }

    // ===========================================================
    // Optimized O(n) Approach
    // ===========================================================
    public int[] rearrangeArray(int[] nums) {
        // TODO: implement optimized two‑pointer logic
        return new int[0]; // demo placeholder
    }

    // ===========================================================
    // Test Runner — compares all versions and prints ✅ / ❌
    // ===========================================================
    private static void runTest(RearrangeArrayElementsBySignLeetCode2149 solver,
                                int[] nums, int[] expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input     : " + Arrays.toString(nums));
        System.out.println("Expected  : " + Arrays.toString(expected));

        int[] brute = solver.rearrangeArrayBrute(nums.clone());
        int[] your  = solver.rearrangeArrayTryYourSelf(nums.clone());
        int[] opt   = solver.rearrangeArray(nums.clone());

        System.out.printf("Brute Force      : %-25s %s%n",
                Arrays.toString(brute), Arrays.equals(brute, expected) ? "✅" : "❌");
        System.out.printf("TryYourSelf      : %-25s %s%n",
                Arrays.toString(your),  Arrays.equals(your, expected) ? "✅" : "❌");
        System.out.printf("Optimized (O(n)) : %-25s %s%n",
                Arrays.toString(opt),   Arrays.equals(opt, expected) ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        RearrangeArrayElementsBySignLeetCode2149 solver =
                new RearrangeArrayElementsBySignLeetCode2149();

        System.out.println("=================================================");
        System.out.println("🔁  Rearrange Array Elements by Sign — Tests");
        System.out.println("=================================================\n");

        runTest(solver, new int[]{3, 1, -2, -5, 2, -4}, new int[]{3, -2, 1, -5, 2, -4}, "Test 1");
        runTest(solver, new int[]{-1, 1}, new int[]{1, -1}, "Test 2");
    }
}