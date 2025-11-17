package Recursion.MazePath.TwoDirection;

public class NumberOfUniquePathsZeroBased {

    // Recursive function that explores from a given cell (row, col) to bottom-right
    public static int uniquePaths(int row, int col, int m, int n) {

        // Base case 1: If row or col moves *outside* the grid boundaries → invalid path
        if (row >= m || col >= n) {
            return 0;
        }

        // Base case 2: If we're already standing on the *bottom-right cell*
        // That’s a valid complete path → count it as 1
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        // Recursive exploration:
        // Move 1 step right  → uniquePaths(row, col + 1)
        // Move 1 step down  → uniquePaths(row + 1, col)
        int rightMove = uniquePaths(row, col + 1, m, n);
        int downMove = uniquePaths(row + 1, col, m, n);

        // Total paths from current cell = paths from right + paths from down
        return rightMove + downMove;
    }

    public static void main(String[] args) {
        int m = 3, n = 3;  // grid dimensions: 3 rows × 3 columns

        System.out.println("===============================================");
        System.out.println("UNIQUE PATHS USING 0-BASED RECURSION EXPLORATION");
        System.out.println("Grid size: " + m + " x " + n);
        System.out.println("Start: (0,0) → Goal: (" + (m - 1) + "," + (n - 1) + ")");
        System.out.println("Only moves allowed: → (Right) and ↓ (Down)");
        System.out.println("===============================================\n");

        int totalPaths = uniquePaths(0, 0, m, n);

        System.out.println("-----------------------------------------------");
        System.out.println("Total UNIQUE PATHS from (0,0) to (" + (m - 1) + "," + (n - 1) + "): " + totalPaths);
        System.out.println("===============================================");
    }
}