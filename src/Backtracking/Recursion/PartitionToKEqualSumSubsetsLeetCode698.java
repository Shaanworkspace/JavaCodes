package Backtracking.Recursion;
import java.util.*;

public class PartitionToKEqualSumSubsetsLeetCode698 {

	public boolean canPartitionKSubsetsMethod1(int[] nums, int k) {
		int sum =0;
		for(int a : nums){
			sum+=a;
		}
		System.out.println(sum);
		if(sum%k!=0) return false;

		int requiredSum = sum/k;
		List<Integer> res = new ArrayList<>();
		Arrays.sort(nums);
		return helper(nums,k,requiredSum,res,0,0);
	}

	private boolean helper(int[] nums, int k, int requiredSum, List<Integer> res, int currSum, int idx) {
		if(res.size() == k - 1) return true;
		if(currSum == requiredSum) {
			res.add(1);

			if(helper(nums, k, requiredSum, res, 0, 0))
				return true;

			res.remove(res.size() - 1);
			return false;
		}

		if(idx == nums.length) return false;

		//skip
		if(helper(nums, k, requiredSum, res, currSum, idx + 1)) return true;

		//pick
		if(nums[idx]!=-1 && currSum+nums[idx] <= requiredSum){
			int val = nums[idx];
			nums[idx]=-1;
			if(helper(nums, k, requiredSum, res, currSum + val, idx + 1)) return true;
			nums[idx] = val;
		}
		return false;
	}

	Map<String, Boolean> dp ;
	public boolean canPartitionKSubsetsMethod2(int[] nums, int k) {
		dp = new HashMap<>();
		int sum = 0;
		for(int a : nums) sum += a;


		System.out.println(sum);
		if(sum%k!=0) return false;

		int requiredSum = sum/k;
		List<Integer> res = new ArrayList<>();
		Arrays.sort(nums);
		return helperDp(nums,k,requiredSum,res,0,0);
	}

	private boolean helperDp(int[] nums, int k, int requiredSum, List<Integer> res, int currSum, int idx) {
		String key = Arrays.toString(nums) + "|" + currSum + "|" + res.size();
		if(dp.containsKey(key)) return dp.get(key);


		if(res.size() == k - 1) return true;
		if(currSum == requiredSum) {
			res.add(1);

			boolean ans = helperDp(nums, k, requiredSum, res, 0, 0);

			res.remove(res.size() - 1);
			dp.put(key, ans);
			return ans;
		}

		if(idx == nums.length) {
			dp.put(key, false);
			return false;
		}

		//skip
		if(helper(nums, k, requiredSum, res, currSum, idx + 1)) {
			dp.put(key, true);
			return true;
		}

		//pick
		if(nums[idx]!=-1 && currSum+nums[idx] <= requiredSum){
			int val = nums[idx];
			nums[idx]=-1;
			if(helper(nums, k, requiredSum, res, currSum + val, idx + 1)){
				dp.put(key, true);
				return true;
			}
			nums[idx] = val;
		}
		dp.put(key, false);
		return false;
	}


	public boolean canPartitionKSubsetsMethod3(int[] nums, int k) {
		return false;
	}

	private static void runTest(PartitionToKEqualSumSubsetsLeetCode698 solver,
	                            int[] nums, int k, boolean expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : nums = " + Arrays.toString(nums) + ", k = " + k);
		System.out.println("Expected  : " + expected);

		boolean m1 = solver.canPartitionKSubsetsMethod1(nums, k);
		boolean m2 = solver.canPartitionKSubsetsMethod2(nums, k);
		boolean m3 = solver.canPartitionKSubsetsMethod3(nums, k);

		System.out.printf("Method1   : %-10s %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method2   : %-10s %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method3   : %-10s %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		PartitionToKEqualSumSubsetsLeetCode698 solver =
				new PartitionToKEqualSumSubsetsLeetCode698();

		System.out.println("=================================================");
		System.out.println("Partition to K Equal Sum Subsets - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{4,3,2,3,5,2,1},
				4,
				true,
				"Test 1");

		runTest(solver,
				new int[]{2,2,2,2,3,4,5},
				4,
				false,
				"Test 2");
	}
}