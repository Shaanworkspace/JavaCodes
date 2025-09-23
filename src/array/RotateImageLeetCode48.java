package array;

public class RotateImageLeetCode48 {

    public void rotate(int[][] arr) {
        int n  = arr.length;
        //for 90 degree -> first transpose then for Clock wise -> reverse rows
        // if 90 counter-clockwise then first transpose then reverse columns

        //transpose
        for(int i =0;i<n;i++){
            for(int j =i+1;j<n;j++){
                //swap
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //now for clockwise -> reverse each ROW
        for(int i =0;i<n;i++){
            for(int j =0;j<n/2;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][n-j-1];
                arr[i][n-j-1] = temp;
            }
        }
    }
    public void rotateBrute(int[][] arr) {
        int n = arr.length;
        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[j][n - 1 - i] = arr[i][j]; // use the mapping rule
            }
        }

        // copy back into original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = copy[i][j];
            }
        }
    }

    // Helper method to print a 2D matrix
    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println(); // move to next row
        }
        System.out.println(); // blank line for readability
    }

    // A simple test runner
    public static void main(String[] args) {
        RotateImageLeetCode48 solution = new RotateImageLeetCode48();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        solution.printMatrix(matrix);

        solution.rotate(matrix); // will do nothing for now

        System.out.println("After Rotation:");
        solution.printMatrix(matrix);
    }
}
