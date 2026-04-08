package Trie.String;
import java.lang.reflect.Array;
import java.util.*;

public class CountDistinctSubstringsGFG {


	static class TrieNode{
		TrieNode[] alpha;
		TrieNode(){
			alpha = new TrieNode[26];
			Arrays.fill(alpha,null);
		}
	}

	static int insertCountInTrie(TrieNode trieNode , String s){
		TrieNode curr = trieNode;
		int count =0;
		for(int i =0;i<s.length();i++){
			int idx = s.charAt(i) - 'a';
			if(curr.alpha[idx]==null) {
				curr.alpha[idx] = new TrieNode();
				count++;
			}
			curr = curr.alpha[idx];
		}
		return count;
	}
	public int countDistinctSubstringsMethod1(String s) {
		TrieNode trieNode = new TrieNode();
		StringBuilder res = new StringBuilder();
		int count =0;
		for(int i = s.length()-1;i>=0;i--){
			res.insert(0, s.charAt(i));
			count+= insertCountInTrie(trieNode,res.toString());
		}
		return count;
	}

	public int countDistinctSubstringsMethod2(String s) {
		return 0;
	}

	public int countDistinctSubstringsMethod3(String s) {
		return 0;
	}

	private static void runTest(CountDistinctSubstringsGFG solver,
	                            String s, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : s = \"" + s + "\"");
		System.out.println("Expected  : " + expected);

		int m1 = solver.countDistinctSubstringsMethod1(s);
		int m2 = solver.countDistinctSubstringsMethod2(s);
		int m3 = solver.countDistinctSubstringsMethod3(s);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		CountDistinctSubstringsGFG solver = new CountDistinctSubstringsGFG();

		System.out.println("=================================================");
		System.out.println("Count of Distinct Substrings - Tests");
		System.out.println("=================================================\n");

		runTest(solver, "ababa", 9, "Test 1");
		runTest(solver, "aaa", 3, "Test 2");
		runTest(solver, "apple", 14, "Test 3");
	}
}