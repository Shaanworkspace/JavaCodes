package array;


import java.util.*;

public class ThreeSumLeetCode15 {

    // ===========================================================
    // 🧠 Optimized O(n²) Two‑Pointer Solution
    // ===========================================================
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    // ===========================================================
    // 🐢 Brute‑Force O(n³) approach (for concept clarity)
    // ===========================================================
    public List<List<Integer>> threeSumBrute(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    // ===========================================================
    // 🧪 TryYourSelf version — your own simplified variation
    // ===========================================================
    public List<List<Integer>> threeSumTryYourSelf(int[] nums) {

        return List.of();
    }

    // ===========================================================
    // 🧾 Helper — compares and prints in consistent format
    // ===========================================================
    private static void runTest(ThreeSumLeetCode15 solver, int[] nums,
                                List<List<Integer>> expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Nums             : " + Arrays.toString(nums));
        System.out.println("Expected Triplets : " + expected);
        System.out.println("--------------------------------------");

        List<List<Integer>> brute = solver.threeSumBrute(nums);
        List<List<Integer>> your = solver.threeSumTryYourSelf(nums);
        List<List<Integer>> opt = solver.threeSum(nums);

        boolean bruteOk = compareLists(brute, expected);
        boolean yourOk = compareLists(your, expected);
        boolean optOk = compareLists(opt, expected);

        System.out.println("Brute Force (O³)        : " + brute + (bruteOk ? " ✅" : " ❌"));
        System.out.println("TryYourSelf (hash+set)  : " + your + (yourOk ? " ✅" : " ❌"));
        System.out.println("Optimized (two‑pointer) : " + opt + (optOk ? " ✅" : " ❌"));
        System.out.println("--------------------------------------\n");
    }

    // Helper function to check equality ignoring triplet order
    private static boolean compareLists(List<List<Integer>> a, List<List<Integer>> b) {
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();
        for (List<Integer> l : a) setA.add(l.toString());
        for (List<Integer> l : b) setB.add(l.toString());
        return setA.equals(setB);
    }

    // ===========================================================
    // 🚀 PSVM — Nice IntelliJ Dashboard
    // ===========================================================
    public static void main(String[] args) {
        ThreeSumLeetCode15 solver = new ThreeSumLeetCode15();

        System.out.println("=================================================");
        System.out.println("🔺 3Sum (Find All Unique Triplets Summing to Zero)");
        System.out.println("=================================================\n");

        runTest(solver, new int[]{-1, 0, 1, 2, -1, -4},
                Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)),
                "Test 1");

        runTest(solver, new int[]{0, 1, 1},
                Collections.emptyList(),
                "Test 2");

        runTest(solver, new int[]{0, 0, 0},
                Arrays.asList(Arrays.asList(0, 0, 0)),
                "Test 3");

        runTest(solver, new int[]{-2, 0, 1, 1, 2},
                Arrays.asList(Arrays.asList(-2, 0, 2), Arrays.asList(-2, 1, 1)),
                "Test 4");
    }
}