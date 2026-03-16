package DynamicProgramming.OneDimension;
import java.util.*;

public class MaximumProductSubarrayGFG {

	public int maxProductMethod1(int[] arr) {
		int sum =arr[0];
		int maxProd = arr[0];
		int minProd = arr[0];

		for(int i =1;i<arr.length;i++){
			int a = arr[i];
			int b = arr[i] * maxProd;
			int c = arr[i] * minProd;

			maxProd= Math.max(a,Math.max(b,c));
			minProd = Math.min(a,Math.min(b,c));

			sum = Math.max(sum,maxProd);
		}
		return sum;
	}

	public int maxProductMethod2(int[] arr) {
		return 0;
	}

	public int maxProductMethod3(int[] arr) {
		return 0;
	}

	private static void runTest(MaximumProductSubarrayGFG solver,
	                            int[] arr, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : arr = " + Arrays.toString(arr));
		System.out.println("Expected  : " + expected);

		int m1 = solver.maxProductMethod1(arr);
		int m2 = solver.maxProductMethod2(arr);
		int m3 = solver.maxProductMethod3(arr);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		MaximumProductSubarrayGFG solver = new MaximumProductSubarrayGFG();

		System.out.println("=================================================");
		System.out.println("Maximum Product Subarray - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{-2, 6, -3, -10, 0, 2},
				180,
				"Test 1");

		runTest(solver,
				new int[]{-1, -3, -10, 0, 6},
				30,
				"Test 2");

		runTest(solver,
				new int[]{2, 3, 4},
				24,
				"Test 3");
	}
}