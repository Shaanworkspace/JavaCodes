package Backtracking;

import java.util.*;

/**
 * ===========================================================
 * 🧭 LeetCode 79 — Word Search
 * ===========================================================
 * Given an m × n grid of characters board and a string word,
 * return true if word exists in the grid.

 * The word can be constructed from sequentially adjacent cells
 * (horizontal or vertical). The same cell may not be reused.

 * Constraints:
 *  1 ≤ m, n ≤ 6
 *  1 ≤ word.length ≤ 15
 * -----------------------------------------------------------
 * Follow‑up: search pruning for larger boards
 */

public class WordSearchLeetCode79 {

    // ===========================================================
    // Brute‑Force Approach (baseline)
    // ===========================================================
    public boolean existBrute(char[][] board, String word) {
        // TODO: implement simple DFS from every cell
        return false; // placeholder
    }

    // ===========================================================
    // TryYourSelf Variant (with tracing)
    // ===========================================================
    public boolean existTryYourSelf(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && search(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int row, int col, String word,int idx) {
        if (idx == word.length()) return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                board[row][col] == '$' || board[row][col] != word.charAt(idx)) {
            return false;
        }

        char ch = board[row][col];
        board[row][col] = '$';
        boolean found =
                        search(board, row + 1, col, word, idx + 1) ||
                        search(board, row - 1, col, word, idx + 1) ||
                        search(board, row, col + 1, word, idx + 1) ||
                        search(board, row, col - 1, word, idx + 1);

        board[row][col]=ch;
        return found;
    }

    // ===========================================================
    // Optimized Backtracking Approach — O(m × n × 4ˡ)
    // ===========================================================
    public boolean exist(char[][] board, String word) {
        // TODO: implement optimized method with search pruning
        return false; // placeholder
    }

    // ===========================================================
    // Test Runner — prints results
    // ===========================================================
    private static void runTest(WordSearchLeetCode79 solver,
                                char[][] board, String word,
                                boolean expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Word  : \"" + word + "\"");

        boolean brute = solver.existBrute(board,word);
        boolean your  = solver.existTryYourSelf(board,word);
        boolean opt   = solver.exist(board,word);

        System.out.printf("Expected            : %s%n", expected);
        System.out.printf("Brute‑Force         : %-6s%n", brute);
        System.out.printf("TryYourSelf         : %-6s%n", your);
        System.out.printf("Optimized (O(m·n·4^l)) : %-6s%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // PSVM — Dashboard
    // ===========================================================
    public static void main(String[] args) {
        WordSearchLeetCode79 solver = new WordSearchLeetCode79();

        System.out.println("=================================================");
        System.out.println("🧭  Word Search — Tests");
        System.out.println("=================================================\n");

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        runTest(solver, board, "ABCCED", true,  "Test 1");
        runTest(solver, board, "SEE",     true,  "Test 2");
        runTest(solver, board, "ABCB",    false, "Test 3");
    }
}