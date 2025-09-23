package Strings.SubString;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharactersLeetCode3 {
    public int lengthOfLongestSubstringHashSet(String s) {
        int result = 0;
        int i = 0, j = 0;

        HashSet<Character> hashSet = new HashSet<>();
        while (j < s.length()) {
            char ch = s.charAt(j);

            while (hashSet.contains(ch)) {
                hashSet.remove(s.charAt(i));
                i++;
            }
            hashSet.add(ch);
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }

    public int lengthOfLongestSubstringOptimised(String s) {
        int result = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);

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


    public void lengthOfLongestSubstringBruteForce(String s) {
//        find all substrings
        int n =  s.length();
        for(int i =0; i<n; i++){
            for (int j = i+1; j<n; j++){
                System.out.println(s.substring(i, j));
                
            }
        }

//        check each substring for  unique elements

//        return largest length

    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharactersLeetCode3 solver =
                new LongestSubstringWithoutRepeatingCharactersLeetCode3();

        // सभी test cases एक ही array में
        String[] testCases = {
                "abcabcbb", // expected 3
                "bbbbb",    // expected 1
                "pwwkew",   // expected 3
                "",         // expected 0
                " ",        // expected 1
                "au",       // expected 2
                "dvdf"      // expected 3
        };

        System.out.println("\n=== Longest Substring Without Repeating Characters ===");
        System.out.println(String.format("%-10s | %-25s | %-25s", "Input", "HashSet Version", "Optimised Version"));
        System.out.println("---------------------------------------------------------------------------");

        for (String test : testCases) {
            int res1 = solver.lengthOfLongestSubstringHashSet(test);
            int res2 = solver.lengthOfLongestSubstringOptimised(test);

            // fixed-width formatting so table looks neat
            System.out.println(String.format("%-10s | %-25d | %-25d", "\"" + test + "\"", res1, res2));
        }

        for (String test : testCases) {
            solver.lengthOfLongestSubstringBruteForce(test);

            // fixed-width formatting so table looks neat
            System.out.println("----------------Next ________________");
        }






    }
}