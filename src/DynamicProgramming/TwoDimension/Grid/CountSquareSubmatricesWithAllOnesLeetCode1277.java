package DynamicProgramming.TwoDimension.Grid;

import java.util.*;

public class CountSquareSubmatricesWithAllOnesLeetCode1277 {

	public int countSquaresBrute(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (matrix[i][j] == 1) {
					count++; // 1x1 square

					int a = i + 1;
					int b = j + 1;

					while (a < m && b < n) {
						if (isValidSquare(matrix, i, j, a, b)) {
							count++;
							a++;
							b++;
						} else {
							break;
						}
					}
				}
			}
		}
		return count;
	}
	private boolean isValidSquare(int[][] matrix, int i, int j, int a, int b) {

		// check bottom row
		for (int col = j; col <= b; col++) {
			if (matrix[a][col] == 0) {
				return false;
			}
		}

		// check right column
		for (int row = i; row <= a; row++) {
			if (matrix[row][b] == 0) {
				return false;
			}
		}

		return true;
	}


	public int countSquaresTryYourSelf(int[][] matrix) {
		return 0;
	}

	public int countSquares(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int count=0;
		for(int i =0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]==0) continue;
				if(i>0 && j>0){
					matrix[i][j] += Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1]));
				}
				count+=matrix[i][j];
			}
		}
		return count;
	}

	private static void printGrid(int[][] grid) {
		for (int[] row : grid) {
			System.out.println(Arrays.toString(row));
		}
	}

	private static void runTest(CountSquareSubmatricesWithAllOnesLeetCode1277 solver,
	                            int[][] matrix, int expected, String name) {
		System.out.println(name);
		System.out.println("Input:");
		printGrid(matrix);

		int brute = solver.countSquaresBrute(matrix);
		int your  = solver.countSquaresTryYourSelf(matrix);
		int opt   = solver.countSquares(matrix);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		CountSquareSubmatricesWithAllOnesLeetCode1277 solver = new CountSquareSubmatricesWithAllOnesLeetCode1277();

		int[][] matrix1 = {
				{0, 1, 1, 1},
				{1, 1, 1, 1},
				{0, 1, 1, 1}
		};

		int[][] matrix2 = {
				{1, 0, 1},
				{1, 1, 0},
				{1, 1, 0}
		};

		runTest(solver, matrix1, 15, "Test 1");
		runTest(solver, matrix2, 7, "Test 2");
	}
}
