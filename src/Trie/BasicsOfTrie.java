package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicsOfTrie {
	class TrieNode {
		TrieNode[] alpha;
		boolean eow;

		TrieNode() {
			alpha = new TrieNode[27];
			Arrays.fill(alpha, null);
			eow = false;
		}
	}

	void insertInTrie(TrieNode node, String st) {
		TrieNode root = node;
		for (int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);
			int idx = ch - 'a';
			if (root.alpha[idx] == null) root.alpha[idx] = new TrieNode();
			root = root.alpha[idx];
		}
		root.eow = true;
	}

	boolean isExistInTrie(TrieNode node, String st) {
		TrieNode root = node;
		for (int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);
			int idx = ch - 'a';
			if (root.alpha[idx] == null) return false;
			root = root.alpha[idx];
		}
		return root.eow;
	}

	private void printTrieVisual(TrieNode node, String prefix, String indent, boolean isLast) {

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
					prefix + (char)(idx + 'a'),
					indent,
					lastChild
			);
		}
	}

	void main() {
		String[] arr = {"ahaan", "ahaai", "ahaanu"};
		TrieNode trieNode = new TrieNode();
		for (String curr : arr) insertInTrie(trieNode, curr);
		System.out.println(isExistInTrie(trieNode,"ahaaiiii"));

		System.out.println("Trie Structure:");
		printTrieVisual(trieNode, "", "", true);
	}
}
