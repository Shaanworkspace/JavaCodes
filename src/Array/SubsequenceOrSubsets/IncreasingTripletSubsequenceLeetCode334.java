package Array.SubsequenceOrSubsets;
import java.util.*;

public class IncreasingTripletSubsequenceLeetCode334 {

	public boolean increasingTripletBrute(int[] nums) {
		int n = nums.length;
		if(n<=3){
			return false;
		}
		int[] preM = new int[n];
		int[] su = new int[n];

		preM[0] = nums[0];
		for (int i = 1; i < n; i++) {
			preM[i] = Math.min(preM[i-1], nums[i]);
		}

		su[n-1] = nums[n-1];
		for (int i = n-2; i >= 0; i--) {
			su[i] = Math.max(su[i+1], nums[i]);
		}
		for(int i =1;i<n-1;i++){
			if(nums[i]>preM[i-1] && nums[i]<su[i+1]){
				return true;
			}
		}
		return false;
	}

	public boolean increasingTripletTryYourSelf(int[] nums) {
		return false;
	}

	public boolean increasingTriplet(int[] nums) {
		return false;
	}

	private static void runTest(IncreasingTripletSubsequenceLeetCode334 solver,
	                            int[] nums, boolean expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : nums = " + Arrays.toString(nums));
		System.out.println("Expected  : " + expected);

		boolean brute = solver.increasingTripletBrute(nums.clone());
		boolean your  = solver.increasingTripletTryYourSelf(nums.clone());
		boolean opt   = solver.increasingTriplet(nums.clone());

		System.out.printf("Brute Force      : %-10s %s%n",
				brute, brute == expected ? "PASS" : "FAIL");
		System.out.printf("TryYourSelf      : %-10s %s%n",
				your,  your == expected ? "PASS" : "FAIL");
		System.out.printf("Optimized (O(n)) : %-10s %s%n",
				opt,   opt == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		IncreasingTripletSubsequenceLeetCode334 solver = new IncreasingTripletSubsequenceLeetCode334();

		System.out.println("=================================================");
		System.out.println("Increasing Triplet Subsequence - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1, 2, 3, 4, 5},
				true,
				"Test 1");

		runTest(solver,
				new int[]{5, 4, 3, 2, 1},
				false,
				"Test 2");

		runTest(solver,
				new int[]{2, 1, 5, 0, 4, 6},
				true,
				"Test 3");
	}
}