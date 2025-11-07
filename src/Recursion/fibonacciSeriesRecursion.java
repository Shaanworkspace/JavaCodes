package Recursion;

public class fibonacciSeriesRecursion {

    // Recursive function for Fibonacci sequence
    public static int fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // "Try Yourself" version for student to implement/test
    public static int fibonacciTryYourselfFunction(int n) {
        //base case
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return 0;
        if (n == 1) return 1;
        //work
        return fibonacciTryYourselfFunction(n-1)+fibonacciTryYourselfFunction(n-2);
    }

    public static int fibonacciTryYourselfFunction2(int n) {
        //base case
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return 0;
        if (n == 1) return 1;

        //work

        int leftTreeAns = fibonacciTryYourselfFunction(n-1);
        int rightTreeAns = fibonacciTryYourselfFunction(n-2);
        return leftTreeAns+rightTreeAns;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8},
                {7, 13},
                {8, 21},
                {10, 55}
        };

        System.out.println("==============================================================");
        System.out.println("🌀 RECURSION TEST REPORT: FIBONACCI SEQUENCE (Dual Function)");
        System.out.println("==============================================================");
        System.out.printf("%-5s %-10s %-12s %-12s %-12s %-12s%n",
                "n", "Expected", "fibonacci()", "Status", "TryYourself()", "Status");
        System.out.println("--------------------------------------------------------------");

        int passed1 = 0;  // for fibonacci()
        int passed2 = 0;  // for fibonacciTryYourselfFunction()

        for (int[] test : testCases) {
            int n = test[0];
            int expected = test[1];

            int result1 = fibonacci(n);
            int result2 = fibonacciTryYourselfFunction(n);

            boolean isCorrect1 = result1 == expected;
            boolean isCorrect2 = result2 == expected;

            String status1 = isCorrect1 ? "✅ PASS" : "❌ FAIL";
            String status2 = isCorrect2 ? "✅ PASS" : "❌ FAIL";

            if (isCorrect1) passed1++;
            if (isCorrect2) passed2++;

            System.out.printf("%-5d %-10d %-12d %-12s %-12d %-12s%n",
                    n, expected, result1, status1, result2, status2);
        }

        System.out.println("--------------------------------------------------------------");
        System.out.printf("Summary:%n");
        System.out.printf("  ➤ fibonacci()               : %2d/%2d tests passed.%n", passed1, testCases.length);
        System.out.printf("  ➤ fibonacciTryYourself()    : %2d/%2d tests passed.%n", passed2, testCases.length);

        if (passed1 == testCases.length && passed2 == testCases.length)
            System.out.println("🎉 Both functions are perfect! Excellent work!");
        else
            System.out.println("⚠️ Some tests failed — review your recursion logic.");
        System.out.println("==============================================================");
    }
}