package Backtracking.Recursion;
import java.util.*;

public class SubsetsIILeetCode90 {

	public List<List<Integer>> subsetsWithDupMethod1(int[] nums) {
		return new ArrayList<>();
	}

	public List<List<Integer>> subsetsWithDupMethod2(int[] nums) {
		List<List<Integer>>  res = new ArrayList<>();
		Arrays.sort(nums);
		helper(0,nums,res,new ArrayList<>());
		return res;
	}

	private void helper(int idx,int[] nums, List<List<Integer>> res, List<Integer> subset) {
		if(res.contains(subset)) return;
		res.add(new ArrayList<>(subset));
		for(int i = idx;i<nums.length;i++){
			subset.add(nums[i]);
			helper(i+1,nums,res,subset);
			subset.remove(subset.size()-1);
		}
	}

	public List<List<Integer>> subsetsWithDupMethod3(int[] nums) {
		return new ArrayList<>();
	}

	private static void runTest(SubsetsIILeetCode90 solver,
	                            int[] nums, List<List<Integer>> expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(nums));
		System.out.println("Expected  : " + expected);

		List<List<Integer>> m1 = solver.subsetsWithDupMethod1(nums);
		List<List<Integer>> m2 = solver.subsetsWithDupMethod2(nums);
		List<List<Integer>> m3 = solver.subsetsWithDupMethod3(nums);

		System.out.printf("Method1   : %-20s %s%n",
				m1, m1.size() == expected.size() ? "PASS" : "FAIL");
		System.out.printf("Method2   : %-20s %s%n",
				m2, m2.size() == expected.size() ? "PASS" : "FAIL");
		System.out.printf("Method3   : %-20s %s%n",
				m3, m3.size() == expected.size() ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		SubsetsIILeetCode90 solver = new SubsetsIILeetCode90();

		System.out.println("=================================================");
		System.out.println("Subsets II - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1,2,2},
				Arrays.asList(
						Arrays.asList(),
						Arrays.asList(1),
						Arrays.asList(1,2),
						Arrays.asList(1,2,2),
						Arrays.asList(2),
						Arrays.asList(2,2)
				),
				"Test 1");

		runTest(solver,
				new int[]{0},
				Arrays.asList(
						Arrays.asList(),
						Arrays.asList(0)
				),
				"Test 2");
	}
}