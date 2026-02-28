package Array;
import java.util.*;

public class MissingElementsInRangeGFG {

	// Try yourself
	public List<Integer> findMissing(int[] arr, int low, int high) {
		Set<Integer> set = new HashSet<>();
		for(int i = low ;i<=high;i++) set.add(i);
		for(int ele  : arr) set.remove(ele);
		return new ArrayList<>(set);
	}

	private static void runTest(MissingElementsInRangeGFG solver,
	                            int[] arr, int low, int high,
	                            List<Integer> expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(arr));
		System.out.println("Range     : [" + low + ", " + high + "]");
		System.out.println("Expected  : " + expected);

		List<Integer> result = solver.findMissing(arr, low, high);

		System.out.printf("Result          : %-20s %s%n",
				result, result.equals(expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		MissingElementsInRangeGFG solver =
				new MissingElementsInRangeGFG();

		System.out.println("=================================================");
		System.out.println("Missing Elements in Range - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{10, 12, 11, 15},
				10,
				15,
				Arrays.asList(13, 14),
				"Test 1");

		runTest(solver,
				new int[]{1, 4, 11, 51, 15},
				50,
				55,
				Arrays.asList(50, 52, 53, 54, 55),
				"Test 2");
	}
}
