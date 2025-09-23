package array;

public class MaximumPointsFromCardsLeetCode1423 {
        // Optimized sliding window solution
        public int maxScore(int[] cardPoints, int k) {
            // TODO: Implement optimized version
            // Hint:
            // 1. Compute total sum of the array.
            // 2. Find the minimum sum of a consecutive window of length n-k.
            // 3. Answer = totalSum - minWindowSum.
            return 0; // placeholder
        }


        public int maxScoreBrute(int[] cardPoints, int k) {
            int n = cardPoints.length;
            // Take first k elements initially
            int currSum = 0;
            for (int i = 0; i < k; i++) {
                currSum += cardPoints[i];
            }
            int maxSum = currSum;

            // Slide the window: move from left side to right side
            for (int i = 0; i < k; i++) {
                currSum -= cardPoints[k - 1 - i];   // remove one taken from start
                currSum += cardPoints[n - 1 - i];   // add one from end
                maxSum = Math.max(maxSum, currSum);
            }

            return maxSum;
        }

        // Simple test runner
        public static void main(String[] args) {
            MaximumPointsFromCardsLeetCode1423 solution = new MaximumPointsFromCardsLeetCode1423();

            int[] test1 = {1, 2, 3, 4, 5, 6, 1};
            int k1 = 3;
            System.out.println("Test1 Expected: 12, Got: " + solution.maxScoreBrute(test1, k1));

            int[] test2 = {2, 2, 2};
            int k2 = 2;
            System.out.println("Test2 Expected: 4, Got: " + solution.maxScoreBrute(test2, k2));

            int[] test3 = {9, 7, 7, 9, 7, 7, 9};
            int k3 = 7;
            System.out.println("Test3 Expected: 55, Got: " + solution.maxScoreBrute(test3, k3));
        }
    }
