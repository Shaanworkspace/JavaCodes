package Graphs.BFS.Matrix;

import java.util.*;

public class SurroundedRegionsLeetCode130 {

	public void solveMethod1(char[][] board) {
		int row = board.length;
		int col = board[0].length;

		// top - right
		for (int i = 0; i < col; i++) if (board[0][i] == 'O') dfs(board, 0, i);
		// down - right
		for (int i = 0; i < col; i++) if (board[row - 1][i] == 'O') dfs(board, row - 1, i);
		// right - down
		for (int i = 0; i < row; i++) if (board[i][col - 1] == 'O') dfs(board, i, col - 1);
		// left - down
		for (int i = 0; i < row; i++) if (board[i][0] == 'O') dfs(board, i, 0);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == 'N') {
					board[i][j] = 'O';
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void dfs(char[][] board, int row, int col) {
		int rowT = board.length;
		int colT = board[0].length;
		board[row][col] = 'N';
		int[] cr = {0, 0, -1, 1};
		int[] cc = {-1, 1, 0, 0};
		for (int i = 0; i < 4; i++) {
			int nr = row + cr[i];
			int nc = col + cc[i];
			if (nr >= 0 && nr < rowT && nc >= 0 && nc < colT && board[nr][nc] == 'O') {
				dfs(board, nr, nc);
			}
		}
	}

	public void solveMethod2(char[][] board) {
	}

	public void solveMethod3(char[][] board) {
	}

	private static void runTest(SurroundedRegionsLeetCode130 solver,
	                            char[][] board, char[][] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(board));
		System.out.println("Expected  : " + Arrays.deepToString(expected));

		char[][] b1 = deepCopy(board);
		char[][] b2 = deepCopy(board);
		char[][] b3 = deepCopy(board);

		solver.solveMethod1(b1);
		solver.solveMethod2(b2);
		solver.solveMethod3(b3);

		System.out.printf("Method 1         : %-10s %s%n",
				"Checked", Arrays.deepEquals(b1, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10s %s%n",
				"Checked", Arrays.deepEquals(b2, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10s %s%n",
				"Checked", Arrays.deepEquals(b3, expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	private static char[][] deepCopy(char[][] board) {
		char[][] copy = new char[board.length][];
		for (int i = 0; i < board.length; i++) {
			copy[i] = board[i].clone();
		}
		return copy;
	}

	public static void main(String[] args) {

		SurroundedRegionsLeetCode130 solver =
				new SurroundedRegionsLeetCode130();

		System.out.println("=================================================");
		System.out.println("Surrounded Regions - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new char[][]{
						{'X', 'X', 'X', 'X'},
						{'X', 'O', 'O', 'X'},
						{'X', 'X', 'O', 'X'},
						{'X', 'O', 'X', 'X'}
				},
				new char[][]{
						{'X', 'X', 'X', 'X'},
						{'X', 'X', 'X', 'X'},
						{'X', 'X', 'X', 'X'},
						{'X', 'O', 'X', 'X'}
				},
				"Test 1");

		runTest(solver,
				new char[][]{
						{'X'}
				},
				new char[][]{
						{'X'}
				},
				"Test 2");

		runTest(solver,
				new char[][]{
						{'O', 'O', 'O'},
						{'O', 'O', 'O'},
						{'O', 'O', 'O'}
				},
				new char[][]{
						{'O', 'O', 'O'},
						{'O', 'O', 'O'},
						{'O', 'O', 'O'}
				},
				"Test 3");
	}
}