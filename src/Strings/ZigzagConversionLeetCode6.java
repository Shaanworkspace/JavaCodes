package Strings;

public class ZigzagConversionLeetCode6 {

    // ===========================================================
    // Optimized O(n) approach
    // ===========================================================
    public String convert(String s, int numRows) {
        if(s.length()==1 || numRows == 1) return s;
        StringBuilder res = new StringBuilder();

        int increment = (numRows-1)*2;
        for(int rowNo = 0 ; rowNo<numRows ;rowNo++){
            for(int i =rowNo ;i<s.length();i+=increment){
                res.append(s.charAt(i));


                //vo jo middle vale h unko bhi add krta chalega
                if(rowNo>0 && rowNo<numRows-1){
                    int diagonal = increment - 2*rowNo;
                    int diagonalFromThisIndex = diagonal + i;
                    if(diagonalFromThisIndex<s.length()){
                        res.append(s.charAt(diagonalFromThisIndex));
                    }
                }
            }
        }
        return res.toString();
    }

    // ===========================================================
    // Brute / simulation approach (conceptual clarity)
    // ===========================================================
    public String convertBrute(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        int index = 0;             // position in string
        int n = s.length();

        while (index < n) {
            // Move straight down
            for (int i = 0; i < numRows && index < n; i++) {
                rows[i].append(s.charAt(index++));
            }
            // Move diagonally up
            for (int i = numRows - 2; i >= 1 && index < n; i--) {
                rows[i].append(s.charAt(index++));
            }
        }
        // Combine all rows
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) ans.append(row);
        return ans.toString();
    }

    // ===========================================================
    // Helper to display formatted results
    // ===========================================================
    private void runTest(int testNo, String s, int numRows, String expected) {
        System.out.println("🔹 Test " + testNo);
        System.out.println("------------------------------------");
        System.out.println("Input String : \"" + s + "\"");
        System.out.println("Number of Rows : " + numRows);
        System.out.println("Expected     : \"" + expected + "\"");

        String brute = convertBrute(s, numRows);
        String opt = convert(s, numRows);

        System.out.println("Brute Result : \"" + brute + "\"");
        System.out.println("Optimized    : \"" + opt + "\"");
        System.out.println();
    }

    // ===========================================================
    // Main with neatly formatted dashboard output 🧾
    // ===========================================================
    public static void main(String[] args) {
        ZigzagConversionLeetCode6 solver = new ZigzagConversionLeetCode6();

        System.out.println("====================================");
        System.out.println("        Zigzag Conversion Tests");
        System.out.println("====================================\n");

        solver.runTest(1, "PAYPALISHIRING", 3, "PAHNAPLSIIGYIR");
        solver.runTest(2, "PAYPALISHIRING", 4, "PINALSIGYAHRPI");
        solver.runTest(3, "A", 1, "A");
        solver.runTest(4, "AB", 1, "AB");
        solver.runTest(5, "ABCDE", 2, "ACEBD");

        System.out.println("====================================");
        System.out.println("        ✅  All Tests Executed");
        System.out.println("====================================");
    }
}