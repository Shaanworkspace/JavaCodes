package Greedy.Scheduling;
import java.util.*;

public class ShortestJobFirstGFG {

	// Method 1: Brute idea (try yourself)
	public int averageWaitingTimeMethod1(int[] bt) {
		Arrays.sort(bt);
		int n = bt.length,sum =0,add=0;
		for(int i =0;i<n-1;i++){
			sum+=bt[i];
			add+=sum;
		}
		return add/n;
	}

	// Method 2: Optimized using sorting (try yourself)
	public int averageWaitingTimeMethod2(int[] bt) {
		return 0;
	}

	// Method 3: Final clean approach (try yourself)
	public int averageWaitingTimeMethod3(int[] bt) {
		return 0;
	}

	private static void runTest(ShortestJobFirstGFG solver,
	                            int[] bt, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Burst Times : " + Arrays.toString(bt));
		System.out.println("Expected    : " + expected);

		int r1 = solver.averageWaitingTimeMethod1(bt);
		int r2 = solver.averageWaitingTimeMethod2(bt);
		int r3 = solver.averageWaitingTimeMethod3(bt);

		System.out.printf("Method 1        : %-5d %s%n",
				r1, r1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-5d %s%n",
				r2, r2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3        : %-5d %s%n",
				r3, r3 == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		ShortestJobFirstGFG solver =
				new ShortestJobFirstGFG();

		System.out.println("=================================================");
		System.out.println("Shortest Job First - Average Waiting Time");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{4,3,7,1,2},
				4,
				"Test 1");

		runTest(solver,
				new int[]{1,2,3,4},
				2,
				"Test 2");
	}
}