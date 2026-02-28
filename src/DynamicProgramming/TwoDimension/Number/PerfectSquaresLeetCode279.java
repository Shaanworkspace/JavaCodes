package DynamicProgramming.TwoDimension.Number;
import java.util.*;

public class PerfectSquaresLeetCode279 {

	public int numSquaresBrute(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp,-1);
		return minSquare(n,dp);
	}

	private int minSquare(int n, int[] dp) {
		if(isPerfect(n)) return 1;

		if(dp[n]!=-1) return dp[n];

		int min = Integer.MAX_VALUE;
		for(int i =1;i*i<n;i++){
			int c = minSquare(i*i,dp)+minSquare(n-(i*i),dp);
			min = Math.min(c,min);
		}
		return dp[n]=min;
	}

	public int numSquaresTryYourSelf(int n) {
		return 0;
	}

	public int numSquares(int n) {
		int[] dp = new int[n+1];
		for(int i=1;i<n;i++){
			if(isPerfect(i)) dp[i]=i;
			else{
				int min = Integer.MAX_VALUE;
				for(int j=1;j<=i/2;j++){
					int count = dp[j]+dp[i-j];
					min = Math.min(min,count);
				}
				dp[i]=min;
			}
		}
		return dp[n];
	}

	private boolean isPerfect(int i) {
		int sqrt = (int)(Math.sqrt(i));
		return (sqrt*sqrt==i);
	}

	private static void runTest(PerfectSquaresLeetCode279 solver,
	                            int n, int expected, String name) {
		System.out.println(name);
		System.out.println("Input: n = " + n);

		int brute = solver.numSquaresBrute(n);
		int your  = solver.numSquaresTryYourSelf(n);
		int opt   = solver.numSquares(n);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		PerfectSquaresLeetCode279 solver = new PerfectSquaresLeetCode279();

		runTest(solver, 12, 3, "Test 1");
		runTest(solver, 13, 2, "Test 2");
		runTest(solver, 1, 1, "Test 3");
		runTest(solver, 43, 3, "Test 4");
	}
}
