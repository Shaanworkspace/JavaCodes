package Recursion.MazePath;

public class PrintUniquePathsZeroBased {

    // Recursive function that prints all paths from (row,col) to destination
    public static void printAllPaths(int row, int col, int m, int n, String path) {

        // Base case 1: stepped outside grid → invalid path
        if (row >= m || col >= n) {
            return;
        }

        // Base case 2: reached destination → print the completed path
        if (row == m - 1 && col == n - 1) {
            System.out.println(path);
            return;
        }

        // Move right → append 'R' to current path
        printAllPaths(row, col + 1, m, n, path + "R");

        // Move down → append 'D' to current path
        printAllPaths(row + 1, col, m, n, path + "D");
    }


    // 🧩 Try‑yourself version to compare or practice writing
    public static void printAllPathsTryYourself(int row, int col, int m, int n, String path) {

        if (row >= m || col >= n) {
            return;
        }

        if (row == m - 1 && col == n - 1) {
            System.out.println(path);
            return;
        }

        // You can try swapping orders to see how path order changes
        printAllPathsTryYourself(row, col + 1, m, n, path + "R");
        printAllPathsTryYourself(row + 1, col, m, n, path + "D");
    }


    public static void main(String[] args) {
        int m = 3, n = 3;

        System.out.println("===============================================");
        System.out.println("🧭 PRINTING ALL UNIQUE PATHS (R = Right, D = Down)");
        System.out.println("Grid size : " + m + " x " + n);
        System.out.println("Start: (0,0) → Goal: (" + (m - 1) + "," + (n - 1) + ")");
        System.out.println("===============================================");
        System.out.println("All possible paths:\n");

        // Run the reference version
        printAllPaths(0, 0, m, n, "");

        System.out.println("-----------------------------------------------");
        System.out.println("Try‑Yourself version output:\n");

        // Run your version to verify same results
        printAllPathsTryYourself(0, 0, m, n, "");

        System.out.println("===============================================");
    }
}