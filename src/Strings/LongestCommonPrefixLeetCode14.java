package Strings;
import java.util.Arrays;

public class LongestCommonPrefixLeetCode14 {

    // ===========================================================
    // Optimized O(n log n)
    // ===========================================================
    public String longestCommonPrefix(String[] strs) {
        /*
        we will first short the array it will short in alphabetical order also --> https://www.youtube.com/watch?v=wtOQaovlvhY
         */
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length-1];

        for(int i  = 0 ;i<first.length();i++){
            if(first.charAt(i) != last.charAt(i)){
                return first.substring(0,i);
            }
        }
        return first;
    }

    // ===========================================================
    // Brute approach (character‑by‑character vertical scan)
    // ===========================================================
    public String longestCommonPrefixBrute(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // ===========================================================
    // Helper to run one test with aligned printing
    // ===========================================================
    private void runTest(int testNo, String[] strs, String expected) {
        System.out.println("🔹 Test " + testNo);
        System.out.println("------------------------------------");
        System.out.println("Input Array : " + Arrays.toString(strs));
        System.out.println("Expected    : \"" + expected + "\"");

        String brute = longestCommonPrefixBrute(strs.clone());
        String opt = longestCommonPrefix(strs.clone());

        System.out.println("Brute Result: \"" + brute + "\"");
        System.out.println("Optimized   : \"" + opt + "\"");
        System.out.println();
    }

    // ===========================================================
    // Nicely formatted IntelliJ dashboard
    // ===========================================================
    public static void main(String[] args) {
        LongestCommonPrefixLeetCode14 solver = new LongestCommonPrefixLeetCode14();

        System.out.println("====================================");
        System.out.println("Longest Common Prefix Tests");
        System.out.println("====================================\n");

        solver.runTest(1, new String[]{"flower","flow","flight"}, "fl");
        solver.runTest(2, new String[]{"dog","racecar","car"}, "");
        solver.runTest(3, new String[]{"apple","app","april"}, "ap");
        solver.runTest(4, new String[]{"interspecies","interstellar","interstate"}, "inters");
        solver.runTest(5, new String[]{"a"}, "a");

        System.out.println("========================================================================");
        System.out.println("All Tests Executed");
        System.out.println("========================================================================");
    }
}