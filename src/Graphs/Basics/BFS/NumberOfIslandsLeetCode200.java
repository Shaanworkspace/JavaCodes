package Graphs.Basics.BFS;

import java.util.*;

public class NumberOfIslandsLeetCode200 {

	public int numIslandsBrute(char[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int count=0;

		boolean[][] isVisited = new boolean[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(grid[i][j]=='1' && !isVisited[i][j]){
					bfs(i,j,grid,isVisited);
					count++;
				}
			}
		}
		return count;
	}


	static class Pair {
		int row;
		int col;
		Pair(int i ,int j){
			row=i;
			col=j;
		}
	}
	private void bfs(int row, int col, char[][] grid, boolean[][] isVisited) {
		Queue<Pair> queue = new LinkedList<>();
		int rowLen = grid.length;
		int colLen = grid[0].length;
		queue.offer(new Pair(row,col));
		isVisited[row][col]=true;
		while(!queue.isEmpty()){
			Pair p = queue.poll();
			int i = p.row;
			int j = p.col;

			//up
			if(i>0 && !isVisited[i-1][j] && grid[i-1][j]=='1'){
				queue.offer(new Pair(i-1,j));
				isVisited[i-1][j]=true;
			}

			//bottom
			if(i+1<rowLen && !isVisited[i+1][j] && grid[i+1][j]=='1'){
					queue.offer(new Pair(i+1,j));
					isVisited[i+1][j]=true;
			}

			//right
			if(j+1<colLen && !isVisited[i][j+1] && grid[i][j+1]=='1'){
				queue.offer(new Pair(i,j+1));
				isVisited[i][j+1]=true;
			}

			//left
			if(j>0 && !isVisited[i][j-1] && grid[i][j-1]=='1'){
				queue.offer(new Pair(i,j-1));
				isVisited[i][j-1]=true;
			}
		}
	}

	public int numIslandsTryYourSelf(char[][] grid) {
		return 0;
	}

	public int numIslands(char[][] grid) {
		return 0;
	}

	private static char[][] copyGrid(char[][] grid) {
		char[][] copy = new char[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			copy[i] = Arrays.copyOf(grid[i], grid[i].length);
		}
		return copy;
	}

	private static void printGrid(char[][] grid) {
		for (char[] row : grid) {
			System.out.println(Arrays.toString(row));
		}
	}

	private static void runTest(NumberOfIslandsLeetCode200 solver,
	                            char[][] grid, int expected, String name) {
		System.out.println(name);
		System.out.println("Input:");
		printGrid(grid);

		int brute = solver.numIslandsBrute(copyGrid(grid));
		int your  = solver.numIslandsTryYourSelf(copyGrid(grid));
		int opt   = solver.numIslands(copyGrid(grid));

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		NumberOfIslandsLeetCode200 solver = new NumberOfIslandsLeetCode200();

		char[][] grid1 = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};

		char[][] grid2 = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};

		char[][] grid3 = {
				{'1','0','1','0','1'},
				{'0','1','0','1','0'},
				{'1','0','1','0','1'},
				{'0','1','0','1','0'}
		};

		char[][] grid4 = {
				{'1','1','1'},
				{'1','1','1'},
				{'1','1','1'}
		};

		char[][] grid5 = {
				{'0','0','0'},
				{'0','0','0'},
				{'0','0','0'}
		};

		char[][] grid6 = {
				{'1'}
		};

		runTest(solver, grid1, 1, "Test 1");
		runTest(solver, grid2, 3, "Test 2");
		runTest(solver, grid3, 10, "Test 3");
		runTest(solver, grid4, 1, "Test 4");
		runTest(solver, grid5, 0, "Test 5");
		runTest(solver, grid6, 1, "Test 6");
	}
}