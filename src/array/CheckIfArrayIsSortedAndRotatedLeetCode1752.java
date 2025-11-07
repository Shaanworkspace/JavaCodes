package array;

import java.util.Arrays;

public class CheckIfArrayIsSortedAndRotatedLeetCode1752 {

    // ===========================================================
    // 🐢 Brute‑Force Approach (baseline)
    // ===========================================================
    public boolean checkBrute(int[] nums) {
        int n = nums.length;
        for(int d = 1 ;d<n;d++){
            if(nums[d]<nums[d-1]){
                int index = d ,i=d,j=d+1;
                while(j!=index){
                    j%=n;
                    i%=n;
                    if(nums[j]<nums[i]){
                        return false;
                    }
                    else {
                        i++;
                        j++;
                    }
                }
            }
        }
        return true;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (for understanding / debug prints)
    // ===========================================================
    public boolean checkTryYourSelf(int[] nums) {
        // TODO: implement a traced version
        return false; // demo placeholder
    }

    // ===========================================================
    // ⚡ Optimized O(n) Approach
    // ===========================================================
    public boolean check(int[] nums) {
        // TODO: implement optimized single‑pass approach
        return false; // demo placeholder
    }

    // ===========================================================
    // 🧾 Test Runner — compares all versions and prints ✅ / ❌
    // ===========================================================
    private static void runTest(CheckIfArrayIsSortedAndRotatedLeetCode1752 solver,
                                int[] nums, boolean expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Array    : " + Arrays.toString(nums));
        System.out.println("Expected : " + expected);

        boolean brute = solver.checkBrute(nums.clone());
        boolean your  = solver.checkTryYourSelf(nums.clone());
        boolean opt   = solver.check(nums.clone());

        System.out.printf("Brute Force      : %-5s %s%n", brute, brute == expected ? "✅" : "❌");
        System.out.printf("TryYourSelf      : %-5s %s%n", your,  your == expected ? "✅" : "❌");
        System.out.printf("Optimized (O(n)) : %-5s %s%n", opt,   opt == expected ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        CheckIfArrayIsSortedAndRotatedLeetCode1752 solver =
                new CheckIfArrayIsSortedAndRotatedLeetCode1752();

        System.out.println("=================================================");
        System.out.println("🔁  Check if Array Is Sorted and Rotated — Tests");
        System.out.println("=================================================\n");

        runTest(solver, new int[]{3, 4, 5, 1, 2}, true, "Test 1");
        runTest(solver, new int[]{2, 1, 3, 4}, false, "Test 2");
        runTest(solver, new int[]{1, 2, 3}, true, "Test 3");
        runTest(solver, new int[]{1}, true, "Test 4");
        runTest(solver, new int[]{1, 1, 1}, true, "Test 5 (duplicates)");
    }
}