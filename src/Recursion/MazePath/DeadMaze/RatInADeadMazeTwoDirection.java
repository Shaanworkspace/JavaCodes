package Recursion.MazePath.DeadMaze;

public class RatInADeadMazeTwoDirection {

    public static void main(String[] args) {

        // ---------- TEST CASES ----------

        // Simple 2x2 open maze (both paths DR and RD are valid)
        int[][] maze1 = {
                {1, 1},
                {1, 1}
        };
        runTest(maze1, "Test 1", 2);

        // Blocked destination (no path)
        int[][] maze2 = {
                {1, 1},
                {1, 0}
        };
        runTest(maze2, "Test 2", 0);

        // 3x3 partial block (only one valid winding path)
        int[][] maze3 = {
                {1, 0, 0},
                {1, 1, 0},
                {0, 1, 1}
        };
        runTest(maze3, "Test 3", 1);

        // Fully blocked middle layer
        int[][] maze4 = {
                {1, 1, 0},
                {0, 0, 0},
                {1, 1, 1}
        };
        runTest(maze4, "Test 4", 0);

        // Larger 4x4 maze with many routes
        int[][] maze5 = {
                {1, 1, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 1}
        };
        runTest(maze5, "Test 5", 4);
    }

    // ---------- Helper Test Function ----------
    private static void runTest(int[][] maze, String label, int expectedCount) {
        System.out.println("---- " + label + " ----");
        System.out.println("All paths:");
        printPaths(maze, 0, 0, "", maze.length);
        int count = countPaths(maze, 0, 0, maze.length);
        System.out.println("Total paths found: " + count + " (Expected: " + expectedCount + ")");
        System.out.println();
    }

    // ---------- Method 1: Print All Paths (Right, Down) ----------
    public static void printPaths(int[][] maze, int row, int col, String path, int n) {

        if(row >= n || col >= n || maze[row][col] == 0){
            return;
        }
        if(row==n-1 && col ==n-1){
            System.out.println(path);
            return;
        }

        //right
        printPaths(maze,row,col+1,path+"R",n);

        //down
        printPaths(maze,row+1,col,path+"D",n);
    }

    // ---------- Method 2: Count All Paths (Right, Down) ----------
    public static int countPaths(int[][] maze, int row, int col, int n) {
        return row;
    }
}
