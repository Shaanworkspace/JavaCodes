package Recursion;
import java.util.*;

public class PowerOfTwoLeetCode231 {

    public boolean isPowerOfTwoApproach1(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwoApproach1(n / 2);
    }

    public boolean isPowerOfTwoApproach2(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }


    /*
    -> Read it
    There is some special feature of power of two
    each have only one bit as 1 others are 0
    and its number which is just less than the power of two have all bit set except the bit set in power of two
    8 = 1000
    8 - 1 = 0111
    1000 & 0111 = 0000
     */
    public boolean isPowerOfTwoApproach3(int n) {
        if(n<0) return false;
        int oneLess = n-1;
        if((n&oneLess)==0) return true;
        return false;
    }

    public boolean isPowerOfTwoApproach4(int n) {
        if (n <= 0) return false;
        double logValue = Math.log(n) / Math.log(2);
        return Math.abs(logValue - Math.round(logValue)) < 1e-10;
    }

    private static void runTest(PowerOfTwoLeetCode231 solver,
                                int n, boolean expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input (n) : " + n);
        System.out.println("Expected  : " + expected);

        boolean a1 = solver.isPowerOfTwoApproach1(n);
        boolean a2 = solver.isPowerOfTwoApproach2(n);
        boolean a3 = solver.isPowerOfTwoApproach3(n);
        boolean a4 = solver.isPowerOfTwoApproach4(n);

        System.out.printf("Approach 1 (Recursive)   : %-5s %s%n", a1, a1 == expected ? "✅" : "❌");
        System.out.printf("Approach 2 (Iterative)   : %-5s %s%n", a2, a2 == expected ? "✅" : "❌");
        System.out.printf("Approach 3 (Bit Math)    : %-5s %s%n", a3, a3 == expected ? "✅" : "❌");
        System.out.printf("Approach 4 (Math Log)    : %-5s %s%n", a4, a4 == expected ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }


    public static void main(String[] args) {
        PowerOfTwoLeetCode231 solver = new PowerOfTwoLeetCode231();

        System.out.println("=================================================");
        System.out.println("Power of Two — Four Approaches");
        System.out.println("=================================================\n");

        runTest(solver, 1, true,   "Test 1: n = 1");
        runTest(solver, 16, true,  "Test 2: n = 16");
        runTest(solver, 3, false,  "Test 3: n = 3");
        runTest(solver, 0, false,  "Test 4: n = 0");
        runTest(solver, -16, false,"Test 5: n = -16");
        runTest(solver, 1024, true,"Test 6: n = 1024");
        runTest(solver, 1000, false,"Test 7: n = 1000");
    }
}