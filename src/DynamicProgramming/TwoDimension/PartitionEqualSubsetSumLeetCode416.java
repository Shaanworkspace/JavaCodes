package DynamicProgramming.TwoDimension;
import java.util.*;

public class PartitionEqualSubsetSumLeetCode416 {

	// Recursion se
	public boolean canPartitionBrute(int[] arr) {
		int n = arr.length,sum =0;
		for(int a : arr) sum+=a;
		if(sum %2!=0) return false;
		return subsetFinder(arr,0,sum/2);

	}
	private static boolean subsetFinder(int[] arr,int idx , int target) {
		if(idx>=arr.length){
			if(target==0) return true;
			else return false;
		}
		boolean skip = subsetFinder(arr,idx+1,target);
		if(target-arr[idx]<0) return false;
		boolean pick = subsetFinder(arr,idx+1,target-arr[idx]);
		return skip || pick;
	}




	public boolean canPartitionTryYourSelf(int[] arr) {
		int n = arr.length,sum =0;
		for(int a : arr) sum+=a;

		if(sum %2!=0) return false;
		int target = sum/2;
		//Changing elements are ==>  target : 0 -> target ,  idx : 0 -> n
		Boolean[][] dp = new Boolean[n][target+1];
		return subsetFinderRecursionMemo(arr,0,target,dp);
	}

	private boolean subsetFinderRecursionMemo(int[] arr, int idx, int target, Boolean[][] dp) {
		if(idx>=arr.length){
			return target == 0;
		}

		if(dp[idx][target] != null) return dp[idx][target];
		boolean skip = subsetFinderRecursionMemo(arr,idx+1,target,dp);
		if(target-arr[idx]<0) {
			dp[idx][target] = skip;
			return skip;
		}else{
			boolean pick = subsetFinderRecursionMemo(arr,idx+1,target-arr[idx],dp);
			dp[idx][target] = pick || skip;
			return dp[idx][target];
		}
	}


	public boolean canPartition(int[] nums) {
		return false;
	}

	private static void runTest(PartitionEqualSubsetSumLeetCode416 solver,
	                            int[] nums, boolean expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : nums = " + Arrays.toString(nums));
		System.out.println("Expected  : " + expected);

		boolean brute = solver.canPartitionBrute(nums.clone());
		boolean your  = solver.canPartitionTryYourSelf(nums.clone());
		boolean opt   = solver.canPartition(nums.clone());

		System.out.printf("Brute Force      : %-10s %s%n",
				brute, brute == expected ? "PASS" : "FAIL");
		System.out.printf("TryYourSelf      : %-10s %s%n",
				your,  your == expected ? "PASS" : "FAIL");
		System.out.printf("Optimized (O(n*sum)) : %-10s %s%n",
				opt,   opt == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSumLeetCode416 solver = new PartitionEqualSubsetSumLeetCode416();

		System.out.println("=================================================");
		System.out.println("Partition Equal Subset Sum - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1, 5, 11, 5},
				true,
				"Test 1");

		runTest(solver,
				new int[]{1, 2, 3, 5},
				false,
				"Test 2");
	}
}