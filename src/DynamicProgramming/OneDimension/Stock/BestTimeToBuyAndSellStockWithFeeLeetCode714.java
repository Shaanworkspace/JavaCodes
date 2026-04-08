package DynamicProgramming.OneDimension.Stock;
import java.util.*;

public class BestTimeToBuyAndSellStockWithFeeLeetCode714 {

	public int maxProfitRecursion(int[] prices, int fee) {
		Integer[][] dp = new Integer[prices.length+1][2];
		return help(prices,fee,0,1,dp);
	}

	private int help(int[] prices, int fee, int idx, int canBuy, Integer[][] dp) {

		if(idx==prices.length) return 0;
		if (dp[idx][canBuy] != null) return dp[idx][canBuy];
		if(canBuy==1){
			return dp[idx][canBuy] = Math.max(-prices[idx]  + help(prices, fee, idx+1, 0, dp),help(prices, fee, idx+1, 1, dp));
		}else{
			return dp[idx][canBuy] = Math.max(prices[idx] - fee + help(prices, fee, idx+1, 1, dp),help(prices, fee, idx+1, 0, dp));
		}
	}

	public int maxProfitRecursionMemo(int[] prices, int fee) {
		return 0;
	}

	public int maxProfitTabulation(int[] prices, int fee) {
		return 0;
	}

	private static void runTest(BestTimeToBuyAndSellStockWithFeeLeetCode714 solver,
	                            int[] prices, int fee, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : prices = " + Arrays.toString(prices) + ", fee = " + fee);
		System.out.println("Expected  : " + expected);

		int recursion = solver.maxProfitRecursion(prices, fee);
		int memo = solver.maxProfitRecursionMemo(prices, fee);
		int tabulation = solver.maxProfitTabulation(prices, fee);

		System.out.printf("Recursion        : %-10d %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-10d %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-10d %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		BestTimeToBuyAndSellStockWithFeeLeetCode714 solver =
				new BestTimeToBuyAndSellStockWithFeeLeetCode714();

		System.out.println("=================================================");
		System.out.println("Best Time to Buy and Sell Stock with Transaction Fee - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1,3,2,8,4,9},
				2,
				8,
				"Test 1");

		runTest(solver,
				new int[]{1,3,7,5,10,3},
				3,
				6,
				"Test 2");
	}
}