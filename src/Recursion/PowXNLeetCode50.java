package Recursion;

import java.util.*;

public class PowXNLeetCode50 {

    // ===========================================================
    // Brute‑Force Approach (Iterative multiplication)
    // ===========================================================
    public double myPowBrute(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return x*myPowBrute(x,n-1);
    }

    // ===========================================================
    // ✍️ TryYourSelf (Simple Recursion with debug prints)
    // ===========================================================
    public double myPowTryYourSelf(double x, int n) {

        return x;
    }

    // ===========================================================
    // ⚡ Optimized (Fast Exponentiation) — O(log n)
    // ===========================================================
    public double myPow(double x, int n) {
        return x;
    }

    private double fastPow(double x, long n) {
        return x;
    }

    // ===========================================================
    // 🧾 Test Runner — compares all versions and prints ✅ / ❌
    // ===========================================================
    private static void runTest(PowXNLeetCode50 solver,
                                double x, int n, double expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.printf("x = %.5f, n = %d%n", x, n);
        System.out.printf("Expected : %.5f%n", expected);

        double brute = solver.myPowBrute(x, n);
        double your  = solver.myPowTryYourSelf(x, n);
        double opt   = solver.myPow(x, n);

        double epsilon = 1e-5;
        System.out.printf("Brute Force (Loop)   : %.5f %s%n", brute,
                Math.abs(brute - expected) < epsilon ? "✅" : "❌");
        System.out.printf("TryYourSelf (Recur)  : %.5f %s%n", your,
                Math.abs(your - expected) < epsilon ? "✅" : "❌");
        System.out.printf("Optimized (Fast Exp) : %.5f %s%n", opt,
                Math.abs(opt - expected) < epsilon ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        PowXNLeetCode50 solver = new PowXNLeetCode50();

        System.out.println("=================================================");
        System.out.println("Pow(x, n) — Three Versions");
        System.out.println("=================================================\n");

        runTest(solver, 2.00000, 10, 1024.00000, "Test 1");
        runTest(solver, 2.10000, 3, 9.26100, "Test 2");
        runTest(solver, 2.00000, -2, 0.25000, "Test 3");
        runTest(solver, 1.00000, -2147483648, 1.00000, "Test 4 (edge)");
        runTest(solver, 2.00000, 0, 1.00000, "Test 5");
    }
}