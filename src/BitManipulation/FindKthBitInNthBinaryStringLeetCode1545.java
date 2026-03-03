package BitManipulation;

public class FindKthBitInNthBinaryStringLeetCode1545 {

	public char findKthBitMethod1(int n, int k) {
		String s = finder(n);
		return s.charAt(k - 1);
	}
	private String reverseInvert(String s){
		StringBuilder res = new StringBuilder();

		for(int i = s.length() - 1; i >= 0; i--){
			char c = s.charAt(i);
			res.append(c == '0' ? '1' : '0');
		}

		return res.toString();
	}

	private String finder(int n){
		if(n == 1) return "0";

		String prev = finder(n - 1);
		return prev + "1" + reverseInvert(prev);
	}

	public char findKthBitMethod2(int n, int k) {
		return ' ';
	}

	public char findKthBitMethod3(int n, int k) {
		return ' ';
	}

	private static void runTest(FindKthBitInNthBinaryStringLeetCode1545 solver,
	                            int n, int k, char expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : n = " + n + ", k = " + k);
		System.out.println("Expected  : '" + expected + "'");

		char m1 = solver.findKthBitMethod1(n, k);
		char m2 = solver.findKthBitMethod2(n, k);
		char m3 = solver.findKthBitMethod3(n, k);

		System.out.printf("Method1   : %-5s %s%n",
				"'" + m1 + "'", m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method2   : %-5s %s%n",
				"'" + m2 + "'", m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method3   : %-5s %s%n",
				"'" + m3 + "'", m3 == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		FindKthBitInNthBinaryStringLeetCode1545 solver =
				new FindKthBitInNthBinaryStringLeetCode1545();

		System.out.println("=================================================");
		System.out.println("Find Kth Bit in Nth Binary String - Tests");
		System.out.println("=================================================\n");

		runTest(solver, 3, 1, '0', "Test 1");
		runTest(solver, 4, 11, '1', "Test 2");
	}
}