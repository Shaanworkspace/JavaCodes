package Array.SlidingWindow;
import java.util.*;

public class LongestSubarrayAtMostTwoDistinctGFG {

	public int totalElementsMethod1(int[] arr) {
		int i =0,j=0,n=arr.length;
		int maxLen = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		while(j<n){
			map.put(arr[j], map.getOrDefault(arr[j],0) + 1);

			while(map.size() > 2){
				map.put(arr[i], map.get(arr[i]) - 1);
				if(map.get(arr[i]) == 0)
					map.remove(arr[i]);
				i++;
			}

			maxLen = Math.max(maxLen, j - i + 1);
			j++;
		}
		return maxLen;
	}

	public int totalElementsMethod2(int[] arr) {
		return 0;
	}

	public int totalElementsMethod3(int[] arr) {
		return 0;
	}

	private static void runTest(LongestSubarrayAtMostTwoDistinctGFG solver,
	                            int[] arr, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : arr = " + Arrays.toString(arr));
		System.out.println("Expected  : " + expected);

		int method1 = solver.totalElementsMethod1(arr);
		int method2 = solver.totalElementsMethod2(arr);
		int method3 = solver.totalElementsMethod3(arr);

		System.out.printf("Method 1         : %-10d %s%n",
				method1, method1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				method2, method2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				method3, method3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		LongestSubarrayAtMostTwoDistinctGFG solver =
				new LongestSubarrayAtMostTwoDistinctGFG();

		System.out.println("=================================================");
		System.out.println("Longest Subarray With At Most Two Distinct Integers - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{2,1,2},
				3,
				"Test 1");

		runTest(solver,
				new int[]{3,1,2,2,2,2},
				5,
				"Test 2");

		runTest(solver,
				new int[]{6, 4, 9 ,10 ,1},
				2,
				"Test 3");
	}
}