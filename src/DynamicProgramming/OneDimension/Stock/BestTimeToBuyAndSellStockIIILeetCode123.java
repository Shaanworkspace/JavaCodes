package DynamicProgramming.OneDimension.Stock;

import java.util.*;

public class BestTimeToBuyAndSellStockIIILeetCode123 {

	public int maxProfitRecursion(int[] prices) {
		Integer[][][] dp = new Integer[prices.length][2][3];
		return helperDP(0, 1, prices, dp,2);
	}

	//Not buy -> sell
	private int helperDP(int idx, int canBuy, int[] prices, Integer[][][] dp, int capacity) {
		if(capacity==0) return 0;
		if (idx == prices.length) return 0;
		if (dp[idx][canBuy][capacity] != null) return dp[idx][canBuy][capacity];
		if (canBuy == 1) {
			//If buy we have to add profits not real value that's why we subtracted the value
			return dp[idx][canBuy][capacity] = Math.max(-prices[idx] + helperDP(idx + 1, 0, prices, dp, capacity), helperDP(idx + 1, 1, prices, dp, capacity));
		} else {
			return dp[idx][canBuy][capacity] = Math.max(prices[idx] + helperDP(idx + 1, 1, prices, dp, capacity-1), helperDP(idx + 1, 0, prices, dp, capacity));
		}
	}


	public int maxProfitRecursionMemo(int[] prices) {
		return 0;
	}

	public int maxProfitTabulation(int[] prices) {
		return 0;
	}

	private static void runTest(BestTimeToBuyAndSellStockIIILeetCode123 solver,
	                            int[] prices, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : prices = " + Arrays.toString(prices));
		System.out.println("Expected  : " + expected);

		int recursion = solver.maxProfitRecursion(prices);
		int memo = solver.maxProfitRecursionMemo(prices);
		int tabulation = solver.maxProfitTabulation(prices);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		BestTimeToBuyAndSellStockIIILeetCode123 solver =
				new BestTimeToBuyAndSellStockIIILeetCode123();

		System.out.println("=================================================");
		System.out.println("Best Time to Buy and Sell Stock III - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{3,3,5,0,0,3,1,4},
				6,
				"Test 1");

		runTest(solver,
				new int[]{1,2,3,4,5},
				4,
				"Test 2");

		runTest(solver,
				new int[]{7,6,4,3,1},
				0,
				"Test 3");
	}
}