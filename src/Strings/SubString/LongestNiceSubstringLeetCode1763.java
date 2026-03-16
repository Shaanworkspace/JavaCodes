package Strings.SubString;
import java.util.*;

public class LongestNiceSubstringLeetCode1763 {

	public String longestNiceSubstringMethod1(String s) {
		return "";
	}

	public String longestNiceSubstringMethod2(String s) {
		return "";
	}

	public String longestNiceSubstringMethod3(String s) {
		return "";
	}

	private static void runTest(LongestNiceSubstringLeetCode1763 solver,
	                            String s, String expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : s = \"" + s + "\"");
		System.out.println("Expected  : \"" + expected + "\"");

		String m1 = solver.longestNiceSubstringMethod1(s);
		String m2 = solver.longestNiceSubstringMethod2(s);
		String m3 = solver.longestNiceSubstringMethod3(s);

		System.out.printf("Method 1         : %-10s %s%n",
				m1, m1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10s %s%n",
				m2, m2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10s %s%n",
				m3, m3.equals(expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		LongestNiceSubstringLeetCode1763 solver =
				new LongestNiceSubstringLeetCode1763();

		System.out.println("=================================================");
		System.out.println("Longest Nice Substring - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"YazaAay",
				"aAa",
				"Test 1");

		runTest(solver,
				"Bb",
				"Bb",
				"Test 2");

		runTest(solver,
				"c",
				"",
				"Test 3");
	}
}