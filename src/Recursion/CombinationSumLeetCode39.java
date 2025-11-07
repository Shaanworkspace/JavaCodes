package Recursion;

import java.util.*;

public class CombinationSumLeetCode39 {

    // ===========================================================
    // Brute‑Force Backtracking --> https://www.youtube.com/watch?v=jkgZw2WEaqA
    // ===========================================================
    Set<List<Integer>> s = new HashSet<>();
    public List<List<Integer>> combinationSumBrute(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combi = new ArrayList<>();

       findAllCombination(candidates,0,target,ans,combi);
       return ans;
    }

    private void findAllCombination(int[] arr,int idx, int target, List<List<Integer>> ans, List<Integer> combi) {

//        base case
        if(idx == arr.length || target<0){
            return;
        }
        if(target==0){
            List<Integer> current = new ArrayList<>(combi);
            if (!s.contains(current)) {
                ans.add(current);
                s.add(current);
            }
            return;
        }

//        work
        combi.add(arr[idx]);
        //single include
        findAllCombination(arr,idx+1,target-arr[idx],ans,combi);
        //multiple include
        findAllCombination(arr,idx,target-arr[idx],ans,combi);

        //end me array khali rkhna h to pop kr du last
        combi.removeLast();

        //Exclusion
        findAllCombination(arr,idx+1,target,ans,combi);

    }


    // ===========================================================
    // ✍️ TryYourSelf Variant — with debug prints, slight pruning
    // Sorts for stable order, prints choices and backtracks.
    // ===========================================================
    public List<List<Integer>> combinationSumTryYourSelf(int[] candidates, int target) {

        return List.of();
    }





    // ===========================================================
    // ⚡ Optimized Backtracking — sort + prune (standard solution)
    // ===========================================================
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        return List.of();
    }

    // ===========================================================
    // Helpers — normalize and compare combination lists
    // ===========================================================
    private static List<List<Integer>> normalize(List<List<Integer>> list) {
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> comb : list) {
            List<Integer> tmp = new ArrayList<>(comb);
            Collections.sort(tmp);
            copy.add(tmp);
        }
        copy.sort((a, b) -> {
            int n = Math.min(a.size(), b.size());
            for (int i = 0; i < n; i++) {
                int cmp = Integer.compare(a.get(i), b.get(i));
                if (cmp != 0) return cmp;
            }
            return Integer.compare(a.size(), b.size());
        });
        return copy;
    }

    private static boolean equalCombinations(List<List<Integer>> a, List<List<Integer>> b) {
        return normalize(a).equals(normalize(b));
    }

    // pretty print
    private static String listToString(List<List<Integer>> list) {
        return normalize(list).toString();
    }

    // ===========================================================
    // 🧾 Test Runner — compares all versions and prints ✅ / ❌
    // ===========================================================
    private static void runTest(CombinationSumLeetCode39 solver,
                                int[] candidates, int target,
                                List<List<Integer>> expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Candidates : " + Arrays.toString(candidates));
        System.out.println("Target     : " + target);
        System.out.println("Expected   : " + listToString(expected));

        List<List<Integer>> brute = solver.combinationSumBrute(candidates, target);
        List<List<Integer>> your  = solver.combinationSumTryYourSelf(candidates, target);
        List<List<Integer>> opt   = solver.combinationSum(candidates, target);

        System.out.printf("Brute Force      : %-45s %s%n", listToString(brute),
                equalCombinations(brute, expected) ? "✅" : "❌");
        System.out.printf("TryYourSelf      : %-45s %s%n", listToString(your),
                equalCombinations(your, expected) ? "✅" : "❌");
        System.out.printf("Optimized (Backtracking): %-45s %s%n", listToString(opt),
                equalCombinations(opt, expected) ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        CombinationSumLeetCode39 solver = new CombinationSumLeetCode39();

        System.out.println("=================================================");
        System.out.println("🧮  Combination Sum — Three Versions");
        System.out.println("=================================================\n");

        runTest(solver,
                new int[]{2, 3, 6, 7}, 7,
                Arrays.asList(
                        Arrays.asList(2, 2, 3),
                        Arrays.asList(7)
                ),
                "Test 1");

        runTest(solver,
                new int[]{2, 3, 5}, 8,
                Arrays.asList(
                        Arrays.asList(2, 2, 2, 2),
                        Arrays.asList(2, 3, 3),
                        Arrays.asList(3, 5)
                ),
                "Test 2");

        runTest(solver,
                new int[]{2}, 1,
                Collections.emptyList(),
                "Test 3");
    }
}