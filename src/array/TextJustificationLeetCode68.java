package array;

import java.util.*;

public class TextJustificationLeetCode68 {

    // ===========================================================
    // Optimized O(n) Greedy solution (to be implemented)
    // ===========================================================
    public List<String> fullJustify(String[] words, int maxWidth) {
        // TODO: Implement optimized logic
        // Hint:
        // 1. Pack as many words as possible into each line (greedy).
        // 2. Compute remaining spaces to fill exactly maxWidth.
        // 3. Distribute extra spaces evenly between words.
        // 4. Last line => left‑justified.
        return new ArrayList<>(); // placeholder
    }

    // ===========================================================
    // Brute / stepwise simulator (for learning clarity)
    // ===========================================================
    public List<String> fullJustifyBrute(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int j = i, lineLength = 0;

            // Collect words that fit the line
            while (j < words.length && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            int EndValeSpaces = maxWidth - lineLength;
            int wordCount = j - i;
            StringBuilder line = new StringBuilder();


            // aab string banaynge
            if (j == words.length || wordCount == 1) {
                // Last line or single word => left‑justify
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < maxWidth) line.append(" ");
            } else {
                // Middle line => distribute extra EndValeSpaces evenly
                int NoOfSpaceBetweenWord = EndValeSpaces / (wordCount - 1);
                int extraToAddInMiddleSpaces = EndValeSpaces % (wordCount - 1); //ye ek hi do hoga

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    // we don't add spaces after the last word of the line
                    if (k < j - 1) {
                        int spaceToAdd = NoOfSpaceBetweenWord;

                        // add one extra space to leftmost gaps while extras remain
                        if (extraToAddInMiddleSpaces > 0) {
                            spaceToAdd += 1;
                            extraToAddInMiddleSpaces--;
                        }

                        line.append(" ".repeat(spaceToAdd));
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }
        return result;
    }

    // ===========================================================
    // Helper: easy comparison of results with ✅ / ❌
    // ===========================================================
    private void runTest(int testNo, String[] words, int maxWidth, List<String> expected) {
        System.out.println();
        System.out.println("🟦 Test #" + testNo);
        System.out.println("──────────────────────────────────────────────");
        System.out.println("Words     : " + Arrays.toString(words));
        System.out.println("Max Width : " + maxWidth);
        System.out.println("Expected  : " + expected);
        System.out.println("----------------------------------------------");

        List<String> brute = fullJustifyBrute(words, maxWidth);
        List<String> opt = fullJustify(words, maxWidth);

        boolean bruteOK = brute.equals(expected);
        boolean optOK = opt.equals(expected);

        System.out.printf("Brute Result : %s %s%n", brute, bruteOK ? "✅" : "❌");
        System.out.printf("Optimized    : %s %s%n", opt, optOK ? "✅" : "❌");
        System.out.println("──────────────────────────────────────────────\n");
    }

    // ===========================================================
    // PSVM — your signature clear dashboard 🧾
    // ===========================================================
    public static void main(String[] args) {
        TextJustificationLeetCode68 solver = new TextJustificationLeetCode68();

        System.out.println("=================================================");
        System.out.println("📘  Text Justification — Test Suite");
        System.out.println("=================================================\n");

        solver.runTest(
                1,
                new String[]{"This", "is", "an", "example", "of", "text", "justification."},
                16,
                Arrays.asList(
                        "This    is    an",
                        "example  of text",
                        "justification.  ")
        );

        solver.runTest(
                2,
                new String[]{"What","must","be","acknowledgment","shall","be"},
                16,
                Arrays.asList(
                        "What   must   be",
                        "acknowledgment  ",
                        "shall be        ")
        );

        solver.runTest(
                3,
                new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"},
                20,
                Arrays.asList(
                        "Science  is  what we",
                        "understand      well",
                        "enough to explain to",
                        "a  computer.  Art is",
                        "everything  else  we",
                        "do                  ")
        );
    }
}