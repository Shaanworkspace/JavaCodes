package array.TwoSumProblem;

import java.util.Arrays;

public class TwoSumIISortedLeetCode167 {

    // ===========================================================
    // Optimized O(n) two‑pointer solution
    // ===========================================================
    public int[] twoSum(int[] numbers, int target) {
        int i =0,n=numbers.length;
        int j = n-1;
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if( sum == target){
                return new int[]{i + 1, j + 1};
            }
            else if(sum < target){
                i++;
            }
            else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }

    // ===========================================================
    // Brute‑force O(n²) solution for conceptual clarity
    // ===========================================================
    public int[] twoSumBrute(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // ===========================================================
    // Helper — neat test printer with ✅ / ❌
    // ===========================================================
    private void runTest(int testNo, int[] numbers, int target, int[] expected) {
        System.out.println();
        System.out.println("🟦 Test #" + testNo);
        System.out.println("────────────────────────────────────");
        System.out.println("Numbers : " + Arrays.toString(numbers));
        System.out.println("Target  : " + target);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("------------------------------------");

        // ✅ correct variable name here
        int[] brute = twoSumBrute(numbers, target);
        int[] opt   = twoSum(numbers, target);

        String bruteMark = Arrays.equals(brute, expected) ? "✅" : "❌";
        String optMark   = Arrays.equals(opt, expected) ? "✅" : "❌";

        System.out.printf("Brute Result : %-15s %s%n", Arrays.toString(brute), bruteMark);
        System.out.printf("Optimized    : %-15s %s%n", Arrays.toString(opt), optMark);
        System.out.println("────────────────────────────────────\n");
    }

    // ===========================================================
    // PSVM — your clean IntelliJ dashboard
    // ===========================================================
    public static void main(String[] args) {
        TwoSumIISortedLeetCode167 solver = new TwoSumIISortedLeetCode167();

        System.out.println("=================================================");
        System.out.println("🎯  Two Sum II (Input Array Is Sorted) — Tests");
        System.out.println("=================================================\n");

        solver.runTest(1, new int[]{2, 7, 11, 15}, 9, new int[]{1, 2});
        solver.runTest(2, new int[]{2, 3, 4}, 6, new int[]{1, 3});
        solver.runTest(3, new int[]{-1, 0}, -1, new int[]{1, 2});
        solver.runTest(4, new int[]{1, 2, 3, 4, 4, 9, 56, 90}, 8, new int[]{4, 5});
        solver.runTest(5, new int[]{5, 25, 75}, 100, new int[]{2, 3});
    }
}