package Backtracking;
import java.util.*;

public class CombinationsLeetCode77 {

	public List<List<Integer>> combineRecursion(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		combiner(1,result,new ArrayList<>(),n,k);
		return result;
	}

	private void combiner(int idx, List<List<Integer>> result, List<Integer> adder, int n, int k) {
		if( adder.size()==k){
			List<Integer> ad = new ArrayList<>(adder);
			result.add(ad);
			return;
		}
		if(idx>n){
			return;
		}


		//take
		adder.add(idx);
		combiner(idx+1,result,adder, n, k);
		adder.remove(adder.size() - 1);
		//skip
		combiner(idx+1,result,adder, n, k);
	}

	public List<List<Integer>> combineRecursionMemo(int n, int k) {
		return new ArrayList<>();
	}

	public List<List<Integer>> combineTabulation(int n, int k) {
		return new ArrayList<>();
	}

	private static void runTest(CombinationsLeetCode77 solver,
	                            int n, int k,
	                            List<List<Integer>> expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : n = " + n + ", k = " + k);
		System.out.println("Expected  : " + expected);

		List<List<Integer>> recursion = solver.combineRecursion(n, k);
		List<List<Integer>> memo = solver.combineRecursionMemo(n, k);
		List<List<Integer>> tabulation = solver.combineTabulation(n, k);

		System.out.printf("Recursion        : %-20s %s%n",
				recursion, recursion.size() == expected.size() ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-20s %s%n",
				memo, memo.size() == expected.size() ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-20s %s%n",
				tabulation, tabulation.size() == expected.size() ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		CombinationsLeetCode77 solver =
				new CombinationsLeetCode77();

		System.out.println("=================================================");
		System.out.println("Combinations - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				4,
				2,
				Arrays.asList(
						Arrays.asList(1,2),
						Arrays.asList(1,3),
						Arrays.asList(1,4),
						Arrays.asList(2,3),
						Arrays.asList(2,4),
						Arrays.asList(3,4)
				),
				"Test 1");

		runTest(solver,
				1,
				1,
				Arrays.asList(
						Arrays.asList(1)
				),
				"Test 2");
	}
}
