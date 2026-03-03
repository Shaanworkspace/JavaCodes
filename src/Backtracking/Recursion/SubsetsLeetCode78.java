package Backtracking.Recursion;
import java.util.*;

public class SubsetsLeetCode78 {

	public List<List<Integer>> subsetsMethod1(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		int n = nums.length;
		int total = 1 << n;
		for(int mask = 0; mask < total; mask++){
			List<Integer> subset = new ArrayList<>();
			for(int i = 0; i < n; i++)
				if((mask & (1 << i)) != 0)
					subset.add(nums[i]);
			ans.add(subset);
		}
		return ans;
	}

	public List<List<Integer>> subsetsMethod2(int[] nums) {
		List<List<Integer>>  res = new ArrayList<>();
		helper(0,nums,res,new ArrayList<>());
		return res;
	}

	private void helper(int idx,int[] nums, List<List<Integer>> res, List<Integer> subset) {
		res.add(new ArrayList<>(subset));
		for(int i = idx;i<nums.length;i++){
			subset.add(nums[i]);
			helper(i+1,nums,res,subset);
			subset.remove(subset.size()-1);
		}
	}


	public List<List<Integer>> subsetsMethod3(int[] nums) {
		return new ArrayList<>();
	}

	private static boolean compare(List<List<Integer>> result, List<List<Integer>> expected) {
		if (result.size() != expected.size()) return false;

		Set<Set<Integer>> set1 = new HashSet<>();
		Set<Set<Integer>> set2 = new HashSet<>();

		for (List<Integer> list : result) set1.add(new HashSet<>(list));
		for (List<Integer> list : expected) set2.add(new HashSet<>(list));

		return set1.equals(set2);
	}

	private static void runTest(SubsetsLeetCode78 solver,
	                            int[] nums, List<List<Integer>> expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(nums));
		System.out.println("Expected  : " + expected);

		List<List<Integer>> m1 = solver.subsetsMethod1(nums);
		List<List<Integer>> m2 = solver.subsetsMethod2(nums);
		List<List<Integer>> m3 = solver.subsetsMethod3(nums);

		System.out.printf("Method1   : %-30s %s%n",
				m1, compare(m1, expected) ? "PASS" : "FAIL");
		System.out.printf("Method2   : %-30s %s%n",
				m2, compare(m2, expected) ? "PASS" : "FAIL");
		System.out.printf("Method3   : %-30s %s%n",
				m3, compare(m3, expected) ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		SubsetsLeetCode78 solver = new SubsetsLeetCode78();

		System.out.println("=================================================");
		System.out.println("Subsets (Power Set) - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1,2,3},
				Arrays.asList(
						Arrays.asList(),
						Arrays.asList(1),
						Arrays.asList(2),
						Arrays.asList(3),
						Arrays.asList(1,2),
						Arrays.asList(1,3),
						Arrays.asList(2,3),
						Arrays.asList(1,2,3)
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