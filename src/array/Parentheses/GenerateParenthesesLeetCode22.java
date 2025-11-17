package array.Parentheses;

import java.util.*;

public class GenerateParenthesesLeetCode22 {

    // ===========================================================
    // 🐢 Brute‑Force Approach (Generate all, then filter valid)
    // Hint: Generate all 2^(2n) combinations, then check if balanced
    // ===========================================================
    public List<String> generateParenthesisBrute(int n) {
        // TODO: Generate all possible strings with n '(' and n ')'
        // Then filter only valid (balanced) ones
        return new ArrayList<>(); // dummy placeholder
    }

    // ===========================================================
    // ✍️ TryYourSelf (Backtracking with debug prints)
    // Hint: Track open/close counts, add debug prints for each choice
    // ===========================================================
    public List<String> generateParenthesisTryYourSelf(int n) {
        // TODO: Backtracking with conditions:
        // - Add '(' if open < n
        // - Add ')' if close < open
        // Optional: print current string at each step
        return new ArrayList<>(); // dummy placeholder
    }

    // ===========================================================
    // ⚡ Optimized (Clean Backtracking with pruning)
    // Hint: Only generate valid sequences from the start
    // ===========================================================
    public List<String> generateParenthesis(int n) {
        ArrayList<String> arrayList = new ArrayList<>();
        generateHelper(n,0,0,"",arrayList);
        return arrayList;
    }

    private void generateHelper(int n, int leftB, int rightB, String s, ArrayList<String> arrayList) {
        if(rightB==n){
            arrayList.add(s);
            return;
        }

        // add left
        if(leftB<n){
            generateHelper(n,leftB+1,rightB,s+'(',arrayList);
        }
        if(rightB<leftB){
            generateHelper(n,leftB,rightB+1,s+')',arrayList);
        }
    }

    // ===========================================================
    // Helper: Check if a parentheses string is valid
    // ===========================================================
    private static boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    // ===========================================================
    // Helper: Sort list for comparison (order-independent check)
    // ===========================================================
    private static List<String> sorted(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return copy;
    }

    // ===========================================================
    // 🧾 Test Runner — compares all versions and prints ✅ / ❌
    // ===========================================================
    private static void runTest(GenerateParenthesesLeetCode22 solver,
                                int n, List<String> expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input (n) : " + n);
        System.out.println("Expected  : " + expected);

        List<String> brute = solver.generateParenthesisBrute(n);
        List<String> your  = solver.generateParenthesisTryYourSelf(n);
        List<String> opt   = solver.generateParenthesis(n);

        // Sort for order-independent comparison
        List<String> expSorted = sorted(expected);

        System.out.printf("Brute (Generate all)   : %-40s %s%n",
                brute.size() + " results", sorted(brute).equals(expSorted) ? "✅" : "❌");
        System.out.printf("TryYourSelf (Debug)    : %-40s %s%n",
                your.size() + " results", sorted(your).equals(expSorted) ? "✅" : "❌");
        System.out.printf("Optimized (Backtrack)  : %-40s %s%n",
                opt.size() + " results", sorted(opt).equals(expSorted) ? "✅" : "❌");

        if (opt.size() > 0) {
            System.out.println("Sample outputs: " + sorted(opt));
        }
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        GenerateParenthesesLeetCode22 solver = new GenerateParenthesesLeetCode22();

        System.out.println("=================================================");
        System.out.println("🔗  Generate Parentheses — Three Versions");
        System.out.println("=================================================\n");

        runTest(solver, 1,
                Arrays.asList("()"),
                "Test 1");

        runTest(solver, 2,
                Arrays.asList("(())", "()()"),
                "Test 2");

        runTest(solver, 3,
                Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"),
                "Test 3");

        runTest(solver, 4,
                Arrays.asList("(((())))", "((()()))", "((())())", "((()))()", "(()(()))",
                        "(()()())", "(()())()", "(())(())", "(())()()", "()((()))",
                        "()(()())", "()(())()", "()()(())", "()()()()"),
                "Test 4");
    }
}