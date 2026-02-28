package Stacks.Monotonic;

import java.util.*;

public class LargestRectangleInHistogramLeetCode84 {
	public int[] nextSmallerElementIndexes(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		Arrays.fill(ans,n); // only for this question
		Stack<Integer> stack = new Stack<>();
		stack.add(n-1); //last index

		for(int i =n-2;i>=0;i--){
			int curr = arr[i];
			while (!stack.isEmpty() && arr[stack.peek()] >= curr) {
				stack.pop();
			}

			if(!stack.isEmpty()){
				ans[i] = stack.peek();
			}
			stack.push(i);
		}

		return ans;
	}

	public int[] previousSmallerElementIndexes(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		Arrays.fill(ans,-1); // iss question ke liye
		Stack<Integer> stack = new Stack<>();
		stack.add(0); //first index

		for(int i =1;i<n;i++){
			int curr = arr[i];
			while (!stack.isEmpty() && arr[stack.peek()] >= curr) {
				stack.pop();
			}
			if(!stack.isEmpty()) ans[i]= stack.peek();
			stack.push(i);
		}
		return ans;
	}

	public int largestRectangleAreaMethod1(int[] heights) {
		int[] nse = nextSmallerElementIndexes(heights);
		int[] pse = previousSmallerElementIndexes(heights);

		int max = Integer.MIN_VALUE;
		for(int i =0;i<heights.length;i++){
			int curr = heights[i];
			max = Math.max(max,curr*(nse[i]-pse[i]-1));
		}
		return max;
	}

	// Method 2: Better approach (try yourself)
	public int largestRectangleAreaMethod2(int[] heights) {
		return 0;
	}

	// Method 3: Optimized using monotonic stack (try yourself)
	public int largestRectangleAreaMethod3(int[] heights) {
		return 0;
	}

	private static void runTest(LargestRectangleInHistogramLeetCode84 solver,
	                            int[] heights, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(heights));
		System.out.println("Expected  : " + expected);

		int r1 = solver.largestRectangleAreaMethod1(heights);
		int r2 = solver.largestRectangleAreaMethod2(heights);
		int r3 = solver.largestRectangleAreaMethod3(heights);

		System.out.printf("Method 1        : %-5d %s%n",
				r1, r1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-5d %s%n",
				r2, r2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3        : %-5d %s%n",
				r3, r3 == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	void main() {
		LargestRectangleInHistogramLeetCode84 solver =
				new LargestRectangleInHistogramLeetCode84();

		System.out.println("=================================================");
		System.out.println("Largest Rectangle in Histogram - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{2,1,5,6,2,3},
				10,
				"Test 1");

		runTest(solver,
				new int[]{2,4},
				4,
				"Test 2");

		runTest(solver,
				new int[]{1,1},
				2,
				"Test 3");
	}
}