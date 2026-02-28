package Stacks.String;

import java.util.*;
public class MinimumRemoveToMakeValidParenthesesLeetCode1249 {

	// Method 1: Stack based approach (try yourself)
	public String minRemoveToMakeValidMethod1(String s) {
		int n = s.length();
		Stack<Integer> st = new Stack<>();
		HashSet<Integer> hashSet = new HashSet<>();
		for(int i =0;i<n;i++){
			if(s.charAt(i)=='(') st.push(i);
			else if (s.charAt(i)==')'){
				if(st.isEmpty()) hashSet.add(i);
				else st.pop();
			}
		}

		System.out.println(st);

		while(!st.isEmpty()){
			hashSet.add(st.pop());
		}
		StringBuilder str = new StringBuilder();
		for(int i =0;i<n;i++){
			if(!hashSet.contains(i)){
				str.append(s.charAt(i));
			}
		}
		return str.toString();
	}

	// Method 2: Two-pass / counter based approach (try yourself)
	public String minRemoveToMakeValidMethod2(String s) {
		// first remove open brackets then remove close brackets
		int n = s.length();

		// Close brackets removal : Left to right iteration
		int openBrackets = 0;
		StringBuilder str = new StringBuilder();

		for(int i=0;i<n;i++){
			if(s.charAt(i)=='(') openBrackets++;
			else if(s.charAt(i)==')' && openBrackets==0) continue;
			else if(s.charAt(i)==')' && openBrackets!=0) openBrackets--;
			str.append(s.charAt(i));

		}
		System.out.println(str.toString());



		// Open brackets removal : Right to Left iteration
		int closeBrackets = 0;
		StringBuilder str2 = new StringBuilder();
		for(int i=str.length()-1;i>=0;i--){
			if(str.charAt(i)==')') closeBrackets++;
			else if(str.charAt(i)=='(' && closeBrackets==0) continue;
			else if(str.charAt(i)=='(' && closeBrackets!=0) closeBrackets--;
			str2.append(str.charAt(i));
		}

		str2.reverse();
		return str2.toString();
	}

	public String minRemoveToMakeValidMethod3(String s) {
		return "";
	}


	private static void runTest(MinimumRemoveToMakeValidParenthesesLeetCode1249 solver,
	                            String s, String expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : \"" + s + "\"");
		System.out.println("Expected  : \"" + expected + "\"");

		String r1 = solver.minRemoveToMakeValidMethod1(s);
		String r2 = solver.minRemoveToMakeValidMethod2(s);
		String r3 = solver.minRemoveToMakeValidMethod3(s);

		System.out.printf("Method 1        : %-20s %s%n",
				"\"" + r1 + "\"", r1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-20s %s%n",
				"\"" + r2 + "\"", r2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3        : %-20s %s%n",
				"\"" + r2 + "\"", r3.equals(expected) ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		MinimumRemoveToMakeValidParenthesesLeetCode1249 solver =
				new MinimumRemoveToMakeValidParenthesesLeetCode1249();

		System.out.println("=================================================");
		System.out.println("Minimum Remove to Make Valid Parentheses - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"lee(t(c)o)de)",
				"lee(t(c)o)de",
				"Test 1");

		runTest(solver,
				"a)b(c)d",
				"ab(c)d",
				"Test 2");

		runTest(solver,
				"))((",
				"",
				"Test 3");
		runTest(solver,
				"(a(b(c)d)",
				"a(b(c)d)",
				"Test 4");
	}
}