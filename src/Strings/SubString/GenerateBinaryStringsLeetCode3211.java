package Strings.SubString;
import java.util.*;

/**
 * ===========================================================
 * 🧠 LeetCode 3211 — Generate Binary Strings Without Adjacent Zeros
 * ===========================================================
 *
 * You are given a positive integer n.
 *
 * A binary string x is *valid* if every substring of length  2 contains
 * at least one '1'. In other words, “00” is never allowed.
 *
 * Return all valid binary strings of length  n (in any order).
 *
 * -----------------------------------------------------------
 * Example  1:
 * Input : n = 3
 * Output: ["010","011","101","110","111"]
 *
 * Example  2:
 * Input : n = 1
 * Output: ["0","1"]
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 1  ≤  n  ≤  18
 * -----------------------------------------------------------
 */

public class GenerateBinaryStringsLeetCode3211 {

    // ===========================================================
    // 🐢 Brute‑Force Approach (generate all 2ⁿ strings, filter)
    // ===========================================================
    public List<String> validStringsBrute(int n) {
        List<String> result = new ArrayList<>();
        generateBinarySubString(n,0,"",result);
        return result;
    }

    private void generateBinarySubString(int n,int idx,String s, List<String> result) {
        if(s.length() == n){
            if(validString(s))
                result.add(s);
            return;
        }
        // Add 1
        generateBinarySubString(n,idx+1,s+'1',result);
        //Add 0
        generateBinarySubString(n,idx+1,s+'0',result);
    }

    private boolean validString(String s) {
        int n = s.length();
        if(n==1) return true;
        for(int i =1;i<n;i++){
            if(s.charAt(i-1) =='0' &&  s.charAt(i) =='0'){
                return false;
            }
        }
        return true;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (recursive tracing with prints)
    // ===========================================================
    public List<String> validStringsTryYourSelf(int n) {

        return List.of();
    }

    // ===========================================================
    // ⚡ Optimized Backtracking Approach — O(2ⁿ)
    // ===========================================================
    public List<String> validStrings(int n) {

        return List.of();
    }

    // ===========================================================
    // 🧾 Test Runner — compares all methods, prints ✅ / ❌
    // ===========================================================
    private static void runTest(GenerateBinaryStringsLeetCode3211 solver,
                                int n, List<String> expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input     : n = " + n);
        System.out.println("Expected  : " + expected);

        List<String> brute = solver.validStringsBrute(n);
        List<String> your  = solver.validStringsTryYourSelf(n);
        List<String> opt   = solver.validStrings(n);

        System.out.printf("Brute Force      : %-50s %s%n",
                brute, new HashSet<>(brute).equals(new HashSet<>(expected)) ? "✅" : "❌");
        System.out.printf("TryYourSelf      : %-50s %s%n",
                your,  new HashSet<>(your).equals(new HashSet<>(expected)) ? "✅" : "❌");
        System.out.printf("Optimized (O(2ⁿ)) : %-50s %s%n",
                opt,   new HashSet<>(opt).equals(new HashSet<>(expected)) ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        GenerateBinaryStringsLeetCode3211 solver = new GenerateBinaryStringsLeetCode3211();

        System.out.println("=================================================");
        System.out.println("🔁  Generate Binary Strings Without Adjacent Zeros — Tests");
        System.out.println("=================================================\n");

        runTest(solver,
                3,
                Arrays.asList("010", "011", "101", "110", "111"),
                "Test 1");

        runTest(solver,
                1,
                Arrays.asList("0", "1"),
                "Test 2");
    }
}