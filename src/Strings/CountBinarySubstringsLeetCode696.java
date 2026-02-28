package Strings;
import java.util.*;

public class CountBinarySubstringsLeetCode696 {

	private int countBinarySubstringsBrute(String s) {
		// generate all substring
		List<String> result = new ArrayList<>();
		generateSubstring(s,result);
		//find having equal and grouped 1s and 0s
		return result.size();
	}
	private void generateSubstring(String s, List<String> result) {


		int n = s.length();

		// fixing start index
		for (int start = 0; start < n; start++) {

			// extending end index continuously
			for (int end = start + 1; end < n; end++) {

				String sub = s.substring(start, end + 1);

				if (checkForCondition(sub)) {
					result.add(sub);
				}
			}
		}
	}
	private boolean checkForCondition(String currString) {
		int noOf1 = 0;
		int noOf0 = 0;
		char firstCh = currString.charAt(0);

		boolean flag = false;
		for(int i =0;i<currString.length();i++){
			char ch = currString.charAt(i);
			if(ch!=firstCh) flag= true;
			if(flag && ch == firstCh) return false;
			if(ch=='0') noOf0++;
			if(ch=='1') noOf1++;
		}
		return noOf0 == noOf1;
	}


	// Try yourself
	public int countBinarySubstrings(String s) {

		return 0;
	}

	private static void runTest(CountBinarySubstringsLeetCode696 solver,
	                            String s, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : s = \"" + s + "\"");
		System.out.println("Expected  : " + expected);

		int resultB = solver.countBinarySubstringsBrute(s);
		int result = solver.countBinarySubstrings(s);

		System.out.printf("Result Brute          : %-5d %s%n",
				resultB, resultB == expected ? "PASS" : "FAIL");
		System.out.printf("Result          : %-5d %s%n",
				result, result == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}


	public static void main(String[] args) {
		CountBinarySubstringsLeetCode696 solver =
				new CountBinarySubstringsLeetCode696();

		System.out.println("=================================================");
		System.out.println("Count Binary Substrings - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"00110011",
				6,
				"Test 1");

		runTest(solver,
				"10101",
				4,
				"Test 2");
	}
}

