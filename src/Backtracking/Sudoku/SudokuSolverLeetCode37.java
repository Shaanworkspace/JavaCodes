package Backtracking.Sudoku;
import java.util.*;

/**
 * ===========================================================
 * 🧮 LeetCode 37 — Sudoku Solver
 * ===========================================================
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A valid sudoku solution must satisfy the following:
 *   • Each digit 1‑9 occurs exactly once in each row.
 *   • Each digit 1‑9 occurs exactly once in each column.
 *   • Each digit 1‑9 occurs exactly once in each 3 × 3 sub‑box.
 *
 * The '.' character indicates empty cells.
 *
 * -----------------------------------------------------------
 * Example 1:
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
 *
 * Output: [
 *  ["5","3","4","6","7","8","9","1","2"],
 *  ["6","7","2","1","9","5","3","4","8"],
 *  ["1","9","8","3","4","2","5","6","7"],
 *  ["8","5","9","7","6","1","4","2","3"],
 *  ["4","2","6","8","5","3","7","9","1"],
 *  ["7","1","3","9","2","4","8","5","6"],
 *  ["9","6","1","5","3","7","2","8","4"],
 *  ["2","8","7","4","1","9","6","3","5"],
 *  ["3","4","5","2","8","6","1","7","9"]
 * ]
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • board.length == 9
 *  • board[i].length == 9
 *  • board[i][j] is '1'–'9' or '.'
 *  • There is exactly one valid solution.
 * -----------------------------------------------------------
 */

public class SudokuSolverLeetCode37 {

    // ===========================================================
    // Brute‑Force Approach (try all boards)
    // ===========================================================
    public void solveSudokuBrute(char[][] board) {
        char[][] grid = new char[9][9];
        boolean s = solver(board,0,0,grid);
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                board[i][j] = grid[i][j];
            }
        }
    }

    private boolean solver(char[][] board, int row, int col, char[][] grid) {
        if(row==9){
            for(int i =0;i<9;i++){
                for(int j =0;j<9;j++){
                   grid[i][j] = board[i][j];
                }
            }
            return true;
        }
        else if(board[row][col] != '.'){
            //call next
            if(col != 8){
                return solver(board,row,col+1,grid);
            } else{
                return solver(board,row+1,0,grid);
            }
        } else{
            for(char c = '1';c<='9';c++){
                if(isSafe(board,row,col,c)){
                    board[row][col]=c;
                    boolean solved;
                    if (col != 8)
                        solved = solver(board, row, col + 1, grid);
                    else
                        solved = solver(board, row + 1, 0, grid);

                    if (solved) return true;
                    board[row][col]='.';
                }
            }
        }
        return false;
    }
    private boolean isSafe(char[][] board, int row, int col, char ch) {

        //check in row of 9x9
        for(int i =0;i<9;i++){
            if(board[row][i] == ch ) return false;
        }

        //check in col of 9x9
        for(int i =0;i<9;i++){
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
    // ✍️ TryYourSelf Variant (with printed tracing)
    // ===========================================================
    public void solveSudokuTryYourSelf(char[][] board) {
        // TODO: Implement step‑by‑step, printing placements and backtracks.
    }

    // ===========================================================
    // ⚡ Optimized Backtracking O(9!)
    // ===========================================================
    public void solveSudoku(char[][] board) {

    }


    // ===========================================================
    // 🧾 Test Runner — prints before/after boards
    // ===========================================================
    private static void runTest(SudokuSolverLeetCode37 solver,
                                char[][] board, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input Board:");
        printBoard(board);

        char[][] brute = copy(board);
        char[][] your  = copy(board);
        char[][] opt   = copy(board);

        solver.solveSudokuBrute(brute);
        solver.solveSudokuTryYourSelf(your);
        solver.solveSudoku(opt);

        System.out.println("Brute Force Result:");
        printBoard(brute);
        System.out.println("TryYourSelf Result:");
        printBoard(your);
        System.out.println("Optimized Result:");
        printBoard(opt);
        System.out.println("--------------------------------------------\n");
    }

    private static char[][] copy(char[][] src) {
        char[][] dest = new char[9][9];
        for (int i = 0; i < 9; i++)
            dest[i] = Arrays.copyOf(src[i], src[i].length);
        return dest;
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board)
            System.out.println(Arrays.toString(row));
        System.out.println();
    }

    // ===========================================================
    // 🚀 PSVM — Testing Dashboard
    // ===========================================================
    public static void main(String[] args) {
        SudokuSolverLeetCode37 solver = new SudokuSolverLeetCode37();

        System.out.println("=================================================");
        System.out.println("🧮  Sudoku Solver — Tests");
        System.out.println("=================================================\n");

        char[][] board = {
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

        runTest(solver, board, "Test 1 — Standard 9×9 Puzzle");
    }
}