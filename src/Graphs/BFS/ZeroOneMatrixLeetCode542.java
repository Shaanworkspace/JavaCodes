package Graphs.BFS;

import java.util.*;

public class ZeroOneMatrixLeetCode542 {
	static class Pair {
		int x;
		int y;

		Pair(int xa, int ya) {
			x = xa;
			y = ya;
		}
	}

	//TLE
	public int[][] updateMatrixBrute(int[][] mat) {
		int m =mat.length;
		int n = mat[0].length;
		int[][] vat = new int[m][n];
		for(int i =0;i<m;i++){
			for(int j =0;j<n;j++){
				if(mat[i][j]==1)
					bfs(mat,i,j,vat);
			}
		}
		return vat;
	}

	private void bfs(int[][] mat, int r, int c,int[][] vat) {
		int m =mat.length;
		int n = mat[0].length;
		int[][] isV = new int[m][n];

		Queue<Pair> queue = new LinkedList<>();

		queue.offer(new Pair(r,c));
		isV[r][c]=1;
		int[] cr = {-1,1,0,0}; //up, d , l , r
		int[] cc = {0,0,-1,1};
		int count=1;
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size!=0){
				Pair curr = queue.poll();
				for(int i =0;i<4;i++){
					int row = curr.x+cr[i];
					int col = curr.y+cc[i];

					if(row>=0 && row<m && col>=0 && col<n && isV[row][col]==0){
						if(mat[row][col]==0){
							vat[r][c]=count;
							return;
						}
						queue.offer(new Pair(row,col));
						isV[row][col]=1;
					}
				}
				size--;
			}
			count++;
		}

	}

	public int[][] updateMatrixTryYourSelf(int[][] mat) {
		return null;
	}

	//From all 0s, how far are the 1s?
	public int[][] updateMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		int[][] dist = new int[m][n];
		Queue<Pair> queue = new LinkedList<>();

		// Step 1: Initialize
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					dist[i][j] = 0;
					queue.offer(new Pair(i, j));
				} else {
					dist[i][j] = -1; // not visited
				}
			}
		}

		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		while (!queue.isEmpty()) {
			Pair curr = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nr = curr.x + dr[k];
				int nc = curr.y + dc[k];

				if (nr >= 0 && nr < m && nc >= 0 && nc < n && dist[nr][nc] == -1) {
					dist[nr][nc] = dist[curr.x][curr.y] + 1;
					queue.offer(new Pair(nr, nc));
				}
			}
		}

		return dist;


	}

	private static int[][] copyGrid(int[][] grid) {
		int[][] copy = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			copy[i] = Arrays.copyOf(grid[i], grid[i].length);
		}
		return copy;
	}

	private static void printGrid(int[][] grid) {
		if (grid == null) {
			System.out.println("null");
			return;
		}
		for (int[] row : grid) {
			System.out.println(Arrays.toString(row));
		}
	}

	private static void runTest(ZeroOneMatrixLeetCode542 solver,
	                            int[][] mat, int[][] expected, String name) {
		System.out.println(name);
		System.out.println("Input:");
		printGrid(mat);

		int[][] brute = solver.updateMatrixBrute(copyGrid(mat));
		int[][] your  = solver.updateMatrixTryYourSelf(copyGrid(mat));
		int[][] opt   = solver.updateMatrix(copyGrid(mat));

		System.out.println("Expected:");
		printGrid(expected);
		System.out.println("Brute Force:");
		printGrid(brute);
		System.out.println("TryYourSelf:");
		printGrid(your);
		System.out.println("Optimized:");
		printGrid(opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		ZeroOneMatrixLeetCode542 solver = new ZeroOneMatrixLeetCode542();

		int[][] mat1 = {
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
		};
		int[][] expected1 = {
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
		};

		int[][] mat2 = {
				{0, 0, 0},
				{0, 1, 0},
				{1, 1, 1}
		};
		int[][] expected2 = {
				{0, 0, 0},
				{0, 1, 0},
				{1, 2, 1}
		};

		runTest(solver, mat1, expected1, "Test 1");
		runTest(solver, mat2, expected2, "Test 2");
	}
}