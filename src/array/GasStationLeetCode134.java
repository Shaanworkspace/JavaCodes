package array;

import java.util.Arrays;

public class GasStationLeetCode134 {

    // ===========================================================
    // Optimized O(n) solution (Disabled / Placeholder)
    // ===========================================================
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length,gasSum=0,gasSpendSum=0,result=0,total=0;
        for(int i =0;i<n;i++){
            gasSum+=gas[i];
            gasSpendSum+=cost[i];
        }
        if(gasSum<gasSpendSum){
            return -1;
        }


        for(int i =0;i<n;i++){
            total = total+gas[i]-cost[i];
            if(total<0){
                total=0;
                result=i+1;
            }
        }

        return result;
    }

    // ===========================================================
    // Brute force O(n²) for verification
    // ===========================================================
    public int canCompleteCircuitBrute(int[] gas, int[] cost) {
        int n = gas.length;

        for (int start = 0; start < n; start++) {

            // agar starting point pe hi gas kam hai toh aage kya hi jayenge 😅
            if (gas[start] < cost[start]) continue;

            int currGas = 0;
            int count = 0;
            int i = start;

            // try to move through all n stations circularly
            while (count < n) {
                currGas += gas[i] - cost[i];
                if (currGas < 0) break;   // fail to reach next station

                i = (i + 1) % n;
                count++;
            }

            if (count == n && currGas >= 0) {
                return start; // poora circle complete hua ✅
            }
        }
        return -1; // koi bhi start point kaam nahi karta 😕
    }

    // ===========================================================
    // Helper to run test and print dashboard results 🧾
    // ===========================================================
    private void runTest(int testNo, int[] gas, int[] cost, int expected) {
        System.out.println("🔹 Test " + testNo);
        System.out.println("------------------------------------");
        System.out.println("Gas  : " + Arrays.toString(gas));
        System.out.println("Cost : " + Arrays.toString(cost));
        System.out.println("Expected    : " + expected);

        int brute = canCompleteCircuitBrute(gas, cost);
        int opt = canCompleteCircuit(gas, cost);

        System.out.println("Brute Result: " + brute);
        System.out.println("Optimized   : " + opt);
        System.out.println();
    }

    // ===========================================================
    // PSVM with formatted clear output
    // ===========================================================
    public static void main(String[] args) {
        GasStationLeetCode134 solver = new GasStationLeetCode134();

        System.out.println("====================================");
        System.out.println("        Gas Station  Tests");
        System.out.println("====================================\n");

        solver.runTest(1, new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3);
        solver.runTest(2, new int[]{2, 3, 4}, new int[]{3, 4, 3}, -1);
        solver.runTest(3, new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}, 4);
        solver.runTest(4, new int[]{3, 3, 4}, new int[]{3, 4, 4}, -1);

        System.out.println("====================================");
        System.out.println("        ✅  All Tests Executed");
        System.out.println("====================================");
    }
}