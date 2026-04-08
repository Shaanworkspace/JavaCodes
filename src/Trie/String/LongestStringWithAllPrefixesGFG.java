package Trie.String;

import java.util.*;

public class LongestStringWithAllPrefixesGFG {

	class TrieNode {
		TrieNode[] alpha;
		boolean eow;

		TrieNode() {
			alpha = new TrieNode[26];
			Arrays.fill(alpha, null);
			eow = false;
		}
	}

	private void insertInTrie(TrieNode trieNode, String s) {
		TrieNode curr = trieNode;
		for (char ch : s.toCharArray()) {
			int idx = ch - 'a';
			if (curr.alpha[idx] == null) curr.alpha[idx] = new TrieNode();
			curr = curr.alpha[idx];
		}
		curr.eow = true;
	}

	private String longestStringHelper(TrieNode node) {
		String best = "";

		for (int i = 0; i < 26; i++) {
			if (node.alpha[i] != null && node.alpha[i].eow) {

				char ch = (char)(i + 'a');

				String child = longestStringHelper(node.alpha[i]);

				String candidate = ch + child;

				if (candidate.length() > best.length()) {
					best = candidate;
				}
			}
		}
		return best;
	}

	public void printTrieVisual(TrieNode node, String prefix, String indent, boolean isLast) {

		if (node == null) return;

		if (!prefix.isEmpty()) {
			char ch = prefix.charAt(prefix.length() - 1);

			System.out.println(
					indent + (isLast ? "└── " : "├── ") + ch + " (eow=" + node.eow + ")"
			);

			indent += isLast ? "    " : "│   ";
		}

		List<Integer> children = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			if (node.alpha[i] != null) {
				children.add(i);
			}
		}

		for (int i = 0; i < children.size(); i++) {
			int idx = children.get(i);
			boolean lastChild = (i == children.size() - 1);

			printTrieVisual(
					node.alpha[idx],
					prefix + (char) (idx + 'a'),
					indent,
					lastChild
			);
		}
	}

	public String longestStringMethod1(String[] words) {
		TrieNode trieNode = new TrieNode();
		for (String s : words) insertInTrie(trieNode, s);
		System.out.println("Trie Structure:");
		printTrieVisual(trieNode, "", "", true);
		return longestStringHelper(trieNode);
	}


	public String longestStringMethod2(String[] words) {
		return "";
	}

	public String longestStringMethod3(String[] words) {
		return "";
	}

	private static void runTest(LongestStringWithAllPrefixesGFG solver,
	                            String[] words, String expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : words = " + Arrays.toString(words));
		System.out.println("Expected  : \"" + expected + "\"");

		String m1 = solver.longestStringMethod1(words);
		String m2 = solver.longestStringMethod2(words);
		String m3 = solver.longestStringMethod3(words);

		System.out.printf("Method 1         : %-10s %s%n",
				m1, m1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10s %s%n",
				m2, m2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10s %s%n",
				m3, m3.equals(expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		LongestStringWithAllPrefixesGFG solver =
				new LongestStringWithAllPrefixesGFG();

		System.out.println("=================================================");
		System.out.println("Find the Longest String (All Prefixes Present) - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new String[]{"p", "pr", "pro", "probl", "problem", "pros", "process", "processor"},
				"pros",
				"Test 1");

		runTest(solver,
				new String[]{"ab", "a", "abc", "abd"},
				"abc",
				"Test 2");

		runTest(solver,
				new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"},
				"apple",
				"Test 3");
	}
}