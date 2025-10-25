package array.TwoSumProblem;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumLeetCode1 {

    // ===========================================================
    // 🐢 Method 1: Brute Force  — O(n²)
    // ===========================================================
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // no valid pair
    }

    // ===========================================================
    // ⚡ Method 2: HashMap (Correct fixed‑index version) — O(n)
    // ===========================================================
    public int[] twoSumByHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // ===========================================================
    // 🔍 Method 3: TryYourSelf — your original approach improved
    // ===========================================================
    public int[] twoSumTryYourSelf(int[] nums, int target) {
        HashMap<Integer,Integer> ind = new HashMap<>();
        for(int i = 0 ; i<nums.length ;i++){
            ind.put(nums[i],i);
        }

        for(int i = 0;i<nums.length;i++){
            int complement = target - nums[i];
            if(ind.containsKey(complement)){
                int j = ind.get(complement);
                if(j!=i){
                    return new int[] {i,j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // ===========================================================
    // 🧾 Test Runner — neatly formatted dashboard
    // ===========================================================
    private static void runTest(TwoSumLeetCode1 solver, int[] nums, int target, int[] expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Array   : " + Arrays.toString(nums));
        System.out.println("Target  : " + target);
        System.out.println("Expected: " + Arrays.toString(expected));

        int[] brute = solver.twoSumBruteForce(nums, target);
        int[] map   = solver.twoSumByHashMap(nums, target);
        int[] self  = solver.twoSumTryYourSelf(nums, target);

        System.out.printf("Brute Force (O²)       : %-10s %s%n",
                Arrays.toString(brute), Arrays.equals(brute, expected) ? "✅" : "❌");
        System.out.printf("HashMap (O(n))         : %-10s %s%n",
                Arrays.toString(map), Arrays.equals(map, expected) ? "✅" : "❌");
        System.out.printf("TryYourSelf (Your ver) : %-10s %s%n",
                Arrays.toString(self), Arrays.equals(self, expected) ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Clean IntelliJ Dashboard
    // ===========================================================
    public static void main(String[] args) {
        TwoSumLeetCode1 solver = new TwoSumLeetCode1();

        System.out.println("=================================================");
        System.out.println("🎯  LeetCode 1 — Two Sum Approaches Comparison");
        System.out.println("=================================================\n");

        runTest(solver, new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}, "Test 1");
        runTest(solver, new int[]{3, 2, 4}, 6, new int[]{1, 2}, "Test 2");
        runTest(solver, new int[]{3, 3}, 6, new int[]{0, 1}, "Test 3");
        runTest(solver, new int[]{-1, 0, 1, 2, -1, -4}, 0, new int[]{1, 2}, "Test 4 (just a random one)");
    }
}