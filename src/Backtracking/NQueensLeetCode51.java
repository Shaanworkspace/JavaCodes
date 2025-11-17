package Backtracking;
import java.util.*;

/**
 * ===========================================================
 * 🧠 LeetCode 51 — N‑Queens
 * ===========================================================

 * The n‑queens puzzle is the problem of placing n queens on
 * an n*n chessboard such that no two queens attack each other.

 * Given an integer n, return all distinct solutions to the n‑queens puzzle.
 * You may return the answer in any order.

 * Each solution contains a distinct board configuration of the queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space, respectively.

 * -----------------------------------------------------------
 * Example 1:
 * Input:  n = 4
 * Output: [
 *   [".Q..","...Q","Q...","..Q."],
 *   ["..Q.","Q...","...Q",".Q.."]
 * ]

 * Example 2:
 * Input:  n = 1
 * Output: [["Q"]]

 * Constraints:
 * 1 <= n <= 9
 * -----------------------------------------------------------
 */

public class NQueensLeetCode51 {

    // ===========================================================
    // 🐢 Brute‑Force Approach (baseline)
    // ===========================================================
    public List<List<String>> solveNQueensBrute(int n) {
        char[][] arr = new char[n][n];
        List<List<String>> result = new ArrayList<>();
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                arr[i][j]='.';
            }
        }
        nQueenHelper(arr,0,result);
        return result;
    }

    private void nQueenHelper(char[][] arr, int row, List<List<String>> result) {
        int n =arr.length;
        if(row==n){
            List<String> st = new ArrayList<>();
            for (char[] chars : arr) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    str.append(chars[j]);
                }
                st.add(str.toString());
            }
            result.add(st);
            return;
        }

        for(int col =0;col<n;col++){
            if(isSafe(arr,row,col)){
                arr[row][col] = 'Q';
                nQueenHelper(arr,row+1,result);

                //backtrack
                arr[row][col]='.';
            }
        }
    }

    private boolean isSafe(char[][] arr, int row, int col) {
        int n = arr.length;

        //Up - Down
        for(int i =0;i<n;i++){
            if(arr[i][col] == 'Q' ) return false;
        }

        //right - left
        for(int i =0;i<n;i++){
            if(arr[row][i] == 'Q' ) return false;
        }

        //northEast
        int i =row,j=col;
        while(i>= 0 && j<n){
            if(arr[i][j] == 'Q' ) return false;
            i--;
            j++;
        }

        //East - South
        i =row;
        j=col;
        while(i <n && j<n){
            if(arr[i][j] == 'Q' ) return false;
            i++;
            j++;
        }

        //West-South
        i =row;
        j=col;
        while(i <n && j>=0){
            if(arr[i][j] == 'Q' ) return false;
            i++;
            j--;
        }

        //North - West
        i =row;
        j=col;
        while(i>=0 && j>=0){
            if(arr[i][j] == 'Q' ) return false;
            i--;
            j--;
        }
        return true;
    }



    // ===========================================================
    // ✍️ TryYourSelf Variant (for tracing / debug steps)
    // ===========================================================
    public List<List<String>> solveNQueensTryYourSelf(int n) {
        // TODO: Implement and print intermediate states for learning.
        return new ArrayList<>();  // demo placeholder
    }

    // ===========================================================
    // ⚡ Optimized Backtracking Approach — O(n!)
    // ===========================================================
    public List<List<String>> solveNQueens(int n) {

        return List.of();
    }



    // ===========================================================
    // 🧾 Test Runner — compares all methods and prints ✅ / ❌
    // ===========================================================
    private static void runTest(NQueensLeetCode51 solver,
                                int n, List<List<String>> expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input     : n = " + n);
        System.out.println("Expected  : " + expected);

        List<List<String>> brute = solver.solveNQueensBrute(n);
        List<List<String>> your  = solver.solveNQueensTryYourSelf(n);
        List<List<String>> opt   = solver.solveNQueens(n);

        System.out.printf("Brute Force      : %-70s %s%n",
                brute, brute.equals(expected) ? "✅" : "❌");
        System.out.printf("TryYourSelf      : %-70s %s%n",
                your,  your.equals(expected) ? "✅" : "❌");
        System.out.printf("Optimized (O(n!)) : %-70s %s%n",
                opt,   opt.equals(expected) ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        NQueensLeetCode51 solver = new NQueensLeetCode51();

        System.out.println("=================================================");
        System.out.println("👑  N‑Queens — Tests");
        System.out.println("=================================================\n");

        runTest(solver,
                4,
                Arrays.asList(
                        Arrays.asList(".Q..","...Q","Q...","..Q."),
                        Arrays.asList("..Q.","Q...","...Q",".Q..")
                ),
                "Test 1");

        runTest(solver,
                1,
                Arrays.asList(
                        Arrays.asList("Q")
                ),
                "Test 2");
    }
}