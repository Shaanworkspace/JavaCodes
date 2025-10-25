package Strings.Romans;

public class IntegerToRomanLeetCode12 {

    // ===========================================================
    // Optimized O(1) approach (since 3999 max)
    // ===========================================================
    private static final int[] VALUES = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
    };

    private static final String[] SYMBOLS = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
    };

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < VALUES.length && num > 0; i++) {
            int quotient = num / VALUES[i];
            num %= VALUES[i];
            while (quotient-- > 0) {
                roman.append(SYMBOLS[i]);
            }
        }
        return roman.toString();
    }

    // ===========================================================
    // Brute step‑by‑step version (practise logic clarity)
    // ===========================================================
    public String intToRomanBrute(int num) {
        // Step 1: define all value-symbol pairs, include subtraction cases too
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


        // Step 2: StringBuilder for efficient concatenation
        StringBuilder result = new StringBuilder();

        // Step 3: go through all symbol-value pairs
        for(int i =0;i<values.length;i++){
            // For each symbol, append while num >= value
            while(num >= values[i]){
                result.append(symbols[i]);
                num-=values[i];
            }
        }
        // Step 4: done
        return result.toString();
    }

    // ===========================================================
    // Simple tester utility for clean dashboard
    // ===========================================================
    private void runTest(int testNo, int num, String expected) {
        System.out.println("🔹 Test " + testNo);
        System.out.println("------------------------------------");
        System.out.println("Input Number : " + num);
        System.out.println("Expected     : " + expected);

        String brute = intToRomanBrute(num);
        String opt = intToRoman(num);

        System.out.println("Brute Result : " + brute);
        System.out.println("Optimized    : " + opt);
        System.out.println();
    }

    // ===========================================================
    // PSVM for formatted IntelliJ console output
    // ===========================================================
    public static void main(String[] args) {
        IntegerToRomanLeetCode12 solver = new IntegerToRomanLeetCode12();

        System.out.println("====================================");
        System.out.println("          Integer → Roman Tests");
        System.out.println("====================================\n");

        solver.runTest(1, 3749, "MMMDCCXLIX");
        solver.runTest(2, 58, "LVIII");
        solver.runTest(3, 1994, "MCMXCIV");
        solver.runTest(4, 9, "IX");
        solver.runTest(5, 40, "XL");

        System.out.println("====================================");
        System.out.println("        ✅  All Tests Executed");
        System.out.println("====================================");
    }
}