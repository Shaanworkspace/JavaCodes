package DynamicProgramming.OneDimension.HouseRobber;
import java.util.*;

public class SticklerThiefGFG {


	int maxSum ;
	public int findMaxSumMethod1(int[] arr) {
		maxSum = Integer.MIN_VALUE;
		helper(arr,0,0);
		return maxSum;
	}

	private void helper(int[] arr, int idx, int sum) {
		if(idx>=arr.length){
			maxSum = Math.max(maxSum,sum);
			return;
		}

		//pick
		helper(arr,idx+2,sum+arr[idx]);

		//skip
		helper(arr,idx+1,sum);
	}

	public int findMaxSumMethod2(int[] arr) {
		return helper(arr,0);
	}

	private int helper(int[] arr, int idx) {
		if(idx >= arr.length)
			return 0;

		int pick = arr[idx] + helper(arr, idx+2);
		int skip = helper(arr, idx+1);

		return Math.max(pick, skip);
	}

	public int findMaxSumMethod3(int[] arr) {
		int[] dp = new int[arr.length+1];
		Arrays.fill(dp,-1);
		return helper3(arr,0,dp);
	}

	private int helper3(int[] arr, int idx, int[] dp) {
		if(idx >= arr.length)
			return 0;
		if(dp[idx]!=-1) return dp[idx];

		int pick = arr[idx] + helper3(arr, idx+2, dp);
		int skip = helper3(arr, idx+1, dp);

		return dp[idx]=Math.max(pick, skip);
	}

	private static void runTest(SticklerThiefGFG solver,
	                            int[] arr, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : arr = " + Arrays.toString(arr));
		System.out.println("Expected  : " + expected);

		int method1 = solver.findMaxSumMethod1(arr);
		int method2 = solver.findMaxSumMethod2(arr);
		int method3 = solver.findMaxSumMethod3(arr);

		System.out.printf("Method 1         : %-10d %s%n",
				method1, method1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				method2, method2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				method3, method3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		SticklerThiefGFG solver = new SticklerThiefGFG();

		System.out.println("=================================================");
		System.out.println("Stickler Thief - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{6,7,1,3,8,2,4},
				19,
				"Test 1");

		runTest(solver,
				new int[]{5,3,4,11,2},
				16,
				"Test 2");
	}
}