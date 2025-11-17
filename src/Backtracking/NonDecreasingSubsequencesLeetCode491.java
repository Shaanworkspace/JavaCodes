package Backtracking;

import java.util.*;

/**
 * ===========================================================
 * 🔢 LeetCode 491 — Non-decreasing Subsequences
 * ===========================================================
 * This file contains only method structure.
 * Implement the logic yourself in the three methods below.
 */

public class NonDecreasingSubsequencesLeetCode491 {

    // ===========================================================
    // Brute Force Method (to implement)
    // ===========================================================
    public List<List<Integer>> findSubsequencesBrute(int[] nums) {
        return new ArrayList<>(); // TODO
    }

    // ===========================================================
    // TryYourSelf Method (to implement)
    // ===========================================================
    public List<List<Integer>> findSubsequencesTryYourSelf(int[] nums) {

        List<Integer> subsequence = new ArrayList<>();
        HashSet<List<Integer>> result = new HashSet<>();

        helper(nums,0,subsequence,result);
        List<List<Integer>> removed = new ArrayList<>(result);;

        return removed;

    }

    private void helper(int[] nums, int idx, List<Integer> subsequence, HashSet<List<Integer>> result) {
        if( idx == nums.length){
            List<Integer> a = List.copyOf(subsequence);
            if(a.size() <=1){
                return;
            }
            for(int i =1;i<a.size();i++){
                if(a.get(i-1) > a.get(i)){
                    return;
                }
            }
            result.add(a);
            return;
        }
        //skip
        helper(nums,idx+1,subsequence,result);

        // Pick
        subsequence.add(nums[idx]);
        helper(nums,idx+1,subsequence,result);


        //backtrack
        subsequence.remove(subsequence.size() - 1);
    }

    // ===========================================================
    // Optimized Method (to implement)
    // ===========================================================
    public List<List<Integer>> findSubsequences(int[] nums) {
        return new ArrayList<>(); // TODO
    }

    // ===========================================================
    // Utility — compare two List<List<Integer>>
    // ===========================================================
    private static boolean isEqual(List<List<Integer>> a, List<List<Integer>> b) {
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();

        for (List<Integer> x : a) s1.add(x.toString());
        for (List<Integer> x : b) s2.add(x.toString());

        return s1.equals(s2);
    }

    // ===========================================================
    // Utility — display list with formatting
    // ===========================================================
    private static void printList(List<List<Integer>> list) {
        if (list.isEmpty()) {
            System.out.println("   []");
            return;
        }
        for (List<Integer> seq : list) {
            System.out.println("   " + seq);
        }
    }

    // ===========================================================
    // Test Runner (automatically checks your answers)
    // ===========================================================
    private static void runTest(
            NonDecreasingSubsequencesLeetCode491 solver,
            int[] nums,
            List<List<Integer>> expected,
            String testName) {

        System.out.println("🔹 " + testName);
        System.out.println("Input : " + Arrays.toString(nums));
        System.out.println("Expected Result:");
        printList(expected);

        List<List<Integer>> brute = solver.findSubsequencesBrute(nums);
        List<List<Integer>> yours = solver.findSubsequencesTryYourSelf(nums);
        List<List<Integer>> opt   = solver.findSubsequences(nums);

        boolean bOK = isEqual(brute, expected);
        boolean yOK = isEqual(yours, expected);
        boolean oOK = isEqual(opt, expected);

        System.out.println("\nYour Outputs:");

        System.out.println("Brute-Force : " + (bOK ? "✔ Correct" : "✘ Wrong"));
        printList(brute);

        System.out.println("\nTryYourSelf : " + (yOK ? "✔ Correct" : "✘ Wrong"));
        printList(yours);

        System.out.println("\nOptimized   : " + (oOK ? "✔ Correct" : "✘ Wrong"));
        printList(opt);

        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // PSVM — Dashboard
    // ===========================================================
    public static void main(String[] args) {

        NonDecreasingSubsequencesLeetCode491 solver =
                new NonDecreasingSubsequencesLeetCode491();

        System.out.println("=================================================");
        System.out.println("🔢  Non-Decreasing Subsequences — Auto Tester");
        System.out.println("=================================================\n");

        // Expected outputs
        List<List<Integer>> exp1 = Arrays.asList(
                Arrays.asList(4,6),
                Arrays.asList(4,6,7),
                Arrays.asList(4,6,7,7),
                Arrays.asList(4,7),
                Arrays.asList(4,7,7),
                Arrays.asList(6,7),
                Arrays.asList(6,7,7),
                Arrays.asList(7,7)
        );

        List<List<Integer>> exp2 = Arrays.asList(
                Arrays.asList(4,4)
        );

        List<List<Integer>> exp3 = Arrays.asList(
                Arrays.asList(1,2)
        );

        runTest(solver, new int[]{4,6,7,7}, exp1, "Test 1");
        runTest(solver, new int[]{4,4,3,2,1}, exp2, "Test 2");
        runTest(solver, new int[]{1,2,1},     exp3, "Test 3");
    }
}
