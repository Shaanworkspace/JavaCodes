package DynamicProgramming.TwoDimension.Knapsack;

public class Knapsack01 {

	// By recursion
	public static int profit(int i, int[] wt, int[] val, int C) {
		if (i == wt.length) return 0;

		int skip = profit(i + 1, wt, val, C);
		if (wt[i] > C) return skip;

		int pick = val[i] + profit(i + 1, wt, val, C - wt[i]);
		return Math.max(pick, skip);
	}

	static void main() {
		int[] val = {5, 3, 9, 16};
		int[] wt  = {1, 2, 8, 10};
		int C = 8;

		System.out.println(profit(0, wt, val, C));
	}

}
