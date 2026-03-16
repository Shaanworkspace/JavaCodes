package Recursion;
import java.util.*;

public class RansomNoteLeetCode383 {

	public boolean canConstructMethod1(String ransomNote, String magazine) {
		HashMap<Character,Integer> ransomHash = new HashMap<>();
		for(char a : ransomNote.toCharArray()) ransomHash.put(a,ransomHash.getOrDefault(a,0)+1);
		for(char a : magazine.toCharArray()){
			if(ransomHash.containsKey(a)){
				ransomHash.put(a, ransomHash.get(a)-1);
				if(ransomHash.get(a)==0) ransomHash.remove(a);
			}
		}
		return ransomHash.isEmpty();
	}

	public boolean canConstructMethod2(String ransomNote, String magazine) {
		return false;
	}

	public boolean canConstructMethod3(String ransomNote, String magazine) {
		return false;
	}

	private static void runTest(RansomNoteLeetCode383 solver,
	                            String ransomNote, String magazine,
	                            boolean expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : ransomNote = \"" + ransomNote + "\", magazine = \"" + magazine + "\"");
		System.out.println("Expected  : " + expected);

		boolean m1 = solver.canConstructMethod1(ransomNote, magazine);
		boolean m2 = solver.canConstructMethod2(ransomNote, magazine);
		boolean m3 = solver.canConstructMethod3(ransomNote, magazine);

		System.out.printf("Method 1         : %-10b %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10b %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10b %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		RansomNoteLeetCode383 solver = new RansomNoteLeetCode383();

		System.out.println("=================================================");
		System.out.println("Ransom Note - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"a",
				"b",
				false,
				"Test 1");

		runTest(solver,
				"aa",
				"ab",
				false,
				"Test 2");

		runTest(solver,
				"aa",
				"aab",
				true,
				"Test 3");
	}
}