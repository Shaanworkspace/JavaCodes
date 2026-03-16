package Strings.SlidingWindow;
import java.util.*;

public class SmallestWindowContainingAllCharactersGFG {

	public String minWindowMethod1(String s, String p) {
		HashMap<Character,Integer> phash = new HashMap<>();
		for(char a : p.toCharArray()) phash.put(a,phash.getOrDefault(a,0)+1);

		String helper = helper(s,  new HashMap<>(), phash, "");
		return (helper.equals(s))? "":helper;
	}

	private static String helper(String s, HashMap<Character, Integer> shash, HashMap<Character, Integer> phash, String currString) {
		int i =0,j=0,n=s.length();
		String res = "";
		while(j<n){
			char a = s.charAt(j);
			shash.put(a,shash.getOrDefault(a,0)+1);

			while(checkHash(phash, shash)){
				if(res.equals("") || j-i+1 < res.length()) res = s.substring(i, j+1);

				char left = s.charAt(i);
				shash.put(left, shash.get(left)-1);
				if(shash.get(left) == 0) shash.remove(left);
				i++;
			}
			j++;
		}
		return res;
	}

	private static  boolean checkHash(HashMap<Character, Integer> phash, HashMap<Character, Integer> shash) {
		for(char ch : phash.keySet())
			if(!shash.containsKey(ch) || shash.get(ch) < phash.get(ch)) return false;
		return true;
	}


	public String minWindowMethod2(String s, String p) {
		return "";
	}

	public String minWindowMethod3(String s, String p) {
		return "";
	}

	private static void runTest(SmallestWindowContainingAllCharactersGFG solver,
	                            String s, String p, String expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : s = \"" + s + "\", p = \"" + p + "\"");
		System.out.println("Expected  : \"" + expected + "\"");

		String m1 = solver.minWindowMethod1(s, p);
		String m2 = solver.minWindowMethod2(s, p);
		String m3 = solver.minWindowMethod3(s, p);

		System.out.printf("Method 1         : %-10s %s%n",
				"\"" + m1 + "\"", m1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10s %s%n",
				"\"" + m2 + "\"", m2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10s %s%n",
				"\"" + m3 + "\"", m3.equals(expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		SmallestWindowContainingAllCharactersGFG solver =
				new SmallestWindowContainingAllCharactersGFG();

		System.out.println("=================================================");
		System.out.println("Smallest Window Containing All Characters - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"timetopractice",
				"toc",
				"toprac",
				"Test 1");

		runTest(solver,
				"zoomlazapzo",
				"oza",
				"apzo",
				"Test 2");

		runTest(solver,
				"zoom",
				"zooe",
				"",
				"Test 3");
	}
}