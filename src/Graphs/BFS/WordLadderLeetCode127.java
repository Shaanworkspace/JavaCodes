package Graphs.BFS;
import java.util.*;

public class WordLadderLeetCode127 {

	class Pair{
		String word;
		int len;
		Pair(String word, int len){
			this.word = word;
			this.len = len;
		}
	}

	public int ladderLengthMethod1(String beginWord, String endWord, List<String> wordList1) {
		Set<String> wordList = new HashSet<>(wordList1);
		if(!wordList.contains(endWord))	return 0;
		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(beginWord,1));
		while(!queue.isEmpty()){
			Pair curr = queue.poll();
			String word = curr.word;
			int l = curr.len;
			if(word.equals(endWord)) return l;

			for(int i =0;i<word.length();i++){
				for(char ch = 'a';ch<='z';ch++){
					char[] wordTocharArray = word.toCharArray();
					wordTocharArray[i] = ch;

					String newS = new String(wordTocharArray);
					if(wordList.contains(newS)){
						wordList.remove(newS);
						queue.add(new Pair(newS,l+1));
					}
				}
			}
		}
		return 0;
	}

	public int ladderLengthMethod2(String beginWord, String endWord, List<String> wordList) {
		return 0;
	}

	public int ladderLengthMethod3(String beginWord, String endWord, List<String> wordList) {
		return 0;
	}

	private static void runTest(WordLadderLeetCode127 solver,
	                            String beginWord, String endWord,
	                            List<String> wordList, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : beginWord = \"" + beginWord + "\", endWord = \"" + endWord + "\"");
		System.out.println("wordList  : " + wordList);
		System.out.println("Expected  : " + expected);

		int m1 = solver.ladderLengthMethod1(beginWord, endWord, wordList);
		int m2 = solver.ladderLengthMethod2(beginWord, endWord, wordList);
		int m3 = solver.ladderLengthMethod3(beginWord, endWord, wordList);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		WordLadderLeetCode127 solver = new WordLadderLeetCode127();

		System.out.println("=================================================");
		System.out.println("Word Ladder - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"hit",
				"cog",
				Arrays.asList("hot","dot","dog","lot","log","cog"),
				5,
				"Test 1");

		runTest(solver,
				"hit",
				"cog",
				Arrays.asList("hot","dot","dog","lot","log"),
				0,
				"Test 2");
	}
}