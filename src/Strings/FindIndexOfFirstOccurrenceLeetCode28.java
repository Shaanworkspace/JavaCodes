package Strings;

public class FindIndexOfFirstOccurrenceLeetCode28 {

    // ===========================================================
    // Optimized version — simple substring scan
    // ===========================================================
    // (kept simple for clarity; behaves exactly like indexOf)
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Compare substring of equal length to the needle
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    // ===========================================================
    // 🔹 Your original brute‑force logic — fixed & safe
    // ===========================================================
    public int strStrBrute(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;

        int firstIndex = 0;   // to store where potential match starts
        int j = 0;            // pointer for needle String
        boolean recordStart = false;  // flag to mark first match start

        for (int i = 0; i < haystack.length(); i++) {
            // Characters match → move both forward
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (!recordStart) {      // first char of potential match
                    firstIndex = i;
                    recordStart = true;
                }
                j++;
                if (j == needle.length()) return firstIndex;

            } else {
                // mismatch → reset needle pointer
                // we go back one step in haystack to re‑evaluate overlapping pattern
                if (recordStart) {
                    i = firstIndex;     // reset to start of last attempted match
                }
                j = 0;
                recordStart = false;
            }
        }
        return -1;
    }

    // ===========================================================
    // Helper — neat per‑test printer with ✅ / ❌ indicators
    // ===========================================================
    private void runTest(int testNo, String haystack, String needle, int expected) {
        System.out.println();
        System.out.println("🟦 Test #" + testNo);
        System.out.println("────────────────────────────────────");
        System.out.printf("🔍 Haystack : \"%s\"%n", haystack);
        System.out.printf("🧵 Needle   : \"%s\"%n", needle);
        System.out.printf("🎯 Expected : %d%n", expected);
        System.out.println("------------------------------------");

        int bruteResult = strStrBrute(haystack, needle);
        int optimizedResult = strStr(haystack, needle);

        String bruteMark = bruteResult == expected ? "✅" : "❌";
        String optMark = optimizedResult == expected ? "✅" : "❌";

        System.out.printf("Brute Result : %-5d %s%n", bruteResult, bruteMark);
        System.out.printf("Optimized    : %-5d %s%n", optimizedResult, optMark);
        System.out.println("────────────────────────────────────\n");
    }

    // ===========================================================
    // PSVM — nice clean dashboard
    // ===========================================================
    public static void main(String[] args) {
        FindIndexOfFirstOccurrenceLeetCode28 solver = new FindIndexOfFirstOccurrenceLeetCode28();

        System.out.println("=================================================");
        System.out.println("🧭  Find Index of First Occurrence — Test Suite");
        System.out.println("=================================================\n");

        solver.runTest(1, "sadbutsad", "sad", 0);
        solver.runTest(2, "leetcode", "leeto", -1);
        solver.runTest(3, "aaabaaabaaaa", "aaab", 0);
        solver.runTest(4, "mississippi", "issi", 1);
        solver.runTest(5, "hello", "ll", 2);
        solver.runTest(6, "aaaaa", "bba", -1);
        solver.runTest(7, "pineapple", "apple", 4);
        solver.runTest(8, "ababababab", "bab", 1);
        solver.runTest(9, "bananasplit", "split", 6);
        solver.runTest(10, "abcd", "abcd", 0);

        System.out.println("=================================================");
        System.out.println("All Test Cases Executed — Results Above");
        System.out.println("=================================================");
    }
}