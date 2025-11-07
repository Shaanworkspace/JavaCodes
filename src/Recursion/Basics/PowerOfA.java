package Recursion.Basics;

public class PowerOfA {

    // Recursive function to calculate a^b
    public static int power(int a, int b) {
        if(b==0) return 1;
        return a*power(a,b-1);
    }

    // main method with test cases
    public static void main(String[] args) {
        int[][] testCases = {
                {2, 3, 8},     // 2^3 = 8
                {5, 0, 1},     // 5^0 = 1
                {3, 4, 81},    // 3^4 = 81
                {2, 10, 1024}, // 2^10 = 1024
                {7, 2, 49},    // 7^2 = 49
                {9, 1, 9},     // 9^1 = 9
                {10, 3, 1000}, // 10^3 = 1000
                {4, 5, 1024},  // 4^5 = 1024
                {1, 9, 1},     // 1^9 = 1
                {6, 4, 1296}   // 6^4 = 1296
        };

        for (int i = 0; i < testCases.length; i++) {
            int a = testCases[i][0];
            int b = testCases[i][1];
            int expected = testCases[i][2];
            int result = power(a, b);
            String verdict = (result == expected) ? "✅ Correct" : "❌ Wrong";
            System.out.printf("Test %d: %d^%d = %d | Expected: %d | %s%n",
                    i + 1, a, b, result, expected, verdict);
        }
    }
}