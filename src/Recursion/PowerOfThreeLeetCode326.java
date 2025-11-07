package Recursion;

import java.util.*;

public class PowerOfThreeLeetCode326 {

    // ===========================================================
    // Approach1 — Recursive Division --> https://www.youtube.com/watch?v=11lCatB_H_A
    // ===========================================================
    public boolean isPowerOfThreeApproach1(int n) {
        if(n<=0) return false;
        //base case
        if(n==1) return true;
        if(n%3 == 0){
            //work
            return isPowerOfThreeApproach1(n/3);
        }
        else{
            return false;
        }

    }

    // ===========================================================
    // Approach2 — Iterative Division (Loop‑based)
    // ===========================================================
    public boolean isPowerOfThreeApproach2(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return true;
    }

    // ===========================================================
    // Approach3 — Mathematical / Logarithmic
    // ===========================================================
    // log₃(n) must be an integer → check via log base change formula
    public boolean isPowerOfThreeApproach3(int n) {
        if (n <= 0) return false;
        double logValue = Math.log10(n) / Math.log10(3);
        //return Math.abs(logValue - Math.round(logValue)) < 1e-10;
        return (int)Math.round(logValue) == logValue;
    }

    // ===========================================================
    // Approach4 — Constant‑Time Integer Bound Check
    // ===========================================================
    // Highest power of 3 in 32‑bit signed int: 3¹⁹ = 1162261467
    // If n divides it cleanly → n is power of 3.
    public boolean isPowerOfThreeApproach4(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    // ===========================================================
    // Test Runner — Compare all approaches
    // ===========================================================
    private static void runTest(PowerOfThreeLeetCode326 solver,
                                int n, boolean expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input (n) : " + n);
        System.out.println("Expected  : " + expected);

        boolean a1 = solver.isPowerOfThreeApproach1(n);
        boolean a2 = solver.isPowerOfThreeApproach2(n);
        boolean a3 = solver.isPowerOfThreeApproach3(n);
        boolean a4 = solver.isPowerOfThreeApproach4(n);

        System.out.printf("Approach 1 (Recursive)   : %-5s %s%n", a1, a1 == expected ? "✅" : "❌");
        System.out.printf("Approach 2 (Iterative)   : %-5s %s%n", a2, a2 == expected ? "✅" : "❌");
        System.out.printf("Approach 3 (Log Math)    : %-5s %s%n", a3, a3 == expected ? "✅" : "❌");
        System.out.printf("Approach 4 (Const‑Time)  : %-5s %s%n", a4, a4 == expected ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Unified testing of all four methods
    // ===========================================================
    public static void main(String[] args) {
        PowerOfThreeLeetCode326 solver = new PowerOfThreeLeetCode326();

        System.out.println("=================================================");
        System.out.println("🔢  Power of Three — Four Approaches");
        System.out.println("=================================================\n");

        runTest(solver, 27, true,  "Test 1: n = 27");
        runTest(solver, 9,  true,  "Test 2: n = 9");
        runTest(solver, 3,  true,  "Test 3: n = 3");
        runTest(solver, 1,  true,  "Test 4: n = 1");
        runTest(solver, 0,  false, "Test 5: n = 0");
        runTest(solver, -3, false, "Test 6: n = -3");
        runTest(solver, 12, false, "Test 7: n = 12");
        runTest(solver, 45, false, "Test 8: n = 45");
        runTest(solver, 81, true,  "Test 9: n = 81");
    }
}