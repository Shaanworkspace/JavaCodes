package array;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharactersLeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isUnique(sub)) {
                    maxLen = Math.max(maxLen, sub.length());
                }
            }
        }

        return maxLen;
    }

    private boolean isUnique(String sub) {
        boolean[] seen = new boolean[128]; // ASCII
        for (int k = 0; k < sub.length(); k++) {
            char c = sub.charAt(k);
            if (seen[c]) return false;
            seen[c] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharactersLeetCode3 solver =
                new LongestSubstringWithoutRepeatingCharactersLeetCode3();

        // Test Case 1
        String s1 = "abcabcbb";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solver.lengthOfLongestSubstring(s1)); // 3

        // Test Case 2
        String s2 = "bbbbb";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solver.lengthOfLongestSubstring(s2)); // 1

        // Test Case 3
        String s3 = "pwwkew";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solver.lengthOfLongestSubstring(s3)); // 3

        // Test Case 4 (edge)
        String s4 = "";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + solver.lengthOfLongestSubstring(s4)); // 0
    }
}