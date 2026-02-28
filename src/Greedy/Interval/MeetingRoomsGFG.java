package Greedy.Interval;

import java.util.*;

public class MeetingRoomsGFG {

	// Greedy approach (sorting by end time)
	public boolean canAttendMeetingsGreedy(int[][] arr) {
		Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
		int n = arr.length;
		if(n==1) return true;
		for(int i =1;i<n;i++){
			if(arr[i-1][1]>arr[i][0])
				return false;
		}
		return true;
	}

	// Alternate thinking slot (try-yourself / variation)
	public boolean canAttendMeetingsTryYourself(int[][] arr) {
		return false;
	}

	private static void runTest(MeetingRoomsGFG solver,
	                            int[][] arr,
	                            boolean expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : arr = " + Arrays.deepToString(arr));
		System.out.println("Expected  : " + expected);

		boolean greedy = solver.canAttendMeetingsGreedy(arr);
		boolean custom = solver.canAttendMeetingsTryYourself(arr);

		System.out.printf("Greedy           : %-7b %s%n",
				greedy, greedy == expected ? "PASS" : "FAIL");
		System.out.printf("Try Yourself     : %-7b %s%n",
				custom, custom == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		MeetingRoomsGFG solver =
				new MeetingRoomsGFG();

		System.out.println("=================================================");
		System.out.println("Meeting Rooms (GFG) - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{{1,4},{10,15},{7,10}},
				true,
				"Test 1");

		runTest(solver,
				new int[][]{{2,4},{9,12},{6,10}},
				false,
				"Test 2");
	}
}
