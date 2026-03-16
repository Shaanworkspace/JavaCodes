package Trie;

import java.util.Arrays;

public class BasicsOfTrie {
	class TrieNode {
		TrieNode[] alphabets;
		boolean eow;

		TrieNode(){
			alphabets = new TrieNode[26];
			Arrays.fill(alphabets,null);
			eow = false;
		}
	}
	void insertInTrie(TrieNode node , String st){
		TrieNode root = node;
		for(int i =0;i<st.length();i++){
			char ch = st.charAt(i);
			int idx = ch-'a';
			if(root.alphabets[idx]==null) root.alphabets[idx] = new TrieNode();
			root =  root.alphabets[idx];
		}
		root.eow = true;
	}

	boolean isExistInTrie(TrieNode node , String st){
		TrieNode root = node;
		for(int i =0;i<st.length();i++){
			char ch = st.charAt(i);
			int idx = ch-'a';
			if(root.alphabets[idx]==null) return false;
			root =  root.alphabets[idx];
		}
		return true;
	}

	void main(){
		String[] arr = {"Shaan","Shaai","Shaanu"};
		TrieNode trieNode = new TrieNode();
		for(String curr : arr) insertInTrie(trieNode,curr);
		System.out.println(isExistInTrie(trieNode,arr[0]));
	}
}
