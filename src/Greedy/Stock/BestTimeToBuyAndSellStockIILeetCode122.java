package Greedy.Stock;

import java.util.*;

public class BestTimeToBuyAndSellStockIILeetCode122 {

	public int maxProfitMethod1(int[] prices) {
		int ele = prices[0];
		int prof = 0;

		for (int i = 1; i < prices.length; i++) {
			if (ele < prices[i]) {
				prof += prices[i] - ele;
			}
			ele = prices[i];
		}
		return prof;
	}

	public int maxProfitMethod2(int[] prices) {
		return helper(0, true, prices);
	}

	//Not buy -> sell
	private int helper(int idx, boolean canBuy, int[] prices) {
		if (idx == prices.length) return 0;
		if (canBuy) {
			//If buy we have to add profits not real value that's why we subtracted the value
			return Math.max(-prices[idx] + helper(idx + 1, false, prices), helper(idx + 1, true, prices));
		} else {
			return Math.max(prices[idx] + helper(idx + 1, true, prices), helper(idx + 1, false, prices));
		}
	}

	public int maxProfitMethod3(int[] prices) {
		Integer[][] dp = new Integer[prices.length][2];
		return helperDP(0, 1, prices, dp);
	}

	//Not buy -> sell
	private int helperDP(int idx, int canBuy, int[] prices, Integer[][] dp) {
		if (idx == prices.length) return 0;
		if (dp[idx][canBuy] != null) return dp[idx][canBuy];
		if (canBuy == 1) {
			//If buy we have to add profits not real value that's why we subtracted the value
			return dp[idx][canBuy] = Math.max(-prices[idx] + helperDP(idx + 1, 0, prices, dp), helperDP(idx + 1, 1, prices, dp));
		} else {
			return dp[idx][canBuy] = Math.max(prices[idx] + helperDP(idx + 1, 1, prices, dp), helperDP(idx + 1, 0, prices, dp));
		}
	}


	// Tabulation
	public int maxProfitMethod4(int[] prices) {
		int n = prices.length;
		Integer[][] dp = new Integer[n + 1][2];


		//base case
		dp[n][0] = 0;
		dp[n][1] = 0;

		//reversing the changing variable : idx , canBuy
		// idx : 0 -> n and canBuy: 1-> 0 SO here idx: n->0 ,canBuy : 0->1

		for (int idx = n-1; idx >= 0; idx--) {
			for (int canBuy = 0; canBuy <= 1; canBuy++) {
				if (canBuy==1) {
					//If buy we have to add profits not real value that's why we subtracted the value
					dp[idx][canBuy] = Math.max(-prices[idx] + dp[idx + 1][0], dp[idx + 1][1]);
				} else {
					dp[idx][canBuy] = Math.max(prices[idx] + dp[idx + 1][1], dp[idx + 1][0]);
				}
			}
		}

		return dp[0][1];
	}

	private static void runTest(BestTimeToBuyAndSellStockIILeetCode122 solver,
	                            int[] prices, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : prices = " + Arrays.toString(prices));
		System.out.println("Expected  : " + expected);

		int m1 = solver.maxProfitMethod1(prices);
		int m2 = solver.maxProfitMethod2(prices);
		int m3 = solver.maxProfitMethod3(prices);
		int m4 = solver.maxProfitMethod4(prices);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 4         : %-10d %s%n",
				m4, m4 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		BestTimeToBuyAndSellStockIILeetCode122 solver =
				new BestTimeToBuyAndSellStockIILeetCode122();

		System.out.println("=================================================");
		System.out.println("Best Time to Buy and Sell Stock II - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{7, 1, 5, 3, 6, 4},
				7,
				"Test 1");

		runTest(solver,
				new int[]{1, 2, 3, 4, 5},
				4,
				"Test 2");

		runTest(solver,
				new int[]{7, 6, 4, 3, 1},
				0,
				"Test 3");
	}
}