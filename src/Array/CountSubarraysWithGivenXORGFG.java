package Array;
import java.util.*;

public class CountSubarraysWithGivenXORGFG {

	// Method 1: Brute force idea (try yourself)
	public int countSubarraysMethod1(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int prefixXor = 0;

		map.put(0, 1);
		for (int i = 0; i < arr.length; i++) {
			prefixXor = prefixXor ^ arr[i];
			int required = prefixXor ^ k;
			if (map.containsKey(required)) {
				count += map.get(required);
			}
			map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
		}

		return count;
	}

	// Method 2: Prefix XOR with HashMap (try yourself)
	public int countSubarraysMethod2(int[] arr, int k) {
		return 0;
	}

	// Method 3: Optimized / clean implementation (try yourself)
	public int countSubarraysMethod3(int[] arr, int k) {
		return 0;
	}

	private static void runTest(CountSubarraysWithGivenXORGFG solver,
	                            int[] arr, int k, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Array     : " + Arrays.toString(arr));
		System.out.println("k         : " + k);
		System.out.println("Expected  : " + expected);

		int r1 = solver.countSubarraysMethod1(arr, k);
		int r2 = solver.countSubarraysMethod2(arr, k);
		int r3 = solver.countSubarraysMethod3(arr, k);

		System.out.printf("Method 1        : %-5d %s%n",
				r1, r1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-5d %s%n",
				r2, r2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3        : %-5d %s%n",
				r3, r3 == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		CountSubarraysWithGivenXORGFG solver =
				new CountSubarraysWithGivenXORGFG();

		System.out.println("=================================================");
		System.out.println("Count Subarrays with Given XOR - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{4, 2, 2, 6, 4},
				6,
				4,
				"Test 1");

		runTest(solver,
				new int[]{5, 6, 7, 8, 9},
				5,
				2,
				"Test 2");

		runTest(solver,
				new int[]{1, 1, 1, 1},
				0,
				4,
				"Test 3");
	}
}