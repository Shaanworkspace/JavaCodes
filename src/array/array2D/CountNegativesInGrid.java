package array.array2D;
public class CountNegativesInGrid {

    public static void main(String[] args) {
        // Define the 2D grid
        int[][] grid = {
            {10,  5,  2, -1},
            { 7,  3, -1, -2},
            { 4,  2, -2, -3},
            { 1, -1, -3, -4}
        };

        // Call the function to count negatives
        int negativeCount = countNegatives(grid);
        // Print the result
        System.out.println("Number of negative numbers in the grid: " + negativeCount);
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] < 0) {
                    count += (cols - j);
                    break;
                }
            }
        }
        return count;
    }
}