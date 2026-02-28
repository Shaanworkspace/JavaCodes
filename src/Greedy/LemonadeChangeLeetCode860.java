package Greedy;

import java.util.*;

public class LemonadeChangeLeetCode860 {

	// Try yourself
	public boolean lemonadeChange(int[] bills) {
		int noOf5 = 0, noOf10 = 0, noOf20 = 0;
		for (int givenMoney : bills) {
			if (givenMoney == 5) noOf5++;
			if (givenMoney == 10) noOf10++;
			if (givenMoney == 20) noOf20++;

			int returnValue = givenMoney - 5;
			if (returnValue == 0) continue;

			// Take maximum 10
			if(returnValue>=10 && noOf10!=0){
				int required10 = returnValue/10;
				if(required10<=noOf10){
					noOf10-=required10;
					returnValue-=required10*10;
				}
			}

			//take maximum 5
			if(returnValue>=5 && noOf5!=0){
				int required5 = returnValue/5;
				if(required5<=noOf5){
					noOf5-=required5;
					returnValue-=required5*5;
				}
			}
			if(returnValue!=0) return false;
		}
		return true;

	}

	private static void runTest(LemonadeChangeLeetCode860 solver,
	                            int[] bills, boolean expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(bills));
		System.out.println("Expected  : " + expected);

		boolean result = solver.lemonadeChange(bills);

		System.out.printf("Result          : %-5b %s%n",
				result, result == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		LemonadeChangeLeetCode860 solver =
				new LemonadeChangeLeetCode860();

		System.out.println("=================================================");
		System.out.println("Lemonade Change - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{5, 5, 5, 10, 20},
				true,
				"Test 1");

		runTest(solver,
				new int[]{5, 5, 10, 10, 20},
				false,
				"Test 2");

		runTest(solver,
				new int[]{5,5,5,10,5,5,10,20,20,20},
				false,
				"Test 3");
	}
}