package Strings;

public class LengthOfLastWordLeetCode58 {

    // ===========================================================
    // Optimized O(n) solution — single backward pass
    // ===========================================================
    public int lengthOfLastWord(String s) {

        int count =0,n=s.length();
        boolean isFirstSpaces= true;

        for(int i =n-1;i>=0;i--){
            if(s.charAt(i)==' ' && !isFirstSpaces){
                break;
            }
            if (s.charAt(i) !=' ') {
                isFirstSpaces=false;
                count++;
            }
        }
    return count;
    }

    // ===========================================================
    // Brute / direct manual parsing approach
    // ===========================================================
    public int lengthOfLastWordBrute(String s) {
        if (s == null || s.isEmpty()) return 0;

        // Trim trailing spaces (for clarity)
        s = s.replaceAll("\\s+$", "");
        int length = 0;

        for (char c : s.toCharArray()) {
            if (c != ' ') {
                length++;
            } else {
                length = 0;
            }
        }
        return length;
    }

    // ===========================================================
    // Helper for formatted dashboard output
    // ===========================================================
    private void runTest(int testNo, String input, int expected) {
        System.out.println("🔹 Test " + testNo);
        System.out.println("------------------------------------");
        System.out.println("Input String : \"" + input + "\"");
        System.out.println("Expected     : " + expected);

        int brute = lengthOfLastWordBrute(input);
        int opt = lengthOfLastWord(input);

        System.out.println("Brute Result : " + brute);
        System.out.println("Optimized    : " + opt);
        System.out.println();
    }

    // ===========================================================
    // PSVM — clean IntelliJ console dashboard 🧾
    // ===========================================================
    public static void main(String[] args) {
        LengthOfLastWordLeetCode58 solver = new LengthOfLastWordLeetCode58();

        System.out.println("====================================");
        System.out.println("        Length of Last Word Tests");
        System.out.println("====================================\n");

        solver.runTest(1, "Hello World", 5);
        solver.runTest(2, "   fly me   to   the moon  ", 4);
        solver.runTest(3, "luffy is still joyboy", 6);
        solver.runTest(4, "a", 1);
        solver.runTest(5, "   ", 0);

        System.out.println("====================================");
        System.out.println("        ✅  All Tests Executed");
        System.out.println("====================================");
    }
}