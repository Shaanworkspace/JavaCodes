package Strings;
import java.util.*;

public class CountAndSayLeetCode38 {
	public String countAndSayBrute(int n) {
		if(n==1) return "1";
		String res = countAndSayBrute(n-1);
		String con = counter(res);
		return con;
	}
	public static String counter(String s){
		StringBuilder sc = new StringBuilder();
		int count = 1;

		for (int i = 1; i <= s.length(); i++) {
			if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
				count++;
			} else {
				sc.append(count).append(s.charAt(i - 1));
				count = 1;
			}
		}
		return sc.toString();
	}



	public String countAndSayTryYourSelf(int n) {
		return null;
	}

	public String countAndSay(int n) {
		return null;
	}

	private static void runTest(CountAndSayLeetCode38 solver,
	                            int n, String expected, String name) {
		System.out.println(name);
		System.out.println("Input: n = " + n);

		String brute = solver.countAndSayBrute(n);
		String your  = solver.countAndSayTryYourSelf(n);
		String opt   = solver.countAndSay(n);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		CountAndSayLeetCode38 solver = new CountAndSayLeetCode38();

		runTest(solver, 1, "1", "Test 1");
		runTest(solver, 4, "1211", "Test 2");
	}
}