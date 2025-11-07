package array.AdjacentIncreasingSubarraysDetection;

import java.util.*;

public class AdjacentIncreasingSubarraysDetectionIILeetCode3350 {

    // ===========================================================
    // Optimized O(n) approach (hinted)
    // ===========================================================
    public int maxIncreasingSubarrays(List<Integer> nums) {
       int n = nums.size(),currRun = 1,prevRun=0,k=0;

       for(int i = 1 ;i<n;i++){
           if (nums.get(i) > nums.get(i - 1)) {
               currRun++;
               // Only update k when we are inside a true increasing run
               if (currRun > k * 2)
                   k = currRun / 2;

               if (Math.min(currRun, prevRun) > k)
                   k = Math.min(currRun, prevRun);
           } else {
               prevRun = currRun;
               currRun = 1;
           }
       }
        return k;
    }

    // ===========================================================
    // Brute force O(n^2) check for correctness on small arrays
    // ===========================================================
    public int maxIncreasingSubarraysBrute(List<Integer> nums) {
        int n = nums.size();
        int maxK = 0;
        // TODO: Try all k from 1..n/2
        // For each starting index i, test
        // sub1 = nums[i..i+k-1], sub2 = nums[i+k..i+2k-1]
        // if both strictly increasing -> update maxK
        return maxK; // placeholder
    }

    // ===========================================================
    // Utility method for running & printing a single test
    // ===========================================================
    private void runTest(int testNo, int[] arr, int expected) {
        List<Integer> list = new ArrayList<>();
        for (int x : arr) list.add(x);

        System.out.println("🔹 Test " + testNo);
        System.out.println("------------------------------------");
        System.out.println("Input Array : " + Arrays.toString(arr));
        System.out.println("Expected    : " + expected);

        int brute = maxIncreasingSubarraysBrute(list);
        int opt = maxIncreasingSubarrays(list);

        System.out.println("Brute Result: " + brute);
        System.out.println("Optimized   : " + opt);
        System.out.println();
    }

    // ===========================================================
    // Main test dashboard 🧾
    // ===========================================================
    public static void main(String[] args) {
        AdjacentIncreasingSubarraysDetectionIILeetCode3350 solver =
                new AdjacentIncreasingSubarraysDetectionIILeetCode3350();

        System.out.println("====================================");
        System.out.println(" Adjacent Increasing Subarrays II Tests");
        System.out.println("====================================\n");

        solver.runTest(1, new int[]{2, 5, 7, 8, 9, 2, 3, 4, 3, 1}, 3);
        solver.runTest(2, new int[]{1, 2, 3, 4, 4, 4, 4, 5, 6, 7}, 2);
        solver.runTest(3, new int[]{1, 2, 3, 4, 5, 6}, 3);
        solver.runTest(4, new int[]{10, 9, 8, 7}, 0);

        System.out.println("====================================");
        System.out.println("        ✅  All Tests Executed");
        System.out.println("====================================");
    }
}