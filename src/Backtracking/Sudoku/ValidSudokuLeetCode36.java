package Backtracking.Sudoku;

import java.util.*;

/**
 * ===========================================================
 * 🧩 LeetCode 36 — Valid Sudoku
 * ===========================================================
 *
 * Determine if a 9 × 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the rules:
 *
 *  • Each row contains digits 1–9 without repetition.
 *  • Each column contains digits 1–9 without repetition.
 *  • Each 3 × 3 sub‑box contains digits 1–9 without repetition.
 *
 * Note:
 *  - The board could be valid even if it’s not solvable.
 *  - Empty cells are represented by '.'.
 *
 * -----------------------------------------------------------
 * Example 1:
 * Input:
 * board = [
 *  ["5","3",".",".","7",".",".",".","."],
 *  ["6",".",".","1","9","5",".",".","."],
 *  [".","9","8",".",".",".",".","6","."],
 *  ["8",".",".",".","6",".",".",".","3"],
 *  ["4",".",".","8",".","3",".",".","1"],
 *  ["7",".",".",".","2",".",".",".","6"],
 *  [".","6",".",".",".",".","2","8","."],
 *  [".",".",".","4","1","9",".",".","5"],
 *  [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 *
 * Example 2:
 * Input: (same board, but top‑left 5→8)
 * Output: false
 * Explanation: two 8’s in the same 3×3 box.
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • board.length == 9
 *  • board[i].length == 9
 *  • board[i][j] is '1'–'9' or '.'
 * -----------------------------------------------------------
 */

public class ValidSudokuLeetCode36 {

    // ===========================================================
    // Brute‑Force Approach (quadratic scanning)
    // ===========================================================
    public boolean isValidSudokuBrute(char[][] board) {
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                char ch = board[i][j];
                if(ch ==  '.') continue; //pahle se hi khali hai
                board[i][j] = '.';
                if(!isSafe(board,i,j,ch)) return false;
                board[i][j] = ch;
            }
        }
        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, char ch) {

        //check in row of 9x9
        for(int i =0;i<col;i++){
            if(board[row][i] == ch ) return false;
        }

        //check in col of 9x9
        for(int i =0;i<row;i++){
            if(board[i][col] == ch ) return false;
        }

        // 3x3 matrix
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;

        for(int i = startRow;i<startRow+3;i++){
            for(int j = startCol;j<startCol+3;j++){
                if(board[i][j] == ch ) return false;
            }
        }
        return  true;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (for tracing / studying behavior)
    // ===========================================================
    public boolean isValidSudokuTryYourSelf(char[][] board) {
        // TODO: insert printed diagnostics for duplicate detection
        return false; // demo placeholder
    }

    // ===========================================================
    // ⚡ Optimized O(9²) Solution
    // ===========================================================
    public boolean isValidSudoku(char[][] board) {

        return false;
    }

    // ===========================================================
    // 🧾 Test Runner — prints results ✅ / ❌
    // ===========================================================
    private static void runTest(ValidSudokuLeetCode36 solver,
                                char[][] board, boolean expected, String testName) {
        System.out.println("🔹 " + testName);
        for (char[] row : board) System.out.println(Arrays.toString(row));

        boolean brute = solver.isValidSudokuBrute(copy(board));
        boolean your  = solver.isValidSudokuTryYourSelf(copy(board));
        boolean opt   = solver.isValidSudoku(copy(board));

        System.out.printf("Expected  : %s%n", expected);
        System.out.printf("Brute Force      : %-6s %s%n", brute, brute == expected ? "✅" : "❌");
        System.out.printf("TryYourSelf      : %-6s %s%n", your,  your == expected ? "✅" : "❌");
        System.out.printf("Optimized (O(81)) : %-6s %s%n", opt,   opt == expected ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    private static char[][] copy(char[][] src) {
        char[][] dest = new char[src.length][src[0].length];
        for (int i = 0; i < src.length; i++)
            dest[i] = Arrays.copyOf(src[i], src[i].length);
        return dest;
    }

    // ===========================================================
    // 🚀 PSVM — Dashboard / Demo
    // ===========================================================
    public static void main(String[] args) {
        ValidSudokuLeetCode36 solver = new ValidSudokuLeetCode36();

        System.out.println("=================================================");
        System.out.println("🧮  Valid Sudoku — Tests");
        System.out.println("=================================================\n");

        char[][] board1 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] board2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        runTest(solver, board1, true,  "Test 1 — Valid Board");
        runTest(solver, board2, false, "Test 2 — Invalid Board");
    }
}