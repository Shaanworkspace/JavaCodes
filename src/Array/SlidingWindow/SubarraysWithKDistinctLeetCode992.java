package Array.SlidingWindow;

import java.util.*;

public class SubarraysWithKDistinctLeetCode992 {

	public int subarraysWithKDistinctBrute(int[] nums, int k) {
		int n = nums.length;
		if(n<k) return 0;
		int count=0;
		for(int i =0;i<=n-k;i++){
			HashSet<Integer> hashSet = new HashSet<>();
			for(int j =i ;j<n;j++){
				hashSet.add(nums[j]);
				if(hashSet.size()==k){
					count++;
				}
				if (hashSet.size()>k){
					break;
				}
			}
		}
		return count;
	}

	public int subarraysWithKDistinctTryYourSelf(int[] nums, int k) {
		return 0;
	}

	public int subarraysWithKDistinct(int[] nums, int k) {


		// Find SubArray have less than or equal to k distinct
		//  Find SubArray have less than or equal to k-1 distinct
		// subtract so you will find exactly  equal to k
		return findSubArraysEqualOrLessThanK(nums,k) - findSubArraysEqualOrLessThanK(nums,k-1);
	}

	private int findSubArraysEqualOrLessThanK(int[] nums, int k) {
		int n = nums.length;
		if(n<k) return 0;
		HashMap<Integer,Integer> hashMap  = new HashMap<>();
		int i =0,j=0,count=0;
		while(j<n){
			int curr = nums[j];
			hashMap.put(curr,hashMap.getOrDefault(curr,0)+1);
			while (hashMap.size() > k) {
				hashMap.put(nums[i], hashMap.get(nums[i]) - 1);
				if (hashMap.get(nums[i]) == 0) {
					hashMap.remove(nums[i]);
				}
				i++;
			}
			count += (j - i + 1);
			j++;
		}
		return count;
	}

	private static void runTest(SubarraysWithKDistinctLeetCode992 solver,
	                            int[] nums, int k, int expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : nums = " + Arrays.toString(nums) + ", k = " + k);
		System.out.println("Expected  : " + expected);

		int brute = solver.subarraysWithKDistinctBrute(nums.clone(), k);
		int your  = solver.subarraysWithKDistinctTryYourSelf(nums.clone(), k);
		int opt   = solver.subarraysWithKDistinct(nums.clone(), k);

		System.out.printf("Brute Force      : %-10d %s%n",
				brute, brute == expected ? "PASS" : "FAIL");
		System.out.printf("TryYourSelf      : %-10d %s%n",
				your,  your == expected ? "PASS" : "FAIL");
		System.out.printf("Optimized (O(n)) : %-10d %s%n",
				opt,   opt == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		SubarraysWithKDistinctLeetCode992 solver = new SubarraysWithKDistinctLeetCode992();

		System.out.println("=================================================");
		System.out.println("Subarrays with K Different Integers - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1, 2, 1, 2, 3},
				2,
				7,
				"Test 1");

		runTest(solver,
				new int[]{1, 2, 1, 3, 4},
				3,
				3,
				"Test 2");
	}
}