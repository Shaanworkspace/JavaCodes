package Recursion.MazePath.DeadMaze;

public class RatInADeadMazeFourDirection {

    public static void main(String[] args) {

        // ---------- TEST CASES ----------

        // Simple 2x2 open maze
        int[][] maze1 = {
                {1, 1},
                {1, 1}
        };
        runTest(maze1, "Test 1", 2);

        // Blocked destination
        int[][] maze2 = {
                {1, 1},
                {1, 0}
        };
        runTest(maze2, "Test 2", 0);

        // 3x3 maze with limited routes
        int[][] maze3 = {
                {1, 0, 0},
                {1, 1, 0},
                {0, 1, 1}
        };
        runTest(maze3, "Test 3", 1);

        // Maze with full open 3x3
        int[][] maze4 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        runTest(maze4, "Test 4", 12);

        // Larger 4x4 with certain blockages
        int[][] maze5 = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        runTest(maze5, "Test 5", 4);
    }

    // ---------- Helper for tests ----------
    private static void runTest(int[][] maze, String label, int expectedCount) {
        System.out.println("---- " + label + " ----");
        System.out.println("All possible paths:");
        boolean[][] visited = new boolean[maze.length][maze.length];
        printPaths(maze, 0, 0, "", visited, maze.length);

        System.out.println("=============================================================");
        printPathsOptimised(maze, 0, 0, "",  maze.length);

        visited = new boolean[maze.length][maze.length];
        int count = countPaths(maze, 0, 0, visited, maze.length);

        System.out.println("Total paths found: " + count + " (Expected: " + expectedCount + ")");
        System.out.println();
    }

    // ---------- 1. Print all paths ----------
    public static void printPaths(int[][] maze, int row, int col, String path, boolean[][] isVisited, int n) {

        if(row >= n || col >= n || row <0 || col <0 || maze[row][col] == 0){
            return;
        }
        if(isVisited[row][col]) return;

        if(row==n-1 && col ==n-1){
            System.out.println(path);
            return;
        }

        isVisited[row][col] = true;
        //right
        printPaths(maze,row,col+1,path+"R",isVisited,n);

        //down
        printPaths(maze,row+1,col,path+"D",isVisited,n);

        //left
        printPaths(maze,row,col-1,path+"L",isVisited,n);

        //UP
        printPaths(maze,row-1,col,path+"U",isVisited,n);

        // backtracking
        isVisited[row][col]=false;
    }


    /**
    --> Here we don't use extra space O(n*n)
     */
    public static void printPathsOptimised(int[][] maze, int row, int col, String path, int n) {

        if(row >= n || col >= n || row <0 || col <0 || maze[row][col] == 0){
            return;
        }

        //if(isVisited[row][col]) return; --> ye line check kr rhi h ki aagr ye value h to aage mat jao , jo ki humko change krnah
        if(maze[row][col]==-1) return;

        if(row==n-1 && col ==n-1){
            System.out.println(path);
            return;
        }

        // isVisited[row][col] = true; --> ye line thi ki jis index pe h usko mark kro true se , to humne apna naya bnaya -1 aab uska use krenge
        maze[row][col] = -1;

        //right
        printPathsOptimised(maze,row,col+1,path+"R",n);

        //down
        printPathsOptimised(maze,row+1,col,path+"D",n);

        //left
        printPathsOptimised(maze,row,col-1,path+"L",n);

        //UP
        printPathsOptimised(maze,row-1,col,path+"U",n);

        // backtracking
        maze[row][col]=1;
    }

    // ---------- 2. Count all possible paths ----------
    public static int countPaths(int[][] maze, int row, int col, boolean[][] visited, int n) {
        return row;
    }
}