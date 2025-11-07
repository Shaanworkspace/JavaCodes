package Strings.SubString;

import java.util.*;

public class SubstringWithConcatenationOfAllWordsLeetCode30 {

    // ===========================================================
    // 🐢 Brute‑Force Approach (baseline)
    // ===========================================================
    public List<Integer> findSubstringBrute(String s, String[] words) {
        /*
        I was thinking to store all the permutation formed by the words but if i'll generate all the permutation it will generate factorial time complexity
        --> Now there is another way, so that we don't need to generate the permutation
         */

        List<Integer> result = new ArrayList<>();
        if (s.isEmpty() || words.length == 0) return result;

        int lengthOfPerWord=words[0].length(),totalWord = words.length;
        int lengthOfWord = lengthOfPerWord*totalWord;

        HashMap<String, Integer > target = new HashMap<>();
        for(String word : words)
            target.put(word,target.getOrDefault(word,0)+1);

        for(int i =0;i<=s.length()-lengthOfWord;i++){
            HashMap<String, Integer > seen = new HashMap<>();

            int j =0;
            while(j<totalWord){
                int start = i+ j*lengthOfPerWord;

                String sub = s.substring(start,start+lengthOfPerWord);
                if(!target.containsKey(sub)){
                    break;
                }
                seen.put(sub,seen.getOrDefault(sub,0)+1);
                if(seen.get(sub) > target.get(sub))
                    break;
                j++;
            }
            if(j==totalWord){
                result.add(i);
            }
        }
        return result;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (for step‑by‑step experiments)
    // ===========================================================
    public List<Integer> findSubstringTryYourSelf(String s, String[] words) {
        // TODO: implement your own traced version
        return new ArrayList<>(); // demo placeholder
    }

    // ===========================================================
    // ⚡ Optimized Approach – Sliding Window + HashMap
    // ===========================================================
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.isEmpty() || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) return result;

        Map<String, Integer> target = new HashMap<>();
        for (String w : words)
            target.put(w, target.getOrDefault(w, 0) + 1);

        // offset windows: starting at each possible wordLen shift
        for (int offset = 0; offset < wordLen; offset++) {
            Map<String, Integer> window = new HashMap<>();
            int left = offset, matched = 0;

            // move right by wordLen steps
            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (!target.containsKey(word)) {
                    // reset window
                    window.clear();
                    matched = 0;
                    left = right + wordLen;
                    continue;
                }

                // add this word
                window.put(word, window.getOrDefault(word, 0) + 1);
                matched++;

                // if too many of this word, shrink from left
                while (window.get(word) > target.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLen;
                    matched--;
                }

                // valid window?
                if (matched == wordCount) {
                    result.add(left);
                    // shrink by one word to look for next window
                    String leftWord = s.substring(left, left + wordLen);
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLen;
                    matched--;
                }
            }
        }
        return result;
    }

    // ===========================================================
    // 🧾 Test Runner — compares all versions and prints ✅ / ❌
    // ===========================================================
    private static void runTest(SubstringWithConcatenationOfAllWordsLeetCode30 solver,
                                String s, String[] words, List<Integer> expected, String testName) {

        System.out.println("🔹 " + testName);
        System.out.println("Input String : \"" + s + "\"");
        System.out.println("Words        : " + Arrays.toString(words));
        System.out.println("Expected     : " + expected);

        List<Integer> brute = solver.findSubstringBrute(s, words);
        List<Integer> your  = solver.findSubstringTryYourSelf(s, words);
        List<Integer> opt   = solver.findSubstring(s, words);

        System.out.printf("Brute Force        : %-20s %s%n", brute, brute.equals(expected) ? "✅" : "❌");
        System.out.printf("TryYourSelf        : %-20s %s%n", your,  your.equals(expected) ? "✅" : "❌");
        System.out.printf("Optimized (O(n))   : %-20s %s%n", opt,   opt.equals(expected) ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWordsLeetCode30 solver =
                new SubstringWithConcatenationOfAllWordsLeetCode30();

        System.out.println("=================================================");
        System.out.println("🧩  Substring with Concatenation of All Words");
        System.out.println("=================================================\n");

        runTest(solver,
                "barfoothefoobarman",
                new String[]{"foo", "bar"},
                Arrays.asList(0, 9),
                "Test 1");

        runTest(solver,
                "wordgoodgoodgoodbestword",
                new String[]{"word", "good", "best", "word"},
                Collections.emptyList(),
                "Test 2");

        runTest(solver,
                "barfoofoobarthefoobarman",
                new String[]{"bar", "foo", "the"},
                Arrays.asList(6, 9, 12),
                "Test 3");
    }
}