package Greedy.Stock;

import java.util.*;

public class BestTimeToBuyAndSellStockLeetCode121 {

	public int maxProfitMethod1(int[] prices) {
		int maxProfit =0;
		int ele = prices[0];

		for (int i = 1; i < prices.length; i++) {
			if (ele > prices[i]) {
				ele = prices[i];
			} else {
				maxProfit = Math.max(maxProfit,prices[i]-ele );
			}
		}
		return maxProfit;
	}


	//Recursive approach
	public int maxProfitMethod2(int[] prices) {

		return 0;
	}

	public int maxProfitMethod3(int[] prices) {

		return 0;
	}

	private static void runTest(BestTimeToBuyAndSellStockLeetCode121 solver,
	                            int[] prices, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : prices = " + Arrays.toString(prices));
		System.out.println("Expected  : " + expected);

		int m1 = solver.maxProfitMethod1(prices);
		int m2 = solver.maxProfitMethod2(prices);
		int m3 = solver.maxProfitMethod3(prices);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		BestTimeToBuyAndSellStockLeetCode121 solver =
				new BestTimeToBuyAndSellStockLeetCode121();

		System.out.println("=================================================");
		System.out.println("Best Time to Buy and Sell Stock - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{7, 1, 5, 3, 6, 4},
				5,
				"Test 1");

		runTest(solver,
				new int[]{7, 6, 4, 3, 1},
				0,
				"Test 2");
	}
}