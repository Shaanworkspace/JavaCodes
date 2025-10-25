package Strings.Romans;

import java.util.*;

public class RomanToIntegerLeetCode13 {

    /*
    // ======================================================================================================================
    // My Code failed at --> { IX -> '9' }  it fails as it converted this to '11'
    // My approach is like to store all conversion in a map then travers the string and check its value from map and sum it then return the sum
    // Mistake : I was not known --> Example : IX as 'I' can come before X, so we have to subtract 'I' value from 'X'
    // ======================================================================================================================

    public int romanToIntBrute(String s) {
        HashMap<Character,Integer> charToIntMap = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        StringBuilder str = new StringBuilder(s);

        int sum=0;
        for(int i = 0 ;i<str.length();i++){
            sum +=charToIntMap.get(str.charAt(i));
        }

        return sum;
    }

     */

    // ===========================================================
    // Optimized O(n) approach (simple linear scan)
    // ===========================================================
    private static final Map<Character, Integer> ROMAN_MAP = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );
    public int romanToInt(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int currVal = ROMAN_MAP.get(s.charAt(i));
            if (i < s.length() - 1 && currVal < ROMAN_MAP.get(s.charAt(i + 1))) {
                total -= currVal;
            } else {
                total += currVal;
            }
        }
        return total;
    }




    // ===========================================================
    // Brute -->  ACTUALLY THIS IS BEST -- it’s already O(n) with O(1) extra space — the best possible theoretical complexity for this task.
    // ===========================================================
    public int romanToIntBrute(String s) {
        HashMap<Character,Integer> charToIntMap = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        StringBuilder str = new StringBuilder(s);

        int sum=0,n=str.length();
        for(int i = 0 ;i<n;i++){
            int currValue = charToIntMap.get(s.charAt(i));

            if(i+1<n){
                int nextValue = charToIntMap.get(s.charAt(i + 1));
                if(currValue<nextValue){
                    sum-=currValue;
                } else {
                    sum+=currValue;
                }
            } else {
                sum+=currValue;
            }
        }

        return sum;
    }

    // ===========================================================
    // Helper for running tests & pretty output
    // ===========================================================
    private void runTest(int testNo, String roman, int expected) {
        System.out.println("🔹 Test " + testNo);
        System.out.println("------------------------------------");
        System.out.println("Roman Input : " + roman);
        System.out.println("Expected    : " + expected);

        int brute = romanToIntBrute(roman);
        int opt = romanToInt(roman);

        System.out.println("Brute Result: " + brute);
        System.out.println("Optimized   : " + opt);
        System.out.println();
    }

    // ===========================================================
    // PSVM with formatted dashboard 🧾
    // ===========================================================
    public static void main(String[] args) {
        RomanToIntegerLeetCode13 solver = new RomanToIntegerLeetCode13();

        System.out.println("====================================");
        System.out.println("         Roman To Integer Tests");
        System.out.println("====================================\n");

        solver.runTest(1, "III", 3);
        solver.runTest(2, "LVIII", 58);
        solver.runTest(3, "MCMXCIV", 1994);
        solver.runTest(4, "XL", 40);
        solver.runTest(5, "IX", 9);

        System.out.println("====================================");
        System.out.println("        ✅  All Tests Executed");
        System.out.println("====================================");
    }
}