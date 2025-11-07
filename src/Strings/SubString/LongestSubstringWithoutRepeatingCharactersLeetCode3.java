package Strings.SubString;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharactersLeetCode3 {

    // ===========================================================
    // 🔹 HashSet Sliding Window — clean O(n)
    // ===========================================================
    public int lengthOfLongestSubstringHashSet(String s) {
        int result = 0;
        int i = 0, j = 0;
        HashSet<Character> window = new HashSet<>();

        while (j < s.length()) {
            char ch = s.charAt(j);

            // If duplicate char comes, shrink window from left
            while (window.contains(ch)) {
                window.remove(s.charAt(i));
                i++;
            }

            window.add(ch);
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }

    // ===========================================================
    // 🐢 Brute‑Force Approach
    // ===========================================================
    public int lengthOfLongestSubstringBrute(String s) {
        // TODO: implement brute logic
        return 0;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (for learning / trace)
    // ===========================================================
    public int lengthOfLongestSubstringTryYourSelf(String s) {
        int left =0,right=0,result=0,n=s.length();

        while(right<n){
            char ch = s.charAt(right);

            for(int i = left ;i<right;i++){
                if(s.charAt(left)== ch){
                    left = i+1;
//                    left++; //IMPROVE HERE
                    break;
                }
            }

            result = Math.max(result,right-left+1);
//            result = Math.max(result,right-left); //IMPROVE HERE
            right++;
        }
        return 0;
    }

    // ===========================================================
    // ⚡ Optimized O(n) (using indices, not HashSet)
    // ===========================================================
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            // Slide 'left' past any duplicate character
            for (int i = left; i < right; i++) {
                if (s.charAt(i) == ch) {
                    left = i + 1;
                    break;
                }
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }

    // ===========================================================
    // 🧾 Test Runner — prints all versions with ✅ / ❌
    // ===========================================================
    private static void runTest(LongestSubstringWithoutRepeatingCharactersLeetCode3 solver,
                                String input, int expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input     : \"" + input + "\"");
        System.out.println("Expected  : " + expected);

        int brute = solver.lengthOfLongestSubstringBrute(input);
        int your  = solver.lengthOfLongestSubstringTryYourSelf(input);
        int opt   = solver.lengthOfLongestSubstring(input);
        int hash  = solver.lengthOfLongestSubstringHashSet(input);

        System.out.printf("Brute Force (O²)      : %-5d %s%n", brute, brute == expected ? "✅" : "❌");
        System.out.printf("TryYourSelf (debug)   : %-5d %s%n", your,  your == expected ? "✅" : "❌");
        System.out.printf("Optimized (O(n))      : %-5d %s%n", opt,   opt == expected ? "✅" : "❌");
        System.out.printf("HashSet (O(n))        : %-5d %s%n", hash,  hash == expected ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharactersLeetCode3 solver =
                new LongestSubstringWithoutRepeatingCharactersLeetCode3();

        System.out.println("=================================================");
        System.out.println("🔠  Longest Substring Without Repeating Characters");
        System.out.println("=================================================\n");

        runTest(solver, "abcabcbb", 3, "Test 1");
        runTest(solver, "bbbbb", 1, "Test 2");
        runTest(solver, "pwwkew", 3, "Test 3");
        runTest(solver, "", 0, "Test 4 (empty string)");
        runTest(solver, " ", 1, "Test 5 (single space)");
    }
}