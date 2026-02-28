package Array.Matrix;
import java.util.*;

public class SearchA2DMatrixLeetCode74 {

	// Try yourself
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length,col = matrix[0].length;
		int idx = col-1,got=0;
		for(int i =0;i<row;i++){
			if(target<=matrix[i][idx]){
				for(int j =0;j<col;j++){
					if(target==matrix[i][j]) got=1;
				}
			}
		}
		if(got==1) return true;
		return false;
	}

	private static void runTest(SearchA2DMatrixLeetCode74 solver,
	                            int[][] matrix, int target,
	                            boolean expected, String testName) {

		System.out.println(testName);
		System.out.println("Matrix    : " + Arrays.deepToString(matrix));
		System.out.println("Target    : " + target);
		System.out.println("Expected  : " + expected);

		boolean result = solver.searchMatrix(matrix, target);

		System.out.printf("Result          : %-5b %s%n",
				result, result == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		SearchA2DMatrixLeetCode74 solver =
				new SearchA2DMatrixLeetCode74();

		System.out.println("=================================================");
		System.out.println("Search a 2D Matrix - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{
						{1,3,5,7},
						{10,11,16,20},
						{23,30,34,60}
				},
				3,
				true,
				"Test 1");

		runTest(solver,
				new int[][]{
						{1,3,5,7},
						{10,11,16,20},
						{23,30,34,60}
				},
				13,
				false,
				"Test 2");
	}
}