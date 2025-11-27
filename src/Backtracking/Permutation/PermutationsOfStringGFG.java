package Backtracking.Permutation;

import java.util.*;

/**
 * ===========================================================
 * 🔁 GeeksForGeeks — Permutations of a String
 * ===========================================================
 * Given a string s (may contain duplicates),
 * return ALL UNIQUE permutations in any order.
 *
 * Examples:
 *  s = "ABC" → ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
 *  s = "AAA" → ["AAA"]
 *
 * This file includes ONLY method skeletons.
 * Implement logic inside the methods.
 */

public class PermutationsOfStringGFG {

    // ===========================================================
    // Brute-Force Method (to implement)
    // ===========================================================
    public ArrayList<String> findPermutationBrute(String s) {
        HashSet<String> adder = new HashSet<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr); // sort first
        permute(new String(arr), "", adder);

        return new ArrayList<>(adder);
    }

    private void permute(String s,String currStr, HashSet<String> adder) {

        if(s.isEmpty()){
            adder.add(currStr);
            return;
        }

        for(int  i=0;i<s.length();i++){
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) continue;
            char ch = s.charAt(i);

            String left = s.substring(0,i);
            String right = s.substring(i+1);

            permute(left+right,currStr+ch,adder);
        }
    }

    // ===========================================================
    // TryYourSelf Method (to implement)
    // ===========================================================
    public ArrayList<String> findPermutationTryYourSelf(String s) {

        return new ArrayList<>();
    }


    // ===========================================================
    // Optimized Backtracking Method — do in this one finally
    // ===========================================================
    public ArrayList<String> findPermutation(String s) {
        return new ArrayList<>(); // TODO
    }

    // ===========================================================
    // Utility — Compare ignoring order
    // ===========================================================
    private static boolean isEqual(List<String> a, List<String> b) {
        return new HashSet<>(a).equals(new HashSet<>(b));
    }

    // ===========================================================
    // Utility — Print list beautifully
    // ===========================================================
    private static void printList(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("   []");
            return;
        }
        for (String s : list) {
            System.out.println("   " + s);
        }
    }

    // ===========================================================
    // Test Runner with ✔ or ✘
    // ===========================================================
    private static void runTest(
            PermutationsOfStringGFG solver,
            String s,
            List<String> expected,
            String testName) {

        System.out.println("🔹 " + testName);
        System.out.println("Input           : \"" + s + "\"");
        System.out.println("Expected Output :");
        printList(expected);
        System.out.println();

        ArrayList<String> brute = solver.findPermutationBrute(s);
        ArrayList<String> yours = solver.findPermutationTryYourSelf(s);
        ArrayList<String> opt   = solver.findPermutation(s);

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

        PermutationsOfStringGFG solver = new PermutationsOfStringGFG();

        System.out.println("=================================================");
        System.out.println("🔁  Permutations of String — Auto Tester");
        System.out.println("=================================================\n");

        runTest(solver, "ABC",
                Arrays.asList("ABC","ACB","BAC","BCA","CAB","CBA"),
                "Test 1");

        runTest(solver, "AAA",
                Arrays.asList("AAA"),
                "Test 2");

        runTest(solver, "ABSG",
                Arrays.asList(
                        "ABGS","ABSG","AGBS","AGSB","ASBG","ASGB",
                        "BAGS","BASG","BGAS","BGSA","BSAG","BSGA",
                        "GABS","GASB","GBAS","GBSA","GSAB","GSBA",
                        "SABG","SAGB","SBAG","SBGA","SGAB","SGBA"
                ),
                "Test 3");

    }
}
