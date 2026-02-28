package Stacks;

import java.util.*;

public class NextSmallerElement {

	// Method 1
	public int[] nextSmallerElementMethod1(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		Arrays.fill(ans,-1);
		Stack<Integer> stack = new Stack<>();
		stack.add(0); //first index

		for(int i =1;i<n;i++){
			int curr = arr[i];
			while(!stack.isEmpty() && curr<arr[stack.peek()]){
				ans[stack.peek()] = curr;
				stack.pop();
			}
			stack.push(i);
		}
		return ans;
	}

	// Method 2
	public int[] nextSmallerElementMethod2(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		Arrays.fill(ans,-1);
		Stack<Integer> stack = new Stack<>();
		stack.add(n-1); //last index

		for(int i =n-2;i>=0;i--){
			int curr = arr[i];
			while(!stack.isEmpty() && curr<arr[stack.peek()]) stack.pop();

			if(!stack.isEmpty()){
				ans[i] = arr[stack.peek()];
			}
			stack.push(i);
		}

		return ans;
	}

	private static void runTest(NextSmallerElement solver,
	                            int[] arr, int[] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(arr));
		System.out.println("Expected  : " + Arrays.toString(expected));

		int[] r1 = solver.nextSmallerElementMethod1(arr);
		int[] r2 = solver.nextSmallerElementMethod2(arr);

		System.out.printf("Method 1  : %-20s %s%n",
				Arrays.toString(r1), Arrays.equals(r1, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2  : %-20s %s%n",
				Arrays.toString(r2), Arrays.equals(r2, expected) ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		NextSmallerElement solver = new NextSmallerElement();

		runTest(solver, new int[]{4,5,2,10}, new int[]{2,2,-1,-1}, "Test 1");
		runTest(solver, new int[]{3,2,1}, new int[]{2,1,-1}, "Test 2");
		runTest(solver, new int[]{1,3,2,4}, new int[]{-1,2,-1,-1}, "Test 3");
		runTest(solver, new int[]{6,8,0,1,3}, new int[]{0,0,-1,-1,-1}, "Test 4");
	}
}