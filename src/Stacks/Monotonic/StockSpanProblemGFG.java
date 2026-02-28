package Stacks.Monotonic;

import java.util.*;

public class StockSpanProblemGFG {

	static class Pair {
		int val;
		int idx;

		Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}

	// Method 1: Brute Force
	// For each day, look left until price is greater
	public List<Integer> stockSpanMethod1(int[] arr) {
		int n = arr.length;

		List<Integer> ans = new ArrayList<>();

		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(arr[0],0));
		ans.add(1);


		for(int i =1;i<n;i++){
			while(!stack.isEmpty() && stack.peek().val<=arr[i])	stack.pop();
			if(stack.isEmpty()) ans.add(i+1);
			else ans.add(i-stack.peek().idx);
			stack.push(new Pair(arr[i],i));
		}
		return ans;
	}

	// Method 2: Better (using previous greater element idea)
	public List<Integer> stockSpanMethod2(int[] arr) {

		return List.of();
	}

	// Method 3: Optimized (Monotonic Stack with Pair)
	public List<Integer> stockSpanMethod3(int[] arr) {

		return List.of();
	}

	private static void runTest(StockSpanProblemGFG solver,
	                            int[] arr, List<Integer> expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(arr));
		System.out.println("Expected  : " + expected);

		List<Integer> r1 = solver.stockSpanMethod1(arr);
		List<Integer> r2 = solver.stockSpanMethod2(arr);
		List<Integer> r3 = solver.stockSpanMethod3(arr);

		System.out.printf("Method 1  : %-20s %s%n", r1, r1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2  : %-20s %s%n", r2, r2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3  : %-20s %s%n", r3, r3.equals(expected) ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		StockSpanProblemGFG solver = new StockSpanProblemGFG();

		runTest(solver,
				new int[]{100, 80, 90, 120},
				Arrays.asList(1, 1, 2, 4),
				"Test 1");

		runTest(solver,
				new int[]{10, 4, 5, 90, 120, 80},
				Arrays.asList(1, 1, 2, 4, 5, 1),
				"Test 2");

		runTest(solver,
				new int[]{3, 7, 7, 6, 1, 2, 6, 3, 7, 5},
				Arrays.asList(1, 2, 3, 1, 1, 2, 4, 1, 9, 1),
				"Test 3");
	}
}