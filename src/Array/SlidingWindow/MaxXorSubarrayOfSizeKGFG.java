package Array.SlidingWindow;
import java.util.*;

public class MaxXorSubarrayOfSizeKGFG {

	public int maxSubarrayXORMethod1(int[] arr, int k) {
		int xor = 0;


		for(int i = 0;i<k;i++){
			xor ^=arr[i];
		}
		int max =xor;

		for(int i =k;i<arr.length;i++){
			xor ^=arr[i-k];
			xor ^=arr[i];
			max = Math.max(max,xor);
		}
		return max;
	}

	public int maxSubarrayXORMethod2(int[] arr, int k) {
		return 0;
	}

	public int maxSubarrayXORMethod3(int[] arr, int k) {
		return 0;
	}

	private static void runTest(MaxXorSubarrayOfSizeKGFG solver,
	                            int[] arr, int k, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : arr = " + Arrays.toString(arr) + ", k = " + k);
		System.out.println("Expected  : " + expected);

		int m1 = solver.maxSubarrayXORMethod1(arr, k);
		int m2 = solver.maxSubarrayXORMethod2(arr, k);
		int m3 = solver.maxSubarrayXORMethod3(arr, k);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		MaxXorSubarrayOfSizeKGFG solver = new MaxXorSubarrayOfSizeKGFG();

		System.out.println("=================================================");
		System.out.println("Max XOR Subarray of Size K - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{2, 5, 8, 1, 1, 3},
				3,
				15,
				"Test 1");

		runTest(solver,
				new int[]{1, 2, 4, 5, 6},
				2,
				6,
				"Test 2");
	}
}