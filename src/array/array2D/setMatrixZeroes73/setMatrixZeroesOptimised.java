package array.array2D.setMatrixZeroes73;

import java.util.HashSet;
import java.util.Set;

public class setMatrixZeroesOptimised {
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean rowZero = false;
        boolean colZero = false;
        // To mark zero in first row and column
        for(int i =0;i<rows;i++){
            for(int j = 0 ;j<columns;j++){
                if(matrix[i][j]==0){
                    if(i==0) colZero=true;
                    if(j==0) rowZero=true;
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        //make rest of 2d array elements as 0 wrt to 1st row and column
        for(int i = 1 ; i<rows;i++){
            for(int j=1;j<columns;j++){
                if(matrix[0][j] ==0 || matrix[i][0]==0 ){
                    matrix[i][j]=0;
                }
            }
        }

        //Now setting 1st row and column as zero
        if(rowZero){
            for (int i = 0 ; i<rows ;i++){
                matrix[i][0]=0;
            }
        }
        if(colZero){
            for (int i = 0 ; i<rows ;i++){
                matrix[0][i]=0;
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
//        int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(arr);
    }
}
