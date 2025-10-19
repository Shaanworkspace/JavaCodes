package array;

import java.util.Arrays;

public class CandyLeetCode135 {

    // ===========================================================
    // Optimized O(n) greedy approach (two‑pass)
    // ===========================================================
    public int candy(int[] ratings) {
        // TODO: Implement optimized greedy logic
        // Hint:
        // 1. Every child gets at least 1 candy -> initialize with ones.
        // 2. Left‑to‑right pass:
        //      if rating[i] > rating[i‑1] -> candies[i] = candies[i‑1] + 1.
        // 3. Right‑to‑left pass:
        //      if rating[i] > rating[i+1] -> candies[i] = max(candies[i], candies[i+1] + 1).
        // 4. Sum all candies and return.
        return 0; // placeholder
    }

    // ===========================================================
    // Brute force (for concept clarity, not efficient)
    // ===========================================================
    public int candyBrute(int[] ratings) {
        int n = ratings.length,sum=0;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        right[n-1]=1;

        //left filling
        for(int i = 1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            } else {
                left[i]=1;
            }
        }

        //now filling right
        for(int i =n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                right[i]=right[i+1]+1;
            }
            else{
                right[i]=1;
            }
        }

        for(int i=0;i<n;i++){
//            ratings[i] = Math.max(left[i],right[i]);
            sum+=Math.max(left[i],right[i]);
        }
        return sum;
    }

    // ===========================================================
    // Helper to print results in dashboard format
    // ===========================================================
    private void runTest(int testNo, int[] ratings, int expected) {
        System.out.println("🔹 Test " + testNo);
        System.out.println("------------------------------------");
        System.out.println("Ratings  : " + Arrays.toString(ratings));
        System.out.println("Expected : " + expected);

        int brute = candyBrute(ratings.clone());
        int opt = candy(ratings.clone());

        System.out.println("Brute Result: " + brute);
        System.out.println("Optimized   : " + opt);
        System.out.println();
    }

    // ===========================================================
    // PSVM with your signature formatted dashboard 🧾
    // ===========================================================
    public static void main(String[] args) {
        CandyLeetCode135 solver = new CandyLeetCode135();

        System.out.println("====================================");
        System.out.println("              Candy Tests");
        System.out.println("====================================\n");

        solver.runTest(1, new int[]{1, 0, 2}, 5);
        solver.runTest(2, new int[]{1, 2, 2}, 4);
        solver.runTest(3, new int[]{1, 3, 4, 5, 2}, 11);
        solver.runTest(4, new int[]{1, 2, 3, 4, 5}, 15);

        System.out.println("====================================");
        System.out.println("        ✅  All Tests Executed");
        System.out.println("====================================");
    }
}