package Trie;

import java.util.Arrays;

public class wordBreakProblem {
	class TrieNode {
		TrieNode[] alphabets;
		boolean eow;

		TrieNode() {
			alphabets = new TrieNode[27];
			Arrays.fill(alphabets, null);
			eow = false;
		}
	}
	boolean isExistInTrie(TrieNode node, String st) {
		TrieNode root = node;
		for (int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);
			int idx = ch - 'a';
			if (root.alphabets[idx] == null) return false;
			root = root.alphabets[idx];
		}
		return root.eow;
	}


	void insertInTrie(TrieNode node, String st) {
		TrieNode root = node;
		for (int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);
			int idx = ch - 'a';
			if (root.alphabets[idx] == null) root.alphabets[idx] = new TrieNode();
			root = root.alphabets[idx];
		}
		root.eow = true;
	}

	void main(){
		String[] a = {"i","like","samsung"};
		String str = "ilikesamsung";
		TrieNode trieNode = new TrieNode();
		for (String curr : a) insertInTrie(trieNode, curr);
		boolean ans =  divideable(trieNode,str);
		System.out.println(ans);
	}

	private boolean divideable(TrieNode trieNode,String str) {
		if(str.isEmpty()) return true;
		for(int i =0;i<str.length();i++){
			if(isExistInTrie(trieNode, str.substring(0,i+1)) && divideable(trieNode,str.substring(i+1))){
				return true;
			}
		}
		 return false;
	}
}
