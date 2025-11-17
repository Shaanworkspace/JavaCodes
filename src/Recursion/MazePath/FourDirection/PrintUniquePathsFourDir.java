package Recursion.MazePath.FourDirection;

public class PrintUniquePathsFourDir {

    // ===========================================================
    // TODO: 🔧 Implement this method yourself.
    // It should print all paths from (row, col) to destination
    // in a 4‑direction grid (Right, Down, Left, Up)
    // without revisiting the same cell in one path.
    // ===========================================================
    public static void printAllPathsFourDir(int row, int col,
                                            int m, int n,
                                            String path,
                                            boolean[][] visited) {
        // Your implementation goes here 👇
    }

    // Optional "try‑yourself" placeholder if you want to test variations
    public static void printAllPathsTryYourself(int row, int col,
                                                int m, int n,
                                                String path,
                                                boolean[][] visited) {
        // Try writing your own logic here 👇
    }

    // ===========================================================
    // WRONG : But approach that should not be thought as linking from two direction
    // ===========================================================

    public static void printAllPathsLinkedFromTwoDirection(int row, int col, int m, int n, String path) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }
        if(row==m-1 && col==n-1){
            System.out.println(path);
            return;
        }
        // going Right
        printAllPathsLinkedFromTwoDirection(row,col+1,m,n,path+"R");

        // going Left
        printAllPathsLinkedFromTwoDirection(row,col-1,m,n,path+"L");

        // going Up
        printAllPathsLinkedFromTwoDirection(row-1,col,m,n,path+"U");

        // going Down
        printAllPathsLinkedFromTwoDirection(row+1,col,m,n,path+"D");


    }





    // ===========================================================
    // 🚀 Test Harness
    // ===========================================================
    public static void main(String[] args) {
        int m = 3, n = 3;
        printAllPathsLinkedFromTwoDirection(0,0,m,n,"");



//        boolean[][] visited1 = new boolean[m][n];
//        boolean[][] visited2 = new boolean[m][n];
//
//        System.out.println("=================================================");
//        System.out.println("🧭 PRINTING ALL UNIQUE PATHS — 4 Directions (R, D, L, U)");
//        System.out.println("Grid size   : " + m + " x " + n);
//        System.out.println("Start       : (0,0)");
//        System.out.println("Goal        : (" + (m - 1) + "," + (n - 1) + ")");
//        System.out.println("=================================================\n");
//
//        System.out.println("Reference Version Output (once you implement it):\n");
//        printAllPathsFourDir(0, 0, m, n, "", visited1);
//
//        System.out.println("-----------------------------------------------");
//        System.out.println("Try‑Yourself Version Output:\n");
//        printAllPathsTryYourself(0, 0, m, n, "", visited2);
//
//        System.out.println("===============================================");
//        System.out.println("🧩  Expected Behavior Hint:");
//        System.out.println("Paths can move in four directions (R, D, L, U)");
//        System.out.println("No cell should repeat in a single path.");
//        System.out.println("For a 3×3 grid, valid paths like:");
//        System.out.println("→ DDRRUL...");
//        System.out.println("→ DRRD...");
//        System.out.println("(Exact ordering depends on your recursion order.)");
//        System.out.println("===============================================");
    }
}