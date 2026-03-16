package Array.SlidingWindow;
import java.util.*;

public class LongestSubstringWithKUniquesGFG {

	public int longestKSubstrMethod1(String s, int k) {
		int n=s.length(),i =0,j=0,max=-1;
		HashMap<Character,Integer> hashMap = new HashMap<>();

		while(j<n){
			hashMap.put(s.charAt(j),hashMap.getOrDefault(s.charAt(j),0)+1);
			while(hashMap.size()>k){
				hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))-1);
				if(hashMap.get(s.charAt(i))==0) hashMap.remove(s.charAt(i));
				i++;
			}
			if(hashMap.size() == k) max = Math.max(max,j-i+1);
			j++;
		}
		return max;
	}

	public int longestKSubstrMethod2(String s, int k) {
		return -1;
	}

	public int longestKSubstrMethod3(String s, int k) {
		return -1;
	}

	private static void runTest(LongestSubstringWithKUniquesGFG solver,
	                            String s, int k, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : s = \"" + s + "\", k = " + k);
		System.out.println("Expected  : " + expected);

		int m1 = solver.longestKSubstrMethod1(s, k);
		int m2 = solver.longestKSubstrMethod2(s, k);
		int m3 = solver.longestKSubstrMethod3(s, k);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		LongestSubstringWithKUniquesGFG solver = new LongestSubstringWithKUniquesGFG();

		System.out.println("=================================================");
		System.out.println("Longest Substring With K Unique Characters - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"aabacbebebe",
				3,
				7,
				"Test 1");

		runTest(solver,
				"aaaa",
				2,
				-1,
				"Test 2");

		runTest(solver,
				"aabaaab",
				2,
				7,
				"Test 3");
	}
}