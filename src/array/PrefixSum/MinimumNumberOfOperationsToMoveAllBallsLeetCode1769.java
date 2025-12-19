package array.PrefixSum;
import java.util.*;

/**
 * ===========================================================
 * ⚙️ LeetCode 1769 — Minimum Number of Operations
 *      to Move All Balls to Each Box
 * ===========================================================
 *
 * You are given n boxes represented by a binary string `boxes`
 * where boxes[i] == '1' if the i‑th box contains a ball,
 * and '0' if it is empty.
 *
 * In one operation, you can move one ball from a box to an
 * adjacent box (i ± 1). Return an array `answer` where
 * answer[i] is the minimum number of operations needed
 * to move all balls into the i‑th box.
 *
 * -----------------------------------------------------------
 * Example 1:
 * Input : boxes = "110"
 * Output: [1, 1, 3]
 *
 * Example 2:
 * Input : boxes = "001011"
 * Output: [11, 8, 5, 4, 3, 4]
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 1 ≤ n ≤ 2000
 *  • boxes[i] ∈ {'0','1'}
 * -----------------------------------------------------------
 */

public class MinimumNumberOfOperationsToMoveAllBallsLeetCode1769 {

    // ===========================================================
    // 🐢 Brute‑Force Approach — O(n²)
    // ===========================================================
    public int[] minOperationsBrute(String boxes) {
        HashSet<Integer> indexOf1 = new HashSet<>();
        int n =boxes.length();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                indexOf1.add(i);
            }
        }
        for(int i =0;i<n;i++){
            int val=0;
            for(int v : indexOf1){
                val+=Math.abs(v-i);
            }
            arr[i]=val;
        }
        return arr;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant — with debug prints
    // ===========================================================
    public int[] minOperationsTryYourSelf(String boxes) {
        // TODO: implement with visible tracing for understanding
        return null; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized Prefix‑Sum Approach — O(n)
    // ===========================================================
    public int[] minOperations(String boxes) {
        // TODO: implement efficient two‑pass prefix‑sum solution
        return null; // placeholder
    }

    // ===========================================================
    // 🧾 Test Runner — prints outputs from all variants
    // ===========================================================
    private static void runTest(MinimumNumberOfOperationsToMoveAllBallsLeetCode1769 solver,
                                String boxes, int[] expected, String name) {
        System.out.println("🔹 " + name);
        System.out.println("Input    : " + boxes);
        System.out.println("Expected : " + Arrays.toString(expected));

        int[] brute = solver.minOperationsBrute(boxes);
        int[] your  = solver.minOperationsTryYourSelf(boxes);
        int[] opt   = solver.minOperations(boxes);

        System.out.printf("Brute Force      : %-20s%n",
                Arrays.toString(brute));
        System.out.printf("TryYourSelf      : %-20s%n",
                Arrays.toString(your));
        System.out.printf("Optimized (O(n)) : %-20s%n",
                Arrays.toString(opt));
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Demo Dashboard
    // ===========================================================
    public static void main(String[] args) {
        MinimumNumberOfOperationsToMoveAllBallsLeetCode1769 solver =
                new MinimumNumberOfOperationsToMoveAllBallsLeetCode1769();

        System.out.println("=================================================");
        System.out.println("⚙️  Minimum Number of Operations to Move All Balls — Tests");
        System.out.println("=================================================\n");

        runTest(solver, "110", new int[]{1,1,3}, "Test 1");
        runTest(solver, "001011", new int[]{11,8,5,4,3,4}, "Test 2");
    }
}