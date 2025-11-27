package Backtracking;

import java.util.*;

/**
 * ===========================================================
 * 🔮 LeetCode 131 — Palindrome Partitioning
 * ===========================================================
 * Given a string s, return all possible palindrome partitioning.
 *
 * Example:
 *  Input:  "aab"
 *  Output: [["a","a","b"], ["aa","b"]]
 *
 * This file includes method skeletons only.
 * Implement logic yourself.
 */

public class PalindromePartitioningLeetCode131 {

    // ===========================================================
    // Brute-Force Method (to implement)
    // ===========================================================
    public List<List<String>> partitionBrute(String s) {
        return new ArrayList<>(); // TODO
    }

    // ===========================================================
    // TryYourSelf Method (to implement)
    // ===========================================================
    public List<List<String>> partitionTryYourSelf(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> additiveString = new ArrayList<>();
        
        finder(s,0,additiveString,result);
        return result;
    }

    private void finder(String s, int idx, List<String> current, List<List<String>> result) {
        if(idx==s.length()){
            List<String> st = new ArrayList<>(current);
            result.add(st);
            return;
        }
        
        /*
         1. Let's say, as we have ["aab"], we need to start from idx 0 as 'a'.
         2. separate the string {a | a,b } from 0 to i and Check is it palindrome
         3. Store the string to list as this is a palindrome
         
         */
        
        
        // here we got from {aab} --> currStr = a
        for (int end = idx; end < s.length(); end++) {
            String sub = s.substring(idx, end + 1);

            if (checkPalinrome(sub)) {
                current.add(sub);               // choose
                finder(s, end + 1, current, result); // explore
                current.remove(current.size()-1); // backtrack
            }

        }
    }

    private boolean checkPalinrome(String currStr) {
        int i = 0;
        int j = currStr.length() - 1;

        while (i < j) {
            if (currStr.charAt(i) != currStr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }


    // ===========================================================
    // Optimized Backtracking Method (to implement)
    // ===========================================================
    public List<List<String>> partition(String s) {
        return new ArrayList<>(); // TODO
    }

    // ===========================================================
    // Utility — compare two result sets ignoring order
    // ===========================================================
    private static boolean isEqual(List<List<String>> a, List<List<String>> b) {
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();

        for (List<String> x : a) s1.add(x.toString());
        for (List<String> x : b) s2.add(x.toString());

        return s1.equals(s2);
    }

    // ===========================================================
    // Utility — print List<List<String>>
    // ===========================================================
    private static void printList(List<List<String>> list) {
        if (list.isEmpty()) {
            System.out.println("   []");
            return;
        }
        for (List<String> seq : list) {
            System.out.println("   " + seq);
        }
    }

    // ===========================================================
    // Test Runner with ✔ or ✘
    // ===========================================================
    private static void runTest(
            PalindromePartitioningLeetCode131 solver,
            String s,
            List<List<String>> expected,
            String testName) {

        System.out.println("🔹 " + testName);
        System.out.println("Input           : \"" + s + "\"");
        System.out.println("Expected Output : ");
        printList(expected);
        System.out.println();

        List<List<String>> brute = solver.partitionBrute(s);
        List<List<String>> yours = solver.partitionTryYourSelf(s);
        List<List<String>> opt   = solver.partition(s);

        boolean bOK = isEqual(brute, expected);
        boolean yOK = isEqual(yours, expected);
        boolean oOK = isEqual(opt, expected);

        System.out.println("Your Outputs:");

        System.out.println("Brute-Force : " + (bOK ? "✔ Correct" : "✘ Wrong"));
        printList(brute);
        System.out.println();

        System.out.println("TryYourSelf : " + (yOK ? "✔ Correct" : "✘ Wrong"));
        printList(yours);
        System.out.println();

        System.out.println("Optimized   : " + (oOK ? "✔ Correct" : "✘ Wrong"));
        printList(opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // PSVM — Dashboard
    // ===========================================================
    public static void main(String[] args) {

        PalindromePartitioningLeetCode131 solver =
                new PalindromePartitioningLeetCode131();

        System.out.println("=================================================");
        System.out.println("🔮  Palindrome Partitioning — Auto Tester");
        System.out.println("=================================================\n");

        List<List<String>> exp1 = Arrays.asList(
                Arrays.asList("a","a","b"),
                Arrays.asList("aa","b")
        );

        List<List<String>> exp2 = Arrays.asList(
                Arrays.asList("a")
        );

        List<List<String>> exp3 = Arrays.asList(
                Arrays.asList("n","i","t","i","n"),
                Arrays.asList("n","iti","n"),
                Arrays.asList("nitin")
        );

        runTest(solver, "aab",   exp1, "Test 1");
        runTest(solver, "a",     exp2, "Test 2");
        runTest(solver, "nitin", exp3, "Test 3");
    }
}
