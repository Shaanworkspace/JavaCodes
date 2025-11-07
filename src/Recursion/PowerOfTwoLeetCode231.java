package Recursion;
import java.util.*;

public class PowerOfTwoLeetCode231 {

    // ===========================================================
    // 🧮 Approach 1 — Recursive Division (Basic Brute‑Force)
    // ===========================================================
    public boolean isPowerOfTwoApproach1(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwoApproach1(n / 2);
    }

    // ===========================================================
    // 🔁 Approach 2 — Iterative Division (Loop‑Based)
    // ===========================================================
    public boolean isPowerOfTwoApproach2(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }

    // ===========================================================
    // ⚙️ Approach 3 — Bit‑Manipulation O(1)
    // ===========================================================
    // Powers of 2 in binary look like: 1, 10, 100, 1000, ...
    // So (n & (n-1)) == 0 when n has exactly one set bit.
    public boolean isPowerOfTwoApproach3(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // ===========================================================
    // 🧠 Approach 4 — Mathematical (Logarithmic check)
    // ===========================================================
    // The logarithm (base 2) of a power‑of‑two number is an integer.
    // Using small tolerance because of floating‑point rounding.
    public boolean isPowerOfTwoApproach4(int n) {
        if (n <= 0) return false;
        double logValue = Math.log(n) / Math.log(2);
        return Math.abs(logValue - Math.round(logValue)) < 1e-10;
    }

    // ===========================================================
    // 🧾 Test Runner — Compare all four approaches
    // ===========================================================
    private static void runTest(PowerOfTwoLeetCode231 solver,
                                int n, boolean expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input (n) : " + n);
        System.out.println("Expected  : " + expected);

        boolean a1 = solver.isPowerOfTwoApproach1(n);
        boolean a2 = solver.isPowerOfTwoApproach2(n);
        boolean a3 = solver.isPowerOfTwoApproach3(n);
        boolean a4 = solver.isPowerOfTwoApproach4(n);

        System.out.printf("Approach 1 (Recursive)   : %-5s %s%n", a1, a1 == expected ? "✅" : "❌");
        System.out.printf("Approach 2 (Iterative)   : %-5s %s%n", a2, a2 == expected ? "✅" : "❌");
        System.out.printf("Approach 3 (Bit Math)    : %-5s %s%n", a3, a3 == expected ? "✅" : "❌");
        System.out.printf("Approach 4 (Math Log)    : %-5s %s%n", a4, a4 == expected ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Unified test dashboard
    // ===========================================================
    public static void main(String[] args) {
        PowerOfTwoLeetCode231 solver = new PowerOfTwoLeetCode231();

        System.out.println("=================================================");
        System.out.println("🔢  Power of Two — Four Approaches");
        System.out.println("=================================================\n");

        runTest(solver, 1, true,   "Test 1: n = 1");
        runTest(solver, 16, true,  "Test 2: n = 16");
        runTest(solver, 3, false,  "Test 3: n = 3");
        runTest(solver, 0, false,  "Test 4: n = 0");
        runTest(solver, -16, false,"Test 5: n = -16");
        runTest(solver, 1024, true,"Test 6: n = 1024");
        runTest(solver, 1000, false,"Test 7: n = 1000");
    }
}