package Greedy.Sorting;

import java.util.*;

public class AssignCookiesLeetCode455 {

	// Try yourself
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int j=0;
		for(int i : s){
			if(i>=g[j] ){
				j++;

			}
			if(j==g.length) return j;
		}
		return j;
	}

	private static void runTest(AssignCookiesLeetCode455 solver,
	                            int[] g, int[] s,
	                            int expected, String testName) {

		System.out.println(testName);
		System.out.println("Greed     : " + Arrays.toString(g));
		System.out.println("Cookies   : " + Arrays.toString(s));
		System.out.println("Expected  : " + expected);

		int result = solver.findContentChildren(g, s);

		System.out.printf("Result          : %-5d %s%n",
				result, result == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		AssignCookiesLeetCode455 solver =
				new AssignCookiesLeetCode455();

		System.out.println("=================================================");
		System.out.println("Assign Cookies - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1,2,3},
				new int[]{1,1},
				1,
				"Test 1");

		runTest(solver,
				new int[]{1,2},
				new int[]{1,2,3},
				2,
				"Test 2");
	}
}