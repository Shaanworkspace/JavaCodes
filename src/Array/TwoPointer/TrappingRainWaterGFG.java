package Array.TwoPointer;

import java.util.*;

public class TrappingRainWaterGFG {

	public int maxWaterMethod1(int[] arr) {
		int n = arr.length;

		//left max
		int[] leftMax = new int[n];
		leftMax[0]  = arr[0];
		for(int i =1;i<n;i++){
			leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
		}

		int[] rightMax = new int[n];
		rightMax[n-1]  = arr[n-1];
		for(int i =n-2;i>=0;i--){
			rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
		}

		int total =0;
		for(int i = 0;i<n;i++){
			total+= Math.min(leftMax[i],rightMax[i])-arr[i]; // need to find units ( not the area )
		}
		return total;
	}

	public int maxWaterMethod2(int[] arr) {
		return 0;
	}

	public int maxWaterMethod3(int[] arr) {
		return 0;
	}

	private static void runTest(TrappingRainWaterGFG solver,
	                            int[] arr, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(arr));
		System.out.println("Expected  : " + expected);

		int m1 = solver.maxWaterMethod1(arr);
		int m2 = solver.maxWaterMethod2(arr);
		int m3 = solver.maxWaterMethod3(arr);

		System.out.printf("Method1   : %-5d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method2   : %-5d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method3   : %-5d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		TrappingRainWaterGFG solver = new TrappingRainWaterGFG();

		System.out.println("=================================================");
		System.out.println("Trapping Rain Water - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{3,0,1,0,4,0,2},
				10,
				"Test 1");

		runTest(solver,
				new int[]{3,0,2,0,4},
				7,
				"Test 2");

		runTest(solver,
				new int[]{1,2,3,4},
				0,
				"Test 3");

		runTest(solver,
				new int[]{2,1,5,3,1,0,4},
				9,
				"Test 4");
	}
}