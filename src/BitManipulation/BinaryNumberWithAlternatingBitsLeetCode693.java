package BitManipulation;

import java.util.*;

public class BinaryNumberWithAlternatingBitsLeetCode693 {

	public boolean hasAlternatingBitsMethod1(int n) {

		int lastBit = n & 1;
		n>>=1;
		while(n>0){
			int currentBit = n & 1;

			if (currentBit == lastBit)
				return false;

			lastBit = currentBit;
			n = n >> 1;
		}
		return true;
	}

	public boolean hasAlternatingBitsMethod2(int n) {
		// alternate have property
		n = n ^ (n>>1);
		int res = n & (n+1);
		return res == 0;
	}

	public boolean hasAlternatingBitsMethod3(int n) {
		return false;
	}

	private static void runTest(BinaryNumberWithAlternatingBitsLeetCode693 solver,
	                            int n, boolean expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : n = " + n);
		System.out.println("Expected  : " + expected);

		boolean m1 = solver.hasAlternatingBitsMethod1(n);
		boolean m2 = solver.hasAlternatingBitsMethod2(n);
		boolean m3 = solver.hasAlternatingBitsMethod3(n);

		System.out.printf("Method1   : %-5b %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method2   : %-5b %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method3   : %-5b %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		BinaryNumberWithAlternatingBitsLeetCode693 solver =
				new BinaryNumberWithAlternatingBitsLeetCode693();

		System.out.println("=================================================");
		System.out.println("Binary Number With Alternating Bits - Tests");
		System.out.println("=================================================\n");

		runTest(solver, 5, true, "Test 1");
		runTest(solver, 7, false, "Test 2");
		runTest(solver, 11, false, "Test 3");
	}
}