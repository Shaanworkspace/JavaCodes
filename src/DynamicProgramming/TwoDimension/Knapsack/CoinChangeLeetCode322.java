package DynamicProgramming.TwoDimension.Knapsack;
import java.util.*;

public class CoinChangeLeetCode322 {

	//recursive code
	public int coinChangeRecursion(int[] coins, int amount) {
		int ans = (int) countCoinRecursive(0,coins,amount);
		if(ans!= Integer.MAX_VALUE) return ans;
		else return -1;
	}

	private long countCoinRecursive(int idx, int[] coins, int amount) {
		if(idx == coins.length){
			if(amount==0) return 0; //no more coin
			else return Integer.MAX_VALUE; // Not a valid coin combination
		}
		// skip or pick unlimited times
		long skip = countCoinRecursive(idx+1,coins,amount);
		if(amount-coins[idx]<0) return skip;
		long pick = 1 + countCoinRecursive(idx,coins,amount-coins[idx]);
		return Math.min(skip,pick);
	}


	//
	public int coinChangeRecursionMemo(int[] coins, int amount) {

		//Changing : coin -> 0 to length AND amount -> amount to 0 (including amount)
		long[][] dp = new long[coins.length][amount+1]; // amount + 1 (IMPORTANT)
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		int ans = (int) countCoinRecursionMemo(0,coins,amount,dp);
		if(ans != Integer.MAX_VALUE) return ans;
		else return -1;
	}

	private long countCoinRecursionMemo(int idx, int[] coins, int amount, long[][] dp) {
		if(idx==coins.length){
			if(amount==0) return 0;
			else return Integer.MAX_VALUE;
		}
		if(dp[idx][amount]!=-1) return dp[idx][amount];
		long skip = countCoinRecursionMemo(idx+1,coins,amount,dp);
		if(amount-coins[idx]<0) return dp[idx][amount]=skip;
		long pick = 1 + countCoinRecursionMemo(idx,coins,amount-coins[idx],dp);
		return dp[idx][amount]=Math.min(pick,skip);
	}

	public int coinChangeTabulation(int[] coins, int amount) {
		return 0;
	}

	private static void runTest(CoinChangeLeetCode322 solver,
	                            int[] coins, int amount, int expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : coins = " + Arrays.toString(coins) + ", amount = " + amount);
		System.out.println("Expected  : " + expected);

		int brute = solver.coinChangeRecursion(coins.clone(), amount);
		int your  = solver.coinChangeRecursionMemo(coins.clone(), amount);
		int opt   = solver.coinChangeTabulation(coins.clone(), amount);

		System.out.printf("Brute Force      : %-10d %s%n",
				brute, brute == expected ? "PASS" : "FAIL");
		System.out.printf("TryYourSelf      : %-10d %s%n",
				your,  your == expected ? "PASS" : "FAIL");
		System.out.printf("Optimized (O(n*amount)) : %-10d %s%n",
				opt,   opt == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		CoinChangeLeetCode322 solver = new CoinChangeLeetCode322();

		System.out.println("=================================================");
		System.out.println("Coin Change - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1, 2, 5},
				11,
				3,
				"Test 1");

		runTest(solver,
				new int[]{2},
				3,
				-1,
				"Test 2");

		runTest(solver,
				new int[]{1},
				0,
				0,
				"Test 3");
	}
}