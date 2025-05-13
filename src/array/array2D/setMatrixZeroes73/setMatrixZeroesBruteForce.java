package array.array2D.setMatrixZeroes73;

import java.util.HashSet;
import java.util.Set;

public class setMatrixZeroesBruteForce {
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        System.out.println(rows+" "+columns);

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        // Step 1: Find all rows and columns that should be zeroed
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        // Step 2: Set the rows to zero
        for (int i : zeroRows) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 0;
            }
        }

        // Step 3: Set the columns to zero
        for (int j : zeroCols) {
            for (int i = 0; i < rows; i++) {
                matrix[i][j] = 0;
            }
        }

        // Step 4: Print the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(arr);
    }
}
