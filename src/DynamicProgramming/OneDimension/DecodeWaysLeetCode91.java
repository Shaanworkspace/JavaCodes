package DynamicProgramming.OneDimension;

public class DecodeWaysLeetCode91 {


	//TLE
	public int numDecodingsMethod1(String s) {
		return helper(s);
	}

	private int helper(String s) {

		if(s.isEmpty()) return 1;
		if(s.startsWith("0")) return 0;

		int countOfOneTake = helper(s.substring(1));
		int countOfTwoTaken= 0;
		if(s.length()>=2 && Integer.parseInt(s.substring(0,2)) < 27 )
			countOfTwoTaken= helper(s.substring(2));
		return countOfOneTake+countOfTwoTaken;
	}

	public int numDecodingsMethod2(String s) {
		Integer[] dp = new Integer[s.length()];
		return helper2(s,0,dp);
	}

	private int helper2(String s, int i, Integer[] dp) {

		if(i == s.length()) return 1;
		if(s.charAt(i) == '0') return 0;
		if(dp[i] != null) return dp[i];


		int countOfOneTake = helper2(s, i+1, dp);
		int countOfTwoTaken= 0;
		if(i + 1 < s.length() && Integer.parseInt(s.substring(i,i+2)) < 27 )
			countOfTwoTaken= helper2(s, i+2, dp);
		return dp[i] = countOfOneTake+countOfTwoTaken;
	}

	public int numDecodingsMethod3(String s) {
		return 0;
	}

	private static void runTest(DecodeWaysLeetCode91 solver,
	                            String s, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : s = \"" + s + "\"");
		System.out.println("Expected  : " + expected);

		int m1 = solver.numDecodingsMethod1(s);
		int m2 = solver.numDecodingsMethod2(s);
		int m3 = solver.numDecodingsMethod3(s);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		DecodeWaysLeetCode91 solver = new DecodeWaysLeetCode91();

		System.out.println("=================================================");
		System.out.println("Decode Ways - Tests");
		System.out.println("=================================================\n");

		runTest(solver, "12", 2, "Test 1");
		runTest(solver, "226", 3, "Test 2");
		runTest(solver, "06", 0, "Test 3");
	}
}