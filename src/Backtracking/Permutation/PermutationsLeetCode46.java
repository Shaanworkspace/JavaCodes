package Backtracking.Permutation;

import java.util.*;

public class PermutationsLeetCode46 {

    // ===========================================================
    // Brute‑Force Approach : TIME -> https://youtu.be/PAgvK1Oku6U?t=4702
    // ===========================================================
    public List<List<Integer>> permuteBrute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> adder = new ArrayList<>();
        boolean[] isValid = new boolean[nums.length];

        createPermutation(nums,adder,result,isValid);
        return result;
    }
    private void createPermutation(int[] nums, ArrayList<Integer> adder, List<List<Integer>> result, boolean[] isValid) {

        if(adder.size() == nums.length){
            List<Integer> temp = new ArrayList<>(adder);
            result.add(temp);
            return;
        }


        for(int i=0;i<nums.length;i++){

            if(isValid[i]) continue;
            //work before call
            adder.add(nums[i]);
            isValid[i] = true;

            createPermutation(nums,adder,result,isValid);


            //backtracking
            adder.removeLast();
            isValid[i] = false;
        }
    }


    // ===========================================================
    // TryYourSelf Variant (for practice / debug prints)
    // ===========================================================
    public List<List<Integer>> permuteTryYourSelf(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> adder = new ArrayList<>();
        boolean[] isValid = new boolean[nums.length];

        createPermutation2(nums,adder,result,isValid);
        return result;
    }

    private void createPermutation2(int[] nums, ArrayList<Integer> adder, List<List<Integer>> result, boolean[] isValid) {

        if(adder.size() == nums.length){
            result.add(new ArrayList<>(adder));
            return;
        }


        for(int i =0;i<nums.length;i++){
            if(isValid[i]) continue;

            int ch = nums[i];
            adder.add(ch);
            isValid[i]=true;

            createPermutation2(nums,adder,result,isValid);

            adder.removeLast();
            isValid[i]=false;
        }

    }

    // ===========================================================
    // ⚡ Optimized Backtracking Approach — we removed all extra space
    // ===========================================================
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
         helper(nums,0,result);
         return result;
    }

    private void helper(int[] nums, int idx, List<List<Integer>> result) {
        int n = nums.length;
        if(idx ==n-1){
            List<Integer> arr = new ArrayList<>();
            for(int a : nums){
                arr.add(a);
            }
            result.add(arr);
            return;
        }

        for(int i = idx ;i<n;i++){
            swap(i,idx,nums);
            helper(nums,idx+1,result);
            swap(i,idx,nums);
        }
    }

    private void swap(int i, int idx, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }

    // ===========================================================
    // Test Runner — compares all methods, prints ✅ / ❌
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