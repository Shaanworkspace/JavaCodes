package DynamicProgramming.TwoDimension.Knapsack;

import java.util.Arrays;

public class DiceThrowGFG {

	public int noOfWaysMethod1(int m, int n, int x) {
		return helperr(m,n,x,0,0);
	}

	private static int helperr(int m, int n, int x,int count,int sum) {
		if(count==n){
			return (sum==x)?  1 : 0;
		}
		int total = 0;
		for(int i = 1;i<=m;i++){
			total+=helperr(m,n,x,count+1,sum+i);
		}
		return total;
	}

	public int noOfWaysMethod2(int m, int n, int x) {
		int sumTotal = m*n+1;
		int[][] dp = new  int[n+1][sumTotal+1];
		for(int [] a : dp){
			Arrays.fill(a,-1);
		}
		return helperrr(m,n,x,0,0,dp);
	}

	private static int helperrr(int m, int n, int x, int count, int sum, int[][] dp) {
		if(dp[count][sum] !=-1) return dp[count][sum] ;
		if(count==n){
			return (sum==x)?  1 : 0;
		}
		int total = 0;
		for(int i = 1;i<=m;i++){
			total+=helperrr(m,n,x,count+1,sum+i, dp);
		}
		return dp[count][sum] = total;
	}

	public int noOfWaysMethod3(int m, int n, int x) {
		return 0;
	}

	private static void runTest(DiceThrowGFG solver,
	                            int m, int n, int x, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : m = " + m + ", n = " + n + ", x = " + x);
		System.out.println("Expected  : " + expected);

		int m1 = solver.noOfWaysMethod1(m, n, x);
		int m2 = solver.noOfWaysMethod2(m, n, x);
		int m3 = solver.noOfWaysMethod3(m, n, x);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		DiceThrowGFG solver = new DiceThrowGFG();

		System.out.println("=================================================");
		System.out.println("Dice Throw - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				6, 3, 12,
				25,
				"Test 1");

		runTest(solver,
				2, 3, 6,
				1,
				"Test 2");
	}
}