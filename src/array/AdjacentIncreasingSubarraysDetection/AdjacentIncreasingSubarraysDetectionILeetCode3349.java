package array.AdjacentIncreasingSubarraysDetection;

import java.util.*;

public class AdjacentIncreasingSubarraysDetectionILeetCode3349 {

    // ===========================================================
    // Optimized O(n) approach (conceptual hint)
    // ===========================================================
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int currCount=1,prevCount=0;
        for(int i =1;i<n;i++){
            if(nums.get(i)> nums.get(i-1)){
                currCount++;
            } else {
                prevCount=currCount;
                currCount=1;
            }

            if(prevCount>=k*2){
                return true;
            }

            if(Math.min(prevCount,currCount)>=k )
                return true;
        }
        return false;
    }

    // ===========================================================
    // Brute force O(n * k)
    // ===========================================================
    public boolean hasIncreasingSubarraysBrute(List<Integer> nums, int k) {
        return false;
    }

    // ===========================================================
    // Formatting helper
    // ===========================================================
    private void runTest(int testNo, int[] arr, int k, boolean expected) {
        List<Integer> list = new ArrayList<>();
        for (int x : arr) list.add(x);

        System.out.println("🔹 Test " + testNo);
        System.out.println("------------------------------------");
        System.out.println("Input Array : " + Arrays.toString(arr));
        System.out.println("k Value     : " + k);
        System.out.println("Expected    : " + expected);

        boolean brute = hasIncreasingSubarraysBrute(list, k);
        boolean opt = hasIncreasingSubarrays(list, k);

        System.out.println("Brute Result: " + brute);
        System.out.println("Optimized   : " + opt);
        System.out.println();
    }


    public static void main(String[] args) {
        AdjacentIncreasingSubarraysDetectionILeetCode3349 solver =
                new AdjacentIncreasingSubarraysDetectionILeetCode3349();

        System.out.println("====================================");
        System.out.println("  Adjacent Increasing Subarrays I Tests");
        System.out.println("====================================\n");

        solver.runTest(1, new int[]{2, 5, 7, 8, 9, 2, 3, 4, 3, 1}, 3, true);
        solver.runTest(2, new int[]{1, 2, 3, 4, 4, 4, 4, 5, 6, 7}, 5, false);
        solver.runTest(3, new int[]{1, 2, 3, 4, 5, 6}, 2, true);
        solver.runTest(4, new int[]{5, 4, 3, 2, 1}, 2, false);

        System.out.println("====================================");
        System.out.println("        All Tests Executed");
        System.out.println("====================================");
    }
}