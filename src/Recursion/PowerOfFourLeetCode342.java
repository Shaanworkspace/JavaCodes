package Recursion;
import java.util.*;

public class PowerOfFourLeetCode342 {

    // ===========================================================
    // Approach 1 — Recursive Division
    // ===========================================================
    public boolean isPowerOfFourApproach1(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 4 != 0) return false;
        return isPowerOfFourApproach1(n / 4);
    }

    // ===========================================================
    // Approach 2 — Iterative Division (Loop-based)
    // ===========================================================
    public boolean isPowerOfFourApproach2(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 4 != 0) return false;
            n /= 4;
        }
        return true;
    }

    // ===========================================================
    // Approach 3 — Bit Manipulation (O(1))
    // ===========================================================
    // 1) n is power of two: (n & (n-1)) == 0
    // 2) the single set bit is at even index: (n & 0x55555555) != 0
    public boolean isPowerOfFourApproach3(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
        // Alternative constant-time (no floats):
        // return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }

    // ===========================================================
    // Approach 4 — Logarithmic Math (O(1))
    // ===========================================================
    public boolean isPowerOfFourApproach4(int n) {
        if (n <= 0) return false;
        double logValue = Math.log10(n) / Math.log10(4);
        return (int)Math.round(logValue) == logValue;
    }

    // ===========================================================
    // 🧾 Test Runner — Compare all approaches
    // ===========================================================
    private static void runTest(PowerOfFourLeetCode342 solver,
                                int n, boolean expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input (n) : " + n);
        System.out.println("Expected  : " + expected);

        boolean a1 = solver.isPowerOfFourApproach1(n);
        boolean a2 = solver.isPowerOfFourApproach2(n);
        boolean a3 = solver.isPowerOfFourApproach3(n);
        boolean a4 = solver.isPowerOfFourApproach4(n);

        System.out.printf("Approach 1 (Recursive)   : %-5s %s%n", a1, a1 == expected ? "✅" : "❌");
        System.out.printf("Approach 2 (Iterative)   : %-5s %s%n", a2, a2 == expected ? "✅" : "❌");
        System.out.printf("Approach 3 (Bit Mask)    : %-5s %s%n", a3, a3 == expected ? "✅" : "❌");
        System.out.printf("Approach 4 (Log Math)    : %-5s %s%n", a4, a4 == expected ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Unified testing of all four methods
    // ===========================================================
    public static void main(String[] args) {
        PowerOfFourLeetCode342 solver = new PowerOfFourLeetCode342();

        System.out.println("=================================================");
        System.out.println("🔢  Power of Four — Four Approaches");
        System.out.println("=================================================\n");

        runTest(solver, 16, true,   "Test 1: n = 16");
        runTest(solver, 5,  false,  "Test 2: n = 5");
        runTest(solver, 1,  true,   "Test 3: n = 1");
        runTest(solver, 4,  true,   "Test 4: n = 4");
        runTest(solver, 64, true,   "Test 5: n = 64");
        runTest(solver, 8,  false,  "Test 6: n = 8");
        runTest(solver, 0,  false,  "Test 7: n = 0");
        runTest(solver, -4, false,  "Test 8: n = -4");
        runTest(solver, 1024, true, "Test 9: n = 1024");       // 4^5
        runTest(solver, 2,  false,  "Test 10: n = 2");
        runTest(solver, 1073741824, true, "Test 11: n = 1073741824"); // 4^15
    }
}