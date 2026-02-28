package Strings.Parentheses;
import java.util.*;

public class RemoveOutermostParenthesesLeetCode1021 {

	public String removeOuterParenthesesBrute(String s) {
		int ans = 0,n=s.length(),pre=0;
		StringBuilder sBuilder = new StringBuilder();
		for(int i = 0; i<n; i++){
			char ch = s.charAt(i);
			if (ch == '(') ans++;
			else ans--;
			if(ans==0){
				sBuilder.append(s, pre + 1, i);
				pre = i + 1;
			}
		}
		return sBuilder.toString();
	}

	public String removeOuterParenthesesTryYourSelf(String s) {
		return null;
	}

	public String removeOuterParentheses(String s) {
		return null;
	}

	private static void runTest(RemoveOutermostParenthesesLeetCode1021 solver,
	                            String s, String expected, String name) {
		System.out.println(name);
		System.out.println("Input: " + s);

		String brute = solver.removeOuterParenthesesBrute(s);
		String your  = solver.removeOuterParenthesesTryYourSelf(s);
		String opt   = solver.removeOuterParentheses(s);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		RemoveOutermostParenthesesLeetCode1021 solver = new RemoveOutermostParenthesesLeetCode1021();

		runTest(solver, "(()())(())", "()()()", "Test 1");
		runTest(solver, "(()())(())(()(()))", "()()()()(())", "Test 2");
		runTest(solver, "()()", "", "Test 3");
	}
}