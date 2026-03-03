package Backtracking.Recursion;

import java.util.*;

public class LetterCombinationsLeetCode17 {

	// Method 1: Basic recursion (try yourself)
	public List<String> letterCombinationsMethod1(String digits) {

		String[] map = {
				"",     // 0
				"",     // 1
				"abc",  // 2
				"def",  // 3
				"ghi",  // 4
				"jkl",  // 5
				"mno",  // 6
				"pqrs", // 7
				"tuv",  // 8
				"wxyz"  // 9
		};
		List<String> combinations = new ArrayList<>();
		if (digits == null || digits.isEmpty())
			return combinations;
		generateCombi(combinations,map,0, new StringBuilder(),digits);
		return combinations;
	}

	private void generateCombi(List<String> combinations, String[] map, int idx, StringBuilder curr, String digits) {
		if(idx>=digits.length()){
			combinations.add(curr.toString());
			return;
		}
		char ch = digits.charAt(idx);
		int digit = ch - '0';
		String letters = map[digit];
		for(int i =0;i<letters.length();i++){
			curr.append(letters.charAt(i));
			generateCombi(combinations, map,idx + 1, curr,digits);
			curr.deleteCharAt(curr.length() - 1);
		}
	}

	// Method 2: Backtracking approach (try yourself)
	public List<String> letterCombinationsMethod2(String digits) {
		return new ArrayList<>();
	}

	// Method 3: Iterative / queue-based approach (try yourself)
	public List<String> letterCombinationsMethod3(String digits) {
		return new ArrayList<>();
	}

	private static void runTest(LetterCombinationsLeetCode17 solver,
	                            String digits, List<String> expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : \"" + digits + "\"");
		System.out.println("Expected  : " + expected);

		List<String> r1 = solver.letterCombinationsMethod1(digits);
		List<String> r2 = solver.letterCombinationsMethod2(digits);
		List<String> r3 = solver.letterCombinationsMethod3(digits);

		System.out.printf("Method 1        : %-25s %s%n",
				r1, r1.size() == expected.size() ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-25s %s%n",
				r2, r2.size() == expected.size() ? "PASS" : "FAIL");
		System.out.printf("Method 3        : %-25s %s%n",
				r3, r3.size() == expected.size() ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		LetterCombinationsLeetCode17 solver =
				new LetterCombinationsLeetCode17();

		System.out.println("=================================================");
		System.out.println("Letter Combinations of a Phone Number - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"23",
				Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"),
				"Test 1");

		runTest(solver,
				"2",
				Arrays.asList("a","b","c"),
				"Test 2");
	}
}